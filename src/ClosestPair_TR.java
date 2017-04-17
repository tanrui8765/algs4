import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by the_real_Rui on 16/4/2017.
 * <p>
 * The code in this page is copied from:
 * "https://github.com/HatlessFox/SelfStudy/blob/master/problem_solving/algorithms/algorithms_4th-sedgewick_wayne/Solutions/src/chapter_1/section_4/Task_16.java"
 */
public class ClosestPair_TR
{
	public static class DoubleInterval implements Comparable<DoubleInterval>
	{
		public double fst, snd;

		public DoubleInterval(double a, double b)
		{
			fst = a;
			snd = b;
		}

		public double dist1d()
		{
			return Math.abs(fst - snd);
		}

		@Override
		public boolean equals(Object obj)
		{
			if (obj == null) return false;
			if (!(obj instanceof DoubleInterval)) return false;

			DoubleInterval that = (DoubleInterval) obj;
			return compareTo(that) == 0;
		}

		@Override
		public int compareTo(DoubleInterval that)
		{
			return Double.compare(dist1d(), that.dist1d());
		}

		@Override
		public String toString()
		{
			return String.format("{%.5f,%.5f}", fst, snd);
		}
	}

	public static DoubleInterval closestPair(double[] data)
	{
		DoubleInterval result = null;
		Arrays.sort(data);

		for (int i = 1; i < data.length; i++)
		{
			DoubleInterval testee = new DoubleInterval(data[i - 1], data[i]);
			if (result == null || testee.compareTo(result) < 0)
			{
				result = testee;
			}
		}
		return result;
	}

	public static DoubleInterval closestPairBf(double[] data)
	{
		DoubleInterval result = null;
		for (int i = 0; i < data.length; i++)
		{
			for (int j = i + 1; j < data.length; j++)
			{
				DoubleInterval testee = new DoubleInterval(data[i], data[j]);
				if (result == null || testee.compareTo(result) < 0)
				{
					result = testee;
				}
			}
		}
		return result;
	}

	public static void main(String[] args)
	{
		double[] array = {1.0, 2.0, 3.0, 4.5, 6.0, 6.1, 8.0, 9.0};
		DoubleInterval closest = closestPair(array);
		StdOut.println(closest.toString());
	}
}
