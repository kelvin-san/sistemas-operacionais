package view;

import controller.NetflixController;

public class Main {

	public static void main(String[] args) throws Exception {
		NetflixController ctrl = new NetflixController();
		
		ctrl.filterByMajorGenre("Comedy");

	}

}
