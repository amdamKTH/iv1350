package se.kth.iv1350.retailStore.model;

import se.kth.iv1350.retailStore.dbhandler.*;

public class ItemObject {
	private ItemDTO itemDTO;
	private int quantity;
	
	public ItemObject() {}
	
	public ItemObject(ItemDTO item, int quantity) {
		this.itemDTO = item;
		this.quantity = quantity;
	}

	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ItemDTO getItemDTO() {
		return itemDTO;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public int getItemID(){
		return itemDTO.getItemID();
	}
	
	public double getPrice(){
		return itemDTO.getPrice();
	}
	
	public double getVAT(){
		return itemDTO.getVAT();
	}
	
	public String getDescription(){
		return itemDTO.getDescription();
	}
	
	public void incrementQuantity(int amount) {
		this.quantity += amount;
	}
	
	public void decrementQuantity(int amount) {
		this.quantity -= amount;
	}
	
}
