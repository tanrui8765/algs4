import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 3/4/2017.
 */
public class BinarySearch_SmallestIndex
{
	private static int lowerBound(int[] data, int k)
	{
		int lo = 0, hi = data.length - 1;

		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (k < data[mid])
			{
				hi = mid - 1;
			}
			else if (k > data[mid])
			{
				lo = mid + 1;
			}
			else if ((mid != 0) && (k == data[mid]) && (k == data[mid - 1]))
			{
				hi = mid - 1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}

	private static int __test_id = 0;

	private static void __runTest(int[] data, int k, int expected)
	{
		StdOut.printf("%d. %s\n", ++__test_id, lowerBound(data, k) == expected ? "OK" : "Failed");
	}

	private static void __runTests()
	{
		int[] a = {1, 2, 3};
		__runTest(a, 4, -1);
		int[] b = {1, 1, 2, 2, 3, 3};
		__runTest(b, 2, 2);
		int[] c = {1, 1, 1, 1, 1};
		__runTest(c, 1, 0);

	}

	public static void main(String[] args)
	{
		__runTests();
	}
}
