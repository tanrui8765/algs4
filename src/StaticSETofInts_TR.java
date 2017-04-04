import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by the_real_Rui on 4/4/2017.
 */
public class StaticSETofInts_TR
{
	private int[] a;

	public StaticSETofInts_TR(int[] keys)
	{
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++)
		{
			a[i] = keys[i];
		}
		Arrays.sort(a);
	}

	public boolean contains(int key)
	{
		return rank(key) != -1;
	}

	private int rank(int key)
	{
		// Binary search
		int lo = 0;
		int hi = a.length - 1;

		while (lo <= hi)
		{
			// key is in a[lo .. hi] or not present
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}

	// two pre-conditions
	// [1] key must in the array
	// [2] array must be sorted

	// this is just an initial implement, will be refined in the future
	private int find_same(int key_rank, int key)
	{
		int num = 0;
		if (key_rank == 0)
		{
			for (int i = 0; i < a.length; i++)
			{
				if (key == a[i])
					num++;
				else
					break;
			}
		}
		else if (key_rank == a.length - 1)
		{
			for (int i = a.length - 1; i >= 0; i--)
			{
				if (key == a[i])
					num++;
				else
					break;
			}
		}
		else
		{
			// search for left
			for (int i = key_rank; i >= 0; i--)
			{
				if (key == a[i])
					num++;
				else break;
			}
			// search for right
			for (int i = key_rank + 1; i < a.length - 1; i++)
			{
				if (key == a[i])
					num++;
				else break;
			}
		}

		return num;
	}

	private int howMany(int key)
	{
		int occur_num = 0;
		int key_rank = rank(key);

		if (key_rank != -1)
		{
			occur_num = find_same(key_rank, key);
		}

		return occur_num;
	}

	public static void main(String[] args)
	{
		int[] w = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 10};

		StaticSETofInts_TR set = new StaticSETofInts_TR(w);
		StdOut.println(set.contains(11));
		StdOut.println(set.howMany(11));


	}
}
