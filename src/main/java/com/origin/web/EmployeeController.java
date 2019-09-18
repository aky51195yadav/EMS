package com.origin.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.origin.service.AccountInfoService;
import com.origin.service.ExpensesService;
import com.origin.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@Autowired
	private AccountInfoService accService;

	@Autowired
	private ExpensesService eexServices;

	@Autowired
	private HttpSession session;

	@Autowired
	private HttpServletResponse response;

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String fillDetails() {

		return "emp_form";
	}

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
		return fillDetails();
	}

	@RequestMapping(value = "signUp", method = RequestMethod.GET)
	public String getSignUp() {
		return "sign_up";
	}

	@RequestMapping(value = "showAll", method = RequestMethod.GET)
	public ModelAndView showRecords() {
		List<Employee> empList = empService.getAllRecords();
		System.out.println(empList);
		// List<AccountInfo> acclist = accService.getAllRecords();
		// List<Expenses> eexlist = eexServices.getAllRecords();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("all_details");
		mav.addObject("empList", empList);
		return mav;
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

	@RequestMapping(value = "fetchUpdatedRecord", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView saveUpdatedRecords(@RequestParam int id, @RequestParam String name,
			@RequestParam String profile, @RequestParam int salary, @RequestParam String address) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setProfile(profile);
		employee.setSalary(salary);
		employee.setAddress(address);
		empService.updateDetails(employee);
		return showRecords();
	}

	@RequestMapping(value = "fetchIdToDelete", method = RequestMethod.POST)
	public ModelAndView deleteRecord(@RequestParam int empId) {
		empService.deleteEmployee(empId);
		return showRecords();
	}

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String userLogin() {
		return "user_login";
	}

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String adminLogin() {
		return "admin_login";
	}

	@RequestMapping(value = "choice", method = RequestMethod.GET)
	public String getChoicePage() {
		return "login_choice";
	}

	@RequestMapping(value = "userPwd", method = RequestMethod.POST)
	public ModelAndView getDetails(@RequestParam String userName, @RequestParam String password, Model model) {

		ModelAndView mav = new ModelAndView();
		Employee emp = empService.fetchUser(userName, password);
		if (emp != null) {
			String dbUser = emp.getUserName();
			String dbPwd = emp.getPwd();
			boolean b = empService.userValidation(userName, dbUser);
			boolean b1 = empService.pwdValidation(password, dbPwd);
			if (!b) {
				model.addAttribute("error", "Invalid user name");
				mav.setViewName("user_login");
				return mav;
			}
			if (!b1) {
				model.addAttribute("error", "Invalid password");
				mav.setViewName("user_login");
				return mav;
			}
		} else {
			model.addAttribute("error", "Invalid Data");
			mav.setViewName("user_login");
			return mav;
		}

		session.setAttribute("emp", emp);
		// checkSession(userName);
		mav.setViewName("description_fill_byUser");
		// mav.addObject("emp", emp);
		return mav;
	}

	@RequestMapping(value = "getDetails", method = RequestMethod.POST)
	public ModelAndView getNameAddress(@RequestParam String name, @RequestParam String address) {
		Employee emp = empService.fetchRecord(name, address);
		System.out.println(emp + "hgdfbhjvfbdgjhs");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("enter_nameaddress");
		mav.addObject("emp", emp);
		return mav;
	}

	@RequestMapping(value = "getEmpId", method = RequestMethod.POST)
	public ModelAndView getEmpId(@RequestParam int empId) {
		Employee emp = empService.fetchEmployeeById(empId);
		AccountInfo info = accService.fetchAccountById(empId);
		Expenses eex = eexServices.fetchExpensesById(empId);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("emp_details");
		mav.addObject("emp", emp);
		mav.addObject("info", info);
		mav.addObject("eex", eex);
		return mav;
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String showHomepage() {
		return "enter_nameaddress";
	}

	@RequestMapping(value = "empId", method = RequestMethod.POST)
	public ModelAndView recordById(@RequestParam int empId) {

		Employee emp = empService.fetchEmployeeById(empId);
		AccountInfo info = accService.fetchAccountById(empId);
		Expenses eex = eexServices.fetchExpensesById(empId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("description_fill_byUser");
		mav.addObject("emp", emp);
		mav.addObject("info", info);
		mav.addObject("eex", eex);

		return mav;
	}

	@RequestMapping(value = "getDescription", method = RequestMethod.POST)
	public String saveUpdatedRecord(@RequestParam int empId, @RequestParam("amount") Float amount,
			@RequestParam MultipartFile file, @RequestParam String date, @RequestParam String time,
			@RequestParam String desc) {

		String string = empService.getRandomString();
		String extension = empService.getExtension(file);
		String fileName = string + extension;
		File f = new File("E:\\Ankit Yadav\\DatabaseImage", fileName);
		try {
			file.transferTo(f);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Employee emp = empService.fetchEmployeeById(empId);

		Expenses eexp = new Expenses();
		eexp.setImage(fileName);
		eexp.setAmount(amount);
		eexp.setDate(date);
		eexp.setTime(time);
		eexp.setDescription(desc);
		eexp.setEmployee(emp);
		eexServices.updateDetails(eexp);
		System.out.println("updated save");
		System.out.println(session.getAttribute("user"));
		return "description_fill_byUser";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {

		session.invalidate();
		return "user_login";
	}

	public void checkSession(String userName) {

		if (session.getAttribute("user") != null) {
			session.removeAttribute("user");
		}

	}
	@RequestMapping(value = "onlyName", method = RequestMethod.GET)
	public String showName()
	{
		return "show_only_name";
	}

	/*
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
