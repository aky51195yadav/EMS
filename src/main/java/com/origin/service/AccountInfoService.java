package com.origin.service;

import java.util.List;

import com.origin.web.AccountInfo;

public interface AccountInfoService {

	AccountInfo fetchAccountById(int empId);

	void saveEmployee(AccountInfo acc);

	List<AccountInfo> getAllRecords();

}
