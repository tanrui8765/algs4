import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.lang.Thread;

/**
 * Created by the_real_Rui on 25/1/2017.
 */

public class VisualCounter_TR
{
	private static int max_op_num = 0;
	private static int max_val = 0;
	private static int tally = 0;
	private static int op_num = 0;

	private static int draw_margin = 5;
	private static int draw_width = 20;

	public VisualCounter_TR(int N, int max)
	{
		max_op_num = N;
		max_val = max;

//		StdDraw.setXscale(0, max_op_num);
		StdDraw.setXscale(0, (draw_margin + draw_width));
		StdDraw.setYscale(0, max_val);
	}

	public static int increment()
	{
		tally++;
		if (tally > max_val) tally = max_val;

		op_num++;

		StdDraw.clear(StdDraw.WHITE);
		StdDraw.filledRectangle(draw_margin + draw_width / 2, tally / 2, draw_width / 2, tally / 2);
		StdDraw.text(draw_margin / 2, tally, Integer.toString(tally));

		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.textLeft(0, max_val - 5, Integer.toString(op_num));


		return tally;
	}

	public static int decrement()
	{
		tally--;
		if (tally < 0) tally = 0;

		op_num++;

		StdDraw.clear(StdDraw.WHITE);
		StdDraw.filledRectangle(draw_margin + draw_width / 2, tally / 2, draw_width / 2, tally / 2);
		StdDraw.text(draw_margin / 2, tally, Integer.toString(tally));

		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.textLeft(0, max_val - 5, Integer.toString(op_num));

		return tally;
	}

	public static void main(String[] algs)
	{
		int N = 1000;
		int MAX = 50;

		VisualCounter_TR visual_counter = new VisualCounter_TR(N, MAX);

		for (int i = 0; i < N; i++)
		{
			try
			{
				Thread.sleep(50);//括号里面的5000代表5000毫秒，也就是5秒，可以该成你需要的时间
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			boolean rand = StdRandom.bernoulli();

			if (rand == true)
				visual_counter.increment();
			else
				visual_counter.decrement();
		}
	}
}
