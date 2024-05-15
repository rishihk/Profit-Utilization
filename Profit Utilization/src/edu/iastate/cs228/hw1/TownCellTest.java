package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/*
 * The TownCell class has 1 method to be tested and I will be testing it here.
 */
class TownCellTest
{
	@Test
	public void censusTest() throws FileNotFoundException
	{
		Town t = new Town("ISP4X4.txt");
		TownCell tc = new Outage(t, 0, 0);
		int[] cens = new int[5];
		tc.census(cens);
		int[] result = {1,2,0,0,0};
		
		// the two arrays must be equal since the Outage cell in the grid at (0,0) has 1 Empty and 2 Reseller neighbours.
		assertArrayEquals(cens, result);
	}
}
