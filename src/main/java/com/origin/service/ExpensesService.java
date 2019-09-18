package com.origin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.origin.web.Expenses;

public interface ExpensesService {

	void updateDetails(Expenses eexp);

	String saveFile(MultipartFile file);

	void saveEmployee(Expenses eex);

	List<Expenses> getAllRecords();

	Expenses fetchRecordEmployee_Expenses(int empId);

}
