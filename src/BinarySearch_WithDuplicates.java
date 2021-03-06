import edu.princeton.cs.algs4.StdOut;

/**
 * Created by john on 2017/5/25.
 *
 * Array must sorted first, in ascending order.
 */
public class BinarySearch_WithDuplicates
{
	private static int upperBound(int[] data, int k)
	{
		int lo = 0, hi = data.length - 1;

		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (k < data[mid])		// key smaller than mid value, find to the left section
			{
				hi = mid - 1;
			}
			else if (k > data[mid])	// key larger than mid value, find to the right section
			{
				lo = mid + 1;
			}
			// key equal to the mid value, if mid value is not the largest index, and the mid value and mid+1
			// are equal, it means duplicates exist, search further to the right(higher) section.
			else if ((mid != (data.length - 1)) && (k == data[mid]) && (k == data[mid + 1]))
			{
				lo = mid + 1;
			}
			// if key equal to the mid value,
			// and if mid index is reached to the top index,
			// or if mid value is the key and the mid+1(higher) value is not the key,
			// any condition above means the higher bound of duplicates found.
			else
			{
				return mid;
			}
		}

		// if cursor lo greater than cursor hi, means search complete, and nothing found.
		return -1;
	}

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
		StdOut.printf("Lower Test %d. %s\n", ++__test_id, lowerBound(data, k) == expected ? "OK" : "Failed");
	}

	private static void __runTest_upper(int[] data, int k, int expected)
	{
		StdOut.printf("Higher Test %d. %s\n", ++__test_id, upperBound(data, k) == expected ? "OK" : "Failed");
	}

	private static void __runTests()
	{
		// Lower Bound test
		int[] a = {1, 2, 3};
		__runTest(a, 4, -1);
		int[] b = {1, 1, 2, 2, 3, 3};
		__runTest(b, 2, 2);
		int[] c = {1, 1, 1, 1, 1};
		__runTest(c, 1, 0);
		int[] d = {1, 1, 1, 1, 1};
		__runTest(d, 2, -1);

		// Higher Bound Test
		int[] a1 = {1, 2, 3};
		__runTest_upper(a1, 4, -1);
		int[] b1 = {1, 1, 2, 2, 3, 3};
		__runTest_upper(b1, 2, 3);
		int[] c1 = {1, 1, 1, 1, 1};
		__runTest_upper(c1, 1, 4);
		int[] d1 = {1, 1, 1, 1, 1};
		__runTest_upper(d1, 2, -1);
	}

	public static void main(String[] args)
	{
		__runTests();
	}
}
