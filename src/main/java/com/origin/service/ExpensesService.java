package com.origin.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.origin.web.EmployeeCalculations;
import com.origin.web.Expenses;

public interface ExpensesService {

	void updateDetails(Expenses eexp);

	String saveFile(MultipartFile file);

	void saveEmployee(Expenses eex);

	List<Expenses> getAllRecords();

	Expenses fetchExpensesById(int empId);

	List<Expenses> fetchExpensesByEmpId(int empId);

	void deleteByExpId(int expId);

	EmployeeCalculations expensesCalculation(List<Expenses> list);

}
