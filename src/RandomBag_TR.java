import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 21/2/2017.
 */
public class RandomBag_TR<Item> implements Iterable<Item>
{
	private Item[] a;
	private int n = 0;
	private int first = 0;
	private int last = 0;

	public RandomBag_TR()
	{
		a = (Item[]) new Object[2];
		n = 0;
		first = 0;
		last = 0;
	}

	public boolean isEmpty()
	{
		return n == 0;
	}

	public int size()
	{
		return n;
	}

	private void resize(int capacity)
	{
		assert capacity >= n;
		// move array to a new array of size capacity
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++)
		{
			temp[i] = a[(first + i) % a.length];
//			temp[i] = a[i];
		}
		a = temp;
		first = 0;
		last = n;
	}

	public Item first()
	{
		if (isEmpty()) throw new NoSuchElementException("RandomBag is Empty");
		return a[first];
	}

	public Item last()
	{
		if (isEmpty()) throw new NoSuchElementException("RandomBag is Empty");
		return a[last - 1];
	}

	public void add(Item item)
	{
		if (n == a.length) resize(2 * a.length);

		a[last++] = item;

//		StdOut.printf("array: ");
//		for(int p=0;p<a.length;p++)
//		{
//			StdOut.printf("%5d, ",a[p]);
//		}
//		StdOut.println();
		n++;
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for (Item item : this)
		{
			s.append(item + " ");
		}
		return s.toString();
	}

	public Iterator<Item> iterator()
	{
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item>
	{
		public ArrayIterator()
		{
			shuffle(a);
		}

//		private void shuffle(Item b[])
//		{
//			int N = b.length;
//			for(int j=0;j<N;j++)
//			{
//				int r = j+(int)(Math.random()*(N-j));
//				Item temp = b[j];
//				b[j] = b[r];
//				b[r] = temp;
//			}
//		}

		private void shuffle(Item b[])
		{
			int N = size();
			for (int j = 0; j < N; j++)
			{   // Exchange a[i] with random element in a[i..N-1]
				int r = j + StdRandom.uniform(N - j);
				Item temp = b[j];
				b[j] = b[r];
				b[r] = temp;
			}
		}

		private int i = 0;

		public boolean hasNext()
		{
			return i < n;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}

		public Item next()
		{
			if (!hasNext()) throw new NoSuchElementException();
			Item item = a[(i + first) % a.length];
			i++;
			return item;
		}
	}

	/* Unit test helper */
	private static void showList(RandomBag_TR list)
	{
		StdOut.println(list);
		if (!list.isEmpty())
		{
			StdOut.printf("Size: %d, First: %s, Last: %s\n\n", list.size(), list.first(), list.last());
		}
		else
		{
			StdOut.printf("Size: %d\n\n", list.size());
		}
	}

	public static void main(String[] args)
	{
		StdOut.println("add:");
		int[] q = {1, 3, 5, 7, 9};
		RandomBag_TR<Integer> list = new RandomBag_TR<Integer>();

		for (int i = 0; i < q.length; i++)
		{
			list.add(q[i]);
		}
//		showList(list);
		StdOut.println(list.toString());
	}
}
