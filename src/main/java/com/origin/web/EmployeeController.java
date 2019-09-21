package com.origin.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.origin.service.AccountInfoService;
import com.origin.service.EmployeeService;
import com.origin.service.ExpensesService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@Autowired
	private AccountInfoService accService;

	@Autowired
	private ExpensesService eexServices;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String fillDetails() {

		return "emp_form";
	}

	/**
	 * ----------------------save the employee data in three
	 * tables------------------------------------------------
	 **/
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String empDetails(@RequestParam String name, @RequestParam String profile, @RequestParam int salary,
			@RequestParam String address, @RequestParam Integer accountNo, @RequestParam String ifsc,
			@RequestParam String bankName, @RequestParam String desc, @RequestParam Float amount,
			@RequestParam String date, @RequestParam String time, @RequestParam("image") MultipartFile file,
			@RequestParam String userName, @RequestParam String pwd) {
		String image = eexServices.saveFile(file);
		Employee emp = new Employee();
		emp.setName(name);
		emp.setProfile(profile);
		emp.setSalary(salary);
		emp.setAddress(address);
		emp.setUserName(userName);
		emp.setPwd(pwd);
		empService.saveEmployee(emp);

		AccountInfo acc = new AccountInfo();
		acc.setAccountNo(accountNo);
		acc.setBankName(bankName);
		acc.setIfsc(ifsc);
		acc.setEmployee(emp);
		accService.saveEmployee(acc);

		Expenses eex = new Expenses();
		eex.setDescription(desc);
		eex.setAmount(amount);
		eex.setImage(image);
		eex.setDate(date);
		eex.setTime(time);
		eex.setEmployee(emp);
		eexServices.saveEmployee(eex);
		return "thanku";
	}

	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public String getSignUp() {
		return "sign_up";
	}

	@RequestMapping(value = "accountUpdate", method = RequestMethod.POST)
	public ModelAndView accountRecords(@RequestParam int accId, @RequestParam int accountNo, @RequestParam String ifsc,
			@RequestParam String bankName) {
		AccountInfo info = new AccountInfo();
		info.setAccId(accId);
		info.setAccountNo(accountNo);
		info.setBankName(bankName);
		info.setIfsc(ifsc);

		ModelAndView andView = new ModelAndView();
		andView.setViewName("all_details");
		andView.addObject("info", info);
		return andView;
	}

	@RequestMapping(value = "expensesUpdate", method = RequestMethod.POST)
	public ModelAndView expensesRecords(@RequestParam int expId, @RequestParam String description,
			@RequestParam float amount, @RequestParam String image, @RequestParam String date,
			@RequestParam String time) {
		Expenses expenses = new Expenses();
		expenses.setExpId(expId);
		expenses.setDescription(description);
		expenses.setAmount(amount);
		expenses.setImage(image);
		expenses.setDate(date);
		expenses.setTime(time);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("all_details");
		andView.addObject("expenses", expenses);
		return andView;
	}

	@RequestMapping(value = "recordsToUpdate", method = RequestMethod.POST)
	public ModelAndView records(@RequestParam int empId, @RequestParam String empName, @RequestParam String profile,
			@RequestParam int salary, @RequestParam String address) {
		Employee employee = new Employee();
		employee.setId(empId);
		employee.setName(empName);
		employee.setProfile(profile);
		employee.setSalary(salary);
		employee.setAddress(address);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("details_editor");
		mav.addObject("employee", employee);
		return mav;
	}
	/*
	 * @RequestMapping(value = "fetchUpdatedRecord", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public ModelAndView saveUpdatedRecords(@RequestParam int
	 * id, @RequestParam String name,
	 * 
	 * @RequestParam String profile, @RequestParam int salary, @RequestParam String
	 * address) { Employee employee = new Employee(); employee.setId(id);
	 * employee.setName(name); employee.setProfile(profile);
	 * employee.setSalary(salary); employee.setAddress(address);
	 * empService.updateDetails(employee); return showEmployeeAllRecords(); }
	 * 
	 * @RequestMapping(value = "fetchIdToDelete", method = RequestMethod.POST)
	 * public ModelAndView deleteRecord(@RequestParam int empId) {
	 * empService.deleteEmployee(empId); return showEmployeeAllRecords(); }
	 */

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String userLogin() {
		return "user_login";
	}

	/** ----------------login_choice page mapping-------------------------- **/
	@RequestMapping(value = "choice", method = RequestMethod.GET)
	public String getChoicePage() {
		return "login_choice";
	}

	/**
	 * --------------------------login verify username and password for user
	 * account----------------------------------------------
	 **/
	@RequestMapping(value = "userPwd", method = RequestMethod.POST)
	public String getDetails(@RequestParam String userName, @RequestParam String password, Model model) {

		Employee emp = empService.fetchUser(userName, password);

		String dbUser = emp.getUserName();
		String dbPwd = emp.getPwd();

		boolean b = empService.userValidation(userName, dbUser);
		boolean b1 = empService.pwdValidation(password, dbPwd);
		if (!b) {
			model.addAttribute("error", "Invalid user name");
			return "user_login";
		}
		if (!b1) {
			model.addAttribute("error", "Invalid password");
			return " user_login";
		}

		return "description_fill_byUser";

	}

	/** ------------------admin login page mapping---------------------- **/
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String adminLogin() {
		return "admin_login";
	}

	/**
	 * ------------------------login verifaye username and password for
	 * admin-------------------------------------------
	 **/
	@RequestMapping(value = "detailsAdminById", method = RequestMethod.POST)
	public String loginForAdmin(@RequestParam String userName, @RequestParam String password, ModelMap modelMap) {
		if (userName.equalsIgnoreCase("Origin") && password.equalsIgnoreCase("origin@123")) {
			session.setAttribute("username", userName);
			return "enter_nameaddress";
		} else {
			modelMap.put("error", "Invalid Account");
			return "admin_login";
		}
	}

	/**
	 * -----------------------------get employee id based on employee name and
	 * address-----------------------------------------------
	 **/
	@RequestMapping(value = "getDetails", method = RequestMethod.POST)
	public ModelAndView getNameAddress(@RequestParam String name, @RequestParam String address) {
		Employee emp = empService.fetchRecord(name, address);
		System.out.println(emp + "hgdfbhjvfbdgjhs");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("enter_nameaddress");
		mav.addObject("emp", emp);
		return mav;
	}

	/**
	 * -------------------------mapping of show table
	 * jsp-----------------------------------------------------
	 **/
	@RequestMapping(value = "getEmpId", method = RequestMethod.POST)
	public ModelAndView getEmpId(@RequestParam int empId) {
		Employee emp = empService.fetchRecordTbl_Employee(empId);
		AccountInfo info = accService.fetchRecordAccountInfo(empId);
		List<Expenses> expenses = eexServices.fetchRecordEmployee_Expenses(empId);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("all_details");
		mav.addObject("emp", emp);
		mav.addObject("info", info);
		mav.addObject("expenses", expenses);
		return mav;
	}

	/*@RequestMapping(value = "show", method = RequestMethod.POST)
	public ModelAndView getamountOfEmployee(@RequestParam int empId) {
			List<Expenses> expenses = eexServices.retriveAmount(empId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee_amount");
		mav.addObject("expenses", expenses);
		return mav;
	}*/

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String showHomepage() {
		return "enter_nameaddress";
	}

	@RequestMapping(value = "getDescription", method = RequestMethod.POST)
	public String saveUpdatedRecord(@RequestParam int empId, @RequestParam String name,
			@RequestParam("amount") Float amount, @RequestParam MultipartFile file, @RequestParam String date,
			@RequestParam String time, @RequestParam String desc) {
//------------------------------------------------------------------------------------------------------------
		// To generate a randomly string name
		String stringName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * stringName.length());
			salt.append(stringName.charAt(index));
		}
		String string = salt.toString();
