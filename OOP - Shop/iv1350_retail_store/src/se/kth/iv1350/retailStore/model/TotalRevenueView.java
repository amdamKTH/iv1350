package se.kth.iv1350.retailStore.model;

import se.kth.iv1350.retailStore.view.View;

public class TotalRevenueView extends IncomeTemplate implements RunningTotalObserver{
	
	public void TotalRevenueView() {}
	@Override
	public void newRunningTotal(double runningTotal) {
		saleComplete(runningTotal);
		
		
	}
	@Override
	protected void doShowTotalIncome() throws Exception {
		System.out.println("Income: " + View.round(income,2));
		
	}
	@Override
	protected void handleErrors(Exception e) {
		// TODO Auto-generated method stub
		
	} 

}