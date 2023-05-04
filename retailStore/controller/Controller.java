package se.kth.iv1350.retailStore.controller;

import se.kth.iv1350.retailStore.dbhandler.*;
import se.kth.iv1350.retailStore.model.*;

import java.time.LocalDate;
import java.time.LocalTime;  

public class Controller {
	private LocalTime time = null;
	private LocalDate date = null;
	
	private ItemDTO currentItem;
	private DiscountDTO[] currentDiscounts;
	private ReceiptDTO currentReceipt;
	
	private Cart cart;
	private Printer printer;
	private SaleLog saleLog;
	
	private ExtInventory inventoryDB;
	private ExtAccounting accountingDB;
	private ExtDiscount discountDB;
	
	/*
	public Controller(ItemDTO currentItem, DiscountDTO[] currentDiscounts, ReceiptDTO currentReceipt, Cart cart,
			Printer printer, SaleLog saleLog, ExtInventory inventoryDB, ExtAccounting accountingDB,
			ExtDiscount discountDB) {
		super();
		this.currentItem = currentItem;
		this.currentDiscounts = currentDiscounts;
		this.currentReceipt = currentReceipt;
		this.cart = cart;
		this.printer = printer;
		this.saleLog = saleLog;
		this.inventoryDB = inventoryDB;
		this.accountingDB = accountingDB;
		this.discountDB = discountDB;
		
	}*/
	
	/**
	 * Creates a clean object that can be used for the sale. This mean null states on all current items, discounts and receipts. 
	 * A new cart and new sale log. Lastly connections to the different databases.  
	 * */
	public void startSale () {
		currentItem = null;
		currentDiscounts = null;
		currentReceipt = null;
		
		cart = new Cart();
		saleLog = new SaleLog(); // This should actually retrieve the Sale Log and not create a new one;
		//printer = new Printer(int PrinterID);
		inventoryDB = new ExtInventory();
		accountingDB = new ExtAccounting();
		discountDB = new ExtDiscount();
	}
	
	/**
	 * Gets item scanned from inventory and adds it to the cart. 
	 * 
	 * @param itemID Number used to find the correct item.
	 * */
	public void scanItem(int itemID) {
		currentItem = inventoryDB.getItem(itemID);
		if (currentItem == null) {return;}
		ItemObject input = new ItemObject(currentItem, 1);
		cart.addItem(input);
	}
	
	/**
	 * Gets item scanned from inventory and adds the specified amount of it to the cart. 
	 * 
	 * @param itemID Number used to find the correct item.
	 * 
	 * @param amount Number of items that should be added to the list. 
	 * */
	public void scanItem(int itemID, int amount) {
		currentItem = inventoryDB.getItem(itemID);
		if (currentItem == null) {return;}
		ItemObject input = new ItemObject(currentItem, amount);
		cart.addItem(input);
	}
	
	/**
	 * Removes the specified item from the cart. 
	 * 
	 * @param itemID Number which identifies item. 
	 * */
	public void removeItem(int itemID) {
		currentItem = inventoryDB.getItem(itemID);
		if (currentItem == null) {return;}
		ItemObject input = new ItemObject(currentItem, 1);
		cart.removeItem(input);
	}
	
	/**
	 * Removes a specified amount of an item from the cart.
	 * 
	 * @param itemID Number used to find the item.
	 * 
	 * @param amount Number of the item that should be taken away. 
	 * */
	public void removeItem(int itemID, int amount) {
		currentItem = inventoryDB.getItem(itemID);
		if (currentItem == null) {return;}
		ItemObject input = new ItemObject(currentItem, amount);
		cart.removeItem(input);
	}
	
	/**
	 * Gets applicable discounts to the purchase.
	 * 
	 * @param customerID The ID related to the member. 
	 * */
	public void retrieveDiscount(int customerID) {
		currentDiscounts = discountDB.checkValidDiscount(customerID, cart);
		cart.setDiscount(currentDiscounts);
	}
	
	/**
	 * Completes the purchase by calculating the change, creating a receipt, printing it and storing the information in the log. 
	 * 
	 * @param paidAmount The amount of money given to the cashier by the customer. 
	 * */
	public void pay(double paidAmount) {
		
		double VAT = 0.12;
		double change = cart.getRunningTotal() - paidAmount;
		
		currentReceipt = new ReceiptDTO(time, date, cart, VAT, paidAmount, change);
		
		Printer.print(currentReceipt);
		saleLog.addReceipt(currentReceipt);
		accountingDB.addPurchase(cart.getRunningTotal());
	}
	
	public Cart getCart() {
		return cart;
	}
	
	/**
	 * Prints the current state of the cart. 
	 * */
	public void printSale() {
	date = java.time.LocalDate.now();  
	time = java.time.LocalTime.now();
	String timeString = ""+time;
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
