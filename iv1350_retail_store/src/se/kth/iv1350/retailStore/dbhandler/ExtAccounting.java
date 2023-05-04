package se.kth.iv1350.retailStore.dbhandler;

public class ExtAccounting {

	private double accountValue;

	public ExtAccounting() {}
	
	/**
	 * Adds the amount obtained by the purchase to the account value. 
	 * 
	 * @param price The price of the purchase. 
	 * */
	public void addPurchase(double price) {
		accountValue += price;
	}
}
