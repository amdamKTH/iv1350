package se.kth.iv1350.retailStore.view;

import se.kth.iv1350.retailStore.model.RunningTotalObserver;

/**
 * This class extends the IncomeTemplate and observers the program so any time the income is increased it prints it to the UI.
 * */
public class TotalRevenueView extends IncomeTemplate implements RunningTotalObserver{
	
	/**
	 * Instantiation of object.
	 * */
	public void TotalRevenueView() {}
	
	/**
	 * Will update the income information stored in the object. 
	 * */
	@Override
	public void newRunningTotal(double runningTotal) {
		saleComplete(runningTotal);
	}
	/**
	 * Prints total income to the document. 
	 * */
	@Override
	protected void doShowTotalIncome() throws Exception {
		System.out.println("Income: " + View.round(income,2));
		
	}
	@Override
	protected void handleErrors(Exception e) {
		// TODO Auto-generated method stub
		
	} 

}
