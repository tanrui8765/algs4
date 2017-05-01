import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 1/5/2017.
 */
public class BitonicSearch_TR
{
	public static void main(String[] args)
	{
		BitonicMax bm = new BitonicMax();
		BinarySearch bs = new BinarySearch();

		int key = 10;
		int N = 20;
		int[] a = bm.bitonic(N);
		int max_pos = bm.max(a, 0, N - 1);

		StdOut.println("max = " + a[bm.max(a, 0, N - 1)]);

		int search_rlt = -1;
		int search_section = 0;

		// search left
		search_rlt = bs.rank(key, a, 0, max_pos);

		if (search_rlt == -1)
		{
			// search right
			search_rlt = bs.rank(key, a, max_pos, a.length - 1);
			if (search_rlt != -1)
			{
				search_section = 1;
			}
		}
		else
		{
			search_section = -1;
		}

		if (search_section == 1)
		{
			StdOut.println("Result is in Right Section.");
		}
		else if (search_section == -1)
		{
			StdOut.println("Result is in Left Section.");
		}
		else
		{
			StdOut.println("Nothing's Found");
		}

		if (search_rlt != -1)
		{
			StdOut.println("The Key " + key + " is at position " + (search_rlt + 1) + ".");
		}
	}
}
