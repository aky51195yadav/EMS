package com.origin.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AccountInfo")
public class AccountInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AccId")
	private Integer accId;

	@Column(name = "AccountNo")
	private Integer accountNo;

	@Column(name = "IFSCCode")
	private String ifsc;

	@Column(name = "BankName")
	private String bankName;

	@OneToOne
	@JoinColumn(name = "EmpId")
	private Employee employee;

	public Integer getAccId() {
		return accId;
	}

	public void setAccId(Integer accId) {
		this.accId = accId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "AccountInfo [accId=" + accId + ", accountNo=" + accountNo + ", ifsc=" + ifsc + ", bankName=" + bankName
				+ ", employee=" + employee + "]";
	}

}
