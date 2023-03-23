package view;

import controller.F1Controller;

public class Main {

	public static void main(String[] args) {
		// 7 equipes 2 carros cada
		// Somente 5 carros na pista
		//   - 1 de cada equipe
		// O segundo carro da equipe já entra na espera caso o primeiro estaja na pista
		// 3 voltas
		
		for (int i = 0; i < 14; i++) {
			new F1Controller();
		}
		
	}

}
