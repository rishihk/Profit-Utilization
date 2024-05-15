package edu.iastate.cs228.hw1;

/*
 * @author - HRISHIKESHA KYATHSANDRA
 * @version - 1.0.
 * 
 * Represents a Casual user in the grid.
 */
public class Casual extends TownCell
{
	public Casual(Town p, int r, int c)
	{
		super(p, r, c);
	}

	@Override
	public State who()
	{
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew)
	{
		census(nCensus);
		if (nCensus[TownCell.EMPTY] + nCensus[TownCell.OUTAGE] <= 1)
		{
			return new Reseller(tNew, row, col);
		} 

		else if (nCensus[TownCell.RESELLER] > 0)
		{
			return new Outage(tNew, row, col);
		}

		else if (nCensus[TownCell.STREAMER] > 0)
		{
			return new Streamer(tNew, row, col);
		}
		
		else if (nCensus[TownCell.CASUAL] >= 5)
		{
			return new Streamer(tNew, row, col);
		}

		return new Casual(tNew, row, col);
	}

}
