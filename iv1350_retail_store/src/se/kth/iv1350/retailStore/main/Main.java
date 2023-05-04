package se.kth.iv1350.retailStore.main;

import se.kth.iv1350.retailStore.view.View;

import java.util.Scanner;

import se.kth.iv1350.retailStore.controller.Controller;
import se.kth.iv1350.retailStore.dbhandler.*;
import se.kth.iv1350.retailStore.model.*;

public class Main {
	
	public static void main(String[] args) {
		
		
		Controller contr = new Controller();
		View view = new View(contr);
		
		contr.startSale();
		Scanner sc = new Scanner(System.in);
		
		
				
		
		while(true) {
			 
			System.out.println(" Write in the number for the item you want to add.");
			System.out.println(" R: *Number* to remove item");
			System.out.println(" Add ', X' at the end to specify amount to be added or removed.");
			System.out.println();
			contr.printSale();
			String input = sc.nextLine();
			
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
}
