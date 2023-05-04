package se.kth.iv1350.retailStore.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.retailStore.dbhandler.*;

class ItemObjectTest {
	private ItemObject item;
	
	@BeforeEach
	public void setUp() throws Exception {
		ExtInventory in = new ExtInventory();
		ItemDTO info = in.getItem(0);
		item = new ItemObject(info, 2);
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		item = null;
	}

	@Test
	public void testItemIncrement() {
		int previousQuantity = item.getQuantity();
		boolean expResult = true;
		item.incrementQuantity(1);
		boolean result = previousQuantity+1 == item.getQuantity();
		assertEquals(expResult, result,
				"The quantity is consistent when incremented");

	}
	
	@Test
	public void testItemDecrement() {
		int previousQuantity = item.getQuantity();
		boolean expResult = true;
		item.decrementQuantity(1);
		boolean result = previousQuantity-1 == item.getQuantity();
		assertEquals(expResult, result,
				"The quantity is consistent when decremented");
	}

}
