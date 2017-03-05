/**
 * Created by the_real_Rui on 3/2/2017.
 */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

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

	public Stack_TR()
	{
		N = 0;
	}

	public Stack_TR(Stack_TR<Item> s)
	{
		if (s.isEmpty())
		{
			throw new NoSuchElementException("Input stack is empty!");
		}
		Stack_TR<Item> temp_st = new Stack_TR<Item>();
		// reverse the iterator
		for (Item item : s)
		{
			temp_st.push(item);
		}
		for (Item item : temp_st)
		{
			this.push(item);
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
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public Item peek()
	{
		// return the most recently item without deleting it from the stack
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
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

	public static void testCopyStack()
	{
		int[] num = {1, 2, 3, 4, 5};
		Stack_TR<Integer> st = new Stack_TR<>();

		for (int i = 0; i < num.length; i++)
		{
			st.push(num[i]);
		}
		StdOut.println("stack_org: " + st.toString());

		Stack_TR<Integer> st_cpy = new Stack_TR<Integer>(st);
		StdOut.println("stack_cpy: " + st_cpy.toString());

		st_cpy.pop();
		st_cpy.push(6);
		StdOut.println("stack_org: " + st.toString());
		StdOut.println("stack_cpy: " + st_cpy.toString());


	}

	public static void main(String[] args)
	{
		testCopyStack(); // test for 1.3.42

		/*
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
		*/
	}
}
