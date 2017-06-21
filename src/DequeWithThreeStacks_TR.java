import edu.princeton.cs.algs4.Stack;

/**
 * Created by the_real_Rui on 18/6/2017.
 */
public class DequeWithThreeStacks_TR<Item>
{
	private Stack<Item> stack1, stack2, stack3;
	private int n_nodes = 0;

	public DequeWithThreeStacks_TR()
	{
		stack1 = new Stack<Item>();
		stack2 = new Stack<Item>();
		stack3 = new Stack<Item>();
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

	//O(1)
	public void pushLeft(Item item)
	{
	}

	//O(1)
	public void pushRight(Item item)
	{
	}

	//Amortized O(1)
	public Item popLeft()
	{
	}

	//Amortized O(1)
	public Item popRight()
	{
	}

	public void main(String[] args)
	{

	}
}
