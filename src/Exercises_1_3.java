import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.*;

/**
 * Created by the_real_Rui on 1/2/2017.
 */
public class Exercises_1_3
{

	public static void exercise_1_3_1(String[] args)
	{
		// exercise 1.3.1 is completed in the java file of FixedCapacityStackofStrings_TR
	}

	public static void exercise_1_3_2(String[] args)
	{
		String input[] = {"it was - the      best - of times - - - it was - the - -"};
		Stack_TR<String> st = new Stack_TR<String>();

		st.main(input);
	}

	// this checkSequence is from aistrate's Github Repo in Ex_1_3_03.java
	public static void checkSequence(int[] v)
	{
		Stack<Integer> s = new Stack<Integer>();
		int n = v.length;

		int i = 0, j = 0;
		while (i < n && j <= n)
		{
			if (!s.isEmpty() && s.peek() == v[i])
			{
				StdOut.print(s.pop() + " ");
				i++;
			}
			else
			{
				if (j < n)
					s.push(j);
				j++;
			}
		}
		StdOut.println();

		StdOut.printf("%s (Unprinted: %d; Stack: [ %s])\n", i == n && s.isEmpty(), n - i, s);
	}

	public static void checkSequence_1(int[] v)
	{
		Stack<Integer> s = new Stack<Integer>();
		int n = v.length;

		int i = 0, j = 0;
		while (i < n && j <= n)
		{
//			StdOut.printf("i=%d; j=%d; Stack: [ %s]\n",i,j,s);
			if (!s.isEmpty() && s.peek() == v[i])
			{
				StdOut.printf("i=%d; j=%d; v[i]=%d; pop:%d; Stack: [%s]\n", i, j, v[i], s.pop(), s);
				i++;
			}
			else
			{
				if (j < n)
				{
					s.push(j);
					StdOut.printf("i=%d; j=%d; v[i]=%d; push:%d; Stack: [%s]\n", i, j, v[i], j, s);
				}
				else
				{
					StdOut.printf("i=%d; j=%d; v[i]=%d; stay:%d; Stack: [%s]\n", i, j, v[i], j, s);
				}
				j++;
			}
		}
		StdOut.println();

		StdOut.printf("%s (Unprinted: %d; Stack: [ %s])\n", i == n && s.isEmpty(), n - i, s);
	}


	public static void exercise_1_3_3(String[] args)
	{
//		String[] a = StdIn.readAll().split("\\s+");
//		String[] a = "4 3 2 1 0 9 8 7 6 5".split("\\s+");
//		String[] a = "4 6 8 7 5 3 2 9 0 1".split("\\s+");
//		String[] a = "2 5 6 7 4 8 9 3 1 0".split("\\s+");
//		String[] a = "4 3 2 1 0 5 6 7 8 9".split("\\s+");
//		String[] a = "1 2 3 4 5 6 9 8 7 0".split("\\s+");
//		String[] a = "0 4 6 5 3 8 1 7 2 9".split("\\s+");
//		String[] a = "1 4 7 9 8 6 5 3 0 2".split("\\s+");
		String[] a = "2 1 4 3 6 5 8 7 9 0".split("\\s+");

		int[] v = new int[a.length];
		for (int i = 0; i < a.length; i++)
		{
			v[i] = Integer.parseInt(a[i]);
		}
		checkSequence_1(v);
	}

	public static boolean Parentheses(String[] s)
	{
		Stack<String> st_par = new Stack<String>();

		StdOut.printf("Stack \" %s\"\n", st_par);
		for (int i = 0; i < s.length; i++)
		{
			if (s[i].equals("{") || s[i].equals("[") || s[i].equals("("))
			{
				st_par.push(s[i]);
			}
			else if (s[i].equals("}") || s[i].equals("]") || s[i].equals(")"))
			{
				if (!st_par.isEmpty())
				{
					String s_tmp = st_par.pop();
					if (s_tmp.equals("{") && s[i].equals("}"))
					{
					}
					else if (s_tmp.equals("[") && s[i].equals("]"))
					{
					}
					else if (s_tmp.equals("(") && s[i].equals(")"))
					{
					}
					else
						return false;
				}
				else
				{
					return false;
				}
			}
			StdOut.printf("Stack \" %s\"\n", st_par);
		}

		if (!st_par.isEmpty())
			return false;

		return true;
	}

