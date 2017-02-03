/**
 * Created by the_real_Rui on 3/2/2017.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.ListIterator;

public class Stack_TR<Item> implements Iterable<Item>
{
	private Node first; // top of stack (most recently added node)
	private int N;

	private class Node
	{
		// nested class to define nodes
		Item item;
		Node next;
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public int size()
	{
		return N;
	}

	public void push(Item item)
	{
		//Add item to top of stack.
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop()
	{
		// Remove item from top of stack
		Item item = first.item;
		first = first.next;
		N--;
		return item;
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
		// Create a stack and push/pop strings as directed on StdIn.
		Stack_TR<String> s = new Stack_TR<String>();
		String[] a = args[0].split("\\s+");

//		while(!StdIn.isEmpty())
		for (int i = 0; i < a.length; i++)
		{
//			String item = StdIn.readString();
			String item = a[i];
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}

		StdOut.println("(" + s.size() + " left on stack)");
	}
}
