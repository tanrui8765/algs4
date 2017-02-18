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


	public void push(Item item)
	{
		append(item);
	}

	public void enqueue(Item item)
	{
		prepend(item);
	}

	public Item pop()
	{
		return removeLast();
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder();

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
}
