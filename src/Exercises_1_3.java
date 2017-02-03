import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 1/2/2017.
 */
public class Exercises_1_3
{

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

	public static void exercise_1_3_3(String[] args)
	{
//		String[] a = StdIn.readAll().split("\\s+");
//		String[] a = "4 3 2 1 0 9 8 7 6 5".split("\\s+");
		String[] a = "4 6 8 7 5 3 2 9 0 1".split("\\s+");

		int[] v = new int[a.length];
		for (int i = 0; i < a.length; i++)
		{
			v[i] = Integer.parseInt(a[i]);
		}
		checkSequence(v);
	}

	public static void exercise_1_3_2(String[] args)
	{
		String input[] = {"it was - the      best - of times - - - it was - the - -"};
		Stack_TR<String> st = new Stack_TR<String>();

		st.main(input);
	}

	public static void exercise_1_3_1(String[] args)
	{
		// exercise 1.3.1 is completed in the java file of FixedCapacityStackofStrings_TR
	}

	public static void main(String[] args)
	{
		exercise_1_3_3(args);
	}
}
