package org.rudyseidinger.expensesclassification.reporting;

import java.util.ArrayList;
import java.util.HashMap;

import org.rudyseidinger.expensesclassification.models.Expense;

public class TotalSpentPerType extends ReportBase<HashMap<String, Float>> {

	public TotalSpentPerType(ArrayList<Expense> expenses) {
		super(expenses);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HashMap<String, Float> groupExpenses() {		
		HashMap<String, Float> expensesPerGroup = new HashMap<>();
		for (Expense expense : expenses) {
			String key = expense.getExpenseType();
			float value = expense.getTransactionValue();
			if (expensesPerGroup.containsKey(key)){
				float newValue = expensesPerGroup.get(key) + expense.getTransactionValue();				
				expensesPerGroup.replace(key, newValue);
			}
			else{
				expensesPerGroup.put(key, value);
			}
		}
		return expensesPerGroup;
	}

}
