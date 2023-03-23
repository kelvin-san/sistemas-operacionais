package controller;

import java.util.concurrent.Semaphore;

public class bankControl extends Thread {
	private int ID, op, balance, value;
	Semaphore smpDeposit, smpDraw = new Semaphore(2);

	public bankControl(int ID, int op, int balance, int value) {
		super();
		
		this.ID = ID;
		this.op = op;
		this.balance = balance;
		this.value = value;
		
		this.start();
	}
	
	@Override
	public void run() {
		
	}
	
	private void deposit() {
		
	}
	
	private void draw() {
		
	}
}
