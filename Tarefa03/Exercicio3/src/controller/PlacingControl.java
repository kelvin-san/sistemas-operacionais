package controller;

public class PlacingControl {

	public PlacingControl() {
		super();
	}
	
	static int placing = 0;
	
	public int getPlacing() {
		placing++;
		
		return placing;
	}

}
