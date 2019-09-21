package com.origin.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.origin.repo.ExpensesRepo;
import com.origin.web.Employee;
import com.origin.web.EmployeeCalculations;
import com.origin.web.Expenses;

@Service
public class ExpensesServiceImpl implements ExpensesService {
	@Autowired
	ExpensesRepo eexpRepo;

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
	public Expenses fetchExpensesById(int empId) {
		Optional<Expenses> option = eexpRepo.findById(empId);
		if (option.isPresent()) {
			return option.get();
		}
		return new Expenses();
	}

	@Override
	public List<Expenses> fetchExpensesByEmpId(int empId) {
		Employee emp = new Employee(empId);
		List<Expenses> list = eexpRepo.findByEmployee(emp);
		System.out.println("list : " + list);
		return list;
	}

	@Override
	public void deleteByExpId(int expId) {
		eexpRepo.deleteById(expId);

	}

	@Override
	public EmployeeCalculations expensesCalculation(List<Expenses> list) {

		float totalFoodAmount = 0;
		float totalTravelAmount = 0;
		float totalLocalConvncAmount = 0;
		float totalMobileAmount = 0;

		int foodBills = 0;
		int travelBills = 0;
		int localConvncBills = 0;
		int mobileBills = 0;

		EmployeeCalculations empCal = new EmployeeCalculations();

		Map<String, List<Expenses>> map = new HashMap<>();

		for (Expenses exp : list) {
			String expenseType = exp.getExpenseType();
			if (expenseType != null) {
				if (!map.containsKey(expenseType)) {
					List<Expenses> newExpenseList = new ArrayList<Expenses>();
					newExpenseList.add(exp);
					map.put(expenseType, newExpenseList);
					System.out.println("new added");
				} else {
					List<Expenses> expenseList = map.get(expenseType);
					expenseList.add(exp);
				}
			}
		}
		System.out.println(map + "Validation");
		System.out.println(map.keySet());
		System.out.println(map.values());
		Set<String> keys = map.keySet();
		for (String key : keys) {
			List<Expenses> amountList = map.get(key);
		}

		return empCal;
	}
}