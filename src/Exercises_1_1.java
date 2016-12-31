/**
 * Created by the_real_Rui on 25/12/2016.
 */
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.lang.Integer;
import java.lang.Double;

public class Exercises_1_1
{
	public static void exercise_1_1_1()
	{
		StdOut.println("Exercise 1.1.1:\n");
		StdOut.println("Ans:\n");

		int a_s32 = (0 + 15) / 2;
		double a_f64 = ((double) 0 + (double) 15) / 2;
		StdOut.println("a. (0 + 15)/2 = " + "(int)" + a_s32 + ", " + "(double)" + a_f64 + ";\n");

		a_f64 = 2.0e-6 * 100000000.1;
		StdOut.println("b. (2.0e-6 * 100000000.1 = " + a_f64 + ";\n");

		boolean c_bool = (true && false || true && true);
		StdOut.println("c. true && false || true && true = " + c_bool + ";\n");

	}

	public static void exercise_1_1_2()
	{
		StdOut.println("Exercise 1.1.2:\n");
		StdOut.println("Ans:\n");

		double a_f64 = (1 + 2.236) / 2;
		StdOut.println("a. (1 + 2.236) / 2 = " + "(double)" + a_f64 + ";\n");

		double b_f64 = 1 + 2 + 3 + 4.0;
		StdOut.println("b. (1 + 2 + 3 + 4.0) = " + "(double)" + b_f64 + ";\n");

		boolean c_f64 = 4.1 >= 4;
		StdOut.println("c. (4.1 >= 4) = " + "(boolean)" + c_f64 + ";\n");

		String d_u8 = 1 + 2 + "3";
		StdOut.println("d. (1 + 2 + \"3\") = " + "(String)" + d_u8 + ";\n");
	}

	public static void exercise_1_1_3(String[] args)
	{
		StdOut.println("Exercise 1.1.3:\n");
		StdOut.println("Ans:\n");

		int INPUT_NUM = 3;

		if (args.length < INPUT_NUM)
		{
			StdOut.println("Not enough inputs!");
		} else
		{
			int arg0 = Integer.parseInt(args[0]);
			int arg1 = Integer.parseInt(args[1]);
			int arg2 = Integer.parseInt(args[2]);
			if ((arg0 == arg1) && (arg1 == arg2))
				StdOut.println("equal");
			else
				StdOut.println("not equal");
		}
	}

	public static void exercise_1_1_4()
	{
		StdOut.println("Exercise 1.1.4:\n");
		StdOut.println("Ans:\n");

		StdOut.println("a. is wrong, no \"then\" keyword.\n ");
		StdOut.println("b. is wrong, a > b should with braces, such as (a > b).\n ");
		StdOut.println("c. and d. are right.\n ");
	}

