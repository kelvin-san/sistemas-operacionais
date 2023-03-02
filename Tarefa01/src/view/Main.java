package view;

import controller.OperacoesTeste;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		OperacoesTeste Operacoes = new OperacoesTeste();
		DecimalFormat df = new DecimalFormat("0.000000000");
		
		System.out.println("Tempo 1k: " + df.format(Operacoes.tempoVetor(1000)) + "s");
		System.out.println("Tempo 10k: " + df.format(Operacoes.tempoVetor(10000)) + "s");
		System.out.println("Tempo 100k: " + df.format(Operacoes.tempoVetor(100000)) + "s");
	}

}
