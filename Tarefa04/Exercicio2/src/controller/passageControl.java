package controller;

import java.util.concurrent.Semaphore;

public class passageControl extends Thread {
	static Semaphore mutex = new Semaphore(1);
	private int distance;
	private int velocity;
	private int crrDistance = 0;
	
	public passageControl(int distance) {
		super();
		
		this.distance = distance;
		velocity = (int) ((Math.random() * 3) + 4); // 4-6 m/s
		
		this.start();
	}
	
	@Override
	public void run() {
		walk();
	}
	
	private void walk() {
		while (crrDistance < distance) {
			crrDistance += velocity;
			System.out.println("Pessoa#" + this.getId() + " esta caminhando... (" + crrDistance + "/" + distance + ")");
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Pessoa#" + this.getId() + " chegou");
		
		try {
			mutex.acquire();
			passThrough();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		} finally {
			mutex.release();
			
		}
	}
	
	private void passThrough() {
		int time = (int) ((Math.random() * 2) + 1); // 1-2 s
		
		System.out.println("Pessoa#" + this.getId() + " passou pela porta");
		
		try {
			sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
