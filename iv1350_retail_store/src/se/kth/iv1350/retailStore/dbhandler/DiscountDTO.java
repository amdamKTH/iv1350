package se.kth.iv1350.retailStore.dbhandler;

public class DiscountDTO {
	private double percent;
	private int discountID;
	
	/**
	 * Creates a new instance of a posible discount.
	 * 
	 * @param percent Describes how discount affects product. 
	 * 
	 * @param discountID Identifies discount. 
	 * */
	public DiscountDTO(float percent, int discountID) {
		super();
		this.percent = percent;
		this.discountID = discountID;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}

	public double getPercent() {
		return percent;
	}

	public int getDiscountID() {
		return discountID;
	}
	
	
	
}
