package org.rudyseidinger.expensesclassification.consoleapp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.rudyseidinger.expensesclassification.csv.CsvFileReader;
import org.rudyseidinger.expensesclassification.models.Expense;
import org.rudyseidinger.expensesclassification.services.ClassifyExpenses;
import org.rudyseidinger.expensesclassification.services.ExpensesParser;

public class ConsoleApp {
	private static int titleIdx, expenseAmountIdx, dateIdx;
	
	public static void old(String[] args) {	
		if (args.length == 0){
			log("You need to supply the path to a file before continuing...");
		}
		else{
			ArrayList<ArrayList<String>> data = readCsvFile(args[0]);			
			readColumnInputs();			
			readAndClassifyExpenses(data);
		}
	}

	private static ArrayList<ArrayList<String>> readCsvFile(String filePath) { 
		log("Loading: " + filePath + " ...");
		ArrayList<ArrayList<String>> data = new CsvFileReader(filePath).readCsvContents();
		log("The first row is: " + data.get(0));
		return data;
	}

	private static void readAndClassifyExpenses(ArrayList<ArrayList<String>> data) {
		ArrayList<Expense> expensesList = new ExpensesParser(data).parseExpenses(titleIdx, expenseAmountIdx, dateIdx);
		log("Classifying expenses...");
		new ClassifyExpenses(expensesList).Execute();
		log("Expenses classifed");
	}

	private static void readColumnInputs() {
		log("Enter the column names to match where data types are (index-based):");
		Scanner scanner = new Scanner(System.in);
		
		try {
			log("Title column index:");
			titleIdx = scanner.nextInt();
			log("Amount column index:");
			expenseAmountIdx = scanner.nextInt();
			log("Date of expense index:");
			dateIdx = scanner.nextInt();	
			scanner.close();					
		} catch (InputMismatchException e) {
			log("Enter valid values...");
		}
	}
	
	private static void log(String text){
		System.out.println(text);
	}
	

}
