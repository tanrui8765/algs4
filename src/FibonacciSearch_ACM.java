/**
 * Created by the_real_Rui on 12/5/2017.
 */

/*
  Fibonaccian search for locating the index of "key" in an array "pData" of size "n"
  that is sorted in ascending order. See http://doi.acm.org/10.1145/367487.367496

  Algorithm description
  -----------------------------------------------------------------------------
  Let Fk represent the k-th Fibonacci number where Fk+2=Fk+1 + Fk for k>=0 and
  F0 = 0, F1 = 1. To test whether an item is in a list of n = Fm ordered numbers,
  proceed as follows:
  a) Set k = m.
  b) If k = 0, finish - no match.
  c) Test item against entry in position Fk-1.
  d) If match, finish.
  e) If item is less than entry Fk-1, discard entries from positions Fk-1 + 1 to n.
     Set k = k - 1 and go to b).
  f) If item is greater than entry Fk-1, discard entries from positions 1 to Fk-1.
     Renumber remaining entries from 1 to Fk-2, set k = k - 2 and go to b)

  If Fm>n then the original array is augmented with Fm-n numbers larger
  than key and the above algorithm is applied.
 */
public class FibonacciSearch_ACM
{
	/*  Precomputed Fibonacci numbers F0 up to F46. This implementation assumes that the size n
	 *  of the input array fits in 4 bytes. Note that F46=1836311903 is the largest Fibonacci
	 *  number that is less or equal to the 4-byte INT_MAX (=2147483647). The next Fibonacci
	 *  number, i.e. F47, is 2971215073 and is larger than INT_MAX, implying that it does not
	 *  fit in a 4 byte integer. Note also that the last array element is INT_MAX rather than
	 *  F47. This ensures correct operation for n>F46.
	 */
	static int[] Fib = {
			0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
			10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578,
			5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
			433494437, 701408733, 1134903170, 1836311903
	};

	public static int fbsearch(int[] data, int n, int key)
	{
		int k, idx, offs;
		int prevn = -1, prevk = -1;

		/* find the smallest fibonacci number that is greater or equal to n. Store this
		 * number to avoid recomputing it in the case of repetitive searches with identical n.
         */
		if (n != prevn)
		{
			int f0, f1, t;
			for (f0 = 0, f1 = 1, k = 1; f1 < n; t = f1, f1 += f0, f0 = t, ++k) ;

			prevk = k;
			prevn = n;
		}
		else
		{
			k = prevk;
		}

		/* If the sought value is larger than the largest Fibonacci number less than n,
	     * care must be taken top ensure that we do not attempt to read beyond the end
	     * of the array. If we do need to do this, we pretend that the array is padded
	     * with elements larger than the sought value.
	     */
		for (offs = 0; k > 0; )
		{
			idx = offs + Fib[--k];

			/* note that at this point k  has already been decremented once */

		}
	}


}
