package com.origin.web;

import java.util.List;

public class EmployeeCalculations {

	private int noOfFoodBill;

	private int noOfTravelBill;

	private int noOfLocalConvncBill;

	private int noOfMobileBill;

	private float totalFoodAmount;

	private float totalTravelAmount;

	private float totalLocalConvncAmount;

	private float totalMobileAmount;

	private String expenseFood;

	private List<String> expenseType;

	public String getExpenseFood() {
		return expenseFood;
	}

	public void setExpenseFood(String expenseFood) {
		this.expenseFood = expenseFood;
	}

	public String getExpenseTravel() {
		return expenseTravel;
	}

	public void setExpenseTravel(String expenseTravel) {
		this.expenseTravel = expenseTravel;
	}

	public String getExpenseLocal() {
		return expenseLocal;
	}

	public void setExpenseLocal(String expenseLocal) {
		this.expenseLocal = expenseLocal;
	}

	public String getExpenseMobile() {
		return expenseMobile;
	}

	public void setExpenseMobile(String expenseMobile) {
		this.expenseMobile = expenseMobile;
	}

	private String expenseTravel;
	private String expenseLocal;
	private String expenseMobile;

	public int getNoOfFoodBill() {
		return noOfFoodBill;
	}

	public void setNoOfFoodBill(int noOfFoodBill) {
		this.noOfFoodBill = noOfFoodBill;
	}

	public int getNoOfTravelBill() {
		return noOfTravelBill;
	}

	public void setNoOfTravelBill(int noOfTravelBill) {
		this.noOfTravelBill = noOfTravelBill;
	}

	public int getNoOfLocalConvncBill() {
		return noOfLocalConvncBill;
	}

	public void setNoOfLocalConvncBill(int noOfLocalConvncBill) {
		this.noOfLocalConvncBill = noOfLocalConvncBill;
	}

	public int getNoOfMobileBill() {
		return noOfMobileBill;
	}

	public void setNoOfMobileBill(int noOfMobileBill) {
		this.noOfMobileBill = noOfMobileBill;
	}

	public float getTotalFoodAmount() {
		return totalFoodAmount;
	}

	public void setTotalFoodAmount(float totalFoodAmount) {
		this.totalFoodAmount = totalFoodAmount;
	}

	public float getTotalTravelAmount() {
		return totalTravelAmount;
	}

	public void setTotalTravelAmount(float totalTravelAmount) {
		this.totalTravelAmount = totalTravelAmount;
	}

	public float getTotalLocalConvncAmount() {
		return totalLocalConvncAmount;
	}

	public void setTotalLocalConvncAmount(float totalLocalConvncAmount) {
		this.totalLocalConvncAmount = totalLocalConvncAmount;
	}

	public float getTotalMobileAmount() {
		return totalMobileAmount;
	}

	public void setTotalMobileAmount(float totalMobileAmount) {
		this.totalMobileAmount = totalMobileAmount;
	}

	@Override
	public String toString() {
		return "EmployeeCalculations [noOfFoodBill=" + noOfFoodBill + ", noOfTravelBill=" + noOfTravelBill
				+ ", noOfLocalConvncBill=" + noOfLocalConvncBill + ", noOfMobileBill=" + noOfMobileBill
				+ ", totalFoodAmount=" + totalFoodAmount + ", totalTravelAmount=" + totalTravelAmount
				+ ", totalLocalConvncAmount=" + totalLocalConvncAmount + ", totalMobileAmount=" + totalMobileAmount
				+ ", expenseFood=" + expenseFood + ", expenseTravel=" + expenseTravel + ", expenseLocal=" + expenseLocal
				+ ", expenseMobile=" + expenseMobile + "]";
	}

	public List<String> getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(List<String> expenseType) {
		this.expenseType = expenseType;
	}

}
