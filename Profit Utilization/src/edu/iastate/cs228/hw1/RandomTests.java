package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;

public class RandomTests
{
	public static void main(String[] args) throws FileNotFoundException
	{

		Town t1 = new Town("ISP4X4.txt");

		System.out.println(t1.toString());

		System.out.println();

		System.out.println(ISPBusiness.updatePlain(t1));

		Town t = new Town("ISP4X4.txt");
		int[] cens = new int[5];

		TownCell tc00 = new Outage(t, 0, 0);
		tc00.census(cens);
		TownCell tc01 = new Reseller(t, 0, 1);
		tc01.census(cens);
		TownCell tc02 = new Outage(t, 0, 2);
		tc02.census(cens);
		TownCell tc03 = new Reseller(t, 0, 3);
		tc03.census(cens);

		TownCell tc10 = new Empty(t, 1, 0);
		tc10.census(cens);
		TownCell tc11 = new Empty(t, 1, 1);
		tc11.census(cens);
		TownCell tc12 = new Casual(t, 1, 2);
		tc12.census(cens);
		TownCell tc13 = new Outage(t, 1, 3);
		tc13.census(cens);

		TownCell tc20 = new Empty(t, 2, 0);
		tc20.census(cens);
		TownCell tc21 = new Streamer(t, 2, 1);
		tc21.census(cens);
		TownCell tc22 = new Outage(t, 2, 2);
		tc22.census(cens);
		TownCell tc23 = new Streamer(t, 2, 3);
		tc23.census(cens);

		TownCell tc30 = new Empty(t, 3, 0);
		tc30.census(cens);
		TownCell tc31 = new Outage(t, 3, 1);
		tc31.census(cens);
		TownCell tc32 = new Reseller(t, 3, 2);
		tc32.census(cens);
		TownCell tc33 = new Reseller(t, 3, 3);
		tc33.census(cens);

	}
}
