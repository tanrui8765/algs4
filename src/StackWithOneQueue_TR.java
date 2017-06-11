import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 11/6/2017.
 */
public class StackWithOneQueue_TR<Item>
{
	private Queue<Item> queue;
	private int n_nodes = 0;

	public StackWithOneQueue_TR()
	{
		queue = new Queue<Item>();
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
		queue.enqueue(item);
		n_nodes++;
	}

	public Item pop()
	{
		for (int i = 1; i <= (n_nodes - 1); i++)
		{
			queue.enqueue(queue.dequeue());
		}
		Item out_item = queue.dequeue();

		if (out_item != null)
			n_nodes--;

		return out_item;
	}

	public static void main(String args[])
	{
		StackWithOneQueue_TR<Integer> stq = new StackWithOneQueue_TR<Integer>();

		int[] array = {1, 2, 3, 4};

		for (int i = 0; i < array.length; i++)
			stq.push(array[i]);

		for (int i = 0; i < array.length; i++)
			StdOut.println(stq.pop());
	}
}
