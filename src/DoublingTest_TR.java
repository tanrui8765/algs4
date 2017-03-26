import edu.princeton.cs.algs4.*;

/**
 * Created by the_real_Rui on 25/3/2017.
 */
public class DoublingTest_TR
{
	public static double timeTrial(int N)
	{
		// Time ThreeSum.count() for N random 6 digit ints.
		int MAX = 1000000;
		int[] a = new int[N];

		for (int i = 0; i < N; i++)
		{
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}

	// not well implemented, will refine in the future.
	public static void drawCharts(int try_cnt, int[] cnt, double time[])
	{
		if (cnt.length == 0 || time.length == 0) throw new RuntimeException("Invalid Input Array");

		int offset = try_cnt - 1;
		double y_max = time[offset];
		double y_min = time[0];
		double x_max = cnt[offset];
		double x_min = cnt[0];


		if (try_cnt > 1)
		{
			StdDraw.setCanvasSize(500, 500);
			StdDraw.setXscale(x_min, x_max);
			StdDraw.setYscale(y_min, y_max);

			for (int i = 1; i < try_cnt; i++)
			{
				StdDraw.line(cnt[i - 1], time[i - 1], cnt[i], time[i]);
			}
		}
	}

	public static void main(String[] args)
	{
		int i = 0;
		int TRY_MAX = 100;

		int[] cnt_array = new int[TRY_MAX];
		double[] time_array = new double[TRY_MAX];


		// Print table of running times
		for (int N = 100; i < TRY_MAX; N += N)
		{
			// Print time for problem size N
			double time = timeTrial(N);
			StdOut.printf("%7d %5.1f\n", N, time);

			cnt_array[i] = N;
			time_array[i] = time;
			i++;
			drawCharts(i, cnt_array, time_array);
		}
	}
}
