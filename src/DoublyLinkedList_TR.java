import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 12/2/2017.
 *
 * Note: this class is mainly from aistrate's GitHub repo.
 */
public class DoublyLinkedList_TR<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int N = 0;

	private class Node
	{
		private DoublyLinkedList_TR<Item> parent = list();
		private Item item;
		private Node next;
		private Node prev;
	}

	private DoublyLinkedList_TR<Item> list()
	{
		return this;
	}

	public DoublyLinkedList_TR()
	{
		first = null;
		last = null;
		N = 0;
	}

	public DoublyLinkedList_TR(Item[] a)
	{
		for (Item t : a)
			append(t);
	}

	public DoublyLinkedList_TR(Iterable<Item> coll)
	{
		for (Item t : coll)
			append(t);
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


	/* Unit test */

	private static void testPrepend()
	{
		StdOut.println("prepend:");
		int[] a = {2, 4, 6, 8, 10};
		DoublyLinkedList_TR<Integer> list = new DoublyLinkedList_TR<Integer>();

		for (int i = 0; i < a.length; i++)
		{
			list.prepend(a[i]);
		}
		showList(list);
		StdOut.println();
	}

	private static void testAppend()
	{
		StdOut.println("append:");
		int[] a = {2, 4, 6, 8, 10};
		DoublyLinkedList_TR<Integer> list = new DoublyLinkedList_TR<Integer>();

		for (int i = 0; i < a.length; i++)
		{
			list.append(a[i]);
		}
		showList(list);
		StdOut.println();
	}

	private static void testRemoveFirst()
	{
		StdOut.println("removeFirst:");
		DoublyLinkedList_TR<Integer> list = new DoublyLinkedList_TR<Integer>(new Integer[]{6, 8, 12});
		StdOut.println(list + "[initial]\n");

		while (!list.isEmpty())
		{
			StdOut.println("removeFirst(): " + list.removeFirst());
			showList(list);
		}
		StdOut.println();
	}

	private static void testRemoveLast()
	{
		StdOut.println("removeLast:");
		DoublyLinkedList_TR<Integer> list = new DoublyLinkedList_TR<Integer>(new Integer[]{6, 8, 12});
		StdOut.println(list + "[initial]\n");

		while (!list.isEmpty())
		{
			StdOut.println("removeLast(): " + list.removeLast());
			showList(list);
		}
		StdOut.println();
	}

	private static void testRemove()
	{
		StdOut.println("remove:");
		DoublyLinkedList_TR<Integer> list = new DoublyLinkedList_TR<Integer>(new Integer[]{2, 4, 6, 8});
		StdOut.println(list + "[initial]\n");

		int[] k = {2, -1, 1, 1};
		for (int i = 0; i < k.length; i++)
		{
			StdOut.printf("remove(node(%d)): %d\n", k[i], list.remove(list.node(k[i])));
			showList(list);
		}
		StdOut.println();
	}

	private static void testInsertBefore()
	{
		StdOut.println("insertBefore:");
		DoublyLinkedList_TR<Integer> list = new DoublyLinkedList_TR<Integer>(new Integer[]{2, 4, 6, 8});
		StdOut.println(list + "[initial]\n");

		int[] k = {3, 2, 1, -1};
		int[] x = {10, 12, 14, 16};
		for (int i = 0; i < k.length; i++)
		{
			StdOut.printf("insertBefore(node(%d),%d):\n", k[i], x[i]);
			list.insertBefore(list.node(k[i]), x[i]);
			showList(list);
		}
		StdOut.println();
	}

	private static void testInsertAfter()
	{
		StdOut.println("insertAfter:");
		DoublyLinkedList_TR<Integer> list = new DoublyLinkedList_TR<Integer>(new Integer[]{1, 3, 5, 7});
		StdOut.println(list + "[initial]\n");

		int[] k = {2, -2, -1, 1};
		int[] x = {9, 11, 13, 15};
		for (int i = 0; i < k.length; i++)
		{
			StdOut.printf("insertAfter(node(%d),%d):\n", k[i], x[i]);
			list.insertAfter(list.node(k[i]), x[i]);
			showList(list);
		}
		StdOut.println();
	}

	/* Unit test helper */
	private static void showList(DoublyLinkedList_TR list)
	{
		StdOut.println(list);
		StdOut.println(list.reversed() + "[in reverse]");
		if (!list.isEmpty())
		{
			StdOut.printf("Size: %d, First: %s, Last: %s\n\n", list.size(), list.first(), list.last());
		}
		else
		{
			StdOut.printf("Size: %d\n\n", list.size());
		}
	}

	public static void main(String[] args)
	{
		testPrepend();
		testAppend();

		testRemoveFirst();
		testRemoveLast();

		testRemove();

		testInsertBefore();
		testInsertAfter();
	}
}
