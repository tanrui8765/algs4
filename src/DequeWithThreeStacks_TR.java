import edu.princeton.cs.algs4.Stack;

import java.util.NoSuchElementException;

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
		// remove and return an item from the left end, i.e. the first item.
		// rebalance the allocation of items between stack left and stack right if appropriate

		if (isEmpty()) throw new NoSuchElementException("DequeWithThreeStacks underflow");
		if (!stack_left.isEmpty())
		{
			return stack_left.pop();
		}
		else
		{
			int s = stack_right.size();
			if (s == 1) return stack_right.pop();
			if (s - 1 > 1) // balance stack_left and stack_right (excuse to use stack_mid)
			{
				for (int i = 0; i < (s - 1) / 2; i++)
				{
					stack_mid.push(stack_right.pop());
				}
				s = stack_right.size();
				for (int i = 0; i < s - 1; i++)
				{
					stack_left.push(stack_right.pop());
				}
				Item first = stack_right.pop();
				s = stack_mid.size();
				for (int i = 0; i < s; i++)
				{
					stack_right.push(stack_mid.pop());
				}
				return first;
			}
			else
			{
				for (int i = 0; i < s - 1; i++)
				{
					stack_left.push(stack_right.pop());
				}
				return stack_right.pop();
			}
		}
	}

	//Amortized O(1)
	public Item popRight()
	{
		// remove and return an item from the right end, i.e. the last item
		// rebalance the allocation of items between stack1 and stack2 if appropriate
		if (isEmpty()) throw new NoSuchElementException("DequeWithThreeStacks underflow");

		if (!stack_right.isEmpty())
			return stack_right.pop();
		else
		{
			int s = stack_left.size();
		}

	}

	public void main(String[] args)
	{

	}
}
