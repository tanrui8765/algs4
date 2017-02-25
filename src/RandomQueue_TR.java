import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import javax.smartcardio.Card;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 22/2/2017.
 */
public class RandomQueue_TR<Item> implements Iterable<Item>
{
	private Item[] a;
	private int n = 0;
	private int first = 0;
	private int last = 0;

	public RandomQueue_TR()
	{
		a = (Item[]) new Object[2];
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
		// move array to a new array of size capacity
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++)
		{
			temp[i] = a[(first + i) % a.length];
		}
		a = temp;
		first = 0;
		last = n;
	}

	public Item first()
	{
		if (isEmpty()) throw new NoSuchElementException("RandomBag is Empty");
		return a[first];
	}

	public Item last()
	{
		if (isEmpty()) throw new NoSuchElementException("RandomBag is Empty");
		return a[last];
	}

	public void enqueue(Item item)
	{
		if (n == a.length) resize(2 * a.length);
		a[last++] = item;
		if (last == a.length) last = 0;
//		StdOut.printf("array: ");
//		for(int p=0;p<a.length;p++)
//		{
//			StdOut.printf("%5d, ",a[p]);
//		}
//		StdOut.println();
		n++;
	}

//	public Item dequeue()
//	{
//		if(isEmpty()) throw new NoSuchElementException("Queue underflow");
//		Item item = a[first];               // retrieve the content
//		a[first] = null;                    // avoid memory loitering
//		n--;                                // update the item number
//		first++;                            // increase the first indexer
//		if(first == a.length) first = 0;    // wrap around if end of array reached
//		if(n>0 && n == a.length/4) resize(a.length/2);  // decrease the array size if item number gets fewer
//		return item;                        // return the item.
//	}

	public Item dequeue()
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item;
		if (n == 1)
		{
			item = a[first];
			a[first] = null;
			n--;
			first = 0;
			last = 0;
		}
		else
		{
			int index = StdRandom.uniform(0, n);
			Item temp = a[(first + index) % a.length];
			a[(first + index) % a.length] = a[last - 1];
			a[last - 1] = temp;

			StdOut.printf("array1: ");
			for (int p = 0; p < a.length; p++)
			{
				StdOut.printf("%5d, ", a[p]);
			}
			StdOut.println();

			item = a[last - 1];
			a[last - 1] = null;
			n--;
			last--;

			StdOut.printf("array2: ");
			for (int p = 0; p < a.length; p++)
			{
				StdOut.printf("%5d, ", a[p]);
			}
			StdOut.println();

			if (n > 0 && n == a.length / 4) resize(a.length / 2);
		}
		return item;
	}

	public Item sample()
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item;
		if (n == 1)
		{
			item = a[first];
		}
		else
		{
			int index = StdRandom.uniform(0, n);
			item = a[(first + index) % a.length];
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
			shuffle(a);
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
			Item item = a[(i + first) % a.length];
			i++;
			return item;
		}
	}

	/* Unit test helper */
	private static void showList(RandomQueue_TR list)
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

	public static void testBridgeHands()
	{
		// TODO This test will be filled up later, cause I don't know much about "how to deal bridge hands".
	}

	public static void main(String[] args)
	{
		StdOut.println("enqueue: ");
		int[] q = {1, 3, 5, 7, 9};
		RandomQueue_TR<Integer> list = new RandomQueue_TR<Integer>();

		for (int i = 0; i < q.length; i++)
		{
			list.enqueue(q[i]);
		}
		showList(list);
		StdOut.println("random iterator test 1: " + list.toString());
		StdOut.println("random iterator test 2: " + list.toString());
		StdOut.println("random iterator test 3: " + list.toString());

//		for (int i = 0; i < q.length; i++)
//		{
//			StdOut.println(list.dequeue().toString());
//		}
	}
}
