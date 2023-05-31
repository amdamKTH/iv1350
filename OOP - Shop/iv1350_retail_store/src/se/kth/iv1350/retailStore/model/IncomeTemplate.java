package se.kth.iv1350.retailStore.model;

public abstract class IncomeTemplate {
	public double income;
	
	public void saleComplete(double totalPrice) {
		income += totalPrice;
		showTotalIncome();
	}
	
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
