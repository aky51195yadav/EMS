package com.origin.service;

import java.util.List;

import com.origin.web.AccountInfo;

public interface AccountInfoService {

	AccountInfo fetchRecordAccountInfo(int empId);

	void saveEmployee(AccountInfo acc);

	List<AccountInfo> getAllRecords();	
	List<AccountInfo> getAllAccountRecords(int empId);

	List<AccountInfo> getAllAccountRecords();

}
