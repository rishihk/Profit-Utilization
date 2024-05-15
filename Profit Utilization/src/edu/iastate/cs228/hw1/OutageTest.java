package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * The class Outage only has two methods, and I will be testing them here.
 */
class OutageTest
{
	@Test
	void whoMethodTest()
	{
		Town t = new Town(4, 4);
		TownCell tc = new Outage(t, 0, 0);
		
		// according to the who method in Outage, the state must be OUTAGE
		assertEquals(State.OUTAGE, tc.who()); 
	}
	
	@Test
	void nextMethodTest() 
	{
		Town t2 = new Town(2,2);
		t2.grid[0][0] = new Outage(t2, 0, 0);
		t2.grid[0][1] = new Outage(t2, 0, 1);
		t2.grid[1][0] = new Empty(t2, 0, 1);
		t2.grid[1][1] = new Outage(t2, 0, 1);
		
		// according to the next method in Outage, the cell should change to Empty.
		assertEquals(State.EMPTY, t2.grid[0][0].next(t2).who()); 
	}
}
