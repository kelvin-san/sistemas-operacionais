package controller;

import java.text.DecimalFormat;

public class ThreadBenchmark extends Thread{

	public ThreadBenchmark() {
		super();
	}
	
	public String ThreadVector(int type, int[] vet) {
		int vetLength = vet.length;
		
		DecimalFormat df = new DecimalFormat("0.000000000");
		int readVet;
		
		double tempoInicial = System.nanoTime();
		
		if (type % 2 == 0) {
			for (int i = 0; i < vetLength; i++) {
				readVet = vet[i];
				
			}
		
		} else {
			for (int i : vet) {
				readVet = i;
				
			}
		
		}
		
		double tempoFinal = System.nanoTime();

		double tempoTotal = (tempoFinal - tempoInicial) / Math.pow(10, 9);
		
		return df.format(tempoTotal) + "s";
	}
}
