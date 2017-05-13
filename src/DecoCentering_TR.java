import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by the_real_Rui on 13/5/2017.
 */

// this is a test for my job project
public class DecoCentering_TR
{
	private final int img_width = 1280;
	private final int img_height = 800;
	private final int sample_num = (4 + 1);
	private Point2D[] cent_points;
	private Point2D[] code_points;

	public void initCanva()
	{
		StdDraw.setCanvasSize(img_width, img_height);
	}

	public void initRegions()
	{
		cent_points = new Point2D[sample_num];
		code_points = new Point2D[sample_num];

		cent_points[0] = new Point2D(20, 20);
		cent_points[1] = new Point2D(60, 20);
		cent_points[2] = new Point2D(60, 40);
		cent_points[3] = new Point2D(20, 40);
//		cent_points[4] = new Point2D(20,20);

		code_points[0] = new Point2D(200, 20);
		code_points[1] = new Point2D(600, 20);
		code_points[2] = new Point2D(600, 40);
		code_points[3] = new Point2D(200, 40);
//		code_points[4] = new Point2D(200,20);
	}

	public void drawRegions()
	{
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setXscale(0, img_width - 1);
		StdDraw.setYscale(0, img_height - 1);
		for (int i = 1; i < sample_num - 1; i++)
		{
			StdDraw.line(cent_points[i - 1].x(), cent_points[i - 1].y(), cent_points[i].x(), cent_points[i].y());
			StdDraw.line(code_points[i - 1].x(), code_points[i - 1].y(), code_points[i].x(), code_points[i].y());
		}

		StdDraw.line(cent_points[0].x(), cent_points[0].y(), cent_points[3].x(), cent_points[3].y());
		StdDraw.line(code_points[0].x(), code_points[0].y(), code_points[3].x(), code_points[3].y());


	}

	public static void main(String[] args)
	{
		DecoCentering_TR dc = new DecoCentering_TR();

		dc.initCanva();
		dc.initRegions();
		dc.drawRegions();
	}
}
