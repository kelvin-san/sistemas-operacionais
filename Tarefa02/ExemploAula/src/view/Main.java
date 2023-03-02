package view;

import controller.RedesController;

public class Main {
	
	public static void main(String[] args) {
		RedesController net = new RedesController();

		net.CallProcess("notepad");
		net.ReadProcess("tasklist /fo table");
		//net.KillProcess("notepad.exe");
	}
	
}