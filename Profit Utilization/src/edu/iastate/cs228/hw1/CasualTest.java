package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * The class Casual has only 2 methods and I will be testing both of them below.
 */
class CasualTest
{
	@Test
	void whoMethodTest()
	{
		Town t = new Town(4, 4);
		TownCell tc = new Casual(t, 0, 0);
		
		// according to the who method in casual, the state must be CASUAL. 
		assertEquals(State.CASUAL, tc.who());
	}
	
	@Test
	void nextMethodTest() 
	{
		Town t2 = new Town(2,2);
		t2.grid[0][0] = new Casual(t2, 0, 0);
		t2.grid[0][1] = new Casual(t2, 0, 1);
		t2.grid[1][0] = new Reseller(t2, 0, 1);
		t2.grid[1][1] = new Casual(t2, 0, 1);
		
		//according to the next method in Casual, the cell should change to a Reseller.
		assertEquals(State.RESELLER, t2.grid[0][0].next(t2).who()); 
	}
}
