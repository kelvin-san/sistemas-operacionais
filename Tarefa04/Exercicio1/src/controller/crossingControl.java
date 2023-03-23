package controller;

import java.util.concurrent.Semaphore;

public class crossingControl extends Thread {
	static Semaphore mutex = new Semaphore(1);
	static int crrWay = 0;

	public crossingControl() {
		super();
		this.run();
	}
	
	@Override
	public void run() {
		try {
			mutex.acquire();
			crossing();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		} finally {
			mutex.release();
			
		}
	}
	
	
	private void crossing() {
		/*
		 *  1: top-down
		 *  2: down-top
		 *  3: left-right
		 *  4: right-left
		 */
		
		crrWay++;
		
		switch (crrWay) {
		case 1:
			verticalCrossing(0);
			break;
		case 2:
			verticalCrossing(1);
			break;
		case 3:
			horizontalCrossing(0);
			break;
		case 4:
			horizontalCrossing(1);
			break;
		}
	}
	
	private void horizontalCrossing(int way) {
		if (way == 0) {
			// left-right
			System.out.println("O carro da esquerda para direita esta passando...");
			System.out.println("O carro da esquerda para direita passou");
		} else {
			// right-left
			System.out.println("O carro da direta para esquerda esta passando...");
			System.out.println("O carro da direta para esquerda passou");
		}
		
	}
	
	private void verticalCrossing(int way) {
		if (way == 0) {
			// top-down
			System.out.println("O carro de cima para baixo esta passando...");
			System.out.println("O carro de cima para baixo passou");
		} else {
			// down-top
			System.out.println("O carro de baixo para cima esta passando...");
			System.out.println("O carro de baixo para cima passou");
		}
		
	}
}
