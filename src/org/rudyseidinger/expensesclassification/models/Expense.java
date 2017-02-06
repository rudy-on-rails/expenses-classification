package org.rudyseidinger.expensesclassification.models;

import java.util.Date;

public class Expense {
	private String title;
	private Date expenseDate;
	private float transactionValue;
	private String expenseType;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	public float getTransactionValue() {
		return transactionValue;
	}
	public void setTransactionValue(float transactionValue) {
		this.transactionValue = transactionValue;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	@Override
	public String toString() {		
		return String.format("Title: %s - Value: %.3f\n", this.getTitle(), this.getTransactionValue()); 
	}
}
