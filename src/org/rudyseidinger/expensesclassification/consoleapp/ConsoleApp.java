package org.rudyseidinger.expensesclassification.consoleapp;

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
			System.out.println(data);
		}	
	}

}
