package se.kth.iv1350.retailStore.dbhandler;

import se.kth.iv1350.retailStore.model.ReceiptDTO;

public class Printer {
	
	/**
	 * Prints the receipt. 
	 * 
	 * @param The receipt that is printed. 
	 * 
	 * */
	public static void print(ReceiptDTO receipt) {
		//Print receipt.
	}
	
	//Stolen from https://www.baeldung.com/java-check-string-number for the testing
			public static boolean isNumeric(String strNum) {
			    if (strNum == null) {
			        return false;
			    }
			    try {
			        double d = Double.parseDouble(strNum);
			    } catch (NumberFormatException nfe) {
			        return false;
			    }
			    return true;
			}
}