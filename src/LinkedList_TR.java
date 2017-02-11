import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by the_real_Rui on 8/2/2017.
 */
public class LinkedList_TR<Item> implements Iterable<Item>
{
	private Node<Item> first;
	private Node<Item> last;
	private int N = 0;

	private static class Node<Item>
	{
		Item item;
		Node<Item> next;
	}

	public LinkedList_TR()
	{
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public int size()
	{
		return N;
	}

	public void add(Item item)
	{
		// Add item to the last of the linked list
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}

	public Item delete()
	{
		if (isEmpty()) throw new NoSuchElementException("LinkedList_TR underflow");
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

		Node<Item> temp = first;
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

	public void remove(LinkedList_TR<Item> list, Item key)
	{
		int size = list.size();
		Node<Item> curr = list.first;
		Node<Item> prev = null;
		for (int i = 0; i < size; i++)
		{
			if (curr.item == key)
			{
				if (curr == list.first)
				{
					list.first = curr.next;
					list.N--;
					if (list.isEmpty()) list.last = null;
				}
				else
				{
					prev.next = curr.next;
					list.N--;
				}
				curr = curr.next;
			}
			else
			{
				prev = curr;
				curr = curr.next;
			}
		}
	}

	public int max(Node<Integer> first_node)
	{
		if (first_node == null) return 0;
		if (first_node.next == null) return first_node.item;

		int max = 0;
		Node<Integer> temp = first_node;
		while (temp != null)
		{
			if (temp.item > max)
			{
				max = temp.item;
			}
			temp = temp.next;
		}
		return max;
	}

	public void removeAfter(Node<Item> node)
	{
		if (node == null) return;        // this node null.

		Node<Item> temp = first;
		for (int i = 0; i < N; i++)
		{
			if (temp == node)            // this node exist.
			{
				if (temp.next == null)   // this node exist, next node null.
				{
					return;
				}
				else                    // this node exist, next node exist.
				{
					temp.next = temp.next.next;
					N--;
					if (isEmpty()) last = null;
				}
			}
			else
			{
				temp = temp.next;
			}
		}
		return; // this node is not in the list.
	}

	public void insertAfter(Node<Item> node1, Node<Item> node2)
	{
		if ((node1 == null) || (node2 == null)) return;

		node2.next = node1.next;
		node1.next = node2;
		N++;

		return;
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
		}

		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args)
	{
		LinkedList_TR<Integer> l = new LinkedList_TR<Integer>();
//		int[] a = {1,1,2,1,2,1,2,2,1,1};
//		int[] a = {1,2,1,2};
		for (int i = 0; i < 10; i++)
		{
			int a = StdRandom.uniform(1, 10);
			l.add(a);
		}
		StdOut.printf("LinkedList: [ %s]\n", l);

//		for(int i=0;i<2;i++)
//		{
//			l.delete();
//		}

//		l.delete(8);
//		l.remove(l,2);
//		StdOut.printf("LinkedList: [ %s]\n", l);

		StdOut.println("The Max is " + l.max(l.first));
	}
}
