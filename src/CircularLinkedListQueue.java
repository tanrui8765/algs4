import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 11/2/2017.
 */
public class CircularLinkedListQueue<Item> implements Iterable<Item>
{
	private Node<Item> last;
	private int N = 0;

	private static class Node<Item>
	{
		Item item;
		Node<Item> next;
	}

	public CircularLinkedListQueue()
	{
		last = null;
	}

	public boolean isEmpty()
	{
		return last == null;
	}

	public int size()
	{
		return N;
	}

	public Item peek()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException("Queue underflow!");
		}
		return last.next.item;
	}

	public void enqueue(Item item)
	{
		Node<Item> x = new Node<Item>();

		x.item = item;
		if (isEmpty())       // this is the first element in the queue.
		{
			x.next = x;
		}
		else
		{
			x.next = last.next;
			last.next = x;
		}
		last = x;
		N++;
	}

	public Item dequeue()
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow!");

		Item item = last.next.item;
		if (last.next == last)   // this is the only element in the queue.
			last = null;
		else
			last.next = last.next.next;

		N--;

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
		int n = N;
		private Node<Item> current = last;

		public boolean hasNext()
		{
			return n > 0;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}

		public Item next()
		{
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.next.item;
			current = current.next;
			n--;
			return item;
		}
	}

	public static void main(String[] args)
	{
		CircularLinkedListQueue<Integer> cl = new CircularLinkedListQueue<Integer>();

		for (int i = 0; i < 10; i++)
		{
			cl.enqueue(i);
		}
		StdOut.printf("Circular LinkedList [ %s]\n", cl);
	}
}
