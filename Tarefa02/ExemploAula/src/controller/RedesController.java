package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class RedesController {

	public RedesController() {
		super();
		
	}

	public String os() {
		return System.getProperty("os.name");
		
	}

	public void CallProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
			
		} catch (Exception e) {
			String errMsg = e.getMessage();
			if (errMsg.contains("740,")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
					
				} catch (IOException e1) {
					e1.printStackTrace();
					
				}
				
			} else {
				System.err.print(errMsg);
				
			}
			
		}
	}
	
	public void ReadProcess(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void KillProcess(String param) {
		String taskPid = "taskkill /pid ";
		String taskName = "taskkill /im ";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try {
			pid = Integer.parseInt(param);
			buffer.append(taskPid);
			buffer.append(pid);
			
		} catch (NumberFormatException e) {
			buffer.append(taskName);
			buffer.append(param);
			
		}
		
		CallProcess(buffer.toString());
		
	}

}