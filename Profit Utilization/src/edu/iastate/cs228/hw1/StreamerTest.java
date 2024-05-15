package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * The Streamer class only has 2 methods and I will be testing them here.
 */
class StreamerTest
{
	@Test
	void whoMethodTest()
	{
		Town t = new Town(4, 4);
		TownCell tc = new Streamer(t, 0, 0);
		
		// according to the who method in Streamer, it must return STREAMER
		assertEquals(State.STREAMER, tc.who()); 
	}
	
	@Test
	void nextMethodTest() 
	{
		Town t2 = new Town(2,2);
		t2.grid[0][0] = new Streamer(t2, 0, 0);
		t2.grid[0][1] = new Streamer(t2, 0, 1);
		t2.grid[1][0] = new Streamer(t2, 0, 1);
		t2.grid[1][1] = new Empty(t2, 0, 1);
		
		// according to the next method in Streamer, the cell should change to Reseller.
		assertEquals(State.RESELLER, t2.grid[0][0].next(t2).who()); 
	}
}
