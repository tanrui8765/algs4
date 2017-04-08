import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 8/4/2017.
 */
public class FourSum_TR
{
	private static int arith_op_cmp_cnt = 0; // for the use of cost models.

	public static int count(int[] a)
	{
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = i + 1; j < N; j++)
			{
				for (int k = j + 1; k < N; k++)
				{
					for (int l = k + 1; l < N; l++)
					{
						if (a[i] + a[j] + a[k] + a[l] == 0)
						{
							cnt++;
						}
						arith_op_cmp_cnt += 4;
					}

				}
			}
		}
		return cnt;
	}

	public static void main(String[] args)
	{
//		In in = new In(args[0]);
		In in = new In("tinyW.txt");
		int[] a = in.readAllInts();
		StdOut.println(count(a));
		StdOut.println("For 1K numbers, " + "cost model: " + arith_op_cmp_cnt);
	}
}
