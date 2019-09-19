package com.origin.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.origin.web.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> getAllRecords();

	void updateDetails(Employee employee);

	void deleteEmployee(int empId);

	void imageWork(MultipartFile image);

	Employee fetchRecord(String name, String address);

	Employee fetchEmployeeById(int empId);

	boolean pwdValidation(String password, String dbPwd);

	boolean userValidation(String userName, String dbUser);

	Employee fetchUser(String userName, String password);

	String getRandomString();

	String getExtension(MultipartFile file);

	void checkSession(String userName);

	int saveEmpId(Integer id);

}
