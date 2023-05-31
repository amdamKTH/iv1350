package se.kth.iv1350.retailStore.dbhandler;

/**
 * This class manages the inventory of items in our program. 
 * */
public class ExtInventory {
	
	private static final ExtInventory extInventory = new ExtInventory();

	
	private ItemDTO[] itemList;
	
	private int[] ItemIds = {0,1,2,3,4};
	private double[] price = {2.50, 2,1.5, 1, 3};
	private double[] VAT = {0.06, 0.12, 0.06, 0.06, 0.25};
	private String[] description = {"1kg Carrots", "1l Juice Box", "Butter", "Bread", "Jam"};
	
	/**
	 * Creates an instance of the External Inventory class, that for the purpose of this  creates a list of items that can be accessed. 
	 * 
	 * */
	private ExtInventory(){
		ItemDTO[] list = new ItemDTO[5];
		for(int i = 0; i < ItemIds.length; i++) {
			list[i] = new ItemDTO(ItemIds[i], price[i], VAT[i], description[i]);
		}
		
		this.itemList = list;
		//this.itemList = null;
	}
	
	/**
	 * Checks if item is in inventory. 
	 * 
	 * @param itemID Identifier used to find the item. 
	 * 
	 * @return The item related to the ID. 
	 * */
	public ItemDTO getItem (int itemID) {
		if(itemList == null) {
			throw new NoDatabaseFoundException();
		}
		
		ItemDTO item = null;
		for (int i = 0; i < itemList.length; i++) {
			if (itemID == itemList[i].getItemID()) {
				item = itemList[i];
			}
		}
		
		
		if (item == null) {
			throw new ItemNotFoundException();
		}
		
		return item;
	}
	
	
	public static ExtInventory getInstance() {
		return extInventory;
	}
	
	public void setInventory(ItemDTO[] items) {
		this.itemList = items;
	}
}
