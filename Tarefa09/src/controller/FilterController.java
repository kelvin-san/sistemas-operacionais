package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FilterController {

	public FilterController() {
		super();
	}
	
	public String filterBy(String param) throws IOException, Exception {
		BufferedReader buffer = readFile();
		StringBuffer foods = new StringBuffer();
		
		String line = buffer.readLine();
		String[] aux = new String[4];
		// FOOD NAME, SCIENTIFIC NAME, SUBGROUP
		while (line != null) {
			if (line.contains(param)) {
				aux = line.split(",");
				foods.append(aux[0]);
				foods.append(alignTab(aux[0].length()));
				foods.append(aux[1]);
				foods.append(alignTab(aux[1].length()));
				foods.append(aux[3] + "\n");
			}
			line = buffer.readLine();
		}
		
		buffer.close();
		
		return foods.toString();
	}
	
	private BufferedReader readFile() throws IOException, Exception {
		File file = new File("C:\\temp\\generic_food.csv");
		if (file.exists() && file.isFile()) {
			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);
			
			return buffer;
		} else {
			throw new Exception("File not found");
		}
	}
	
	private String alignTab(int length) {
		String tab = "";
		
		if (length >= 32) {
			tab = "\t";
		} else if (length >= 24) {
			tab = "\t\t";
		} else if (length >= 16) {
			tab = "\t\t\t";
		} else if (length >= 8) {
			tab = "\t\t\t\t";					
		} else {
			tab = "\t\t\t\t\t";
		}
		
		return tab;
	}
}
