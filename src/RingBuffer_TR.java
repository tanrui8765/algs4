import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 2/3/2017.
 */
public class RingBuffer_TR<Item> implements Iterable<Item>
{
	private int capacity = 10;
	private Item[] rb;
	private int first = 0;
	private int last = 0;
	private int n = 0;

	// Initialization
	public RingBuffer_TR()
	{
		rb = (Item[]) new Object[capacity];
		first = 0;
		last = 0;
		n = 0;
	}

	// Initialization with parameter.
	public RingBuffer_TR(int buffer_capacity)
	{
		if (buffer_capacity <= 0)
		{
			throw new RuntimeException("Buffer Created Error!");
		}
		rb = (Item[]) new Object[buffer_capacity];
		capacity = buffer_capacity;
		first = 0;
		last = 0;
		n = 0;
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

	public Item first()
	{
		if (isEmpty()) throw new NoSuchElementException("Buffer is Empty");
		return rb[first];
	}

	public Item last()
	{
		if (isEmpty()) throw new NoSuchElementException("Buffer is Empty");
		return rb[last];
	}

	public void add(Item item)
	{
		if (n == capacity)
		{
			throw new RuntimeException("Buffer is Full!");
		}

		if (n > 0)
		{
			last++;
			if (last == rb.length) last = 0;
		}
		rb[last] = item;
		n++;
	}

	public Item delete()
	{
		if (n == 0)
		{
			throw new RuntimeException("Buffer is Empty!");
		}
		Item item = rb[first];
		rb[first] = null;
		n--;
		first++;
		if (first == rb.length) first = 0;
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

	// return an iterator that iterates over the items in this queue in FIFO order.
	public Iterator<Item> iterator()
	{
		return new ArrayIterator();
	}

	// an iterator doesn't implement remove() since it's optional
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
			Item item = rb[(i + first) % rb.length];
			i++;
			return item;
		}
	}

	public static void main(String[] args)
	{
		int[] p = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

		int[] q = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		RingBuffer_TR<Integer> ring_buff = new RingBuffer_TR<Integer>();

		for (int i = 0; i < q.length; i++)
		{
			ring_buff.add(q[i]);
		}
		StdOut.println(ring_buff.toString());

		for (int i = 0; i < 5; i++)
		{
			StdOut.println(ring_buff.delete());
		}
		StdOut.println(ring_buff.toString());

		for (int i = 0; i < 5; i++)
		{
			ring_buff.add(p[i]);
		}
		StdOut.println(ring_buff.toString());

		for (int i = 0; i < q.length; i++)
		{
			StdOut.println(ring_buff.delete());
		}
		StdOut.println(ring_buff.toString());
	}
}
