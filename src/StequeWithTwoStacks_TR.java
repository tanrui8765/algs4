import edu.princeton.cs.algs4.Stack;

/**
 * Created by the_real_Rui on 11/6/2017.
 */
public class StequeWithTwoStacks_TR<Item>
{
	private Stack<Item> in_stk;
	private Stack<Item> out_stk;
	private int n_nodes = 0;

	public StequeWithTwoStacks_TR()
	{
		in_stk = new Stack<Item>();
		out_stk = new Stack<Item>();
		n_nodes = 0;
	}

	public int size()
	{
		return n_nodes;
	}

	public boolean isEmpty()
	{
		return (n_nodes == 0);
	}

	public void push(Item item)
	{
		in_stk.push(item);
		n_nodes++;
	}

	public Item pop()
	{
		if (in_stk.isEmpty() == true)
		{
			while (out_stk.isEmpty() == false)
			{
				in_stk.push(out_stk.pop());
			}
		}
		Item out_item = in_stk.pop();

		if (out_item != null)
			n_nodes--;

		return out_item;
	}

	public void enqueue(Item item)
	{
		in_stk.push(item);
		n_nodes++;
	}

	// this is the way to amortized the operations.
	public Item dequeue()
	{
		if (out_stk.isEmpty() == true)
		{
			while (in_stk.isEmpty() == false)
			{
				out_stk.push(in_stk.pop());
			}
		}
		Item out_item = out_stk.pop();

		if (out_item != null)
			n_nodes--;

		return out_item;
	}

	public void main(String args[])
	{
		// test code later.
	}
}
