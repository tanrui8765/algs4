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

	}

	public Item pop()
	{

	}

	public void enqueue(Item item)
	{

	}

	public Item dequeue()
	{

	}

}
