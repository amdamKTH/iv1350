package se.kth.iv1350.retailStore.dbhandler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.retailStore.model.ReceiptDTO;

class SaleLogTest {

	private SaleLog emptyList;
	private SaleLog threeList;
	
	@BeforeEach
	public void setUp () {
		emptyList = new SaleLog();
		threeList = new SaleLog();
		emptyList.setList(new ReceiptDTO[3]);
		threeList.setList(new ReceiptDTO[3]);
		
		for (int i = 0; i < threeList.length(); i++) {
			threeList.setIndex(new ReceiptDTO(), i);
		}
	}
	
	@AfterEach
	public void tearDown() {
		emptyList = null;
		threeList = null;
	}
	
	@Test
	public void testAddReceipt() {
		ReceiptDTO newReceipt = new ReceiptDTO();
		boolean expResult = true;
		threeList.addReceipt(newReceipt);
		boolean result = threeList.getReceipt(threeList.length()-1) == newReceipt;
		assertEquals(expResult, result, "Receipt instance in the last position is equal to new Receipt");
	}
}
