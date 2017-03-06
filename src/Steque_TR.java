import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 17/2/2017.
 */
public class Steque_TR<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int N = 0;

	private class Node
	{
		private Steque_TR<Item> parent = list();
		private Item item;
		private Node next;
		private Node prev;
	}

	private Steque_TR<Item> list()
	{
		return this;
	}

	public Steque_TR()
	{
		first = null;
		last = null;
		N = 0;
	}

	public Steque_TR(Item[] a)
	{
		for (Item t : a)
		{
			push(t);
		}
	}

	public Steque_TR(Iterable<Item> coll)
	{
		for (Item t : coll)
		{
			push(t);
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

	public void setSize(int stq_size)
	{
		N = stq_size;
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


	public void push(Item item)
	{
		append(item);
	}

	public void enqueue(Item item)
	{
		append(item);
	}

	public Item pop()
	{
		return removeLast();
	}

	public Item dequeue()
	{
		return removeFirst();
	}

	public Steque_TR<Item> catenation(Steque_TR<Item> stq)
	{
		if (stq.isEmpty()) throw new NoSuchElementException("Input Null");

		Steque_TR<Item> tmp = new Steque_TR<Item>();

		tmp.first = this.first;
		tmp.last = stq.last;
		this.last.next = stq.first;
		stq.first.prev = this.last;

		tmp.setSize(this.size() + stq.size());

		return tmp;
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
	private static void testPush()
	{
		StdOut.println("push:");
		int[] a = {2, 4, 6, 8, 10};
		Steque_TR<Integer> list = new Steque_TR<Integer>();

		for (int i = 0; i < a.length; i++)
		{
			list.push(a[i]);
		}
		showList(list);
		StdOut.println();
	}

	private static void testEnqueue()
	{
		StdOut.println("enqueue:");
		int[] a = {2, 4, 6, 8, 10};
		Steque_TR<Integer> list = new Steque_TR<Integer>();

		for (int i = 0; i < a.length; i++)
		{
			list.enqueue(a[i]);
		}
		showList(list);
		StdOut.println();
	}

	private static void testPop()
	{
		StdOut.println("pop:");
		Steque_TR<Integer> list = new Steque_TR<Integer>(new Integer[]{6, 8, 12});
		StdOut.println(list + "[initial]\n");

		while (!list.isEmpty())
		{
			StdOut.println("pop: " + list.pop());
			showList(list);
		}
		StdOut.println();
	}

	private static void testDequeue()
	{
		StdOut.println("dequeue:");
		Steque_TR<Integer> list = new Steque_TR<Integer>(new Integer[]{6, 8, 12});
		StdOut.println(list + "[initial]\n");

		while (!list.isEmpty())
		{
			StdOut.println("pop: " + list.dequeue());
			showList(list);
		}
		StdOut.println();
	}

	private static void testCatenation()
	{
		// test concatenation
		Steque_TR<Integer> list_1 = new Steque_TR<Integer>(new Integer[]{6, 8, 12});
		Steque_TR<Integer> list_2 = new Steque_TR<Integer>(new Integer[]{7, 9, 13});
		Steque_TR<Integer> list_cnt = list_1.catenation(list_2);

		StdOut.println(list_cnt + "[initial]\n");
		showList(list_cnt);
	}

	/* Unit test helper */
	private static void showList(Steque_TR list)
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
//		testPush();
//		testPop();

//		testEnqueue();
//		testDequeue();

		testCatenation();
	}
}
