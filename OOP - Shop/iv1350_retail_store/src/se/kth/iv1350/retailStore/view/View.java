package se.kth.iv1350.retailStore.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import se.kth.iv1350.retailStore.controller.Controller;
import se.kth.iv1350.retailStore.dbhandler.Printer;
import se.kth.iv1350.retailStore.model.*;

/**
 * This class takes care of interaction between the view and sends requests to the controller that should be performed.  
 * */
public class View {
	private LocalTime time = null;
	private LocalDate date = null;
	private Controller contr;
	private Scanner sc;
	
	/**
	 * Creates a new instance, representing the programs View.
	 * 
	 * @param contr The controller that communicates between the View and other inputs and with the model. 
	 * 
	 * */
	public View (Controller contr, Scanner sc) {
		this.contr = contr;
		this.sc = sc;
	}
	
	public void StartSale() {
		TotalRevenueView trv = new TotalRevenueView();
		TotalRevenueFileOutput trfo = new TotalRevenueFileOutput();
		contr.startSale();
		Cart cart = contr.getCart();
		contr.addObserver(trv);
		contr.addObserver(trfo);
		while(true) {
			 
			System.out.println(" Write in the number for the item you want to add.");
			System.out.println(" R: *Number* to remove item");
			System.out.println(" Add ', X' at the end to specify amount to be added or removed.");
			System.out.println();
			this.printSale(cart);
			String input = sc.nextLine();
			
			if (input.contains("pay")) {
				double payment = Double.parseDouble(input.substring(5,input.length())); 
				
				if ((payment-cart.getRunningTotal()) > 0) {
					contr.pay(payment);
					printSale(cart);
					double change = payment-cart.getRunningTotal();
					SpacePrinter(20);
					System.out.println("Your payment is: " + round(payment, 2));
					SpacePrinter(20);
					System.out.println("Your change is: " + round(change, 2));
					SpacePrinter(10);
					System.out.println("Thank you very much and see you soon!");
					System.out.println();
					contr.startSale();
					cart = contr.getCart();
					continue;
				}
				System.out.println("Payment amount not reached.");
			}
			
			if (input.contains(",")) {
				int comma = input.indexOf(",");
				int amount = 1;
				
				if (input.substring(0, 1).equals("R")) {
					
					String operation = input.substring(0,3);
					String opInput = input.substring(3, comma);
					String opAmount = input.substring(comma+2, input.length());
					
					
						if(operation.equals("R: "))
						{
							if(Printer.isNumeric(opAmount)) {
								
								amount = Integer.parseInt(opAmount);
							
								if(Printer.isNumeric(opInput))
									contr.removeItem(Integer.parseInt(opInput), amount);
							}
						}; 
						continue;
					}
				
				String opInput = input.substring(0, comma);
				String opAmount = input.substring(comma+2, input.length());
				if(Printer.isNumeric(opAmount)) {
					amount = Integer.parseInt(opAmount);
					if(Printer.isNumeric(opInput)) {
						contr.scanItem(Integer.parseInt(opInput), amount);
						}
					
					else {
					System.out.println("Invalid Input");
					}
				}
			}
			
			else
			
			{
			if (input.length() > 3) {
				
			String operation = input.substring(0,3);
			String opInput = input.substring(3, input.length());
			
			
				if(operation.equals("R: "))
				{
					if(Printer.isNumeric(opInput))
						contr.removeItem(Integer.parseInt(opInput));
				}; 
				continue;
			}
			
			if(Printer.isNumeric(input)) {
				contr.scanItem(Integer.parseInt(input));
				}
				else {
				System.out.println("Invalid Input");
					}
					
		}
		
		}
	}
	/**
	 * Prints the current state of the cart. 
	 * */
	private void printSale(Cart cart) {
	date = java.time.LocalDate.now();  
	time = java.time.LocalTime.now();
	String timeString = "" + time;
	timeString = timeString.substring(0,8);
	System.out.println("Date: " + date + "   -----   " + "Time: " + timeString);
	System.out.println();
	System.out.println("Item:		   |  Amount   |    Price    |");
	System.out.println();
	
	//ItemDTO[] items = cart.getItemList();
	//int[] amounts = cart.getItemAmounts();
	ItemObject[] items = cart.getItemList();
	
	for (int i = 0; i < items.length; i++)	
		{
			System.out.print(" " + items[i].getDescription());
			SpacePrinter(16-items[i].getDescription().length());
			
			System.out.print("  |     " + items[i].getQuantity() + "     |     ");
			SpacePrinter(4-String.valueOf(items[i].getQuantity()*items[i].getPrice()).length());
			
			System.out.print( + round(items[i].getQuantity()*(items[i].getPrice()+items[i].getPrice()*items[i].getVAT()), 2) + "    |");
			System.out.println();
		}
	System.out.println();
		
	System.out.println("					Total (incl. VAT): " + round(cart.getRunningTotal(),2));
	System.out.println();
	System.out.println("Have a great day!");
	System.out.println();
	}
	
	private static void SpacePrinter(int spaces) {
		for (int i = 0; i < spaces; i++) {
			System.out.print(" ");
		}
	}
	
	//Stolen from https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
