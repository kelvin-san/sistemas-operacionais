package view;

import controller.passageControl;

public class Main {
	
	public static void main(String[] args) {
		
		int distance = 200; // Meters
		
		for (int i = 0; i < 4; i++) {	
			new passageControl(distance);
		}
		
		
	}

}