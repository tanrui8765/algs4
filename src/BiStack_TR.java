import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 6/3/2017.
 */
public class BiStack_TR<Item> implements Iterable<Item>
{
	private Node left_first;
	private Node left_last;
	private Node right_first;
	private Node right_last;
	private Node mid_node;
	private int left_N = 0;
	private int right_N = 0;
	private int N = 0;

	private class Node
	{
		private BiStack_TR<Item> parent = list();
		private Item item;
		private Node next;
		private Node prev;
	}

	private BiStack_TR<Item> list()
	{
		return this;
	}

	public BiStack_TR()
	{
		mid_node = new Node();
	}

	public boolean isEmpty()
	{
		return N == 0;
	}

	public boolean isLeftEmpty()
	{
		return left_N == 0;
	}

	public boolean isRightEmpty()
	{
		return right_N == 0;
	}

	public int size()
	{
		return N;
	}

	public int left_size()
	{
		return left_N;
	}

	public int right_size()
	{
		return right_N;
	}

	public Item left_first()
	{
//		if (isLeftEmpty()) throw new NoSuchElementException("Left List is empty");
		if (isLeftEmpty()) return null;
		return left_first.item;
	}

	public Item left_last()
	{
//		if (isLeftEmpty()) throw new NoSuchElementException("Left List is empty");
		if (isLeftEmpty()) return null;
		return left_last.item;
	}

	public Item right_first()
	{
//		if (isRightEmpty()) throw new NoSuchElementException("Right List is empty");
		if (isLeftEmpty()) return null;
		return right_first.item;
	}

	public Item right_last()
	{
//		if (isRightEmpty()) throw new NoSuchElementException("Right List is empty");
		if (isLeftEmpty()) return null;
		return right_last.item;
	}

	public void pushLeft(Item item)
	{
		Node x = new Node();
		x.item = item;
		if (isLeftEmpty())
		{
			left_first = x;
			left_last = x;
			left_last.next = mid_node;
		}
		else
		{
			x.next = left_first;
			left_first.prev = x;
			left_first = x;
		}
		left_N++;
		N++;
	}

	public Item popLeft()
	{
		if (isLeftEmpty()) throw new RuntimeException("Left Stack is Empty");
		Item item = left_first.item;
		left_first.parent = null;
		if (left_first.next != mid_node) left_first.next.prev = null;
		left_first = left_first.next;
		left_N--;
		N--;
		if (left_first == mid_node)
		{
			left_first = null;
			left_last = null;
		}
		return item;
	}

	public void pushRight(Item item)
	{
		Node x = new Node();
		x.item = item;
		if (isRightEmpty())
		{
			right_first = x;
			right_last = x;
			right_last.next = mid_node;
		}
		else
		{
			x.next = right_first;
			right_first.prev = x;
			right_first = x;
		}
		right_N++;
		N++;
	}

	public Item popRight()
	{
		if (isRightEmpty()) throw new RuntimeException("Right Stack is Empty");
		Item item = right_first.item;
		right_first.parent = null;
		if (right_first.next != mid_node) right_first.next.prev = null;
		right_first = right_first.next;
		right_N--;
		N--;
		if (right_first == mid_node)
		{
			right_first = null;
			right_last = null;
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
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>
	{
		private Node current = left_first;

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
			private Node current = right_first;

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

	/* Unit test helper */
	private static void showList(BiStack_TR list)
	{
		StdOut.println(list);
//		StdOut.println(list.reversed() + "[in reverse]");
		if (!list.isEmpty())
		{
			StdOut.printf("Size: %d, First: %s, Last: %s\n\n", list.size(), list.left_first(), list.right_first());
		}
		else
		{
			StdOut.printf("Size: %d\n\n", list.size());
		}
	}

	private static void testPushLeft()
	{
		StdOut.println("push left:");
		int[] a = {2, 4, 6, 8, 10};
		BiStack_TR<Integer> list = new BiStack_TR<Integer>();

		for (int i = 0; i < a.length; i++)
		{
			list.pushLeft(a[i]);
		}
		showList(list);
		StdOut.println();
	}

	private static void testPopLeft()
	{

	}

	private static void testPushRight()
	{
		StdOut.println("push right:");
		int[] a = {1, 3, 5, 7, 9};
		BiStack_TR<Integer> list = new BiStack_TR<Integer>();

		for (int i = 0; i < a.length; i++)
		{
			list.pushRight(a[i]);
		}
		showList(list);
		StdOut.println();
	}

	private static void testPopRight()
	{

	}

	public static void main(String[] args)
	{
		testPushLeft();
	}
}
