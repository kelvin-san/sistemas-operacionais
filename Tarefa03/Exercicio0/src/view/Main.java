package view;

import controller.ThreadBenchmark;

public class Main {

	public static void main(String[] args) {
		
		ThreadBenchmark tb1 = new ThreadBenchmark();
		ThreadBenchmark tb2 = new ThreadBenchmark();
		
		int vet[] = new int[1000];
		for (int i = 0; i < 1000; i++) {
			vet[i] = (int) (Math.random() * 101);
		}
		
		System.out.println("Thread#" + tb2.getId() + " Normal for: " + tb2.ThreadVector(2, vet));
		System.out.println("Thread#" + tb1.getId() + " For each: " + tb1.ThreadVector(1, vet));

	}

}
