import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 5/3/2017.
 */
public class MoveToFront_TR<Item>
{
	private DoublyLinkedList_TR<Item> list;

	public MoveToFront_TR()
	{
		list = new DoublyLinkedList_TR<Item>();
	}

	public void add(Item x)
	{
		int i = 0;
		int added = 0;

		for (Item item : list)
		{
			i++;
			if (x.equals(item))
			{
				list.prepend(list.remove(list.node(i)));
				added = 1;
				break;
			}
		}

		if (added == 0)
		{
			list.append(x);
		}
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for (Item item : list)
		{
			s.append(item + " ");
		}
		return s.toString();
	}

	public static void main(String[] args)
	{
		char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'c'};

		MoveToFront_TR<Character> mtf_c = new MoveToFront_TR<Character>();

		for (int i = 0; i < c.length; i++)
		{
			mtf_c.add(c[i]);
		}
		StdOut.println(mtf_c.toString());
	}
}
