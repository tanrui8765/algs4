import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdOut;

import java.util.function.UnaryOperator;

/**
 * Created by the_real_Rui on 3/4/2017.
 */
public class FragmentsOrderOfGrowth
{
	public static int runFragmentA(int N)
	{
		// code frag a: linear (N + N/2 + N/4 + ...)
		int sum = 0;
		for (int n = N; n > 0; n /= 2)
			for (int i = 0; i < n; i++)
				sum++;

		return sum;
	}

	public static int runFragmentB(int N)
	{
		// code frag b: linear (1 + 2 + 4 + 8 + ...)
		int sum = 0;
		for (int i = 1; i < N; i *= 2)
			for (int j = 0; j < i; j++)
				sum++;

		return sum;
	}

	public static int runFragmentC(int N)
	{
		// code frag c: linearithmic (N + 2N + 4N + 8N + ...) // Is this Right ???
		int sum = 0;
		for (int i = 1; i < N; i *= 2)
			for (int j = 0; j < N; j++)
				sum++;

		return sum;
	}

	public static boolean testFragment(UnaryOperator<Integer> fragment, UnaryOperator<Integer> expected_supplier)
	{
		for (int n = 1; n < 1_000_000; n *= 16)
		{
			int actual = fragment.apply(n), expected = expected_supplier.apply(n);
			if (actual != expected)
				return false;
		}
		return true;
	}

	private static double log2(int n)
	{
		return Math.log(n) / Math.log(2);
	}

	public static void runTests()
	{
		StdOut.printf("A. %s\n", testFragment(FragmentsOrderOfGrowth::runFragmentA, (n -> 2 * n - 1)) ? "OK" : "FAIL");
		StdOut.printf("B. %s\n", testFragment(FragmentsOrderOfGrowth::runFragmentB, (n -> n - 1)) ? "OK" : "FAIL");
		StdOut.printf("C. %s\n", testFragment(FragmentsOrderOfGrowth::runFragmentC, (n -> (int) (n * log2(n)))) ? "OK" : "FAIL");
	}

	public static void main(String[] args)
	{
		runTests();
	}
}
