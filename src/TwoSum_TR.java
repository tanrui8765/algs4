import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by the_real_Rui on 26/3/2017.
 */
public class TwoSum_TR
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
	public static int count(int[] a)
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

	public static void main(String[] args)
	{
		In in = new In("4Kints.txt");
//		In in = new In(args[0]);

		int[] a = in.readAllInts();
		Stopwatch timer = new Stopwatch();
		int count = count(a);
		StdOut.println("elapsed time = " + timer.elapsedTime());
		StdOut.println(count);
	}


}
