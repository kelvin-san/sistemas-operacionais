package view;

import controller.FrogThread;

public class Main {

	public static void main(String[] args) {
		
		// Values in meters
		int maxJump = 5; 
		int maxDistance = 5;
		
		for (int i = 0; i < 5; i++) {
			new FrogThread(maxJump, maxDistance);
		}
		
	}

}
