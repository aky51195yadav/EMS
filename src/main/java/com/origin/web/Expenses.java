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
@Table(name = "Employee_Expenses")
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ExpId")
	private Integer expId;

	@Column(name = "Description")
	private String description;

	@Column(name = "Amount")
	private Float amount;

	@Column(name = "BillsImage")
	private String image;

	@Column(name = "Date")
	private String date;

	@Column(name = "Time")
	private String time;

	@OneToOne
	@JoinColumn(name = "EmpId")
	private Employee employee;

	public Integer getExpId() {
		return expId;
	}

	public void setExpId(Integer expId) {
		this.expId = expId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Expenses [expId=" + expId + ", description=" + description + ", amount=" + amount + ", image=" + image
				+ ", date=" + date + ", time=" + time + ", employee=" + employee + "]";
	}

}
