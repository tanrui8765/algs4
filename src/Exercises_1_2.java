import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by the_real_Rui on 19/1/2017.
 */
public class Exercises_1_2
{
	public static void exercise_1_2_1(String[] args)
	{
		int N = 20;

		double x_lo = 0.0;
		double x_hi = 1.0;
		double y_lo = 0.0;
		double y_hi = 1.0;

		Draw draw = new Draw("exercise_1_2_1");
		draw.setCanvasSize(512, 512);
		draw.setXscale(x_lo, x_hi);
		draw.setYscale(y_lo, y_hi);

		for (int i = 0; i < N; i++)
		{
			double x = StdRandom.uniform(0.0, 1.0);
			double y = StdRandom.uniform(0.0, 1.0);

			Point2D pt = new Point2D(x, y);
			draw.point(x, y);
		}
	}

	public static void main(String[] args)
	{
		exercise_1_2_1(args);
	}
}
