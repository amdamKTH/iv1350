package se.kth.iv1350.retailStore.main;

import se.kth.iv1350.retailStore.view.*;

import java.util.Scanner;

import se.kth.iv1350.retailStore.controller.Controller;
import se.kth.iv1350.retailStore.dbhandler.*;
import se.kth.iv1350.retailStore.model.*;

/**
 * This class starts the program. It creates a controller and scanner that the view can access.
 * */
public class Main {
	
	/**
	 * This method initializes the program.
	 * */
	public static void main(String[] args) {
		
		
		Controller contr = new Controller();
		Scanner sc = new Scanner(System.in);
		TotalRevenueFileOutput trfo = new TotalRevenueFileOutput();
		contr.addObserver(trfo);
		View view = new View(contr, sc);
		
		
		
		
		view.StartSale();				
		
		
	}
}
