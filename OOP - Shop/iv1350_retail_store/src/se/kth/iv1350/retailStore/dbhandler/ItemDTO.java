package se.kth.iv1350.retailStore.dbhandler;

import se.kth.iv1350.retailStore.dbhandler.ItemDTO;
import se.kth.iv1350.retailStore.dbhandler.DiscountDTO;


/**
 * This class holds the abstraction of our Item, holding attributes like its ID, price, VAT and description. 
 * */
public class ItemDTO {
	private int itemID;
	private double price;
	private double VAT;
	private String description;
	
	/**
	 * Creates an instance of an item object. 
	 * 
	 * @param itemID The item's identification number.
	 * 
	 * @param price The price of the item.
	 * 
	 * @param VAT The VAT associated with the item. 
	 * 
	 * @param description Describes what the item is. 
	 * 
	 * */
	public ItemDTO(int itemID, double price, double VAT, String description) {
		super();
		this.itemID = itemID;
		this.price = price;
		this.VAT = VAT;
		this.description = description;
	}

	public int getItemID() {
		return itemID;
	}

	public double getPrice() {
		return price;
	}

	public double getVAT() {
		return VAT;
	}

	public String getDescription() {
		return description;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setVAT(double vAT) {
		this.VAT = vAT;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
