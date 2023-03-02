package view;

import controller.KillController;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		KillController kill = new KillController();
		
		int opt = 0;
		do {
			try {
				opt = Integer.parseInt(JOptionPane.showInputDialog("MENU\n\n1. Listar processos em execução;\n2. Matar processo por PID;\n3. Matar processo por nome;\n9. Sair;\n\n"));
			
			} catch (NumberFormatException e) {
				opt = 0;
			
			}
			switch (opt) {
				case 1:
					kill.listProcesses();
					break;
				case 2:
					try {
						int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID"));
						kill.killByPid(pid);
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "O PID deve ser um valor numérico!");
					}
					break;
				case 3:
					String pName = JOptionPane.showInputDialog("Digite o nome do processo");
					kill.killByName(pName);
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
