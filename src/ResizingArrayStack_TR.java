/**
 * Created by the_real_Rui on 5/2/2017.
 */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ResizingArrayStack_TR<Item> implements Iterable<Item>
{
	private Item[] a = (Item[]) new Object[1];  // stack Items
	private int N = 0;                          // number of Items

	public boolean isEmpty()
	{
		return N == 0;
	}
	public int size()
	{
		return N;
	}

	private void resize(int max)
	{
		// Move stack to a new array of size max.
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
		{
			temp[i] = a[i];
		}
		a = temp;
	}

	public void push(Item item)
	{
		// Add item to top of stack
		if (N == a.length) resize(2 * a.length);
		a[N++] = item;      // first take the value from the array, then N++;
	}

	public Item pop()
	{
		// Remove the item from top of the stack.
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = a[--N]; // first --N, then take the value from array.
		a[N] = null;    // avoid memory loitering
		if (N > 0 && N == a.length / 4) resize(a.length / 2);
		return item;
	}

	public void print()
	{
		if (isEmpty())
		{
			StdOut.println("Stack has Nothing!");
			return;
		}

		StdOut.printf("element number: %d\n", N);
		StdOut.printf("array size: %d\n", a.length);
		StdOut.printf("Stack [ ");
		for (int i = 0; i < N; i++)
		{
			StdOut.printf("%s ", a[i]);
		}
		StdOut.printf("]\n");
	}

	public Iterator<Item> iterator()
	{
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item>
	{
		// support LIFO iteration
		private int i = N;

		public boolean hasNext()
		{
			return i > 0;
		}

		public Item next()
		{
			return a[--i];
		}

		public void remove()
		{
		}
	}
}

