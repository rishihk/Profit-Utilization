package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * 
 * @author <<HRISHIKESHA KYATHSANDRA>>
 * @version 1.0.
 * 
 * The class TownCell contains all the common code for the 
 * different types of cells that a town can have.This class 
 * is essentially an abstract cell. Its main attributes is the
 * construction of a cell, and checking the neighbours for a
 * given cell. Abstract methods have been specified for any class
 * that extends this class.
 * 
 */
public abstract class TownCell
{
	// Attributes of a cell
	protected Town plain;
	protected int row;
	protected int col;

	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;

	// Holds the value of the number of types of cells.
	public static final int NUM_CELL_TYPE = 5;

	// Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c)
	{
		plain = p;
		row = r;
		col = c;
	}

	/**
	 * Checks all neigborhood cell types in the neighborhood.
	 * Refer to homework pdf for neighbor definitions (all adjacent
	 * neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 *  
	 * @param counts of all customers
	 */
	public void census(int nCensus[])
	{
		// zero the counts of all customers
		nCensus[RESELLER] = 0;
		nCensus[EMPTY] = 0;
		nCensus[CASUAL] = 0;
		nCensus[OUTAGE] = 0;
		nCensus[STREAMER] = 0;

		int width = plain.getWidth();
		int length = plain.getLength();

		if (row - 1 >= 0) // top
		{
			nCensus[getStateVar(plain.grid[row - 1][col].who())]++;
		}

		if (row - 1 >= 0 && col + 1 < width) // top right
		{
			nCensus[getStateVar(plain.grid[row - 1][col + 1].who())]++;
		}
		
		if (row - 1 >= 0 && col - 1 >= 0) // top left
		{
			nCensus[getStateVar(plain.grid[row - 1][col - 1].who())]++;
		}
		
		if (row + 1 < length) // bottom
		{
			nCensus[getStateVar(plain.grid[row + 1][col].who())]++;
		}
		
		if (row + 1 < length && col + 1 < width) // bottom right
		{
			nCensus[getStateVar(plain.grid[row + 1][col + 1].who())]++;
		}
		
		if (row + 1 < length && col - 1 >= 0) // bottom left
		{
			nCensus[getStateVar(plain.grid[row + 1][col - 1].who())]++;
		}

		if (col + 1 < width) // exact right
		{
			nCensus[getStateVar(plain.grid[row][col + 1].who())]++;
		}

		if (col - 1 >= 0) // exact left
		{
			nCensus[getStateVar(plain.grid[row][col - 1].who())]++;
		}
	}
	
	/*
	 * Helper method for census, to find the states index.
	 * 
	 * @param - any state.
	 * 
	 * @return - the states census index.
	 */
	public int getStateVar(State s)
	{
		if (s.equals(State.CASUAL))
		{
			return TownCell.CASUAL;
		}

		else if (s.equals(State.EMPTY))
		{
			return TownCell.EMPTY;
		}

		else if (s.equals(State.OUTAGE))
		{
			return TownCell.OUTAGE;
		}

		else if (s.equals(State.RESELLER))
		{
			return TownCell.RESELLER;
		}

		else if (s.equals(State.STREAMER))
		{
			return TownCell.STREAMER;
		}

		return -1;
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
