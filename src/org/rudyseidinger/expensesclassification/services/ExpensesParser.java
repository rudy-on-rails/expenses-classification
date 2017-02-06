package org.rudyseidinger.expensesclassification.services;

import java.util.ArrayList;

import org.rudyseidinger.expensesclassification.models.Expense;

public class ExpensesParser {
	private ArrayList<ArrayList<String>> data;
	
	public ExpensesParser(ArrayList<ArrayList<String>> data){
		this.data = data;
	}
	
	public ArrayList<Expense> parseExpenses(int titleIdx, int valueIdx, int dateIdx){
		ArrayList<Expense> expenses = new ArrayList<>();
		for (ArrayList<String> row : data) {
			Expense expense = new Expense();
			expense.setTitle(row.get(titleIdx));
			try {
				expense.setTransactionValue(parseToFloat(row.get(valueIdx)));
				expenses.add(expense);
			} catch (NumberFormatException e) {
				System.out.println(String.format("Couldn't parse: %s", e.getMessage()));
			}			
		}
		return expenses;
	}

	private float parseToFloat(String valueString) { 
		return Float.parseFloat(valueString);
	}
}
