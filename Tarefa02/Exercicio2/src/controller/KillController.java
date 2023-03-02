package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class KillController {

	public KillController() {
		super();
	}
	
	static String os() {
		return System.getProperty("os.name");

	}
	
	public void listProcesses() {
		if (os().contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("tasklist /fo table");
				InputStream pStream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(pStream);
				BufferedReader buffer = new BufferedReader(reader);
				String readedLine = buffer.readLine();
				while (readedLine != null) {
					System.out.println(readedLine);
					readedLine = buffer.readLine();
					
				}
				buffer.close();
				pStream.close();
				reader.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (os().contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ps -ef");
				InputStream pStream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(pStream);
				BufferedReader buffer = new BufferedReader(reader);
				String readedLine = buffer.readLine();
				while (readedLine != null) {
					System.out.println(readedLine);
					readedLine = buffer.readLine();
					
				}
				buffer.close();
				pStream.close();
				reader.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void killByPid(int pid) {
		if (os().contains("Windows")) {
			try {
				Runtime.getRuntime().exec("taskkill /pid " + pid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (os().contains("Linux")) {
			try {
				Runtime.getRuntime().exec("kill -9 " + pid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void killByName(String processName) {
		if (os().contains("Windows")) {
			try {
				Runtime.getRuntime().exec("taskkill /im " + processName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (os().contains("Linux")) {
			try {
				Runtime.getRuntime().exec("pkill -f " + processName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
