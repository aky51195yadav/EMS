package com.origin.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.origin.repo.ExpensesRepo;
import com.origin.web.Expenses;

import java.util.Optional;

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
	public Expenses fetchRecordEmployee_Expenses(int empId) {
		Optional<Expenses> option = eexpRepo.findById(empId);
		if (option.isPresent()) {
			return option.get();
		}
		return new Expenses();
	}

}