	public static void exercise_1_3_4(String[] args)
	{
//		String s = "[()]{}{[()()]()}";
//		String s = "[{]}";
//		String s = "[[[";
//		String s = "]]]";
//		String s = "[[]";
		String s = "[]]";
		String[] a = s.split("");

		StdOut.println(Parentheses(a));
	}

	public static void exercise_1_3_5(String[] args)
	{
		// this is the binary representation of N
		int N = 8;
		Stack<Integer> stack = new Stack<Integer>();

		while (N > 0)
		{
			stack.push(N % 2); // Get the last binary bit
			N = N / 2;              // N >> 1, Right shift N by 1 binary bit
		}
		// Digit save from lower bit to higher bit
		// Digit print from higher bit to lower bit
		for (int d : stack) StdOut.print(d);
		StdOut.println();
	}


	public static void exercise_1_3_6(String[] args)
	{
		// the following code reverse the data in the queue.ª
		/*
		Stack<String> s = new Stack<String>();
		while(!q.isEmpty())
			s.push(q.dequeue());
		while(!s.isEmpty())
			q.enqueue(s.pop());
		*/
	}

	public static void exercise_1_3_7(String[] args)
	{
		// this peek() has implemented in the Stack_TR.java.
	}

	public static void exercise_1_3_8(String[] args)
	{
		String s = "it was - the best - of times - - - it was - the - -";
		String[] a = s.split("\\s+");

		ResizingArrayStack_TR<String> stack = new ResizingArrayStack_TR<String>();

		for (int i = 0; i < a.length; i++)
		{
			if (!a[i].equals("-"))
			{
				stack.push(a[i]);
			}
			else if (!stack.isEmpty())
			{
				stack.pop();
			}
		}
		stack.print();
	}

	// I copied this from aistrate's GitHub implementation.
	// very good one!
	public static void exercise_1_3_9(String[] args)
	{
		String in = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
//		String in = "sqrt 1 + 2 ) )";
		String[] in_a = in.split("\\s+");

		Stack<String> vals = new Stack<String>();
		Stack<String> ops = new Stack<String>();

		for (int i = 0; i < in_a.length; i++)
		{
			String s = in_a[i];
			if (s.equals("("))
			{
			}
			else if (s.equals("+") ||
					s.equals("-") ||
					s.equals("*") ||
					s.equals("/") ||
					s.equals("sqrt"))
			{
				ops.push(s);
			}
			else if (s.equals(")"))
			{
				String op = ops.pop();
				String v = vals.pop();

				if (op.equals("+") ||
						op.equals("-") ||
						op.equals("*") ||
						op.equals("/"))
					v = String.format("( %s %s %s )", vals.pop(), op, v);
				else if (op.equals("sqrt"))
					v = String.format("( %s %s )", op, v);

				vals.push(v);
				StdOut.println(vals.peek());
			}
			else    // digital value case
				vals.push(s);
		}

		StdOut.println(vals.pop());
	}

