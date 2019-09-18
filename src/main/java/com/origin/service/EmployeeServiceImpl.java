package com.origin.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
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
	public Employee fetchEmployeeById(int empId) {

		Optional<Employee> option = employeeRepo.findById(empId);
		if (option.isPresent()) {

			return option.get();

		}
		return new Employee();

	}

	@Override
	public boolean userValidation(String userName, String dbUser) {

		return userName.equalsIgnoreCase(dbUser);

	}

	@Override
	public boolean pwdValidation(String password, String dbPwd) {
		return password.equals(dbPwd);
	}

	@Override
	public Employee fetchUser(String userName, String pwd) {
		return employeeRepo.findByUserNameAndPwd(userName, pwd);
	}

	@Override
	public String getRandomString() {
		String stringName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * stringName.length());
			salt.append(stringName.charAt(index));
		}
		return salt.toString();
	}

	@Override
	public String getExtension(MultipartFile file) {

		return "."+FilenameUtils.getExtension(file.getOriginalFilename());
	}

	@Override
	public void checkSession(String userName) {
		
		
	}

}
