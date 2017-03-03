/**
 * Created by the_real_Rui on 2/3/2017.
 */
public class RingBuffer_TR<Item> implements Iterable<Item>
{
	final private int cq_size = 10;
	private Item[] cq = (Item[]) new Object[cq_size];
	private int first = 0;
	private int last = 0;
	private int n = 0;

	// is the queue empty?
	// return true if the queue is empty, otherwise false
	public boolean isEmpty()
	{
		return n == 0;
	}

	// return number of items in this queue
	public int size()
	{
		return n;
	}

	public void add(Item item)
	{

	}

}
