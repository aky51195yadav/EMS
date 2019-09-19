package com.origin.service;

import java.util.List;

import com.origin.web.AccountInfo;

public interface AccountInfoService {

	AccountInfo fetchRecordAccountInfo(int expId);

	void saveEmployee(AccountInfo acc);

	List<AccountInfo> getAllRecords();	
	List<AccountInfo> getAllAccountRecords(int empId);

	List<AccountInfo> getAllAccountRecords();

}
