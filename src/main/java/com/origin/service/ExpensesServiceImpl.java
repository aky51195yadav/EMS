package com.origin.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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
		// HashMap<String, String> empExpenseType = new HashMap<String, String>();
		List<EmployeeCalculations> lists = new ArrayList<EmployeeCalculations>();

		EmployeeCalculations empCal = new EmployeeCalculations();

		int noOfFoodBill = 0;
		int noOfTravelBill = 0;
		int noOfLocalConvncBill = 0;
		int noOfMobileBill = 0;

		float totalFoodAmount = 0;
		float totalTravelAmount = 0;
		float totalLocalConvncAmount = 0;
		float totalMobileAmount = 0;

		String expenseFood = null;
		String expenseTravel = null;
		String expenseLocal = null;
		String expenseMobile = null;

		for (int i = 0; i < list.size(); i++) {
			Expenses eexp = list.get(i);
			if (eexp != null) {
				if (eexp.getExpenseType().equalsIgnoreCase("Food")) {
					expenseFood = eexp.getExpenseType();
					if (eexp.getImage() != null) {
						noOfFoodBill = noOfFoodBill + 1;
					}
					if (eexp.getAmount() != null) {
						totalFoodAmount = totalFoodAmount + eexp.getAmount();
					}
				}
				if (eexp.getExpenseType().equalsIgnoreCase("Travel")) {
					expenseTravel = eexp.getExpenseType();
					if (eexp.getImage() != null) {
						noOfTravelBill = noOfTravelBill + 1;
					}
					if (eexp.getAmount() != null) {
						totalTravelAmount = totalTravelAmount + eexp.getAmount();
					}
				}
				if (eexp.getExpenseType().equalsIgnoreCase("local Conveyance")) {
					expenseLocal = eexp.getExpenseType();
					if (eexp.getImage() != null) {
						noOfLocalConvncBill = noOfLocalConvncBill + 1;
					}
					if (eexp.getAmount() != null) {
						totalLocalConvncAmount = totalLocalConvncAmount + eexp.getAmount();
					}
				}
				if (eexp.getExpenseType().equalsIgnoreCase("Mobile Expenses")) {
					expenseMobile = eexp.getExpenseType();
					if (eexp.getImage() != null) {
						noOfMobileBill = noOfMobileBill + 1;
					}
					if (eexp.getAmount() != null) {
						totalMobileAmount = totalMobileAmount + eexp.getAmount();
					}
				}
			}
		}

		empCal.setExpenseFood(expenseFood);
		empCal.setExpenseLocal(expenseLocal);
		empCal.setExpenseTravel(expenseTravel);
		empCal.setExpenseMobile(expenseMobile);
		empCal.setNoOfFoodBill(noOfFoodBill);
		empCal.setTotalFoodAmount(totalFoodAmount);
		empCal.setNoOfLocalConvncBill(noOfLocalConvncBill);
		empCal.setTotalLocalConvncAmount(totalLocalConvncAmount);
		empCal.setNoOfMobileBill(noOfMobileBill);
		empCal.setTotalMobileAmount(totalMobileAmount);
		empCal.setNoOfTravelBill(noOfTravelBill);
		empCal.setTotalTravelAmount(totalTravelAmount);

		return empCal;
	}

}
