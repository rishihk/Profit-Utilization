package edu.iastate.cs228.hw1;

/*
 * @author - HRISHIKESHA KYATHSANDRA
 * @version - 1.0.
 * 
 * Represents a Streamer in the grid.
 */
public class Streamer extends TownCell
{
	public Streamer(Town p, int r, int c)
	{
		super(p, r, c);
	}

	@Override
	public State who()
	{
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew)
	{
		census(nCensus);
		if (nCensus[TownCell.EMPTY] + nCensus[TownCell.OUTAGE] <= 1)
		{
			return new Reseller(tNew, row, col);
		} 
		
		else if(nCensus[TownCell.RESELLER]>0) 
		{
			return new Outage(tNew, row, col);
		}
		
		else if(nCensus[TownCell.OUTAGE]>0) 
		{
			return new Empty(tNew, row, col);
		}
		
		else if (nCensus[TownCell.CASUAL] >= 5)
		{
			return new Streamer(tNew, row, col);
		}
		
		return new Streamer(tNew, row, col);
	}

}
