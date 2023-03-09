package view;

import controller.SumVectorThread;

public class Main {

	public static void main(String[] args) {
		
		int[][] matriz = new int[3][5];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				matriz[i][j] = (int) (Math.random() * 11);
			}
		}
		
		for (int i = 0; i < 5; i++) {
			new SumVectorThread(matriz, i);
		}

	}

}
