package org.rudyseidinger.expensesclassification.consoleapp;

public class ConsoleApp {

	public static void main(String[] args) {
		if (args.length == 0){
			System.out.println("You need to supply the path to a file before continuing...");
		}
		else{
			String filePath = args[0];
			System.out.println("filePath: " + filePath);
		}	
	}

}
