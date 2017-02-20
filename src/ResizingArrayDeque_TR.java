import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by the_real_Rui on 19/2/2017.
 * this solution is mainly referenced from GleasonK/Java on Github
 */
public class ResizingArrayDeque_TR<Item> implements Iterable<Item>
{
	private Item[] q;       // Deque Items
	private int n = 0;      // number of Items
	private int first = 0;  // index of first element of queue
	private int last = 0;   // index of next available slot

	// Initialize an empty queue
	public ResizingArrayDeque_TR()
	{
		q = (Item[]) new Object[2];
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
		// Move array to a new array of size max.
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
		if (isEmpty()) throw new NoSuchElementException("Deque is empty");
		return q[first];
	}

	public Item last()
	{
		if (isEmpty()) throw new NoSuchElementException("Deque is empty");
		return q[last - 1];
	}

	public void pushLeft(Item item)
	{
		if (n == q.length) resize(2 * q.length);

		if (first == 0)
		{
			first = q.length - 1;
			q[first] = item;
		}
		else
		{
			first--;
			q[first] = item;
		}
		n++;
	}

	public void pushRight(Item item)
	{
		if (n == q.length) resize(2 * q.length);

		q[last++] = item;
		if (last == q.length) last = 0;
		n++;
	}

	public Item popLeft()
	{
		if (isEmpty()) throw new NoSuchElementException("Deque Underflow");
		Item item = q[first];
		q[first] = null;
		n--;
		first++;
		if (first == q.length) first = 0;
		if (n > 0 && n == q.length / 4) resize(q.length / 2);
		return item;
	}


	public Item popRight()
	{
		if (isEmpty()) throw new NoSuchElementException("Deque Underflow");

		Item item = q[last];
		q[last] = null;
		if (last == 0) last = q.length - 1;
		else last--;
		n--;
		if (n > 0 && n == q.length / 4) resize(q.length / 2);
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

	public Iterable<Item> reversed()
	{
		return new ReverseIterable();
	}

	private class ReverseIterable implements Iterable<Item>
	{
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
			return new ReverseListIterator();
		}

		private class ReverseListIterator implements Iterator<Item>
		{
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
				if (!hasNext())
				{
					throw new NoSuchElementException();
				}
				Item item;
				if (last - i >= 0) item = q[last - i];
				else item = q[q.length - i + last];
				i++;
				return item;
			}
		}
	}

	/* Unit Test */
	private static void testPushRight()
	{
		StdOut.println("push right:");
		int[] a = {1, 3, 5, 7, 9};
		Deque_TR<Integer> list = new Deque_TR<Integer>();

		for (int i = 0; i < a.length; i++)
		{
			list.pushRight(a[i]);
		}
		showList(list);
		StdOut.println();
	}

	private static void testPushLeft()
	{
		StdOut.println("push left:");
		int[] a = {1, 3, 5, 7, 9};
		Deque_TR<Integer> list = new Deque_TR<Integer>();

		for (int i = 0; i < a.length; i++)
		{
			list.pushLeft(a[i]);
		}
		showList(list);
		StdOut.println();
	}

	private static void testPopLeft()
	{
		StdOut.println("pop left:");
		Deque_TR<Integer> list = new Deque_TR<Integer>(new Integer[]{3, 9, 11});
		StdOut.println(list + "[initial]\n");

		while (!list.isEmpty())
		{
			StdOut.println("pop: " + list.popLeft());
			showList(list);
		}
		StdOut.println();
	}

	private static void testPopRight()
	{
		StdOut.println("pop right:");
		Deque_TR<Integer> list = new Deque_TR<Integer>(new Integer[]{3, 9, 11});
		StdOut.println(list + "[initial]\n");

		while (!list.isEmpty())
		{
			StdOut.println("pop: " + list.popRight());
			showList(list);
		}
		StdOut.println();
	}

	/* Unit test helper */
	private static void showList(Deque_TR list)
	{
		StdOut.println(list);
		StdOut.println(list.reversed() + "[in reverse]");
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
//		testPushRight();
//		testPopRight();

		testPushLeft();
		testPopLeft();
	}
}
