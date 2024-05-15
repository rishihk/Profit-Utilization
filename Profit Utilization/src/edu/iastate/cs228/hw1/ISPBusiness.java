package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @author <<HRISHIKESHA KYATHSANDRA>>
 * @version 1.0
 * 
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness
{
	/*
	 * Variable to hold the value of the number of Casual users for a given Town
	 */
	private static int numCasual = 0;

	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld)
	{
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		for (int i = 0; i < tOld.getLength(); i++)
		{
			for (int j = 0; j < tOld.getWidth(); j++)
			{
				tNew.grid[i][j] = tOld.grid[i][j].next(tNew);
			}
		}
		return tNew;
	}

	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town)
	{
		for (int i = 0; i < town.getLength(); i++)
		{
			for (int j = 0; j < town.getWidth(); j++)
			{
				if (town.grid[i][j].who().equals(State.CASUAL))
				{
					numCasual++;
				}
			}
		}
		return numCasual;
	}

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		
		// Interaction with the user for selecting the type of town.
		System.out.println("How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed");
		int response = scnr.nextInt();
		//scnr.close();

		Town userTown = null;
		
		if (response == 1)
		{
			System.out.println("Please enter file path:");
			Scanner scan = new Scanner(System.in);
			String fileName = scan.next();

			try
			{
				userTown = new Town(fileName);
			}

			catch (FileNotFoundException e)
			{
				System.out.println("Invalid file name, make sure you have mentioned the correct file name and location");
				return;
			}

			scan.close();
		}

		else if (response == 2)
		{
			System.out.println("Provide rows, cols and seed integer separated by spaces:");
			Scanner sc = new Scanner(System.in);
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			int seed = sc.nextInt();
			userTown = new Town(rows, cols);
			userTown.randomInit(seed);

			sc.close();
		}

		else
		{
			System.out.println("Invalid option, please try again later, or re-run the program.");
			scnr.close();
			return;
		}

		// Updates the plain throughout the billing cycle and calculates the profit of each.
		int profit = 0;
		for (int i = 1; i <13; i++)
		{
			profit = getProfit(userTown);
			userTown = updatePlain(userTown);
		}
		
		int maxPotential = (userTown.getLength() * userTown.getWidth())*12;
		double percent = (double) profit/maxPotential*100;
		System.out.printf("%.2f",percent);
		System.out.print("%");
	}
}