//------------------------------------------------------------------------------------------------------------

		String addExtention = string + "." + FilenameUtils.getExtension(file.getOriginalFilename());
		File f = new File("E:\\Ankit Yadav\\DatabaseImage", addExtention);
		try {
			file.transferTo(f);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Expenses eexp = new Expenses();
		eexp.setImage(addExtention);
		eexp.setAmount(amount);
		eexp.setDate(date);
		eexp.setTime(time);
		eexp.setDescription(desc);
		eexServices.updateDetails(eexp);
		System.out.println("updated save");

		return "description_fill_byUser";
	}

	/**
	 * ------------------------logout
	 * mapping-------------------------------------------
	 **/
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logoutPage(HttpSession session) throws IOException {
		session.invalidate();
		return "user_login";
	}

	/**
	 * -----------------------logout mapping for admin
	 * ---------------------------------------------
	 **/
	@RequestMapping(value = "adminLogout", method = RequestMethod.GET)
	public String adminLogout(HttpSession session) {
		session.invalidate();
		return "admin_login";
	}

	@RequestMapping(value = "homepage", method = RequestMethod.GET)
	public String dataChange() {
		return "thanku";
	}

	@RequestMapping(value = "home1", method = RequestMethod.GET)
	public String homeReturn() {
		return "login_choice";
	}

	@RequestMapping(value = "backtohome", method = RequestMethod.GET)
	public String returnHome() {
		return "login_choice";
	}

	@RequestMapping(value = "disapprove", method = RequestMethod.GET)
	public String disapprove() {
		return "disapproval_page";
	}

	@RequestMapping(value = "getexpenses", method = RequestMethod.GET)
	public String approveAmount() {
		return "thanku";
	}

	@RequestMapping(value = "amountpageto_homepage", method = RequestMethod.GET)
	public String expensesHome() {
		return "login_choice";
	}

	@RequestMapping(value = "showpage", method = RequestMethod.POST)
	public String expensespage() {
		return "NewFile";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView employee_Expenses(@RequestParam int empId) {
		Expenses exp = new Expenses();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NameFile");

		return mv;
	}
	/*
	 * @RequestMapping(value = "showpage", method = RequestMethod.POST) public
	 * ModelAndView getExpensesData(@RequestParam int empId) { List<Expenses>
	 * expenses = eexServices.Employee_Expenses(empId);
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.setViewName("NewFile");
	 * mav.addObject("expenses", expenses); return mav; }
	 */

	/**
	 * ------------------------------------------------------
	 * 
	 * @RequestMapping(value = "Approve", method = RequestMethod.GET) public
	 *                       ModelAndView addCheckbox(@RequestParam int empId) {
	 *                       List<Expenses> expenses =
	 *                       eexServices.fetchEmployee_Expenses(empId); Expenses st
	 *                       = expenses.get(0);
	 * 
	 *                       ModelAndView mav = new ModelAndView();
	 *                       mav.setViewName("all_details");
	 *                       mav.addObject("expenses", expenses);
	 *                       mav.addObject("st", st); return mav; }
	 **/

	@RequestMapping(value = "approve", method = RequestMethod.GET)
	public ModelAndView getamountbyEmpId(@RequestParam int expId) {
		Expenses expenses = eexServices.fetchEmployee_Expenses(expId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("thanku");
		mav.addObject("expenses", expenses);
		return mav;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public void fetchAmount(@RequestParam int expId, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String amount[] = request.getParameterValues("amount");
		for (String s : amount) {
			out.println(s);
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		Expenses member = new Expenses();
		List<String> courses = new ArrayList<String>();
		model.addAttribute("courses", courses);
		return "member";
	}

	@RequestMapping(value = "/food-page")
	public ModelAndView foodPage() {
		return new ModelAndView("food-form", "food", new Expenses());
	}

	/*
	 * @RequestMapping(value="/food-result") public ModelAndView
	 * processFuits(@ModelAttribute Food food) { ModelAndView modelAndView = new
	 * ModelAndView("food-result"); modelAndView.addObject("food", food); return
	 * modelAndView; }
	 */

	@RequestMapping(value = "editCustomer", method = RequestMethod.POST)
	public void editCustomer(@RequestParam("addcheck") String[] addcheck) {
		if (addcheck[0] != null) {
			System.out.println("checkbox is checked");
		} else {
			System.out.println("checkbox is not checked");
		}
	}

	@RequestMapping(value = "show", method = RequestMethod.POST)
	public ModelAndView showExpenses() {
		Expenses ex = new Expenses();
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		return mv;
	}

	@RequestMapping(value = "viewexp", method = RequestMethod.POST)
	public String submitPage(Model model, Expenses ex, BindingResult result) {
		model.addAttribute("ex", ex);
		return "NewFile";
	}

	/*
	 * @RequestMapping(value = "getDetails", method = RequestMethod.POST) public
	 * ModelAndView getAmount(@RequestParam float amount) { Employee emp =
	 * empService.fetchAmountRecord(amount); System.out.println(emp +
	 * "hgdfbhjvfbdgjhs"); ModelAndView mav = new ModelAndView();
	 * mav.setViewName("all_details"); mav.addObject("emp", emp); return mav; }
	 * 
	 * 
	 */
	/*
	 * @RequestMapping(value="login") public ModelAndView logout(HttpServletRequest
	 * request, HttpServletResponse response) {
	 * 
	 * 
	 * log.debug("Starting of the method logout");
	 * System.out.println("Starting of the method logout");
	 * 
	 * ModelAndView mv = new ModelAndView("/home"); session.invalidate(); session =
	 * request.getSession(true); mv.addObject("homePagee", "true");
	 * mv.addObject("temp1", "true");
	 * 
	 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * if (auth != null) { new SecurityContextLogoutHandler().logout(request,
	 * response, auth); } System.out.println("Ending of the method logout");
	 * 
	 * log.debug("Ending of the method logout"); return mv; // return
	 * "redirect:/login?logout"; }
	 * 
	 * 
	 * ------------------
	 * 
	 * @RequestMapping("/logout") public ModelAndView logout(HttpServletRequest
	 * request, HttpServletResponse response) {
	 * log.debug("Starting of the method logout");
	 * System.out.println("Starting of the method logout");
	 * 
	 * ModelAndView mv = new ModelAndView("/home"); session.invalidate(); session =
	 * request.getSession(true); mv.addObject("homePagee", "true");
	 * mv.addObject("temp1", "true");
	 * 
	 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * if (auth != null) { new SecurityContextLogoutHandler().logout(request,
	 * response, auth); } System.out.println("Ending of the method logout");
	 * 
	 * log.debug("Ending of the method logout"); return mv; // return
	 * "redirect:/login?logout";
	 * 
	 * }
	 * 
	 * /*
	 * 
	 * @RequestMapping(value="getNewDetails" ,method = RequestMethod.POST) public
	 * String saveSalaryAndLocation(@RequestParam String empName,@RequestParam
	 * String profile,@RequestParam String address,@RequestParam String
	 * location,@RequestParam int salary) {
	 * 
	 * Employee empInfo = new Employee(); empInfo.setDesignation(designation);
	 * empInfo.setLocation(location); empInfo.setSalary(salary);
	 * 
	 * empService.addEmployeeDLS(empInfo);
	 * 
	 * return "thanku"; }
	 */

}
