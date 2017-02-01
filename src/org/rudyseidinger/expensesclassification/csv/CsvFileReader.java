package org.rudyseidinger.expensesclassification.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.rudyseidinger.expensesclassification.services.CsvReader;

public class CsvFileReader implements CsvReader {
	private Path filePath;
	
	public CsvFileReader(String filePath){
		this.filePath = Paths.get(filePath);
	}
	
	@Override
	public ArrayList<ArrayList<String>> readCsvContents() {
		Charset charset = Charset.forName("UTF-8");
		ArrayList<ArrayList<String>> dataPerRow = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(this.filePath, charset)) {
		    String line = null; 
		    while ((line = reader.readLine()) != null) {
		    	ArrayList<String> rowData = new ArrayList<>();
		    	for (String row : line.split(",")) {
					rowData.add(row);
				}
		    	dataPerRow.add(rowData);		        
		    } 
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}		
		return dataPerRow;
	}

}
