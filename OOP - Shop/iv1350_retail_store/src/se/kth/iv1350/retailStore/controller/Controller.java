package se.kth.iv1350.retailStore.controller;

import se.kth.iv1350.retailStore.dbhandler.*;
import se.kth.iv1350.retailStore.model.*;
import se.kth.iv1350.retailStore.controller.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;  


/**
 * This class handles the coordination between the View and the lower layers of the model. 
 * Specifically, holding and executing functions in the model that are requested by the view. 
 * */
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
	private List<RunningTotalObserver> observers = new ArrayList<>();
	
	/**
	 * Creates a clean object that can be used for the sale. This mean null states on all current items, discounts and receipts. 
	 * A new cart and new sale log. Lastly connections to the different databases.  
	 * */
	public void startSale () {
		currentItem = null;
		currentDiscounts = null;
		currentReceipt = null;
		
		cart = new Cart();
		saleLog = new SaleLog();
		
		
		inventoryDB = ExtInventory.getInstance();
		accountingDB = new ExtAccounting();
		discountDB = new ExtDiscount();
	}	
	/**
	 * Gets item scanned from inventory and adds it to the cart. 
	 * 
	 * @param itemID Number used to find the correct item.
	 * */
	public void scanItem(int itemID){	
		
		currentItem = inventoryDB.getItem(itemID);
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
		double change = paidAmount - cart.getRunningTotal();	
		
		currentReceipt = new ReceiptDTO(time, date, cart, VAT, paidAmount, change);
		
		Printer.print(currentReceipt);
		saleLog.addReceipt(currentReceipt);
		accountingDB.addPurchase(cart.getRunningTotal());
		notifyObservers();
	}
	
	public Cart getCart() {
		return cart;
	}
	
	/**
	 * Adds an observer to the class.
	 * */
	public void addObserver(RunningTotalObserver observer) {
		 observers.add(observer);
		 }
	
	private void notifyObservers() {
		 for (RunningTotalObserver observer : observers) {
			 observer.newRunningTotal(cart.getRunningTotal());
		 	}
		 }
	
	
}
