package view;

import java.io.IOException;
import javax.swing.JOptionPane;
import controller.SteamController;

public class Main {

	public static void main(String[] args) throws IOException, Exception {
		SteamController ctrl = new SteamController();

		// Menu
		String opt = "";
		int optNumber = 0;
		do {
			opt = JOptionPane.showInputDialog("MENU\n\n1. Consultar resultados filtrados por m�dia\n2. Salvar consulta por data\n9. Sair\n\n");
			try {
				optNumber = Integer.parseInt(opt);
				int year = 0;
				int month = 0;
				switch (optNumber) {
				case 1:
					year = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano da consulta"));
					month = Integer.parseInt(JOptionPane.showInputDialog("Informe o m�s da consulta (Valor num�rico)"));
					int avg = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor m�nimo da m�dia a ser consultada"));
					System.out.println(ctrl.filterByAvg(year, month, avg));
					break;
				case 2:
					year = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano da consulta"));
					month = Integer.parseInt(JOptionPane.showInputDialog("Informe o m�s da consulta (Valor num�rico)"));
					String path = JOptionPane.showInputDialog("Informe o caminho do diret�rio para salvar o arquivo");
					// c:\\temp\\
					ctrl.saveByFilter(year, month, path);
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "Sistema finalizado");
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Op��o inv�lida");
					
				}

			} catch (NumberFormatException e) {
				if (opt == null) {
					JOptionPane.showMessageDialog(null, "Sistema finalizado");
					optNumber = 9;

				} else {
					JOptionPane.showMessageDialog(null, "Op��o inv�lida");

				}

			}

		} while (optNumber != 9);
	}

}
