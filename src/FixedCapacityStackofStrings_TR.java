import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 2/2/2017.
 */
public class FixedCapacityStackofStrings_TR
{
	private String[] a; // stack entries
	private int N;      // size

	public FixedCapacityStackofStrings_TR(int cap)
	{
		a = new String[cap];
	}

	public boolean isEmpty()
	{
		return N == 0;
	}

	public int size()
	{
		return N;
	}

	public void push(String item)
	{
		a[N++] = item;
	}

	public String pop()
	{
		return a[--N];
	}

	public boolean isFull()
	{
		return N == a.length;
	}

	public static void main(String[] args)
	{
		int size = 3;
		FixedCapacityStackofStrings_TR fcss = new FixedCapacityStackofStrings_TR(size);
		StdOut.println("fcss empty? " + fcss.isEmpty());
		StdOut.println();
		for (int i = 0; i < size; i++)
		{
			fcss.push("1");
			StdOut.println("fcss full? " + fcss.isFull());
		}

		StdOut.println();
		for (int i = 0; i < size; i++)
		{
			StdOut.println("pop " + Integer.toString(i) + " " + fcss.pop());
		}
	}
}
