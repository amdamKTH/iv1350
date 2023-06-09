package se.kth.iv1350.retailStore.dbhandler;

import se.kth.iv1350.retailStore.model.Cart; 

/**
 * This class holds the distinct discounts that can exist, holding them and habilitating searching and modification. 
 * */

public class ExtDiscount {

	private DiscountDTO[] discountList;
	
	/**
	 * Instantiates function. 
	 * */
	public ExtDiscount() {}
	
	/**
	 * Finds the discounts applicable to the sale depending on items bought, the amount of each and any discounts associated with the member. 
	 * 
	 * @param customerID Used to find discounts related to the customer.
	 * 
	 * @param cart Used to find discounts applicable to items. 
	 * 
	 * @return The list of applicable discounts. 
	 * 
	 * */
	public DiscountDTO[] checkValidDiscount(int customerID, Cart cart) {
		//Find the appropriate discounts. 
		return null;
	}
}
