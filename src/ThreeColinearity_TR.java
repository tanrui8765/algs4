import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 4/6/2017.
 *
 * Explanations:
 * "https://github.com/zalacer/projects-tn/blob/862c13adc573d6bd88ab242790f67eb5bebc243f/Algorithms4edCh1%2B2/src/ex14/Ex1426ThreeCollinearity.java"
 */
public class ThreeColinearity_TR
{
	public static boolean isThreePointsCollinear(Point2D a, Point2D b, Point2D c)
	{
		double slope_ab = 0.0;
		double slope_ac = 0.0;
		boolean is_three_points_collinear = false;

		slope_ab = (Math.pow(b.y(), 3.0) - Math.pow(a.y(), 3.0)) / (b.x() - a.x());
		slope_ac = (Math.pow(c.y(), 3.0) - Math.pow(a.y(), 3.0)) / (c.x() - a.x());

		if (slope_ab == slope_ac)
		{
			is_three_points_collinear = true;
		}

		return is_three_points_collinear;
	}

	public static boolean isThreeSumZero(double a, double b, double c)
	{
		boolean is_three_sum_zero = false;

		Point2D a_point = new Point2D(a, a);
		Point2D b_point = new Point2D(b, b);
		Point2D c_point = new Point2D(c, c);

		if ((a == b) || (a == c) || (b == c))
		{
			is_three_sum_zero = false;
		}   // make sure their are three distinct number.
		else
		{
			is_three_sum_zero = isThreePointsCollinear(a_point, b_point, c_point);
		}

		return is_three_sum_zero;
	}

	public static void main(String args[])
	{
		boolean is_three_sum_zero = false;

		int a = 5;
		int b = 2;
		int c = -3;
		is_three_sum_zero = isThreeSumZero(a, b, c);

		StdOut.println(" " + a + " " + b + " " + c + " " + is_three_sum_zero);
	}
}
