import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 17/4/2017.
 * <p>
 * The code in this page is from:
 * "https://github.com/HatlessFox/SelfStudy/blob/master/problem_solving/algorithms/algorithms_4th-sedgewick_wayne/Solutions/src/chapter_1/section_4/Task_18.java"
 */
public class LocalMinArray_TR
{
	private static boolean isDecrLeft(int data[], int i)
	{
		return i != 0 && data[i - 1] < data[i];
	}

	private static boolean isLocalMin(int data[], int i)
	{
		if (i == 0)
		{
			return data[i] < data[i + 1];
		}
		if (i == data.length - 1)
		{
			return data[i - 1] > data[i];
		}
		return data[i - 1] > data[i] && data[i] < data[i + 1];
	}

	public static int findLocalMin(int data[])
	{
		if (data.length == 0) return -1;
		if (data.length == 1) return 0;

		int lo = 0, hi = data.length - 1;

		while (lo < hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (isLocalMin(data, mid))
			{
				return mid;
			}
			else if (isDecrLeft(data, mid))
			{
				hi = mid - 1;
			}   // Move search space to left
			else
			{
				lo = mid + 1;
			}                            // Move search space to right
		}
		return hi;
	}

	public static boolean verifyLocalMin(int[] data, int ind)
	{
		if (ind < 0 || data.length <= ind) return data.length == 0 && ind < 0;
		if (data.length == 1) return true;

		if (ind == 0 && data[ind] < data[ind + 1] || ind == data.length - 1 && data[ind] < data[ind - 1])
		{
			return true;
		}

		return data[ind - 1] > data[ind] && data[ind] < data[ind + 1];
	}

	public static void main(String[] args)
	{
//		int[] array = {1,2,6,4,7,9,4};
//		int[] array = {1,3,5,6,4,2};
//		int[] array = {6,5,4,3};
		int[] array = {3, 2, 4, 5, 8, 7, 9};
//		int[] array = {9,7,8,5,4,2,3};
		int local_min_index = findLocalMin(array);

		boolean verify = verifyLocalMin(array, local_min_index);

		StdOut.println("Local Min Index: " + local_min_index);
		StdOut.println("Value is: " + array[local_min_index]);
		StdOut.println("Verification Rst: " + verify);
	}
}
