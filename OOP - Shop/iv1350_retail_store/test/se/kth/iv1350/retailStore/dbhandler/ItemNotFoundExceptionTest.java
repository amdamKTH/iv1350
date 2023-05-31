package se.kth.iv1350.retailStore.dbhandler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemNotFoundExceptionTest {
	ExtInventory inventoryDB;
	ItemDTO item = null;
	

	@BeforeEach
	void setUp() throws Exception {
		inventoryDB = ExtInventory.getInstance();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		inventoryDB = null;
	}

	@Test
	public void testIfItemIsInInventory() throws ItemNotFoundException{
		boolean expResult = true;
		try {
			item = inventoryDB.getItem(5);
			fail("Item was found");
			
		}
		catch (ItemNotFoundException infe){
			assertTrue(expResult,"The item was not found.");			
		}
	}

}
