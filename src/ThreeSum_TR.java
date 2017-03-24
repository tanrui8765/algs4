import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 24/3/2017.
 */
public class ThreeSum_TR
{
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
					if (a[i] + a[j] + a[k] == 0)
					{
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args)
	{
//		In in = new In(args[0]);
		In in = new In("1Kints.txt");
		int[] a = in.readAllInts();
		StdOut.println(count(a));
	}
}