	// for more explanation of infix, prefix and postfix
	// please refer to the following urls:
	// --> http://www.cs.man.ac.uk/~pjj/cs212/fix.html
	// --> http://blog.csdn.net/chhj0103121429/article/details/40925555
	public static void exercise_1_3_10(String[] args)
	{
//		String str = "( ( 1 + 2 ) * ( 3 - 4 ) * ( 5 - 6 ) ) )";
		String str = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
		String[] a = str.split("\\s+");

		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < a.length; i++)
		{
			String s = a[i];

			if (s.equals("+") ||
					s.equals("-") ||
					s.equals("*") ||
					s.equals("/"))
			{
				stack.push(s);
			}
			else if (s.equals(")"))
			{
				StdOut.print(stack.pop() + " ");
			}
			else if (s.equals("("))
			{
			}
			else
			{
				StdOut.print(s + " ");
			}
		}
	}

	public static String[] InfixToPostfix(String str)
	{
		String[] a = str.split("\\s+");
		String[] out = new String[a.length];
		int n = 0;

		Stack_TR<String> stack = new Stack_TR<String>();

		for (int i = 0; i < a.length; i++)
		{
			String s = a[i];

			if (s.equals("+") ||
					s.equals("-") ||
					s.equals("*") ||
					s.equals("/"))
			{
				stack.push(s);
			}
			else if (s.equals(")"))
			{
				String tmp = stack.pop();
				StdOut.print(tmp + " ");
				out[n++] = tmp;
			}
			else if (s.equals("("))
			{
			}
			else
			{
				StdOut.print(s + " ");
				out[n++] = s;
			}
		}
		StdOut.println();

		String[] temp_array = new String[n];
		for (int i = 0; i < n; i++)
			temp_array[i] = out[i];

		out = temp_array;

		return out;
	}

	public static int EvaluatePostfix(String[] str_post)
	{
		Stack_TR<Integer> vals = new Stack_TR<Integer>();
//		Stack_TR<String> ops = new Stack_TR<String>();

		for (int i = 0; i < str_post.length; i++)
		{
			String s = str_post[i];

			if (s.equals("+") ||
					s.equals("-") ||
					s.equals("*") ||
					s.equals("/"))
			{
				int val2 = vals.pop();
				int val1 = vals.pop();
				int rlt = 0;

				if (s.equals("+"))
				{
					rlt = val1 + val2;
				}
				if (s.equals("-"))
				{
					rlt = val1 - val2;
				}
				if (s.equals("*"))
				{
					rlt = val1 * val2;
				}
				if (s.equals("/"))
				{
					rlt = val1 / val2;
				}

				vals.push(rlt);
			}
			else
				vals.push(Integer.parseInt(s));

			StdOut.printf("Symbol %s; Stack [ %s]\n", s, vals);
		}

		return vals.pop();
	}

	// Code need to be refined more in the future:
	// (1) no error checking
	// (2) characters must be separated by whitespace.
	public static void exercise_1_3_11(String[] args)
	{
//		String str_in = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
		String str_in = "( 3 * ( 4 + 5 ) )";
		String[] str_post = InfixToPostfix(str_in);
		StdOut.println("rlt is " + EvaluatePostfix(str_post));
	}

	public static Stack_TR<String> stack_copy(Stack_TR<String> st_org)
	{
		if (st_org.isEmpty()) throw new NoSuchElementException("Stack empty");

		Stack_TR<String> st_cpy = new Stack_TR<String>();
		Stack_TR<String> st_tmp = new Stack_TR<String>();

		for (String s : st_org)
		{
			st_tmp.push(s);
		}
		StdOut.printf("Mid [ %s]\n", st_tmp);
		for (String s : st_tmp)
		{
			st_cpy.push(s);
		}

		return st_cpy;
	}

	public static void exercise_1_3_12(String[] args)
	{
		String str = "1 2 3";
		String[] a = str.split("\\s+");

		Stack_TR<String> stack_org = new Stack_TR<String>();

		for (int i = 0; i < a.length; i++)
		{
			stack_org.push(a[i]);
		}

		StdOut.printf("Org [ %s]\n", stack_org);

		Stack_TR<String> stack_cpy = stack_copy(stack_org);

		StdOut.printf("Cpy [ %s]\n", stack_cpy);

	}

	public static void exercise_1_3_13(String[] args)
	{
		String str = "0 1 2 3 4 5 6 7 8 9";
//		String str = "4 6 8 7 5 3 2 9 0 1";
//		String str = "0 1 2 3 4 9 8 7 6 5";
		String[] a = str.split("\\s+");

		int[] v = new int[a.length];
		for (int i = 0; i < a.length; i++)
		{
			v[i] = Integer.parseInt(a[i]);
		}

		Queue<Integer> q = new Queue<Integer>();

		int i = 0, j = 0;
		int n = a.length;
		while (i < n && j <= n)
		{
			if (!q.isEmpty() && q.peek() == v[i])
			{
				StdOut.printf("i=%d; j=%d; v[i]=%d; deq:%d; Queue: [ %s]\n", i, j, v[i], q.dequeue(), q);
//				StdOut.print(q.dequeue() + " ");
				i++;
			}
			else
			{
				if (j < n)
				{
					q.enqueue(j);
					StdOut.printf("i=%d; j=%d; v[i]=%d; enq:%d; Queue: [ %s]\n", i, j, v[i], j, q);
				}
				else
				{
					StdOut.printf("i=%d; j=%d; v[i]=%d; stay:%d; Queue: [ %s]\n", i, j, v[i], j, q);
				}
				j++;
			}
		}
		StdOut.println();
		// Loop jumped out is because i over the length of int array.
		StdOut.printf("i=%d; j=%d; Queue: [ %s]\n", i, j, q);
		StdOut.printf("%s (Unprinted: %d; Queue: [ %s])\n", i == n && q.isEmpty(), n - i, q);
	}

	public static void exercise_1_3_14(String[] args)
	{
		// get a copy from the following url, but name changed as "ResizingArrayQueue_TR".
		// http://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html
	}


	public static void exercise_1_3_15(String[] args)
	{
		int k = 2;
		ResizingArrayQueue_TR<String> queue = new ResizingArrayQueue_TR<String>();
//		In in = new In("tinyW.txt");
//		String[] a = in.readAllStrings();

		String[] a = {"1", "2", "3", "4", "5"};

		for (int i = 0; i < a.length; i++)
		{
			queue.enqueue(a[i]);
		}
		// actually, in this exercise, the programmer should not know how many strings,
		// the queue has collected so far.
		// all strings are from standard input one by one.

		int n = queue.size() - k + 1;
		int i = 0;
		for (String s : queue)
		{
			i++;
			if (i == n)
			{
				StdOut.println("i=" + i + "; string:" + s);
				break;
			}
		}

	}

	public static Date[] readAllDates()
	{
		String[] str_date = {"2/7/2017",
				"3/8/2017",
				"4/9/2017",
				"5/10/2017"};
//		In in = new In(name);
		Queue<Date> q = new Queue<Date>();
//		while(!in.isEmpty())
//		{
//			q.enqueue(in.readInt());
//		}
		for (int i = 0; i < str_date.length; i++)
		{
			String[] mdy = str_date[i].split("/");
			Date date = new Date(Integer.parseInt(mdy[0]), Integer.parseInt(mdy[1]), Integer.parseInt(mdy[2]));
			q.enqueue(date);
		}

		int N = q.size();
		Date[] a = new Date[N];
		for (int i = 0; i < N; i++)
		{
			a[i] = q.dequeue();
		}
		return a;
	}

	public static void exercise_1_3_16(String[] args)
	{
		Date[] date = readAllDates();

		for (int i = 0; i < date.length; i++)
		{
			StdOut.println(date[i]);
		}
	}

	public static Transaction_TR[] readAllTransctions()
	{
		String[] str_trans = {"Rui 2/7/2017 12.34",
				"Emma 3/8/2017 22.22",
				"Steve 4/9/2017 33.33",
				"Michelle 5/10/2017 11.11"};
//		In in = new In(name);
		Queue<Transaction_TR> q = new Queue<Transaction_TR>();
//		while(!in.isEmpty())
//		{
//			q.enqueue(in.readInt());
//		}
		for (int i = 0; i < str_trans.length; i++)
		{
			String[] wwa = str_trans[i].split("\\s+");
			String[] mdy = wwa[1].split("/");
			SmartDate_TR smt_date = new SmartDate_TR(Integer.parseInt(mdy[0]), Integer.parseInt(mdy[1]), Integer.parseInt(mdy[2]));
			Transaction_TR trans = new Transaction_TR(wwa[0], smt_date, Double.parseDouble(wwa[2]));
			q.enqueue(trans);
		}

		int N = q.size();
		Transaction_TR[] a = new Transaction_TR[N];
		for (int i = 0; i < N; i++)
		{
			a[i] = q.dequeue();
		}
		return a;
	}

	public static void exercise_1_3_17(String[] args)
	{
		Transaction_TR[] trans = readAllTransctions();

		for (int i = 0; i < trans.length; i++)
		{
			StdOut.println(trans[i]);
		}
	}


	public static void exercise_1_3_18(String[] args)
	{
		// x is a linked-list node, but not the last one.
		// the effect of the following code
		// x.next = x.next.next;

		// Answer: Delete the node from the list immediately following x.
		// Node: Memory collection should be carefully in systems without automatic
		//       garbage collector.
	}


	public static void exercise_1_3_19(String[] args)
	{
		// think this should solve the problem, but not 100% sure yet.
		/*
			if(first != null)
			{
				temp = first;
				prev = null;
				while (temp.next != null)
				{
					prev = temp;
					temp = temp.next;
				}

				if(temp == first)   // if first is the only one
				{
					first = null;
					temp = null;
				}
				else                // node is more than one
				{
					temp = null;
					prev.next = null;
				}
			}
		*/
	}

	public static void exercise_1_3_20(String[] args)
	{
		// implemented in the LinkedList_TR.java
	}

	public static boolean find(LinkedList_TR<String> list, String key)
	{
		if (list.isEmpty())
		{
			return false;
		}

		for (String item : list)
		{
			if (item.equals(key))
			{
				return true;
			}
		}

		return false;
	}

	public static void exercise_1_3_21(String[] args)
	{
		LinkedList_TR<String> list = new LinkedList_TR<String>();

		for (int i = 0; i < 10; i++)
		{
			list.add(Integer.toString(i));
		}

		StdOut.printf("LinkedList [ %s]\n", list);

		String str = "1";
		StdOut.println("find " + str + " " + find(list, "9"));
	}

	public static void exercise_1_3_22(String[] args)
	{
		// t.next = x.next;
		// x.next = t;

		// insert t into the x and x's next item.
		// insert t right after x
	}


	public static void exercise_1_3_23(String[] args)
	{
		// x.next = t;
		// t.next = x.next;

		// this behavior will make t.next point to t itself.
	}

	public static void exercise_1_3_24(String[] args)
	{
		// TODO: have no idea how to test this... Try this later.
		// Code is in LinkedList_TR.java : removeAfter
	}

	public static void exercise_1_3_25(String[] args)
	{
		// TODO: have no idea how to test this... Try this later.
		// Code is in LinkedList_TR.java : insertAfter
	}

	public static void exercise_1_3_26(String[] args)
	{
		// Code is in LinkedList_TR.java : remove
	}

	public static void exercise_1_3_27(String[] args)
	{
		// Code is in LinkedList_TR.java : max
	}

	public static void exercise_1_3_28(String[] args)
	{
		// Code is in LinkedList_TR.java : max_recursive
	}


	public static void exercise_1_3_29(String[] args)
	{
		// Code is in CircularLinkedListQueue.java
	}

	public static void exercise_1_3_30(String[] args)
	{
		// a very smart implementation.
		// please refer to test book page 165 to learn.
		// code is in LinkedList_TR.java, reverse() and reverse_recursive()
	}

	public static void exercise_1_3_31(String[] args)
	{
		// code is in DoublyLinkedList_TR.java
	}

	public static void exercise_1_3_32(String[] args)
	{
		// code is in Steque_TR.java
	}

	public static void exercise_1_3_33(String[] args)
	{
		// LikedList implementation code is in Deque_TR.java
		// Resize Array implement code is in ResizingArrayDeque_TR.java
	}

	public static void exercise_1_3_34(String[] args)
	{
		// please find code in RandomBag_TR.java
	}

	public static void exercise_1_3_35(String[] args)
	{
		// please find code in RandomQueue_TR.java
	}

	public static void main(String[] args)
	{
		exercise_1_3_24(args);
	}
}
