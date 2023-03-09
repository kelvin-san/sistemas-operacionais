package controller;

public class Threads extends Thread{

	public Threads() {
		super();
		this.start();
	}
	
	@Override
	public void run() {
		ShowThreadId();
	}
	
	private void ShowThreadId() {
		System.out.println("Thread#" + this.getId());
	}
}
