package se.kth.iv1350.retailStore.dbhandler;

import se.kth.iv1350.retailStore.model.ReceiptDTO;


/**
 * This class is not currently used for the seminar task but represent the abstraction of a printer that would hold the connection to a real physical device.  
 * */
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
	
	//Retreived from https://www.baeldung.com/java-check-string-number for the testing
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
