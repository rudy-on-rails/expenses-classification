package org.rudyseidinger.expensesclassification.services;

import java.util.ArrayList;

import org.rudyseidinger.expensesclassification.models.Expense;

public class ClassifyExpenses {
	private ArrayList<Expense> expenses;

	public ClassifyExpenses(ArrayList<Expense> expenses){
		this.expenses = expenses;
	}
	
	public void Execute(){
		for (Expense expense : expenses) {
			classifyExpense(expense);
		}
	}

	private void classifyExpense(Expense expense) {
		
	}
}
