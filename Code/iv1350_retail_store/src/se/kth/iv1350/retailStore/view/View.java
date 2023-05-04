package se.kth.iv1350.retailStore.view;

import se.kth.iv1350.retailStore.controller.Controller;

public class View {
	private Controller contr;
	
	/**
	 * Creates a new instance, representing the programs View.
	 * 
	 * @param contr The controller that communicates between the View and other inputs and with the model. 
	 * 
	 * */
	public View (Controller contr) {
		this.contr = contr;
	}
	
}
