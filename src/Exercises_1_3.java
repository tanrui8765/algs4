import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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


	public static void main(String[] args)
	{
		exercise_1_3_11(args);
	}
}
