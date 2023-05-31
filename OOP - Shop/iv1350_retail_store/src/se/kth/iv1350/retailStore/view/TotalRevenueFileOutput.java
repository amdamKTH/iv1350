package se.kth.iv1350.retailStore.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.retailStore.model.RunningTotalObserver;

/**
 * This class extends the IncomeTemplate and observers the program so any time the income is increased it prints it to the revenueLog.text file.
 * */
public class TotalRevenueFileOutput extends IncomeTemplate implements RunningTotalObserver	{
	private PrintWriter logStream;
	
	/**
	 * The instantiation that creates the writer object and the file to which write. 
	 * */
	public TotalRevenueFileOutput() { 
		try {
			logStream = new PrintWriter(new FileWriter("revenueLog.text"), true);
		
		}catch (IOException ioe) {
			System.out.println("Cannot log.");
			ioe.printStackTrace();
		}
	}
	
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
		logStream.println("Income: " + View.round(income,2));
	}

	@Override
	protected void handleErrors(Exception e) {
		// TODO Auto-generated method stub
		
	}
}
