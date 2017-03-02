/**
 * Created by the_real_Rui on 2/3/2017.
 */
public class RingBuffer_TR<Item>
{
	final private int cq_size = 10;
	private Item[] cq = (Item[]) new Object[cq_size];
	private int first = 0;
	private int last = 0;
	private int n = 0;



}
