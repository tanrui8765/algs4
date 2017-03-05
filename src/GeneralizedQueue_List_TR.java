import com.sun.tools.javac.jvm.Gen;
import edu.princeton.cs.algs4.StdOut;

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

	public GeneralizedQueue_List_TR(GeneralizedQueue_List_TR<Item> q)
	{
		if (q.isEmpty())
		{
			throw new NoSuchElementException("Input queue is empty!");
		}
		/*
		GeneralizedQueue_List_TR<Item> temp_list = new GeneralizedQueue_List_TR<Item>();
//		GeneralizedQueue_List_TR<Item> ret_list = new GeneralizedQueue_List_TR<Item>();

		for(Item item : q)
		{
			temp_list.append(q.removeFirst());
		}

		for(Item item : temp_list)
		{
			q.append(item);
			this.append(item);
		}
		*/

		for (Item item : q)
		{
			this.append(item);
		}
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

	public Item delete(int k)
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		if ((k <= 0) || (k > N)) throw new NoSuchElementException("No such index");

		Item item;
		if (k == 1)
		{
			item = first.item;
			first.parent = null;
			if (first.next != null) first.next.prev = null;
			first = first.next;
			N--;
			if (first == null) last = null;  // to avoid loitering
		}
		else if (k == N)
		{
			item = last.item;
			last.parent = null;
			if (last.prev != null) last.prev.next = null;
			last = last.prev;
			N--;
			if (last == null) first = null; // to avoid loitering
		}
		else
		{
			Node temp = first;
			for (int i = 1; i <= k - 1; i++)
			{
				temp = temp.next;
			}

			item = temp.item;
			temp.parent = null;
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			N--;
			if (isEmpty()) last = null;
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

	public static void testCopyQueue()
	{
		int[] num = {1, 2, 3, 4, 5};
		GeneralizedQueue_List_TR<Integer> list = new GeneralizedQueue_List_TR<>();

		for (int i = 0; i < num.length; i++)
		{
			list.insert(num[i]);
		}
		StdOut.println("list_org: " + list.toString());

		GeneralizedQueue_List_TR<Integer> list_cpy = new GeneralizedQueue_List_TR<Integer>(list);
		StdOut.println("list_cpy: " + list_cpy.toString());

		list_cpy.removeLast();
		list_cpy.insert(6);
		StdOut.println("list_org: " + list.toString());
		StdOut.println("list_cpy: " + list_cpy.toString());


	}

	/* Unit test helper */
	private static void showList(GeneralizedQueue_List_TR list)
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

	public static void main(String[] args)
	{
		testCopyQueue();    // test for 1.3.41
/*

		StdOut.println("enqueue: ");
		int[] q = {1, 2, 3, 4, 5};
		GeneralizedQueue_List_TR<Integer> list = new GeneralizedQueue_List_TR<>();

		for (int i = 0; i < q.length; i++)
		{
			list.insert(q[i]);
		}
		showList(list);
		StdOut.println("generalized queue is: " + list.toString());
		StdOut.println();

//		StdOut.println("delete: " + list.delete(2).toString());
		StdOut.println("delete: " + list.delete(3).toString());
		StdOut.println("generalized queue is: " + list.toString());

//		int[] q2 = {2, 4, 6, 8, 10};
//		for (int i = 0; i < q.length; i++)
//		{
//			list.insert(q2[i]);
//		}
//		showList(list);
//		StdOut.println("generalized queue is: " + list.toString());
//		StdOut.println();
//
//		StdOut.println("delete: " + list.delete(2).toString());
//		StdOut.println("delete: " + list.delete(3).toString());
//		StdOut.println("generalized queue is: " + list.toString());

*/
	}
}
