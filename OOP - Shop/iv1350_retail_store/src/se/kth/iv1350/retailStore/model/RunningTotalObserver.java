package se.kth.iv1350.retailStore.model;

/**
 * A listener observer to watch when the running total is updated. 
 * */

public interface RunningTotalObserver {
	
	/**
	 * Invoked when the running total is changed.
	 * 
	 * @param The running total.
	 * */
	
	void newRunningTotal(double runningTotal);
}
