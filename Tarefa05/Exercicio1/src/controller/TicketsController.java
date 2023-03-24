package controller;

import java.util.concurrent.Semaphore;

public class TicketsController extends Thread {
	
	static int amountTickets = 100;
	
	static Semaphore mutex = new Semaphore(1);
	

	public TicketsController() {
		super();
		this.start();
	}
	
	@Override
	public void run() {
		login();
	}
	
	public void login() {
		int time = (int) ((Math.random() * 1951) + 50); // 50-2000 ms
		
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (time > 1000) {
			System.out.println(this.getId() + "\t TIMEOUT: O login passou do tempo aceito pelo sistema. Seu processo de compra nao podera mais ocorrer;");
		} else {
			buyTicket();
		}
	}
	
	public void buyTicket() {
		int time = (int) ((Math.random() * 2001) + 1000); // 1000-3000 ms
		
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (time > 2500) {
			System.out.println(this.getId() + "\t TIMEOUT: Sua compra passou do tempo aceito pelo sistema. Seu processo de compra nao podera mais ocorrer;");
		} else {
			try {
				mutex.acquire();
				validatePurchase();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				mutex.release();
			}
		}
	}
	
	public void validatePurchase() {
		int amountToBuy = (int) ((Math.random() * 4) + 1); // 1-4
		
		if (amountToBuy <= amountTickets) {
			amountTickets -= amountToBuy;
			System.out.println(this.getId() + "\t Compra de " + amountToBuy + " realizada com sucesso! (Resta(m) " + amountTickets + " ingresso(s));");
		} else if (amountTickets == 0) {
			System.out.println(this.getId() + "\t Compra cancelada. Nao ha mais ingressos disponiveis. Sua sessao foi encerrada;");
		} else {
			System.out.println(this.getId() + "\t Compra cancelada. Nao ha ingressos sucifentes para a quantidade requisitada. Sua sessao foi encerrada;");
		}
	}
}
