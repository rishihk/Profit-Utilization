package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 *  @author <<HRISHIKESHA KYATHSANDRA>>
 *  @version - 1.0.
 *  
 *  The main objective of the Town class is the
 *  constructions of the grid.
 *
 */
public class Town
{	
	private int length, width; // Row and col (first and second indices)

	public TownCell[][] grid; // grid of type TownCells

	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width)
	{
		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];
	}

	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simply throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException
	{
		File file = new File(inputFileName);
		Scanner scnr = new Scanner(file);

		this.length = scnr.nextInt();
		this.width = scnr.nextInt();

		grid = new TownCell[length][width];

		while (scnr.hasNext())
		{
			for (int i = 0; i < grid.length; i++)
			{
				for (int j = 0; j < grid[i].length; j++)
				{
					String type = scnr.next();

					if (type.equals("C"))
					{
						grid[i][j] = new Casual(this, i, j);
					}

					else if (type.equals("S"))
					{
						grid[i][j] = new Streamer(this, i, j);
					}

					else if (type.equals("R"))
					{
						grid[i][j] = new Reseller(this, i, j);
					}

					else if (type.equals("E"))
					{
						grid[i][j] = new Empty(this, i, j);
					}

					else if (type.equals("O"))
					{
						grid[i][j] = new Outage(this, i, j);
					}
				}
			}
		}

		scnr.close();
	}

	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed)
	{
		Random rand = new Random(seed);

		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < width; j++)
			{
				int r = rand.nextInt(5);

				if (r == 0)
				{
					grid[i][j] = new Reseller(this, i, j);
				}

				else if (r == 1)
				{
					grid[i][j] = new Empty(this, i, j);
				}

				else if (r == 2)
				{
					grid[i][j] = new Casual(this, i, j);
				}

				else if (r == 3)
				{
					grid[i][j] = new Outage(this, i, j);
				}

				else if (r == 4)
				{
					grid[i][j] = new Streamer(this, i, j);
				}
			}
		}
	}

	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString()
	{
		String s = "";

		for (int i = 0; i < grid.length; i++)
		{
			if (i != 0)
			{
				s += "\n";
			}

			for (int j = 0; j < grid[i].length; j++)
			{
				if (grid[i][j].who().equals(State.CASUAL))
				{
					if (j == grid[i].length - 1)
					{
						s += "C";
					} 
					
					else
					{
						s += "C ";
					}
				}

				else if (grid[i][j].who().equals(State.EMPTY))
				{
					if (j == grid[i].length - 1)
					{
						s += "E";
					} 
					
					else
					{
						s += "E ";
					}
				}

				else if (grid[i][j].who().equals(State.OUTAGE))
				{
					if (j == grid[i].length - 1)
					{
						s += "O";
					} 
					
					else
					{
						s += "O ";
					}
				}

				else if (grid[i][j].who().equals(State.RESELLER))
				{
					if (j == grid[i].length - 1)
					{
						s += "R";
					} 
					
					else
					{
						s += "R ";
					}
				}

				else if (grid[i][j].who().equals(State.STREAMER))
				{
					if (j == grid[i].length - 1)
					{
						s += "S";
					} 
					
					else
					{
						s += "S ";
					}
				}
			}
		}

		return s;
	}
}
