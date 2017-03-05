import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 5/3/2017.
 */
public class Buffer_TR<Item>
{
	private int cursor_pos = 0; // 0 is the beginning, N is the ending. N-1 points to the last item.
	private Stack<Item> left;
	private Stack<Item> right;

	public Buffer_TR()
	{

		left = new Stack<Item>();
		right = new Stack<Item>();
		cursor_pos = 0;
	}

	public int size()
	{
		return (left.size() + right.size());
	}

	public void insert(Item c)
	{
		cursor_pos++;
		left.push(c);
	}

	public Item get()
	{
		if (cursor_pos == 0)
		{
			return null;
		}

		return left.peek();
	}

	public Item delete()
	{
		if (cursor_pos == 0)
		{
			return null;
		}

		cursor_pos--;
		return left.pop();
	}

	public void left(int k)
	{
		if (k <= 0) return;

		for (int i = 0; i < k; i++)
		{
			if (cursor_pos == 0) break;
			right.push(left.pop());
			cursor_pos--;
		}
	}

	public void right(int k)
	{
		if (k <= 0) return;

		for (int i = 0; i < k; i++)
		{
			if (cursor_pos == size()) break;
			left.push(right.pop());
			cursor_pos++;
		}
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for (Item item : right)
		{
			s.append(item);
			s.append(' ');
		}
		s = s.reverse();
		s.append(" | ");

		for (Item item : left)
		{
			s.append(item);
			s.append(' ');
		}

		// Note string reversed here.
		return s.reverse().toString();
	}

	public static void main(String[] args)
	{
		Buffer_TR<Character> buff = new Buffer_TR<Character>();
		char[] c = {'1', '2', '3', '4', '5', '6'};

		for (int i = 0; i < c.length; i++)
		{
			buff.insert(c[i]);
		}
		StdOut.println(buff);

		StdOut.println(buff.get());
		StdOut.println(buff);

		StdOut.println(buff.delete());
		StdOut.println(buff);

		buff.right(1);
		buff.right(1);
		StdOut.println(buff);

		buff.left(2);
		StdOut.println(buff);
		buff.left(4);
		StdOut.println(buff);

		buff.right(4);
		StdOut.println(buff);
		buff.right(2);
		StdOut.println(buff);
	}
}