	public static void exercise_1_1_5(String[] args)
	{
		int INPUT_NUM = 2;
		if (args.length < INPUT_NUM)
		{
			StdOut.println("not enough inputs.");
		} else
		{
			double x = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[1]);

			boolean x_bool = ((x < 1.0) && (x > 0.0));
			boolean y_bool = ((y < 1.0) && (y > 0.0));

			if ((x_bool == true) && (y_bool == true))
				StdOut.println("true");
			else
				StdOut.println("false");
		}
	}

	public static void exercise_1_1_6()
	{
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++)
		{
			StdOut.println(f);
			f = f + g;
			g = f - g;
		}
	}

	public static void exercise_1_1_7()
	{
		StdOut.println("Exercise 1.1.7:\n");
		StdOut.println("Ans:\n");
		StdOut.println("[a]:\n");
		double t = 9.0;
		while (Math.abs(t - 9.0 / t) > .001)
		{
			t = (9.0 / t + t) / 2.0;
			StdOut.printf("%.5f\n", t);
		}

		StdOut.println("[b]:\n");
		int sum = 0;
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < i; j++)
			{
				sum++;
			}
		}
		StdOut.println(sum);

		StdOut.println("[c]:\n");
		sum = 0;
		for (int i = 1; i < 1000; i *= 2)
		{
			for (int j = 0; j < 1000; j++)
			{
				sum++;
			}
		}
		StdOut.println(sum);
	}

	public static void exercise_1_1_8()
	{
		StdOut.println("Exercise 1.1.8:\n");
		StdOut.println("Ans:\n");

		System.out.println('b');
		System.out.println('b' + 'c');
		System.out.println((char) ('a' + 4));
	}

	public static void exercise_1_1_9()
	{
		StdOut.println("Exercise 1.1.9:\n");
		StdOut.println("Ans:\n");

		while (!StdIn.isEmpty())
		{
			String s = "";
			int N = StdIn.readInt();
			for (; N > 0; N /= 2)
			{
				s = (N % 2) + s;
			}
			StdOut.println(s);
		}
	}

	public static void exercise_1_1_11()
	{
		StdOut.println("Exercise 1.1.11:\n");
		StdOut.println("Ans:\n");

		int width = 2;
		int height = 5;

		boolean[][] array_2d = new boolean[height][width];

		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				array_2d[i][j] = false;
				if (i == j)
					array_2d[i][j] = true;
			}
		}

		for (int i = 0; i < height + 1; i++)
		{
			for (int j = 0; j < width + 1; j++)
			{
				if (i == 0)
				{
					if (j > 0)
					{
						StdOut.printf("%d ", j);
					} else
					{
						StdOut.printf("\\ ");
					}
				} else
				{
					if (j == 0)
					{
						StdOut.printf("%d ", i);
					} else
					{
						if (array_2d[i - 1][j - 1] == false)
							StdOut.printf("_ ");
						else
							StdOut.printf("* ");
					}
				}
			}
			StdOut.printf("\n");
		}
	}

	public static void exercise_1_1_12()
	{
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
			a[i] = 9 - i;
		for (int i = 0; i < 10; i++)
			a[i] = a[a[i]];
		for (int i = 0; i < 10; i++)
			System.out.println(a[i]);
	}

	public static void exercise_1_1_13()
	{
		int width = 8;
		int height = 5;
		int[][] array_init = new int[height][width];
		int[][] array_tran = new int[width][height];

		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				array_init[i][j] = 0;
				if (i == 2)
					array_init[i][j] = 1;
			}
		}

		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				array_tran[j][i] = array_init[i][j];
			}
		}
	}

	public static void exercise_1_1_14()
	{
		while (!StdIn.isEmpty())
		{
			int N = StdIn.readInt();
			int temp_n = N;
			int cnt = 0;


			while (temp_n > 0)
			{
				temp_n /= 2;
				cnt++;
			}

			if (N == 0)
				cnt = 0;
			else
				cnt--;

			StdOut.printf("%d\n", cnt);
			StdOut.printf("Math %f\n", Math.log10(N) / Math.log10(2));
		}
	}

	public static void exercise_1_1_15(String[] args)
	{
//		In in = new In(args[0]);
//		int[] array = in.readAllInts();
		int M = 10;
		int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4};

		int[] hist = new int[M];

		for (int i = 0; i < a.length; i++)
		{
			hist[a[i]]++;
		}

		int sum = 0;
		for (int j = 0; j < hist.length; j++)
		{
			sum += hist[j];
		}

		StdOut.printf("a.len = %d; sum is %d\n", a.length, sum);
		StdOut.println("hist is:\n");

		for (int i = 0; i < hist.length; i++)
		{
			StdOut.printf("%d, ", i);
		}
		StdOut.println("");
		for (int i = 0; i < hist.length; i++)
		{
			StdOut.printf("%d, ", hist[i]);
		}
	}

	// Exercise 1.1.16 is hard to imagine.
	public static String exR1(int n)
	{
		if (n <= 0) return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}

	public static void exercise_1_1_16(String[] args)
	{
//		while (!StdIn.isEmpty())
		{
//			int n = StdIn.readInt();
			int n = 6;
			String s = exR1(n);
			StdOut.printf("%s\n", s);
		}
	}

	public static String exR2(int n)
	{
		String s = exR2(n - 3) + n + exR2(n - 2) + n;
		if (n <= 0) return "";
		return s;
	}

	public static void exercise_1_1_17(String[] args)
	{
//		while (!StdIn.isEmpty())
		{
//			int n = StdIn.readInt();
			int n = 6;
			String s = exR2(n);
			StdOut.printf("%s\n", s);
		}
	}

	public static int mystery(int a, int b)
	{
		if (b == 0) return 0;
		if (b % 2 == 0) return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}

	public static int mystery2(int a, int b)
	{
		if (b == 0) return 1;
		if (b % 2 == 0) return mystery2(a * a, b / 2);
		return mystery2(a * a, b / 2) * a;
	}

	public static void exercise_1_1_18()
	{
		int rlt = mystery(3, 11);
		StdOut.printf("rlt: %d\n", rlt);

		int rlt2 = mystery2(3, 11);
		StdOut.printf("rlt2: %d\n", rlt2);
	}


	public static long Fibonacci(int N)
	{
		if (N == 0) return 0;
		if (N == 1) return 1;
		return Fibonacci(N - 1) + Fibonacci(N - 2);
	}

	public static long Fibonacci2(int N, long[] array)
	{
		if (N == 0) return 0;
		if (N == 1) return 1;
		return array[N - 1] + array[N - 2];
	}

	public static void exercise_1_1_19()
	{
//		for(int N = 0; N < 90; N++)
//			StdOut.println(N + " " + Fibonacci(N));

		/* A better implementation */
		int len = 100;
		long[] a = new long[len];

		for (int i = 0; i < len; i++)
		{
			a[i] = Fibonacci2(i, a);
			StdOut.println(i + " " + a[i]);
		}
	}

	public static double factorialln(long N)
	{
		if (N > 1)
		{
			double rlt = Math.log10(N) + factorialln(N - 1);
			return rlt;
		} else
			return 0;
	}

	public static void exercise_1_1_20()
	{
		long N = 3;
		double rlt = factorialln(N);

		StdOut.println(rlt);
	}

	public static void exercise_1_1_21(String[] args)
	{
		In in = new In(args[0]);
		while(in.hasNextLine())
		{
			String name = in.readString();
			int score = in.readInt();
			int assist = in.readInt();

			StdOut.printf("%8s | %8d | %8d | %8.3f\n", name, score, assist, (score*1.0)/assist);
		}
	}


	private static int rank(int key, int[] a, int lo, int hi, int dep)
	{
//		for (int i = 0; i < dep; ++i)
//			StdOut.printf(" ");

//		StdOut.println("low: " + lo + " high: " + hi);
		dep++;
		if (lo > hi)
			return -1;

		int mid = (lo + hi) / 2;
		if (key < a[mid])
			return rank(key, a, lo, mid - 1, dep);
		else if (key > a[mid])
			return rank(key, a, mid + 1, hi, dep);
		else
			return mid;
	}

	public static int rank(int key, int[] a, int depth)
	{
		return rank(key,a,0,a.length-1,depth);
	}

	public static void exercise_1_1_22(String[] args)
	{
		int len = 100;
		int[] a = new int[len];
		for (int i = 0; i < len; i++)
			a[i] = i;

		int location = rank(99, a, 0);
		if (location < 0)
			StdOut.println("Key not found!");
		else
			StdOut.println("Key's location = " + (location+1));
	}

	public static void exercise_1_1_23(String[] args)
	{
		In in = new In(args[0]);
		In in2 = new In(args[2]);
		int[] whitelist = in.readAllInts();
		String s = args[3];
		Arrays.sort(whitelist);

		while(!in2.isEmpty())
		{
			int key = in2.readInt();
			int rlt = rank(key, whitelist, 0);
			if((s.equals("+")) && (rlt == -1))
				StdOut.println(key);
			if((s.equals("-")) && (rlt > -1))
				StdOut.println(key);
		}
	}

	public static int gcd(int p, int q)
	{
		StdOut.println("p: " + p + ", q: " + q);
		if(q == 0) return p;
		return gcd(q, (p%q));
	}

	public static void exercise_1_1_24(String[] args)
	{
		while(StdIn.hasNextLine())
		{
			int x = StdIn.readInt();
			int y = StdIn.readInt();
			StdOut.println("the GCD of " + x + " and " + y + " is: " + gcd(x, y));
			break;
		}
	}

	public static void exercise_1_1_26(String[] args)
	{
		int a = StdIn.readInt();
		int b = StdIn.readInt();
		int c = StdIn.readInt();
		int t = 0;

		if(a>b){ t=a; a=b; b=t; }
		StdOut.println("a " +a+", b " + b+ ", c "+c);
		if(a>c){ t=a; a=c; c=t; }
		StdOut.println("a " +a+", b " + b+ ", c "+c);
		if(b>c){ t=b; b=c; c=t; }

		StdOut.println("a " +a+", b " + b+ ", c "+c);
	}

	public static double binomial(int N, int k, double p)
	{
		if ((N == 0) && (k == 0)) return 1.0;
		if ((N < 0) || (k < 0)) return 0.0;

		StdOut.println("N: " + N + ", k: " + k + ", p: " + p);
		return (1 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
	}

	public static void exercise_1_1_27(String[] args)
	{
		double p = binomial(100, 50, 0.25);

		StdOut.println("final p is " + p);
	}


	public static void main(String[] args)
	{
		exercise_1_1_27(args);
	}
}
