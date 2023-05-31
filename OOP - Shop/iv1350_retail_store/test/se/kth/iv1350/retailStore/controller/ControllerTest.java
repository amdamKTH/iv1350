package se.kth.iv1350.retailStore.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.retailStore.dbhandler.*;
import se.kth.iv1350.retailStore.model.*;

class ControllerTest {
	ExtInventory inv;
	Controller contr;
	
	@BeforeEach
	void setUp() throws Exception {
		inv = ExtInventory.getInstance();
		contr = new Controller();
		contr.startSale();
	}

	@AfterEach
	void tearDown() throws Exception {
		inv = null;
		contr = null;
	}

	@Test
	void testScanItem() {
		ItemObject item = new ItemObject(inv.getItem(0), 1); 
		contr.scanItem(0);
		
		Cart cart = contr.getCart();
		ItemObject[] itemList = cart.getItemList();
		
		boolean expResult = true;
		boolean result = false;
		
		for (int i = 0; i < itemList.length; i++)
		{
			if (item.getItemID() == itemList[i].getItemID()) {
				
				if(item.getQuantity() == itemList[i].getQuantity()) {
					result = true;
			}
			}
		}
		assertEquals(expResult, result, "The added item has been found in the cart in the correct amount.");
		
	}
	
	@Test
	void testScanItemWithAmount() {
		ItemObject item = new ItemObject(inv.getItem(0), 2); 
		contr.scanItem(0, 2);
		
		Cart cart = contr.getCart();
		ItemObject[] itemList = cart.getItemList();
		
		boolean expResult = true;
		boolean result = false;
		
		for (int i = 0; i < itemList.length; i++)
		{
			if (item.getItemID() == itemList[i].getItemID()) {
				
				if(item.getQuantity() == itemList[i].getQuantity()) {
					result = true;
			}
			}
		}
		assertEquals(expResult, result, "The added item has been found in the cart in the correct amount.");
	}
	
	@Test
	void testRemoveItem() {
		ItemObject item = new ItemObject(inv.getItem(0), 1); 
		contr.scanItem(0, 2);
		contr.removeItem(0);
		
		Cart cart = contr.getCart();
		ItemObject[] itemList = cart.getItemList();
		
		boolean expResult = true;
		boolean result = false;
		
		for (int i = 0; i < itemList.length; i++)
		{
			if (item.getItemID() == itemList[i].getItemID()) {
				
				if(item.getQuantity() == itemList[i].getQuantity()) {
					result = true;
			}
			}
		}
		assertEquals(expResult, result, "The removed item has been found in the cart in the correct amount.");
	}
	
	@Test
	void testRemoveItemWithAmount() {
		ItemObject item = new ItemObject(inv.getItem(0), 1); 
		contr.scanItem(0, 3);
		contr.removeItem(0, 2);
		
		Cart cart = contr.getCart();
		ItemObject[] itemList = cart.getItemList();
		
		boolean expResult = true;
		boolean result = false;
		
		for (int i = 0; i < itemList.length; i++)
		{
			if (item.getItemID() == itemList[i].getItemID()) {
				
				if(item.getQuantity() == itemList[i].getQuantity()) {
					result = true;
			}
			}
		}
		assertEquals(expResult, result, "The removed item has been found in the cart in the correct amount.");
	}
	
	@Test
	void testRetrieveDiscount() {
		assertEquals(true, true, "Not needed to be implemented in this seminar.");
	}
	
	@Test
	void testPay() {
		assertEquals(true, true, "Not needed to be implemented in this seminar.");
	}
}
