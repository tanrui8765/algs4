/**
 * Created by the_real_Rui on 28/1/2017.
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

import java.util.Arrays;
import java.util.Comparator;

public class Transaction_TR implements Comparable<Transaction_TR>
{
	// This Class is a Copy of "aistrate/AlgorithmsSedgewick"'s GitHub Code.


	private final String who;
	private final SmartDate_TR when;
	private final double amount;

	public Transaction_TR(String who, SmartDate_TR when, double amount)
	{
		this.who = who;
		this.when = when;
		this.amount = amount;
	}

	// create new transaction by parsing string of the form: name,
	// date, real number, separated by whitespace
	public Transaction_TR(String transaction)
	{
		String[] a = transaction.split("\\s+");
		who = a[0];
		when = new SmartDate_TR(a[1]);
		amount = Double.parseDouble(a[2]);
	}

	// access methods
	public String who()
	{
		return who;
	}

	public SmartDate_TR when()
	{
		return when;
	}

	public double amount()
	{
		return amount;
	}

	public String toString()
	{
		return String.format("%-10s %10s %8.2f", who, when, amount);
	}

	public int compareTo(Transaction_TR that)
	{
		if (this.amount < that.amount) return -1;
		else if (this.amount > that.amount) return +1;
		else return 0;
	}

	// is the transaction equal to x?
	public boolean equals(Object x)
	{
		if (x == this) return true;
		if (x == null) return false;
		if (x.getClass() != this.getClass()) return false;
		Transaction_TR that = (Transaction_TR) x;
		return (this.amount == that.amount) && (this.who.equals(that.who))
				&& (this.when.equals(that.when));
	}

	public int hashCode()
	{
		int hash = 17;
		hash = hash * 31 + who.hashCode();
		hash = hash * 31 + when.hashCode();
		hash = hash * 31 + ((Double) amount).hashCode();

		return hash;
	}

	// ascending order of account number
	public static class WhoOrder implements Comparator<Transaction_TR>
	{
		public int compare(Transaction_TR v, Transaction_TR w)
		{
			return v.who.compareTo(w.who);
		}
	}


	// ascending order of time
	public static class WhenOrder implements Comparator<Transaction_TR>
	{
		public int compare(Transaction_TR v, Transaction_TR w)
		{
			return v.when.compareTo(w.when);
		}
	}

	// ascending order of amount
	public static class HowMuchOrder implements Comparator<Transaction_TR>
	{
		public int compare(Transaction_TR v, Transaction_TR w)
		{
			if (v.amount < w.amount) return -1;
			else if (v.amount > w.amount) return +1;
			else return 0;
		}
	}

	public static void main(String[] args)
	{
		Transaction_TR[] a = new Transaction_TR[4];

		a[0] = new Transaction_TR("Turing   6/17/1990  644.08");
		a[1] = new Transaction_TR("Tarjan   3/26/2002  4121.85");
		a[2] = new Transaction_TR("Knuth    6/14/1999  288.34");
		a[3] = new Transaction_TR("Dijkstra 8/22/2007  2678.40");

		StdOut.println("Unsorted");
		for (int i = 0; i < a.length; i++)
		{
			StdOut.println(a[i]);
		}
		StdOut.println();

		StdOut.println("Sort by date");
		Arrays.sort(a, new Transaction_TR.WhenOrder());
		for (int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
		StdOut.println();

		StdOut.println("Sort by customer");
		Arrays.sort(a, new Transaction_TR.WhoOrder());
		for (int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
		StdOut.println();

		StdOut.println("Sort by amount");
		Arrays.sort(a, new Transaction_TR.HowMuchOrder());
		for (int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
		StdOut.println();
	}
}
