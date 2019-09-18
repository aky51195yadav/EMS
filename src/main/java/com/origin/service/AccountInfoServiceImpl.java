package com.origin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.origin.repo.AccountInfoRepo;
import com.origin.web.AccountInfo;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {
	@Autowired
	AccountInfoRepo accRepo;

	@Override
	public AccountInfo fetchAccountById(int empId) {
		Optional<AccountInfo> option = accRepo.findById(empId);
		if (option.isPresent()) {
			return option.get();
		}
		return new AccountInfo();
	}

	@Override
	public void saveEmployee(AccountInfo acc) {
		accRepo.save(acc);

	}

	@Override
	public List<AccountInfo> getAllRecords() {
		return accRepo.findAll();

	}

}
