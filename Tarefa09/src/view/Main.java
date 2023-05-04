package view;

import controller.FilterController;

public class Main {

	public static void main(String[] args) throws Exception {
		FilterController ctrl = new FilterController();
		
		System.out.print(ctrl.filterBy("Tropical fruits"));
	}

}
