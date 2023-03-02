package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class RedesController {

	public RedesController() {
		super();
	}

	static String os() {
		return System.getProperty("os.name");

	}

	public void showIpv4() {
		if (os().contains("Windows")) {
			Process p;
			try {
				p = Runtime.getRuntime().exec("ipconfig");

				InputStream pStream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(pStream);
				BufferedReader buffer = new BufferedReader(reader);
				String readedLine = buffer.readLine();
				
				StringBuffer viewBuffer = new StringBuffer();
				
				while (readedLine != null) {
					if (readedLine.contains("IPv4")) {
						viewBuffer.append(readedLine);
						viewBuffer.append("\n");
					}
					readedLine = buffer.readLine();

				}
				
				JOptionPane.showMessageDialog(null, viewBuffer.toString());

				buffer.close();
				pStream.close();
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		if (os().contains("Linux")) {
            try {
                Process p = Runtime.getRuntime().exec("ifconfig");
                
                InputStream pStream = p.getInputStream();
                InputStreamReader reader = new InputStreamReader(pStream);
                BufferedReader buffer = new BufferedReader(reader);
                String readedLine = buffer.readLine();
                
                StringBuffer viewBuffer = new StringBuffer();
                
                while (readedLine != null) {
                    if (readedLine.contains("inet ")) {
                        String ipv4Line[] = readedLine.toString().split(" ");
                        
                        viewBuffer.append(ipv4Line[8] + " ");
                        viewBuffer.append(ipv4Line[9] + " ");
                        viewBuffer.append("\n");
                    }
                    readedLine = buffer.readLine();

                }
                
                JOptionPane.showMessageDialog(null, viewBuffer.toString());

                buffer.close();
                pStream.close();
                reader.close();
                
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        }

	}
	
	public void avgPing() {
		if (os().contains("Windows")) {
			Process p;
			try {
				p = Runtime.getRuntime().exec("ping www.google.com -n 10");

				InputStream pStream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(pStream);
				BufferedReader buffer = new BufferedReader(reader);
				String readedLine = buffer.readLine();
				
				int i = 0;
				
				while (readedLine != null) {
					if (i == 17) {
						String pingStats[] = readedLine.toString().split("=");
						JOptionPane.showMessageDialog(null, pingStats[3]);
					}
					readedLine = buffer.readLine();
					i++;
				}
				
				buffer.close();
				pStream.close();
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		if (os().contains("Linux")) {
            try {
                Process p = Runtime.getRuntime().exec("ping www.google.com -c 10");
                
                InputStream pStream = p.getInputStream();
                InputStreamReader reader = new InputStreamReader(pStream);
                BufferedReader buffer = new BufferedReader(reader);
                String readedLine = buffer.readLine();
                
                int i = 0;
                
                while (readedLine != null) {
                    if (i == 14) {
                        String pingStats[] = readedLine.toString().split("/");
                        JOptionPane.showMessageDialog(null, pingStats[4] + "ms");
                    }
                    readedLine = buffer.readLine();
                    i++;
                }
                
                buffer.close();
                pStream.close();
                reader.close();
                
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        }
	}

}
