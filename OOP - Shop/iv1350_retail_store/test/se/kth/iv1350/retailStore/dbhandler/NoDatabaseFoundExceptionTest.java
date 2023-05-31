package se.kth.iv1350.retailStore.dbhandler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NoDatabaseFoundExceptionTest {
	ExtInventory inventoryDB;
	
	@BeforeEach
	void setUp() throws Exception {
		inventoryDB = ExtInventory.getInstance();
		inventoryDB.setInventory(null);
	}

	@AfterEach
	void tearDown() throws Exception {
		inventoryDB = null;
	}

	@Test
	void testIfDatabaseExists() {
		boolean expResult = true;
		try {
			inventoryDB.getItem(0);
			fail("Inventory was found");
		}
		catch(NoDatabaseFoundException ndfe) {
			assertTrue(expResult, "Inventory was not found");
		}
	}

}
