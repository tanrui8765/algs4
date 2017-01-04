/**
 * Created by the_real_Rui on 25/12/2016.
 */

import edu.princeton.cs.algs4.*;
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
		}
		else
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
		}
		else
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
					}
					else
					{
						StdOut.printf("\\ ");
					}
				}
				else
				{
					if (j == 0)
					{
						StdOut.printf("%d ", i);
					}
					else
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
		}
		else
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
		while (in.hasNextLine())
		{
			String name = in.readString();
			int score = in.readInt();
			int assist = in.readInt();

			StdOut.printf("%8s | %8d | %8d | %8.3f\n", name, score, assist, (score * 1.0) / assist);
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
		return rank(key, a, 0, a.length - 1, depth);
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
			StdOut.println("Key's location = " + (location + 1));
	}

	public static void exercise_1_1_23(String[] args)
	{
		In in = new In(args[0]);
		In in2 = new In(args[2]);
		int[] whitelist = in.readAllInts();
		String s = args[3];
		Arrays.sort(whitelist);

		while (!in2.isEmpty())
		{
			int key = in2.readInt();
			int rlt = rank(key, whitelist, 0);
			if ((s.equals("+")) && (rlt == -1))
				StdOut.println(key);
			if ((s.equals("-")) && (rlt > -1))
				StdOut.println(key);
		}
	}

	public static int gcd(int p, int q)
	{
//		StdOut.println("p: " + p + ", q: " + q);
		if (q == 0) return p;
		return gcd(q, (p % q));
	}

	public static void exercise_1_1_24(String[] args)
	{
		while (StdIn.hasNextLine())
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

		if (a > b)
		{
			t = a;
			a = b;
			b = t;
		}
		StdOut.println("a " + a + ", b " + b + ", c " + c);
		if (a > c)
		{
			t = a;
			a = c;
			c = t;
		}
		StdOut.println("a " + a + ", b " + b + ", c " + c);
		if (b > c)
		{
			t = b;
			b = c;
			c = t;
		}

		StdOut.println("a " + a + ", b " + b + ", c " + c);
	}

	public static double binomial(int N, int k, double p)
	{
		if ((N == 0) && (k == 0)) return 1.0;
		if ((N < 0) || (k < 0)) return 0.0;

		return (1 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
	}

	// method from aistrate's GitHub "AlgorithmSedgewick" Repo.
	public static double binomial2(int N, int k, double p, Counter c)
	{
		double[][] v = new double[N + 1][k + 1];
		for (int i = 0; i <= N; i++)
		{
			for (int j = 0; j <= k; j++)
			{
				v[i][j] = -1;
			}
		}
		return binomial2(v, N, k, p, c);
	}

	public static double binomial2(double[][] v, int N, int k, double p, Counter c)
	{
		if ((N == 0) && (k == 0)) return 1.0;
		if ((N < 0) || (k < 0)) return 0.0;

		if (v[N][k] == -1)
		{
			c.increment();
			v[N][k] = (1.0 - p) * binomial2(v, N - 1, k, p, c) + p * binomial2(v, N - 1, k - 1, p, c);
		}
		return v[N][k];
	}

	public static void exercise_1_1_27(String[] args)
	{
		// Read the Link below for the explanation of binomial distribution
		// http://blog.csdn.net/q932104843/article/details/51921756
		// http://www.cnblogs.com/TonyNeal/p/zhsdtgs.html
		// http://blog.csdn.net/zjq2008wd/article/details/23103411

		int N = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		double p = Double.parseDouble(args[2]);

		Counter c = new Counter("calls");

		double prob = binomial2(N, k, p, c);

//		double prob = binomial(N, k, p);

		StdOut.println(prob);
		StdOut.println(c);
	}

	public static void exercise_1_1_28(String[] args)
	{
		// Remove duplicate keys after sort
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist);

		StdOut.printf("raw: ");
		for (int i = 0; i < whitelist.length; i++)
		{
			StdOut.printf("%d, ", whitelist[i]);
		}
		StdOut.printf("\n");

		// sign the same pair of data
		int[] whitelist_rep = whitelist;
		int cnt = 0;
		for (int i = 1; i < whitelist_rep.length; i++)
		{
			if (whitelist_rep[i] == whitelist_rep[i - 1])
			{
				whitelist_rep[i - 1] = -1;
				cnt++;
			}
		}

		StdOut.printf("sgn: ");
		for (int i = 0; i < whitelist_rep.length; i++)
		{
			StdOut.printf("%d, ", whitelist_rep[i]);
		}
		StdOut.printf("\n");

		int[] whitelist_new = new int[whitelist_rep.length - cnt];
		for (int i = 0, j = 0; i < whitelist_rep.length; i++, j++)
		{
			if (whitelist_rep[i] != -1)
			{
				whitelist_new[j] = whitelist_rep[i];
			}
			else
			{
				j--;
			}
		}

		StdOut.printf("new: ");
		for (int i = 0; i < whitelist_new.length; i++)
		{
			StdOut.printf("%d, ", whitelist_new[i]);
		}
		StdOut.printf("\n");
	}

	public static int rank_rec(int key, int lo, int hi, int[] a)
	{
		int ret_val = 0;
		if (hi < lo)
		{
			ret_val = lo;
		}
		else
		{
			int mid = (lo + hi) / 2;
			if (a[mid] > key)
				ret_val = rank_rec(key, lo, mid - 1, a);
			else if (a[mid] < key)
				ret_val = rank_rec(key, mid + 1, hi, a);
			else
				ret_val = mid;
		}
		return ret_val;
	}

	public static int rank(int key, int[] a)
	{
		int lo = 0;
		int hi = a.length - 1;
		int pos = 0;
		pos = rank_rec(key, lo, hi, a);

		int i = 0;
		for (i = 0; i < a.length; i++)
		{
			if (a[i] == a[pos])
			{
				break;
			}
		}

		return i;
	}

	public static int count(int key, int[] a)
	{
		int cnt = 0;
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] == key)
				cnt++;
		}
		return cnt;
	}

	public static void exercise_1_1_29(String[] args)
	{
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist);

		int key = Integer.parseInt(args[1]);

		int i = rank(key, whitelist);
		int j = count(key, whitelist);

		StdOut.println("rank: " + i + ", count: " + j);
	}

	public static void exercise_1_1_30(String[] args)
	{
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);

		boolean[][] a = new boolean[i][j];

		for (int m = 0; m < i; m++)
		{
			for (int n = 0; n < j; n++)
			{
				if (gcd(m, n) > 1)
				{
					a[m][n] = false;
				}
				else
				{
					a[m][n] = true;
				}

				StdOut.printf("%5s ", a[m][n]);
			}
			StdOut.printf("\n");
		}
	}

	public static boolean rel_prime(int i, int j)
	{
		if (i == 0 || j == 0)
			return false;

		if (i > j)
		{
			i = i ^ j;
			j = j ^ i;
			i = i ^ j;
		}
		for (int k = 2; k <= i; k++)
		{
			// i and j can be divided by k, then i and j are not relatively prime.
			if (j % k == 0 && i % k == 0)
				return false;
		}
		return true;
	}

	public static void exercise_1_1_30_2(String[] args)
	{
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		boolean[][] a = new boolean[i][j];

		for (int m = 0; m < i; m++)
		{
			for (int n = 0; n < j; n++)
			{
				a[m][n] = rel_prime(m, n);
			}
		}

		for (int m = 0; m < a.length; m++)
		{
			for (int n = 0; n < a[m].length; n++)
			{
				System.out.print(a[m][n] + " ");
			}
			System.out.println();
		}
	}

	// Referred from aistrate's GitHub Repos.
	public static void drawRandConn(int N, double p)
	{
		StdDraw.setCanvasSize(512, 512);
		StdDraw.setScale(-2.0, 2.0);
		StdDraw.setPenRadius(.015);

		double[][] d = new double[N][2];
		for (int i = 0; i < N; i++)
		{
			// this is polar coordinate
			d[i][0] = Math.cos(2 * Math.PI * i / N);
			d[i][1] = Math.sin(2 * Math.PI * i / N);
			StdDraw.point(d[i][0], d[i][1]);
		}

		StdDraw.setPenRadius();

		for (int i = 0; i < N - 1; i++)
		{
			for (int j = i + 1; j < N; j++)
			{
				if (StdRandom.bernoulli(p))
					StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
			}
		}
	}

	public static void exercise_1_1_31(String[] args)
	{
		int N = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);

		p = Math.max(0, Math.min(1, p));

		drawRandConn(N, p);
	}

	public static int get_interval(double in, int n, double l, double r)
	{
		if ((in <= l) || (in >= r))
			return -1;
		else
			return (int) ((in - l) * n / (r - l));
	}

	public static void histogram(double[] in, int n, double l, double r)
	{
		if (l > r)
		{
			double tmp;
			tmp = l;
			l = r;
			r = tmp;
		}
		else if (l == r)
		{
			return;
		}

		double w = (r - l) / n;
		int[] count = new int[n];

		for (int i = 0; i < in.length; i++)
		{
			int k = get_interval(in[i], n, l, r);
			if (k >= 0)
				count[k]++;
		}

		int count_max = StdStats.max(count);

		// following part is from aistrate's GitHub repos.
		StdDraw.setCanvasSize(512, 256);
		StdDraw.setXscale(l, r);
		StdDraw.setYscale(0, count_max * 1.1);

		for (int i = 0; i < n; i++)
		{
			// Note: the rectangle is draw based on the center point.
			double x = l + (i + 0.5) * w;
			double y = count[i] / 2.0;
			double rw = 0.5 * w;
			double rh = count[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}

	public static void exercise_1_1_32(String[] args)
	{
		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]);
		double r = Double.parseDouble(args[2]);

		In in = new In(args[3]);
		double[] values = in.readAllDoubles();

		histogram(values, N, l, r);
	}

	// exercise 1.1.33 is required to develop a Matrix Class with several methods
	// let's just implement the methods below and test them with exercise_1_1_33()

	// Some references:
	// http://www.cnblogs.com/DreamUp/archive/2010/07/27/1786225.html
	public static double dot(double[] x, double[] y)    // vector dot product
	{
		double dot_prod = 0;
		if(x.length == y.length)
		{
			int len = x.length;

			for(int i=0;i<len;i++)
			{
				dot_prod += x[i]*y[i];
			}
		}
		return dot_prod;
	}

	public static double[][] mult(double[][] a, double[][] b)   // matrix-matrix product
	{
		int a_row = a.length;
		int a_col = a[0].length;
		int b_row = b.length;
		int b_col = b[0].length;

		if (a_col == b_row)
		{
			double[][] mm_prod = new double[a_row][b_col];

			for (int i = 0; i < a_row; i++)
			{
				for (int j = 0; j < b_col; j++)
				{
					for (int k = 0; k < a_col; k++)
					{
						mm_prod[i][j] += a[i][k] + b[k][j];
					}
				}
			}
			return mm_prod;
		}
		else
			return null;
	}

	public static double[] mult(double[][] a, double[] x)   // matrix-vector product
	{
		int a_row = a.length;
		int a_col = a[0].length;
		int x_row = x.length;
		int x_col = 1;

		if(a_col == x_row)
		{
			double[] mv_prod = new double[a_row];

			for (int i = 0; i < a_row; i++)
			{
				for (int k = 0; k < a_col; k++)
				{
					mv_prod[i] += a[i][k] + x[k];
				}
			}
			return mv_prod;
		}
		else
			return null;
	}

	public static double[] mult(double[] y, double[][] b)   // vector-matrix product
	{
		int y_row = 1;
		int y_col = y.length;
		int b_row = b.length;
		int b_col = b[0].length;

		if (y_col == b_row)
		{
			double[] vm_prod = new double[b_col];

			for (int j = 0; j < b_col; j++)
			{
				for (int k = 0; k < y_col; k++)
				{
					vm_prod[j] += y[k] + b[k][j];
				}
			}
			return vm_prod;
		}
		else
			return null;
	}


	public static double[][] transpose(double[][] a)   // transpose
	{
		int a_row = a.length;
		int a_col = a[0].length;

		double[][] a_trans = new double[a_col][a_row];

		for(int i=0;i<a_row;i++)
		{
			for(int j=0;j<a_col;j++)
			{
				a_trans[j][i] = a[i][j];
			}
		}
		return a_trans;
	}

	public static void exercise_1_1_33(String[] args)
	{

	}


	public static void main(String[] args)
	{
		exercise_1_1_32(args);
	}
}
