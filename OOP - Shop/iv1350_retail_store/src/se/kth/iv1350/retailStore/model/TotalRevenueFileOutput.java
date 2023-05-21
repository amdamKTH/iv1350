package se.kth.iv1350.retailStore.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.retailStore.view.View;

public class TotalRevenueFileOutput extends IncomeTemplate implements RunningTotalObserver	{
	private PrintWriter logStream;
	
	public TotalRevenueFileOutput() { 
		try {
			
			logStream = new PrintWriter(new FileWriter("revenueLog.text"), true);
		
		}catch (IOException ioe) {
			System.out.println("Cannot log.");
			ioe.printStackTrace();
		}
	}
	
	
	@Override
	public void newRunningTotal(double runningTotal) {
		saleComplete(runningTotal);
		
		
	}


	@Override
	protected void doShowTotalIncome() throws Exception {
		logStream.println("Income: " + View.round(income,2));
		
	}


	@Override
	protected void handleErrors(Exception e) {
		// TODO Auto-generated method stub
		
	}
}
