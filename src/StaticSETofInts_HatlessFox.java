import edu.princeton.cs.algs4.StdOut;

import java.util.function.Predicate;

/**
 * Created by the_real_Rui on 4/4/2017.
 * <p>
 * this file is refered from GitHub::Hatless Fox
 * "https://github.com/HatlessFox/SelfStudy/blob/master/problem_solving/algorithms/algorithms_4th-sedgewick_wayne/Solutions/src/chapter_1/section_4/Task_11.java"
 */
public class StaticSETofInts_HatlessFox
{
	private static int bsTemplate(int data[], int k, Predicate<Integer> shouldGoLeft, Predicate<Integer> shouldGoRight)
	{
		int lo = 0, hi = data.length - 1;
		while (lo <= hi)
		{
			debug_steps_num++;

			int mid = lo + (hi - lo) / 2;
			if (shouldGoLeft.test(mid))
			{
				hi = mid - 1;
			}
			else if (shouldGoRight.test(mid))
			{
				lo = mid + 1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}

	private static int lowerBound(int data[], int k)
	{
		return bsTemplate(data, k,
				(mid) -> k < data[mid] || (data[mid] == k && mid != 0) && data[mid - 1] == k,
				(mid) -> data[mid] < k);
	}

	private static int upperBound(int data[], int k)
	{
		return bsTemplate(data, k,
				(mid) -> k < data[mid],
				(mid) -> data[mid] < k || (data[mid] == k && (mid != data.length - 1) && data[mid + 1] == k));
	}

	private static int howMany(int data[], int k)
	{
		int upper_bnd = upperBound(data, k);
		if (upper_bnd == -1)
		{
			return 0;
		}
		return upper_bnd - lowerBound(data, k) + 1;
	}

	private static int __test_id = 0;
	private static int debug_steps_num = 0;

	private static void __runTest(int[] data, int k, int expected)
	{
		StdOut.printf("%d,%s\n", ++__test_id, howMany(data, k) == expected ? "OK" : "Failed");
	}

	private static void __runTests()
	{
		int[] w0 = {1, 1, 1, 1, 1, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10};
//		int[] w = {1, 1, 1, 1, 1};
		int[] w1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};


		__runTest(w0, 1, 5);
		StdOut.println("steps num: " + debug_steps_num);
		debug_steps_num = 0;
		__runTest(w1, 1, w1.length);
		StdOut.println("steps num: " + debug_steps_num);
		debug_steps_num = 0;
	}

	public static void main(String[] args)
	{
		__runTests();
	}
}
