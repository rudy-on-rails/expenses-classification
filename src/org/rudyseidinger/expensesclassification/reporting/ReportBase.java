package org.rudyseidinger.expensesclassification.reporting;

import java.util.ArrayList;

import org.rudyseidinger.expensesclassification.models.Expense;

public abstract class ReportBase<T> {
	protected ArrayList<Expense> expenses;

	public ReportBase(ArrayList<Expense> expenses){
		this.expenses = expenses;
	}
	
	public abstract T groupExpenses();
}
