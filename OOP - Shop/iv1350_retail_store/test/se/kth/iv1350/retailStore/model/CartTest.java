package se.kth.iv1350.retailStore.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.retailStore.dbhandler.*;

class CartTest {
	Cart cart = new Cart();
	ItemObject item = new ItemObject();

	@BeforeEach
	void setUp() throws Exception {
		cart = new Cart();
	}

	@AfterEach
	void tearDown() throws Exception {
		cart = null;
		item = null;
	}
	
	
	@Test
	void testAddItem() {
		ExtInventory inv = ExtInventory.getInstance();
		ItemDTO in = inv.getItem(0);
		item = new ItemObject(in, 1);
		cart.addItem(item);
		item = new ItemObject(in, 1);
		cart.addItem(item);
		int itemQuantity = item.getQuantity();
		boolean expResult = true;
		boolean result = false;
		ItemObject[] itemList = cart.getItemList();
		for (int i = 0; i < cart.getItemList().length; i++ ) {
			if (item.getItemID() == itemList[i].getItemID()) {
			if (itemList[i].getQuantity()== 2)
					result = true;
			}
		}
		assertEquals(expResult, result,
				"The item has been added and the amount is correct.");
	}
	
	
	@Test
	void testRemoveItem() {
		ExtInventory inv = ExtInventory.getInstance();
		ItemDTO in = inv.getItem(0);
		item = new ItemObject(in, 1);
		cart.addItem(item);
		item = new ItemObject(in, 1);
		cart.addItem(item);
		item = new ItemObject(in, 1);
		cart.addItem(item);
		item = new ItemObject(in, 1);
		cart.addItem(item);
		item = new ItemObject(in, 1);
		cart.removeItem(item);
		
		
		boolean expResult = true;
		boolean result = false;
		ItemObject[] itemList = cart.getItemList();
		
		for (int i = 0; i < itemList.length; i++ ) {
			if (item.getItemID() == itemList[i].getItemID()) {
				if (itemList[i].getQuantity() == 3)
					result = true;
			}
		}
		assertEquals(expResult, result,
				"The item has been removed and the amount is correct.");
	}
	

}
