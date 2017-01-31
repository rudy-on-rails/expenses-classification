package org.rudyseidinger.expensesclassification.services;

import java.util.ArrayList;

public interface CsvReader {
	public ArrayList<ArrayList<String>> readCsvContents(); 
}
