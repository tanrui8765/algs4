import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by the_real_Rui on 4/4/2017.
 */
public class StaticSETofInts_TR
{
	private int[] a;
	private int[] a_distinct;

	public StaticSETofInts_TR(int[] keys)
	{
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++)
		{
			a[i] = keys[i];
		}
		Arrays.sort(a);
		StdOut.println("Array Size: " + a.length);
	}

// Function Below is referenced from web:"https://ask.julyedu.com/question/558#!answer_form";
/*
	public StaticSETofInts_TR2(int[] keys)
	{
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++)
		{
			a[i] = keys[i];
		}
		Arrays.sort(a);

		// remove duplicates
		int length = 0;
		for (int i = 0; i < a.length; i++)
			if ((i == 0) || (a[i] != a[length - 1]))
				a[length++] = a[i];
		// no duplications in a[] now.
		a_distinct = new int[length];
		for (int i = 0; i < length; i++)
			a_distinct[i] = a[i];
		StdOut.println("Array Size: " + a_distinct.length);
	}
*/

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
		int debug_steps_num = 0;

		int num = 0;
		if (key_rank == 0)
		{
			for (int i = 0; i < a.length; i++)
			{
				if (key == a[i])
				{
					num++;
					debug_steps_num++;
				}
				else
					break;
			}
		}
		else if (key_rank == a.length - 1)
		{
			for (int i = a.length - 1; i >= 0; i--)
			{
				if (key == a[i])
				{
					num++;
					debug_steps_num++;
				}
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
				{
					num++;
					debug_steps_num++;
				}
				else break;
			}
			// search for right
			for (int i = key_rank + 1; i < a.length; i++)
			{
				if (key == a[i])
				{
					num++;
					debug_steps_num++;
				}
				else break;
			}
		}

		StdOut.print("step_num (" + debug_steps_num + ") ");

		return num;
	}

	private int find_same_binary(int key_rank, int key)
	{
		int debug_steps_num = 0;

		int num = 0;
		if (key_rank == 0)
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
				else lo = mid + 1;

				debug_steps_num++;
			}
			num = hi - key_rank + 1;
		}
		else if (key_rank == a.length - 1)
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
				else hi = mid - 1;

				debug_steps_num++;
			}
			num = key_rank - lo + 1;
		}
		else
		{
			{
				// Binary search to find left edge
				int lo = 0;
				int hi = a.length - 1;

				while (lo <= hi)
				{
					// key is in a[lo .. hi] or not present
					int mid = lo + (hi - lo) / 2;
					if (key < a[mid]) hi = mid - 1;
					else if (key > a[mid]) lo = mid + 1;
					else hi = mid - 1;

					debug_steps_num++;
				}
				num = key_rank - lo + 1;
			}

			{
				// Binary search to find right edge
				int lo = 0;
				int hi = a.length - 1;

				while (lo <= hi)
				{
					// key is in a[lo .. hi] or not present
					int mid = lo + (hi - lo) / 2;
					if (key < a[mid]) hi = mid - 1;
					else if (key > a[mid]) lo = mid + 1;
					else lo = mid + 1;

					debug_steps_num++;
				}
				num += hi - key_rank + 1 - 1; // key at key_rank added twice, hence -1.
			}
		}

		StdOut.print("step_num (" + debug_steps_num + ") ");

		return num;
	}

	private int howMany(int key)
	{
		int occur_num = 0;
		int key_rank = rank(key);

		if (key_rank != -1)
		{
			StdOut.print("Ordinary Find: ");
			occur_num = find_same(key_rank, key);           // this is the ordinary one, worst case is N
			StdOut.println(occur_num);

			StdOut.print("Binary Find: ");
			occur_num = find_same_binary(key_rank, key);    // this is the binary search one, worst case might be log(N)
			// Am I Right ??? Could anyone help me to figure it out,
			// thanks !!!
			StdOut.println(occur_num);
		}

		return occur_num;
	}

	public static void main(String[] args)
	{
		int[] w = {1, 1, 1, 1, 1, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10};
//		int[] w = {1, 1, 1, 1, 1};
//		int[] w = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

		StaticSETofInts_TR set = new StaticSETofInts_TR(w);
//		StdOut.println(set.contains(5));
		set.howMany(1);
	}
}
