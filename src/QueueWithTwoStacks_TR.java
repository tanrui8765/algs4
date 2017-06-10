import edu.princeton.cs.algs4.Stack;

/**
 * Created by the_real_Rui on 7/6/2017.
 */
public class QueueWithTwoStacks_TR<Item>
{
	// A queue is first in first out
	// A queue is last in first out

	private Stack<Item> in_stk;
	private Stack<Item> out_stk;
	private int n_nodes = 0;

	public QueueWithTwoStacks_TR()
	{
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

	public void enqueue(Item item)
	{
		in_stk.push(item);
		n_nodes++;
	}

	// this method is not amortized operation
	public Item dequeue()
	{
		Item out_item = null;
		shift_between_stacks(out_stk, in_stk);
		out_item = out_stk.pop();
		shift_between_stacks(in_stk, out_stk);

		if (out_item != null)
			n_nodes--;

		return out_item;
	}

	private void shift_between_stacks(Stack<Item> stack_dst, Stack<Item> stack_src)
	{
		while (stack_src.isEmpty() == false)
		{
			stack_dst.push(stack_src.pop());
		}
	}

	public void main(String args[])
	{

	}
}
