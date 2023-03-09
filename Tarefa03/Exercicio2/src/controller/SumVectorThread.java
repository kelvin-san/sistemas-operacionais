package controller;

public class SumVectorThread extends Thread {
	
	public int[][] m = new int[3][5];
	public int line;
	
	public SumVectorThread(int[][] m, int line) {
		super();
		this.m = m;
		this.line = line;
		this.start();
	}

	@Override
	public void run() {
		System.out.println("Linha " + line + ": " + sum(m, line));
	}
	
	private int sum(int[][] m, int line) {
		int result = 0;
		
		for (int i = 0; i < 3; i++) {
			result += m[i][line];
		}
		
		return result;
	}
	
}
