package org.rudyseidinger.expensesclassification.consoleapp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.rudyseidinger.expensesclassification.csv.CsvFileReader;
import org.rudyseidinger.expensesclassification.models.Expense;
import org.rudyseidinger.expensesclassification.services.ExpensesParser;

public class ConsoleApp {
	private static int titleIdx, expenseAmountIdx, dateIdx;
	
	public static void main(String[] args) {	
		if (args.length == 0){
			System.out.println("You need to supply the path to a file before continuing...");
		}
		else{
			String filePath = args[0];
			System.out.println("Loading: " + filePath + " ...");
			ArrayList<ArrayList<String>> data = new CsvFileReader(filePath).readCsvContents();
			System.out.println("The first row is: " + data.get(0));
			System.out.println("Enter the column names to match where data types are (index-based):");					
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.println("Title column index:");
				titleIdx = scanner.nextInt();
				System.out.println("Amount column index:");
				expenseAmountIdx = scanner.nextInt();
				System.out.println("Date of expense index:");
				dateIdx = scanner.nextInt();	
				scanner.close();		
				
			} catch (InputMismatchException e) {
				System.out.println("Enter valid values next time...");
			}
			
			ArrayList<Expense> expensesList = new ExpensesParser(data).parseExpenses(titleIdx, expenseAmountIdx, dateIdx);
			for (Expense expense : expensesList) {
				System.out.println(expense.toString());
			}
		}	
	}

}
