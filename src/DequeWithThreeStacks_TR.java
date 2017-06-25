import edu.princeton.cs.algs4.Stack;

/**
 * Created by the_real_Rui on 18/6/2017.
 *
 * https://github.com/zalacer/projects-tn/blob/862c13adc573d6bd88ab242790f67eb5bebc243f/Algorithms4edCh1%2B2/src/ds/DequeWithThreeStacks.java
 * https://github.com/zalacer/projects-tn/blob/862c13adc573d6bd88ab242790f67eb5bebc243f/Algorithms4edCh1%2B2/src/ex14/Ex1431DequeWithThreeStacks.java
 */
public class DequeWithThreeStacks_TR<Item>
{
	private Stack<Item> stack_left, stack_mid, stack_right;
	private int n_nodes = 0;

	public DequeWithThreeStacks_TR()
	{
		stack_left = new Stack<Item>();
		stack_mid = new Stack<Item>();
		stack_right = new Stack<Item>();
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
		stack_left.push(item);
		n_nodes++;
	}

	//O(1)
	public void pushRight(Item item)
	{
		stack_right.push(item);
		n_nodes++;
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
