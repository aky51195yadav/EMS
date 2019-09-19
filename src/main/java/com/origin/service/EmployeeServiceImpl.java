package com.origin.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.origin.repo.EmployeeRepo;
import com.origin.web.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllRecords() {
		return employeeRepo.findAll();
	}

	@Override
	public void updateDetails(Employee employee) {
		employeeRepo.save(employee);

	}

	@Override
	public void deleteEmployee(int empId) {
		employeeRepo.deleteById(empId);
	}

	@Override
	public void imageWork(MultipartFile image) {
		String fileName = image.getOriginalFilename();
		File file = new File("E:\\Ankit Yadav\\DatabaseImages", fileName);
		try {
			image.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Employee fetchRecord(String name, String address) {
		return employeeRepo.findByNameAndAddress(name, address);

	}

	@Override
	public Employee fetchRecordTbl_Employee(int employee) {

		Optional<Employee> option = employeeRepo.findById(employee);
		if (option.isPresent()) {

			return option.get();

		}
		return new Employee();

	}

	@Override
	public boolean userValidation(String userName, String dbUser) {

		return userName.equals("dbUser");

	}

	@Override
	public boolean pwdValidation(String password, String dbPwd) {
		return password.equalsIgnoreCase("dbPwd");
	}

	@Override
	public Employee fetchUser(String userName, String pwd) {
		System.out.println("vdfhjkvbdfjvgbf ghdv ");
		return employeeRepo.findByUserNameAndPwd(userName, pwd);
	}

	@Override
	public List<Employee> getAllEmployeeRecords() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

}
