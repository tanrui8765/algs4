import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 28/2/2017.
 */
public class GeneralizedQueue_TR<Item> implements Iterable<Item>
{
	private Item[] q;   // queue elements
	private int n;      // number of elements on queue
	private int first;  // index of first element of queue
	private int last;   // index of next available slot

	// Initializes an empty queue.
	public GeneralizedQueue_TR()
	{
		q = (Item[]) new Object[2];
		n = 0;
		first = 0;
		last = 0;
	}

	// is the queue empty?
	// return true if the queue is empty, otherwise false
	public boolean isEmpty()
	{
		return n == 0;
	}

	// return number of items in this queue
	public int size()
	{
		return n;
	}

	// resize the underlying array
	private void resize(int capacity)
	{
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++)
		{
			temp[i] = q[(first + i) % q.length];
		}
		q = temp;
		first = 0;
		last = n;
	}

	public Item first()
	{
		if (isEmpty()) throw new NoSuchElementException("GeneralizedQueue is Empty");
		return q[first];
	}

	public Item last()
	{
		if (isEmpty()) throw new NoSuchElementException("GeneralizedQueue is Empty");
		return q[last - 1]; // might have wrap around problem, should check carefully later.
	}

	// add the item to this queue
	public void insert(Item item)
	{
		// double size of array if necessary and recopy to front of array
		if (n == q.length) resize(2 * q.length);    // double size of array if necessary
		q[last++] = item;                                   // add item
		if (last == q.length) last = 0;                     // wrap-around
		n++;
	}

	public Item delete(int k)
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		if ((k <= 0) || (k > n)) throw new NoSuchElementException("No such index");

		Item item;
		if (n == 1)
		{
			item = q[first];
			q[first] = null;
			n--;
			first = 0;
			last = 0;
		}
		else
		{
			if (k <= (n - first))    // (n-1) - first + 1
			{
				item = q[first + k - 1];

				for (int i = first + k - 1; i > first; i--)
				{
					q[i] = q[i - 1];
				}
			}
			else
			{
				int index = k + first - n;
				item = q[index - 1];

				for (int i = index - 1; i > 0; i--)
				{
					q[i] = q[i - 1];
				}
				q[0] = q[q.length - 1];
				for (int i = q.length - 1; i > first; i--)
				{
					q[i] = q[i - 1];
				}
			}
			q[first] = null;
			n--;
			first++;
			if (first == q.length) first = 0;
			// shrink size of array if necessary
			if (n > 0 && n == q.length / 4) resize(q.length / 2);
		}
		return item;
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
		}

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
			Item item = q[(i + first) % q.length];
			i++;
			return item;
		}
	}

	/* Unit test helper */
	private static void showList(GeneralizedQueue_TR list)
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
		StdOut.println("enqueue: ");
		int[] q = {1, 3, 5, 7, 9};
		GeneralizedQueue_TR<Integer> list = new GeneralizedQueue_TR<>();

		for (int i = 0; i < q.length; i++)
		{
			list.insert(q[i]);
		}
		showList(list);
		StdOut.println("generalized queue is: " + list.toString());
		StdOut.println();

		StdOut.println("delete: " + list.delete(2).toString());
		StdOut.println("delete: " + list.delete(3).toString());
		StdOut.println("generalized queue is: " + list.toString());

		int[] q2 = {2, 4, 6, 8, 10};
		for (int i = 0; i < q.length; i++)
		{
			list.insert(q2[i]);
		}
		showList(list);
		StdOut.println("generalized queue is: " + list.toString());
		StdOut.println();

		StdOut.println("delete: " + list.delete(2).toString());
		StdOut.println("delete: " + list.delete(3).toString());
		StdOut.println("generalized queue is: " + list.toString());
	}
}
