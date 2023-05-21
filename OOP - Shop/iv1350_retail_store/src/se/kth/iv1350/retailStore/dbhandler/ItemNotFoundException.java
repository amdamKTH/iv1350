package se.kth.iv1350.retailStore.dbhandler;


/**
 * Thrown when an item cannot be found in the database. 
 * */
public class ItemNotFoundException extends RuntimeException{
	
	/**
	 * Instantiates empty exception.
	 * */
	public ItemNotFoundException () {}
	
	
	/**
	 * Let's message be displayed when error instantiated. 
	 * */
	public ItemNotFoundException (String message) {
		super(message);
	}
	
	public void dispErrorMessage() {
		System.out.println("The item id is invalid.");
	};
	
}