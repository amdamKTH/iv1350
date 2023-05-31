package se.kth.iv1350.retailStore.model;

import se.kth.iv1350.retailStore.dbhandler.ItemDTO;
import java.time.LocalDate;
import java.time.LocalTime; 
import se.kth.iv1350.retailStore.dbhandler.DiscountDTO;


/**
 * This class represents the Receipt and holds all the information from a purchease. 
 * */
public class ReceiptDTO {
	private LocalTime time;
	private LocalDate date;
	private Cart cart;
	private double VAT;
	private double paidAmount;
	private double changeAmount;
	
	/**
	 * Creates a new instance that stores all relevant
	 * sale information. 
	 * 
	 * @param time Time at which sale took place.
	 * 
	 * @param date Date at which sale took place.
	 * 
	 * @param cart Object containing all items bought, the amounts of each item and eventual discounts applied.  
	 * 
	 * @param VAT Any VAT percentages applied to the total purchase.
	 * 
	 * @param paidAmount The amount paid to the cashier for the purchase.
	 * 
	 * @param changeAmount The amount returned to the client. 
	 * */
	public ReceiptDTO() {}
	
	public ReceiptDTO(LocalTime time, LocalDate date, Cart cart,
			double VAT, double paidAmount, double changeAmount) {
		super();
		this.time = time;
		this.date = date;
		this.cart = cart;
		this.VAT = VAT;
		this.paidAmount = paidAmount;
		this.changeAmount = changeAmount;
	}	
	
}


