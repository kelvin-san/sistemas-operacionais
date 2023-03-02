package controller;

public class OperacoesTeste {

	public OperacoesTeste() {
		super();
	}
	
	public double tempoVetor(int tamanho) {
		int[] vetor = new int[tamanho];
		double tempoInicial = System.nanoTime();
		
		for (int i = 0; i < tamanho; i++) {
			vetor[i] = 0;
		}
		
		double tempoFinal = System.nanoTime();

		double tempoTotal = (tempoFinal - tempoInicial) / Math.pow(10, 9);
		
		return tempoTotal;
	}

}
