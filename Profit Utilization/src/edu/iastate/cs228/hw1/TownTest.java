package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/*
 * The town class has 4 methods to be tested and I will be testing them here.
 */
class TownTest
{
	private Town fileTown;
	private Town randomTown;
	
	@Test
	public void randomInItTest() 
	{
		randomTown = new Town(2,2);
		randomTown.randomInit(3);
		
		String townForSeed3 = "S R\n" // this is the fixed 2x2 grid with random seed 3
				            + "R E";
		
		//if the randomInIt method works, the randomTown must have the same layout.
		assertEquals(townForSeed3, randomTown.toString());
	}
	
	@Test
	public void toStringTest() throws FileNotFoundException
	{
		fileTown = new Town("ISP4X4.txt");
		
		String s = "O R O R\n"
				+ "E E C O\n"
				+ "E S O S\n"
				+ "E O R R";
		
		// if the toString methods work, the string above must be the same as the fileTown.toString
		assertEquals(s, fileTown.toString());
	}
	
	@Test
	public void getLengthTestfileTown() throws FileNotFoundException
	{
		fileTown = new Town("ISP4X4.txt");
		assertEquals(4, fileTown.getLength());
	}

	@Test
	public void getWidthTestfileTown() throws FileNotFoundException
	{
		fileTown = new Town("ISP4X4.txt");
		assertEquals(4, fileTown.getWidth());
	}

	@Test
	public void getLengthTestRandomTown()
	{
		randomTown = new Town(2, 2);
		randomTown.randomInit(3);
		assertEquals(2, randomTown.getLength());
	}

	@Test
	public void getWidthTestRandomTown()
	{
		randomTown = new Town(2, 2);
		randomTown.randomInit(3);
		assertEquals(2, randomTown.getWidth());
	}

}
