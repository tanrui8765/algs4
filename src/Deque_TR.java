import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 19/2/2017.
 */
public class Deque_TR<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int N = 0;

	private class Node
	{
		private Deque_TR<Item> parent = list();
		private Item item;
		private Node next;
		private Node prev;
	}

	private Deque_TR<Item> list()
	{
		return this;
	}

	public Deque_TR()
	{
		first = null;
		last = null;
		N = 0;
	}

	public Deque_TR(Item[] a)
	{
		for (Item t : a)
		{
			pushRight(t);
		}
	}

	public Deque_TR(Iterable<Item> coll)
	{
		for (Item t : coll)
		{
			pushRight(t);
		}
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public int size()
	{
		return N;
	}

	public Item first()
	{
		if (isEmpty()) throw new NoSuchElementException("List is empty");
		return first.item;
	}

	public Item last()
	{
		if (isEmpty()) throw new NoSuchElementException("List is empty");
		return last.item;
	}

	private void prepend(Item item)
	{
		Node x = new Node();
		x.item = item;
		if (isEmpty())
		{
			first = x;
			last = x;
		}
		else
		{
			x.next = first;
			first.prev = x;
			first = x;
		}
		N++;
	}

	private void append(Item item)
	{
		Node x = new Node();
		x.item = item;
		if (isEmpty())
		{
			first = x;
			last = x;
		}
		else
		{
			x.prev = last;
			last.next = x;
			last = x;
		}
		N++;
	}

	public Item removeLast()
	{
		if (isEmpty()) throw new RuntimeException("List is Empty");
		Item item = last.item;
		last.parent = null;
		if (last.prev != null) last.prev.next = null;
		last = last.prev;
		N--;
		if (last == null) first = null;  // to avoid loitering
		return item;
	}

	public Item removeFirst()
	{
		if (isEmpty()) throw new RuntimeException("List is Empty");
		Item item = first.item;
		first.parent = null;
		if (first.next != null) first.next.prev = null;
		first = first.next;
		N--;
		if (first == null) last = null;
		return item;
	}


	public void pushRight(Item item)
	{
		append(item);
	}

	public void pushLeft(Item item)
	{
		prepend(item);
	}

	public Item popRight()
	{
		return removeLast();
	}

	public Item popLeft()
	{
		return removeFirst();
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
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;

		public boolean hasNext()
		{
			return current != null;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}

		public Item next()
		{
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
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
			private Node current = last;

			public boolean hasNext()
			{
				return current != null;
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
				Item item = current.item;
				current = current.prev;
				return item;
			}
		}
	}

	/* Unit Test */
	private static void testPushRight()
	{
		StdOut.println("push right:");
		int[] a = {2, 4, 6, 8, 10};
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
		int[] a = {2, 4, 6, 8, 10};
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
		Deque_TR<Integer> list = new Deque_TR<Integer>(new Integer[]{6, 8, 12});
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
		Deque_TR<Integer> list = new Deque_TR<Integer>(new Integer[]{6, 8, 12});
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
