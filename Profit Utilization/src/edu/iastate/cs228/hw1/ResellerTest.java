package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * The Reseller class has only 2 methods, and I will be testing them here.
 */
class ResellerTest
{
	@Test
	void whoMethodTest()
	{
		Town t = new Town(4, 4);
		TownCell tc = new Reseller(t, 0, 0);
		
		// according to the who method in Reseller, it must return Reseller.
		assertEquals(State.RESELLER, tc.who()); 
	}
	
	@Test
	void nextMethodTest() 
	{
		Town t2 = new Town(2,2);
		t2.grid[0][0] = new Reseller(t2, 0, 0);
		t2.grid[0][1] = new Casual(t2, 0, 1);
		t2.grid[1][0] = new Reseller(t2, 0, 1);
		t2.grid[1][1] = new Empty(t2, 0, 1);
		
		// according to the next method in Reseller, the cell should change to Empty.
		assertEquals(State.EMPTY, t2.grid[0][0].next(t2).who()); 
	}
}
