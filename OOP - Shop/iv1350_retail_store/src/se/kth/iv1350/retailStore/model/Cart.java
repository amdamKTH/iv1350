package se.kth.iv1350.retailStore.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.retailStore.dbhandler.ItemDTO;
import se.kth.iv1350.retailStore.dbhandler.DiscountDTO;

/**
 * Cart is the abstraction that holds information about the list of items that are being purchased, their total price and eventual discounts and VAT that should be applied. 
 * */
public class Cart {
	
	private List<RunningTotalObserver> observers = new ArrayList<>();
	
	private ItemObject[] itemList;
	
	private double runningTotal;
	private DiscountDTO[] appliedDiscounts;
	private double VAT = 0.12;
	
	/**
	 * Creates a new instance of the cart that sets it to initial values for transaction. 
	 * */
	public Cart() {
		
		itemList = new ItemObject[0];
		
		runningTotal = 0;
		appliedDiscounts = new DiscountDTO[0];
	}
	
	
	
	/**
	 * Adds item to the item list if it's not already present and increments the amount of that item by the amount specified.
	 * 
	 * @param item The item that is added to the list that holds DTO and quantity. 
	 * 
	 * */
	public void addItem(ItemObject item){
		
		for (int i = 0; i < itemList.length; i++) {
			if (item.getItemID() == itemList[i].getItemID()) {
				itemList[i].incrementQuantity(item.getQuantity());
				return;
			}
		}
		
		ItemObject[] nL = new ItemObject[itemList.length+1];
		
		for (int i = 0; i < itemList.length; i++) {
			nL[i] = itemList[i]; 
		}
		
		nL[nL.length-1] = item;
		this.itemList = nL;
		
		updateRunningTotal();
	}
	
	/**
	 * Decrements the amount of certain item by one. If there are no more items of that type the column for the item is removed from the list. 
	 * 
	 * @param item The item that is removed to the list which also contains the amount of items to be removed. 
	 * */
	public void removeItem(ItemObject item) {
		
		for (int i = 0; i < itemList.length; i++) {
			if (item.getItemID() == itemList[i].getItemID()){
				itemList[i].decrementQuantity(item.getQuantity());
				if (itemList[i].getQuantity() <= 0) {
					
					ItemObject[] nL = new ItemObject[itemList.length-1];
					int pCounter = 0;
					for (int j = 0; j < itemList.length; j++) {
						
						if (itemList[j].getItemID() !=  itemList[i].getItemID()) {
							nL[pCounter] = itemList[j];
							pCounter++;
						}
						
					}
					this.itemList = nL;
					
					updateRunningTotal();
				}
				return;
			}
		}
		System.out.println("The item was not found in the cart.");
		
	}
				
	
	
	public double getRunningTotal() {
		updateRunningTotal();
		return runningTotal;
	}
	
	public void setDiscount(DiscountDTO[] currentDiscounts) {
		appliedDiscounts = currentDiscounts;
	}

	public ItemObject[] getItemList() {
		return itemList;
	}


	public DiscountDTO[] getAppliedDiscounts() {
		return appliedDiscounts;
	}
	
	private void updateRunningTotal(){
		
		double newTotal = 0;
		for (int i = 0; i < itemList.length; i++) {
			newTotal += (itemList[i].getPrice() + itemList[i].getPrice()*itemList[i].getVAT()) * itemList[i].getQuantity();
		}
		newTotal = newTotal + newTotal*VAT;
		
		//Discount code still to be written
		runningTotal = newTotal;
	}
	
	
}
