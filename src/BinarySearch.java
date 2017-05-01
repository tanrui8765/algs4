/**
 * Created by the_real_Rui on 25/12/2016.
 */
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch
{
	public static int rank(int key, int[] a, int start_pos, int end_pos)
	{
		if (start_pos > end_pos) return -1;
		if (start_pos < 0) return -1;
		if (end_pos > a.length - 1) return -1;

		int lo = start_pos;
		int hi = end_pos;
		while (lo <= hi)
		{   // Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}

    public static int rank(int key, int[] a)
    {   // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {   // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty())
        {   // Read key, print if not in whitelist
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}
