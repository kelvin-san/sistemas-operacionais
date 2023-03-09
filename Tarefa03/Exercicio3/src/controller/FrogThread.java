package controller;

public class FrogThread extends Thread{
	
	public int maxJump;
	public int maxDistance;
	PlacingControl placing = new PlacingControl();
	
	public FrogThread(int maxJump, int maxDistance) {
		super();
		this.maxJump = maxJump;
		this.maxDistance = maxDistance;
		
		this.start();
	}
	
	@Override
	public void run() {
		race();
	}
	
	private int currentDistance = 0;
	private void race() {
		do {
			jump();
		} while (currentDistance < maxDistance);
		
		endRace();
	}
	
	private int jumpValue = 0;
	private int remDistance = maxDistance;
	private void jump() {
		jumpValue = (int) (Math.random()*(maxJump+1));
		currentDistance += jumpValue;
		remDistance = maxDistance - currentDistance;
		if (remDistance <= 0) {
			System.out.println("O sapo #" + this.getId() + " pulou " + jumpValue + " metros!  (Chegou ao final)");
		} else {
			System.out.println("O sapo #" + this.getId() + " pulou " + jumpValue + " metros!  (" + currentDistance + "/" + maxDistance + " metros)");			
		}
	}
	
	private void endRace() {
		System.out.println("O sapo #" + this.getId() + " finalizou a corrida! (Colocacao: " + placing.getPlacing() + "o)");
	}
}
