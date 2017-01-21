import edu.princeton.cs.algs4.*;
import sun.jvm.hotspot.utilities.Interval;

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


	public static void exercise_1_2_3(String[] args)
	{
		int N = 5;
		double min = 0.0;
		double max = 1.0;

		Interval2D[] inter_array = new Interval2D[N];
		Interval1D[] inter_1d_x = new Interval1D[N];
		Interval1D[] inter_1d_y = new Interval1D[N];

		StdDraw.setCanvasSize(512, 512);
		StdDraw.setScale(min, max);
//		StdDraw.setPenColor(StdDraw.BLACK);

		for (int i = 0; i < N; i++)
		{
			double min1 = StdRandom.uniform(min, max);
			double max1 = StdRandom.uniform(min, max);

			while (min1 == max1)
			{
				min1 = StdRandom.uniform(min, max);
			}

			if (min1 > max1)
			{
				double temp = max1;
				max1 = min1;
				min1 = temp;
			}

			double min2 = StdRandom.uniform(min, max);
			double max2 = StdRandom.uniform(min, max);

			while (min2 == max2)
			{
				min2 = StdRandom.uniform(min, max);
			}

			if (min2 > max2)
			{
				double temp = max2;
				max2 = min2;
				min2 = temp;
			}

			inter_1d_x[i] = new Interval1D(min1, max1);
			inter_1d_y[i] = new Interval1D(min2, max2);

			inter_array[i] = new Interval2D(inter_1d_x[i], inter_1d_y[i]);

			StdOut.println(inter_1d_x[i].toString() + inter_1d_y[i].toString());
			inter_array[i].draw();
//			StdDraw.rectangle(inter_1d_x.length()/2+inter_1d_x.min(),inter_1d_y.length()/2+inter_1d_y.min(),inter_1d_x.length()/2,inter_1d_y.length()/2);
		}

//		StdOut.println((max-min)/2);
//		StdDraw.setPenColor(StdDraw.RED);
//		StdDraw.rectangle((max-min)/2,(max-min)/2,(max-min)/2,(max-min)/2);

		int num_intersect = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = i + 1; j < N; j++)
			{
				if (inter_array[i].intersects(inter_array[j]) == true)
				{
					num_intersect++;
				}
			}
		}

		int num_contain = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (i != j) // avoid the same
				{
					Point2D pt1 = new Point2D(inter_1d_x[j].min(), inter_1d_y[j].min()); // Point left bottom
					Point2D pt2 = new Point2D(inter_1d_x[j].min(), inter_1d_y[j].max()); // Point left top
					Point2D pt3 = new Point2D(inter_1d_x[j].max(), inter_1d_y[j].min()); // Point right bottom
					Point2D pt4 = new Point2D(inter_1d_x[j].max(), inter_1d_y[j].max()); // Point right top

					if ((inter_array[i].contains(pt1) == true
							&& inter_array[i].contains(pt2) == true
							&& inter_array[i].contains(pt3) == true
							&& inter_array[i].contains(pt4) == true) == true)
					{
						num_contain++;
					}
				}
			}
		}

		num_intersect = num_intersect - num_contain;

		StdOut.println();
		StdOut.println("intersects: " + num_intersect + " contains: " + num_contain);
	}

	public static void exercise_1_2_4(String[] args)
	{
		String string1 = "hello";
		String string2 = string1;
		string1 = "world";
		StdOut.println(string1);
		StdOut.println(string2);
	}

	public static void exercise_1_2_5(String[] args)
	{
		String s = "Hello World";
		s.toUpperCase();
		s.substring(6, 11);
		StdOut.println(s);
	}

	public static void exercise_1_2_6(String[] args)
	{
		String s = "1234567890abcdefg";
		String t = "190ab1def11234167";
		boolean is_match = false;

		if (s.length() != t.length())
		{
			StdOut.println("strings not same length");
			return;
		}

		// find first character in the string t.
		char s0 = s.charAt(0);
		int s0_in_t = t.indexOf(s0, 0);
		while (s0_in_t >= 0)
		{
			if (s0_in_t > 0)
			{
				String str_t2 = t.substring(s0_in_t);
				String str_t1 = t.substring(0, s0_in_t);
				String str_attempt = str_t2.concat(str_t1);
				is_match = s.equals(str_attempt);

				StdOut.println("[ " + s + " ] match with,");
				StdOut.println("[ " + str_attempt + " ]");
				StdOut.println();
			}
			else
			{
				is_match = s.equals(t);

				StdOut.println("[ " + s + " ] match with,");
				StdOut.println("[ " + t + " ]");
				StdOut.println();
			}

			if (is_match)
			{
				break;
			}
			else
			{
				s0_in_t = t.indexOf(s0, s0_in_t + 1);
			}
		}

		StdOut.println("s and t match result is: " + is_match);
	}

	public static void main(String[] args)
	{
		exercise_1_2_6(args);
	}
}
