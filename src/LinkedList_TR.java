import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 8/2/2017.
 */
public class LinkedList_TR<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int N = 0;

	private class Node
	{
		Item item;
		Node next;
	}

	public LinkedList_TR()
	{
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public int size()
	{
		return N;
	}

	public void add(Item item)
	{
		// Add item to the last of the linked list
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}

	public Item delete()
	{
		if (isEmpty()) throw new NoSuchElementException("LinkedList_TR underflow");
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) last = null;
		return item;
	}

	public Item delete(int k)
	{
		if (N < k) throw new NoSuchElementException("No kth element");
		if (k <= 0) throw new NoSuchElementException("k should not be zero");
		if (k == 1)
		{
			return delete();
		}

		Node temp = first;
		for (int i = 1; i < k - 1; i++)
		{
			temp = temp.next;
		}

		Item item = temp.item;
		temp.next = temp.next.next;
		N--;
		if (isEmpty()) last = null;
		return item;
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for (Item item : this)
		{
			s.append(item);
			s.append(' ');
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
		}

		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args)
	{
		LinkedList_TR<Integer> l = new LinkedList_TR<Integer>();

		for (int i = 1; i < 10; i++)
		{
			l.add(i);
		}
		StdOut.printf("LinkedList: [ %s]\n", l);

//		for(int i=0;i<2;i++)
//		{
//			l.delete();
//		}
		l.delete(8);
		StdOut.printf("LinkedList2: [ %s]\n", l);
	}
}
