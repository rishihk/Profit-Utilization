package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import edu.iastate.cs228.hw1.ISPBusiness;

import org.junit.jupiter.api.Test;

/*
 * The ISPBuisness class has 2 methods to be tested and I will be testing them below.
 */
class ISPBusinessTest
{
	@Test
	public void getProfitTest() 
	{
		Town t = new Town(2,2);
		t.grid[0][0] = new Casual(t, 0, 0);
		t.grid[0][1] = new Reseller(t, 0, 1);
		t.grid[1][0]= new Empty(t, 1, 0);
		t.grid[1][1] = new Casual(t, 1, 1);
		
		// the profit here must be 2 since there are 2 Casual users
		assertEquals(2, ISPBusiness.getProfit(t) );
	}
	
	@Test
	public void updatePlainTest() throws FileNotFoundException
	{
		Town t = new Town("ISP4X4.txt");
		
		// according to the next method of each cell, this has to be the updated plain
		String s = "E E E E\n"
				+ "C C O E\n"
				+ "C O E O\n"
				+ "C E E E";
		
		Town updatedPlain = ISPBusiness.updatePlain(t);
		
		// after updating the plain, the cells of the town must be equal to the String above.
		assertEquals(s, updatedPlain.toString());
	}
}
