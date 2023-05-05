package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class SteamController {

	public SteamController() {
		super();
	}
	
	public String filterByAvg(int year, int monthNumber, int avg) throws IOException, Exception {
		BufferedReader buffer = readFile();
		StringBuffer games = new StringBuffer();
		
		String month = Month.of(monthNumber).getDisplayName(TextStyle.FULL, Locale.US);
		
		// gamename, year, month, avg, gain, peak, avg_peak_perc
		buffer.readLine(); // Eliminando linha de cabeçalho
		String line = buffer.readLine();
		String[] aux = new String[7];
		Double auxAvg = 0.0;
		while (line != null) {
			aux = line.split(",");
			auxAvg = Double.parseDouble(aux[3]);
			if (line.contains(String.valueOf(year)) && line.contains(month) && avg <= auxAvg) {
				games.append(aux[0] + alignTab(aux[0].length()) + aux[3] + "\n");
			}
			line = buffer.readLine();
		}
		
		buffer.close();
		
		return games.toString();
	}
	
	public void saveByFilter(int year, int monthNumber, String path) throws Exception {
		File dir = new File(path);
		File file = new File(dir, "nome.csv");
		if (dir.exists() && dir.isDirectory()) {
			BufferedReader buffer = readFile();
			StringBuffer games = new StringBuffer();
			
			String month = Month.of(monthNumber).getDisplayName(TextStyle.FULL, Locale.US);
			
			// gamename, year, month, avg, gain, peak, avg_peak_perc
			buffer.readLine(); // Eliminando linha de cabeçalho
			String line = buffer.readLine();
			String[] aux = new String[7];
			while (line != null) {
				aux = line.split(",");
				if (line.contains(String.valueOf(year)) && line.contains(month)) {
					games.append(aux[0] + "," + aux[3] + "\n");
				}
				line = buffer.readLine();
			}
			
			Boolean fileExists = false;
			if (file.exists() && file.isFile()) {
				fileExists = true;
			}
			FileWriter openFile = new FileWriter(file, fileExists);
			PrintWriter writeFile = new PrintWriter(openFile);
			writeFile.write(games.toString());
			writeFile.flush();
			writeFile.close();
			openFile.close();
			
			buffer.close();
			
		} else {
			throw new Exception("Directory does not exist");
		}
	}
	
	private BufferedReader readFile() throws IOException, Exception {
		File file = new File("C:\\temp\\SteamCharts.csv");
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
		
		if (length >= 48) {
			tab = "\t";
		} else if (length >= 40) {
			tab = "\t\t";
		} else if (length >= 32) {
			tab = "\t\t\t";
		} else if (length >= 24) {
			tab = "\t\t\t\t";
		} else if (length >= 16) {
			tab = "\t\t\t\t\t";
		} else if (length >= 8) {
			tab = "\t\t\t\t\t\t";					
		} else {
			tab = "\t\t\t\t\t\t\t";
		}
		
		return tab;
	}
}
