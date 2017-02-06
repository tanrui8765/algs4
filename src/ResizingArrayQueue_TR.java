import edu.princeton.cs.algs4.ResizingArrayQueue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 5/2/2017.
 */
public class ResizingArrayQueue_TR<Item> implements Iterable<Item>
{
	private Item[] q;   // queue elements
	private int n;      // number of elements on queue
	private int first;  // index of first element of queue
	private int last;   // index of next available slot

	// Initializes an empty queue.
	public ResizingArrayQueue_TR()
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

	// add the item to this queue
	public void enqueue(Item item)
	{
		// double size of array if necessary and recopy to front of array
		if (n == q.length) resize(2 * q.length);    // double size of array if necessary
		q[last++] = item;                                   // add item
		if (last == q.length) last = 0;                     // wrap-around
		n++;
	}

	// removes and return the item on this queue that was least recently added
	public Item dequeue()
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = q[first];
		q[first] = null;                    // to avoid loitering
		n--;
		first++;
		if (first == q.length) first = 0;    // wrap around
		// shrink size of array if necessary
		if (n > 0 && n == q.length / 4) resize(q.length / 2);
		return item;
	}

	// return the item least recently added to this queue
	public Item peek()
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return q[first];
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
			Item item = q[(i + first) % q.length];
			i++;
			return item;
		}
	}

	// unit test the data type
	public static void main(String[] args)
	{
		String str = "0 1 2 - 3 4 5 - 6 7 8 - 9";
		String[] a = str.split("\\s+");

		ResizingArrayQueue_TR<String> queue = new ResizingArrayQueue_TR<String>();

		for (int i = 0; i < a.length; i++)
		{
			String item = a[i];
			if (!item.equals("-")) queue.enqueue(item);
			else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
		}
		StdOut.println("(" + queue.size() + " left on queue)");
	}
}
