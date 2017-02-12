import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 12/2/2017.
 */
public class DoublyLinkedList_TR<Item> implements Iterable<Item>
{
	private Node<Item> first;
	private Node<Item> last;
	private int N = 0;

	private static class Node<Item>
	{
		Item item;
		Node<Item> next;
		Node<Item> prev;
	}

	public DoublyLinkedList_TR()
	{
		first = null;
		last = null;
		N = 0;
	}

	public boolean isEmpty()
	{
		return N == 0;
	}

	public int size()
	{
		return N;
	}

	// insert at the beginning
	public void insertFirst(Node<Item> x)
	{
		if (x == null) throw new NoSuchElementException("Input is NULL");
		if (isEmpty())
		{
			first = x;
			first.next = null;
			first.prev = null;

			last = x;
			last.next = null;
			last.prev = null;
		}
		else
		{
			Node<Item> oldfirst = first;
			first = x;
			first.prev = null;
			first.next = oldfirst;
			oldfirst.prev = first;
		}
		N++;
		return;
	}

	// insert at the end
	public void insertLast(Node<Item> x)
	{
		if (x == null) throw new NoSuchElementException("Input is NULL");
		if (isEmpty())
		{
			first = x;
			first.next = null;
			first.prev = null;

			last = x;
			last.next = null;
			last.prev = null;
		}
		else
		{
			Node<Item> oldlast = last;
			last = x;
			last.prev = oldlast;
			last.next = null;
			oldlast.next = last;
		}
		N++;
		return;
	}

	// remove from the beginning
	public Node<Item> removeFirst()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException("Linked List Empty");
		}

		Node<Item> node = first;
		first = first.next;
		first.prev = null;
		N--;
		if (isEmpty()) last = null;

		return node;
	}

	// remove from the end
	public Node<Item> removeLast()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException("Linked List Empty");
		}

		Node<Item> node = last;
		last = last.prev;
		last.next = null;
		N--;
		if (isEmpty()) first = null;

		return node;
	}

	// insert before a given node
	public void insertBefore(Node<Item> node, Item item)
	{
	}

	// insert after a given node
	public void insertAfter()
	{

	}

	// remove a given node
	public boolean remove(Node<Item> x)
	{
		if (isEmpty())
		{
			return false;
		}

		Node<Item> temp = first;
		while (temp != null)
		{
			if (temp == x)
			{
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				N--;
				if (isEmpty())
				{
					first = null;
					last = null;
				}
				return true;
			}
			else
			{
				temp = temp.next;
			}
		}
		return false;
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
		private Node<Item> current = first;

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
			private Node<Item> current = last;

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
}
