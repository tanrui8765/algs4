import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 1/3/2017.
 */
public class GeneralizedQueue_List_TR<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int N = 0;

	private class Node
	{
		private GeneralizedQueue_List_TR<Item> parent = list();
		private Item item;
		private Node next;
		private Node prev;
	}

	private GeneralizedQueue_List_TR<Item> list()
	{
		return this;
	}

	public GeneralizedQueue_List_TR()
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

	// return the kth node
	// positive k is the kth node from the beginning.
	// negative k is the kth node from the end.
	public Node node(int k)
	{
		Node curr = null;
		int i = 1;

		if (k > 0)
		{
			curr = first;
			while (i < k && curr != null)
			{
				curr = curr.next;
				i++;
			}
		}
		else if (k < 0)
		{
			k = -k;
			curr = last;
			while (i < k && curr != null)
			{
				curr = curr.prev;
				i++;
			}
		}

		return curr;
	}

	public void prepend(Item item)
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

	public void append(Item item)
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

	public void insertBefore(Node node, Item item)
	{
		if (node.parent != this)
		{
			throw new RuntimeException("Node does not belong to this list");
		}

		if (node == first)
			prepend(item);
		else
		{
			Node prev = node.prev;
			Node x = new Node();
			x.item = item;
			x.prev = prev;
			x.next = node;
			prev.next = x;
			node.prev = x;
			N++;
		}
	}

	public void insertAfter(Node node, Item item)
	{
		if (node.parent != this)
		{
			throw new RuntimeException("Node does not belong to this list");
		}

		if (node == last)
			append(item);
		else
		{
			Node next = node.next;
			Node x = new Node();
			x.item = item;
			x.prev = node;
			x.next = next;
			next.prev = x;
			node.next = x;
			N++;
		}
	}

	public Item removeFirst()
	{
		if (isEmpty()) throw new RuntimeException("List is Empty");
		Item item = first.item;
		first.parent = null;
		if (first.next != null) first.next.prev = null;
		first = first.next;
		N--;
		if (first == null) last = null;  // to avoid loitering
		return item;
	}

	public Item removeLast()
	{
		if (isEmpty()) throw new RuntimeException("List is Empty");
		Item item = last.item;
		last.parent = null;
		if (last.prev != null) last.prev.next = null;
		last = last.prev;
		N--;
		if (last == null) first = null; // to avoid loitering
		return item;
	}

	public Item remove(Node node)
	{
		if (node.parent != this)
		{
			throw new RuntimeException("Node does not belong to this list");
		}

		if (node == first)
			return removeFirst();
		else if (node == last)
			return removeLast();
		else
		{
			node.parent = null;
			Node prev = node.prev;
			Node next = node.next;

			prev.next = node.next;
			next.prev = node.prev;
			N--;
			return node.item;
		}
	}

	public void insert(Item x)
	{
		append(x);
	}

	public Item delete()
	{
		if (isEmpty()) throw new NoSuchElementException("List underflow");
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
			private Node current = last;

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
