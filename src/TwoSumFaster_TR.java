import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * Created by the_real_Rui on 8/4/2017.
 */
public class TwoSumFaster_TR
{
	// print distinct pairs (i,j) such that a[i] + a[j] = 0
	public static void printAll(int[] a)
	{
		int n = a.length;
		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				if (a[i] + a[j] == 0)
				{
					StdOut.println(a[i] + " " + a[j]);
				}
			}
		}
	}

	// return number of distinct pairs(i,j) such that a[i] + a[j] = 0;
	public static int count_brute(int[] a)
	{
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				if (a[i] + a[j] == 0)
				{
					count++;
				}
			}
		}
		return count;
	}

	public static int count_sorted(int[] a)
	{
		int n = a.length;
		int count = 0;

		if ((a[0] > 0) || (a[n] < 0)) return 0;

		if (a[0] == 0)
		{
			int count_0 = 0;
			for (int i = 0; i < n; i++)
			{
				if (a[i] == 0)
				{
					count_0++;
				}
			}

			if (count_0 == 1) return 0;
			count = count_0 * (count_0 - 1);
		}

		if (a[0] < 0)
		{

		}

		return count;
	}

	public static void main(String[] args)
	{
//		In in = new In("4Kints.txt");
//		In in = new In(args[0]);

//		int[] a = in.readAllInts();
		int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 7, 5, 4, 1, 6, 8, 9, -2, 4, -7, -7, -9, -6, -5, -6, -9, -8, -7, -5, -3, -9, -2, -1};
		Stopwatch timer = new Stopwatch();

		Arrays.sort(a);
		int count = count_brute(a);
		StdOut.println("elapsed time = " + timer.elapsedTime());
		StdOut.println(count);
	}


}
