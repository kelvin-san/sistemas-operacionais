package controller;

import java.util.concurrent.Semaphore;

public class AirportController extends Thread {
	
	static boolean northRunway, southRunway;
	static Semaphore smpLeaveGate = new Semaphore(2);
	
	public AirportController() {
		super();
		this.start();
	}
	
	@Override
	public void run() {
		try {
			smpLeaveGate.acquire();
			
			pushBack();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			smpLeaveGate.release();
		}
		
	}
	
	public void pushBack() {
		int time = (int) ((Math.random() * 4001) + 3000); // 3000-7000 ms
		
		System.out.println("A aeronave " + this.getId() + " iniciou o pushback;");
		fSleep(time);
		
		taxi();
	}
	
	public void taxi() {
		int time = (int) ((Math.random() * 5001) + 5000); // 5000-10000 ms
		
		System.out.println("A aeronave " + this.getId() + " iniciou o taxi;");
		fSleep(time);
		
		takeOff();
	}
	
	public void takeOff() {
		int time = (int) ((Math.random() * 3001) + 1000); // 1000-4000 ms
		int runway = (int) (Math.random() * 2); // 0-1
		
		if (runway > 0 && !northRunway) {
			northRunway = true;
			System.out.println("A aeronave " + this.getId() + " iniciou a decolagem pela pista norte;");
		} else {
			southRunway = true;
			System.out.println("A aeronave " + this.getId() + " iniciou a decolagem pela pista sul;");
		}
		fSleep(time);
		
		takeAway(runway);
	}
	
	public void takeAway(int runway) {
		int time = (int) ((Math.random() * 5001) + 3000); // 3000-8000 ms
		
		if (runway > 0) {
			northRunway = false;
		} else {
			southRunway = false;
		}
		System.out.println("A aeronave " + this.getId() + " esta se distanciando;");
		fSleep(time);
		System.out.println("A aeronave " + this.getId() + " transitou de controlador;");
	}
	
	public void fSleep(int t) {
		try {
			sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
