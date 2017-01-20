import edu.princeton.cs.algs4.*;

import java.awt.*;

/**
 * Created by the_real_Rui on 19/1/2017.
 */
public class Exercises_1_2
{
	public static void exercise_1_2_1(String[] args)
	{
		int N = 20;

		Point2D[] pt = new Point2D[N];

		double x_lo = 0.0;
		double x_hi = 1.0;
		double y_lo = 0.0;
		double y_hi = 1.0;

		Font font = new Font("Sans Serif", Font.PLAIN, 9);
		Draw draw = new Draw("exercise_1_2_1");
		draw.setFont(font);
		draw.setCanvasSize(512, 512);
		draw.setXscale(x_lo, x_hi);
		draw.setYscale(y_lo, y_hi);

		for (int i = 0; i < N; i++)
		{
			double x = StdRandom.uniform(0.0, 1.0);
			double y = StdRandom.uniform(0.0, 1.0);

			pt[i] = new Point2D(x, y);
			draw.point(x, y);
		}
		draw.setPenColor(Draw.BLUE);
		Point2D pt_closest_1 = null;
		Point2D pt_closest_2 = null;
		double dist_min = 1.0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				double dist = pt[i].distanceTo(pt[j]);
				if ((dist < dist_min) && (dist > 0.0))
				{
					dist_min = dist;
					pt_closest_1 = pt[i];
					pt_closest_2 = pt[j];
				}
			}
		}
		draw.setPenColor(Draw.RED);
		draw.circle(pt_closest_1.x(), pt_closest_1.y(), dist_min / 8);
		draw.circle(pt_closest_2.x(), pt_closest_2.y(), dist_min / 8);
		draw.line(pt_closest_1.x(), pt_closest_1.y(), pt_closest_2.x(), pt_closest_2.y());
		draw.text((x_lo + x_hi) / 2, y_hi * 0.95, "dist_min is " + dist_min);
	}

	public static void exercise_1_2_2(String[] args)
	{
		int N = 3;

		Interval1D[] inter_array = new Interval1D[N];

		inter_array[0] = new Interval1D(0.0, 5.0);
		inter_array[1] = new Interval1D(7.0, 9.0);
		inter_array[2] = new Interval1D(4.0, 8.0);

		for (int i = 0; i < N; i++)
		{
			for (int j = i + 1; j < N; j++)
			{
				if (i != j)
				{
					if (inter_array[i].intersects(inter_array[j]))
					{
						StdOut.println(inter_array[i].toString() + inter_array[j].toString());
					}
				}
			}
		}
	}
	public static void main(String[] args)
	{
		exercise_1_2_2(args);
	}
}
