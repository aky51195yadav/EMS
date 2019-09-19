package com.origin.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.origin.repo.EmployeeRepo;
import com.origin.repo.ExpensesRepo;
import com.origin.web.Employee;
import com.origin.web.Expenses;

import java.util.Optional;

@Service
public class ExpensesServiceImpl implements ExpensesService {
	@Autowired
	ExpensesRepo eexpRepo;
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public void updateDetails(Expenses eexp) {
		eexpRepo.save(eexp);

	}

	@Override
	public void saveEmployee(Expenses eex) {
		eexpRepo.save(eex);

	}

	@Override
	public String saveFile(MultipartFile file) {
		// To generate a randomly string name
		String stringName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) {
			int index = (int) (rnd.nextFloat() * stringName.length());
			salt.append(stringName.charAt(index));
		}
		String string = salt.toString();

		// To add file extension

		String addExtension = string + "." + FilenameUtils.getExtension(file.getOriginalFilename());

		File f = new File("E:\\Ankit Yadav\\DatabaseImage", addExtension);
		try {
			file.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return addExtension;
	}

	@Override
	public List<Expenses> getAllRecords() {
		return eexpRepo.findAll();
	}

	@Override
	public List<Expenses> fetchRecordEmployee_Expenses(int empId) {
		Employee emp = empRepo.findById(empId).orElse(null);
		Optional<List<Expenses>> option = eexpRepo.findAllByEmployee(emp);
		if (option.isPresent()) {
			return option.get();
		}
		return new ArrayList<Expenses>();
	}

	

/*	public List<Expenses> getAllExpensesRecords(int expId) {
		// TODO Auto-generated method stub
		return eexpRepo.existsById();
	}*/

	@Override
	public List<Expenses> getAllExpensesRecords() {
		// TODO Auto-generated method stub
		return eexpRepo.findAll();
	}

	@Override
	public List<Expenses> getAllExpensesRecords(int expId) {
		// TODO Auto-generated method stub
		return null;
	}

}
