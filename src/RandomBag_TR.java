import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 21/2/2017.
 */
public class RandomBag_TR<Item> implements Iterable<Item>
{
	private Item[] a;
	private int n = 0;
	private int first = 0;
	private int last = 0;

	public RandomBag_TR()
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

	public void add(Item item)
	{
		if (n == a.length) resize(2 * a.length);

		a[last++] = item;
		n++;
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
}
