import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 8/5/2017.
 */
public class FibonacciSearch_TR
{
	private int min(int a, int b)
	{
		return a < b ? a : b;
	}

	public int search(int[] arr, int x, int n)
	{
		/* Initialize fibonacci numbers */
		int fibMMm2 = 0;    // (m-2)'th Fibonacci No.
		int fibMMm1 = 1;    // (m-1)'th Fibonacci No.
		int fibM = fibMMm2 + fibMMm1;   // m'th Fibonacci

		/*
		*  fibM is going to store the smallest Fibonacci Number greater than or
		*  equal to n
		*/

		while (fibM < n)
		{
			fibMMm2 = fibMMm1;
			fibMMm1 = fibM;
			fibM = fibMMm1 + fibMMm2;
		}

		// Marks the eliminated range from front
		int offset = -1;

		/*
		* while there are elements to be inspected. Note that we compare
		* arr[fibMMm2] with x. when fibM becomes 1, fibMMm2 becomes 0
		* */
		while (fibM > 1)
		{
			// check if fibMMm2 is a valid location
			int i = min(offset + fibMMm2, n - 1);

			/*
			* If x is greater than the value at index fibMMm2, cut the subarray
			* array from offset to i
			*/
			if (arr[i] < x)
			{
				fibM = fibMMm1;
				fibMMm1 = fibMMm2;
				fibMMm2 = fibM - fibMMm1;
				offset = i;
			}

			/*
			* if x is greater than the value at index fibMMm2, cut the subarray
			* after i+1
			*/
			else if (arr[i] > x)
			{
				fibM = fibMMm2;
				fibMMm1 = fibMMm1 - fibMMm2;
				fibMMm2 = fibM - fibMMm1;
			}

			/* element found. return index */
			else
				return i;
		}

		/* comparing the last element with x */
		if (fibMMm1 != 0 & arr[offset + 1] == x)
			return offset + 1;

		/* element not found. return -1 */
		return -1;
	}

	int fbsearch(int[] arry, int target)
	{
		int fm1 = 1;
		int fm2 = 0;
		int fm0 = fm1 + fm2;

		while (fm0 < arry.length)
		{
			fm2 = fm1;
			fm1 = fm0;
			fm0 = fm1 + fm2;
		}

		int offset = -1;
		while (fm1 > 0)
		{
			int mid = min((offset + fm1), arry.length - 1);
			if (arry[mid] == target)
				return mid;
			else if (arry[mid] < target)
			{
				fm0 = fm2;
				fm1 = fm1 - fm2;
				fm2 = fm2 - fm1;
				offset = mid;
			}
			else
			{
				fm0 = fm1;
				fm1 = fm2;
				fm2 = fm0 - fm1;
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int array[] = new int[10];
		for (int i = 0; i < 10; i++)
		{
			array[i] = i + 8;
			StdOut.print(array[i] + " ");
		}
		StdOut.println();

		FibonacciSearch_TR fs = new FibonacciSearch_TR();
		for (int i : array)
		{
			StdOut.print("i is " + i + "; ");
			StdOut.println(fs.fbsearch(array, i));
//			StdOut.println(fs.search(array,i,array.length));
		}
	}
}
