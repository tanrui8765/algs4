import edu.princeton.cs.algs4.Stack;

/**
 * Created by the_real_Rui on 14/6/2017.
 */
public class DequeWithStackAndStaque_TR<Item>
{
	private Stack<Item> stack;        // left
	private Steque_TR<Item> staque;    // right
	private int n_nodes = 0;

	public DequeWithStackAndStaque_TR()
	{
		stack = new Stack<Item>();
		staque = new Steque_TR<Item>();
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
		staque.push(item);
		n_nodes++;
	}

	//O(1)
	public void pushRight(Item item)
	{
		stack.push(item);
		n_nodes++;
	}

	//Amortized O(1)
	public Item popLeft()
	{
//		if (staque.isEmpty() == true)
//		{
//			while (stack.isEmpty() == false)
//			{
//
//			}
//		}
	}

	//Amortized O(1)
	public Item popRight()
	{

	}

	public void main(String args[])
	{

	}
}
