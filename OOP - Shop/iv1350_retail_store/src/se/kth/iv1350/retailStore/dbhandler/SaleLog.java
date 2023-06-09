package se.kth.iv1350.retailStore.dbhandler;

import se.kth.iv1350.retailStore.model.ReceiptDTO;


/**
 * SaleLog holds the information for any purchases that have taken place. This is a list of receipts. 
 * */
public class SaleLog {
	
	private ReceiptDTO[] receiptList;
	
	/**
	 * Instantiates the object and empties list.
	 * */
	public SaleLog() {
		receiptList = new ReceiptDTO[0];
	}
	
	/**
	 * Adds a new receipt to the list of receipts stored in the Sale LOg.
	 * 
	 * @param receipt The receipt added to the list. 
	 * */
	public void addReceipt(ReceiptDTO receipt) {
		int arrLength = receiptList.length;
		ReceiptDTO[] newList = new ReceiptDTO[arrLength+1];
		for (int i = 0; i < receiptList.length; i++) {
			newList[i] = receiptList[i];
		}
		newList[arrLength] = receipt; 
		receiptList = newList;
	}
	
	public ReceiptDTO[] getList() {
		return receiptList;
	}
	
	public void setList(ReceiptDTO[] list) {
		this.receiptList = list;
	}
	
	public int length() {
		return receiptList.length;
	}
	
	public void setIndex (ReceiptDTO receipt, int index) {
		receiptList[index] = receipt;
	}
	
	public ReceiptDTO getReceipt (int index) {
		return receiptList[index];
	}
}
