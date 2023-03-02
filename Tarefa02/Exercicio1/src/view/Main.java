package view;

import controller.RedesController;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		RedesController net = new RedesController();
		
		int opt = 0;
		do {
			try {
				opt = Integer.parseInt(JOptionPane.showInputDialog("MENU\n\n1. Exibir Endereço IPv4;\n2. Exibir média de ping;\n9. Sair;\n\n"));
			
			} catch (NumberFormatException e) {
				opt = 0;
			
			}
			switch (opt) {
				case 1:
					net.showIpv4();
					break;
				case 2:
					net.avgPing();
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "Programa finalizado");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida");
					break;
			}
		} while (opt != 9);

	}

}
