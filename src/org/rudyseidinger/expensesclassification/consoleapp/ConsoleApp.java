package org.rudyseidinger.expensesclassification.consoleapp;

import java.io.IOException;
import java.util.ArrayList;

import org.rudyseidinger.expensesclassification.csv.CsvFileReader;

public class ConsoleApp {

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
			System.out.println("Title column:");
			try {
				int titleIdx = System.in.read();
				System.out.println("Value column:");
				int valueColumn = System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}			
		}	
	}

}
