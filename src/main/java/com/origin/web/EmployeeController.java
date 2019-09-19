package com.origin.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
   
	/**----------------------save the employee data in three tables------------------------------------------------**/
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
     /**----------------login_choice page mapping--------------------------**/
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
		if (userName.equalsIgnoreCase("HelloAdmin") && password.equalsIgnoreCase("12345")) {
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
	 * -------------------------------------------------------------------------
	 **/
	@RequestMapping(value = "getEmpId", method = RequestMethod.POST)
	public ModelAndView getEmpId(@RequestParam int empId) {
		Employee emp = empService.fetchRecordTbl_Employee(empId);
		AccountInfo info = accService.fetchRecordAccountInfo(empId);
		Expenses eex = eexServices.fetchRecordEmployee_Expenses(empId);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("all_details");
		mav.addObject("emp", emp);
		mav.addObject("info", info);
		mav.addObject("eex", eex);
		return mav;
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String showHomepage() {
		return "enter_nameaddress";
	}

	/**
	 * -------------------------mapping of show table
	 * jsp-----------------------------------------------------
	 **/

	@RequestMapping(value = "empId", method = RequestMethod.POST)
	public ModelAndView recordById(@RequestParam int employee) {

		Employee emp = empService.fetchRecordTbl_Employee(employee);
		AccountInfo info = accService.fetchRecordAccountInfo(employee);
		Expenses eex = eexServices.fetchRecordEmployee_Expenses(employee);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("description_fill_byUser");
		mav.addObject("emp", emp);
		mav.addObject("info", info);
		mav.addObject("eex", eex);

		return mav;
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
