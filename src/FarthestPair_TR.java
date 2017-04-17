import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by the_real_Rui on 17/4/2017.
 * <p>
 * The code in this page is from:
 * "https://github.com/HatlessFox/SelfStudy/blob/master/problem_solving/algorithms/algorithms_4th-sedgewick_wayne/Solutions/src/chapter_1/section_4/Task_17.java"
 */
public class FarthestPair_TR
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

	public static DoubleInterval farthestPair2(double[] data)
	{
		if (data.length < 2) return null;

		double min_value = Double.POSITIVE_INFINITY, max_value = Double.NEGATIVE_INFINITY;

		for (int i = 0; i < data.length; i++)
		{
			min_value = data[i] < min_value ? data[i] : min_value;
			max_value = max_value < data[i] ? data[i] : max_value;
		}
		return new DoubleInterval(min_value, max_value);
	}

	public static DoubleInterval farthestPair(double[] data)
	{
		DoubleInterval result = null;
		Arrays.sort(data);

		for (int i = 1; i < data.length; i++)
		{
			DoubleInterval testee = new DoubleInterval(data[i - 1], data[i]);
			if (result == null || testee.compareTo(result) > 0)
			{
				result = testee;
			}
		}
		return result;
	}

	public static DoubleInterval farthestPairBf(double[] data)
	{
		DoubleInterval result = null;
		for (int i = 0; i < data.length; i++)
		{
			for (int j = i + 1; j < data.length; j++)
			{
				DoubleInterval testee = new DoubleInterval(data[i], data[j]);
				if (result == null || testee.compareTo(result) > 0)
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
		DoubleInterval closest = farthestPair(array);
		StdOut.println(closest.toString());
	}
}
