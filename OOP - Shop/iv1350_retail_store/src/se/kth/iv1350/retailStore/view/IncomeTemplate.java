package se.kth.iv1350.retailStore.view;

/**
 * Abstract class that represents the income observers.
 * */
public abstract class IncomeTemplate {
	public double income;
	
	/**
	 * When a sale is completed the info about revenue is updated and a adaptation of display if run. 
	 * */
	public void saleComplete(double totalPrice) {
		income += totalPrice;
		showTotalIncome();
	}
	
	/**
	 * Handles the distinct methods of displaying or writing income to files and UI.
	 * */
	public void showTotalIncome() {
		try {
			doShowTotalIncome();
		}
		catch(Exception e) {
			handleErrors(e);
		}
	}
	
	protected abstract void doShowTotalIncome() throws Exception;
	
	protected abstract void handleErrors(Exception e);
}
