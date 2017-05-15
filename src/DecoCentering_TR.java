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

		cent_points[0] = new Point2D(480, 400);
		cent_points[1] = new Point2D(660, 400);
		cent_points[2] = new Point2D(660, 480);
		cent_points[3] = new Point2D(480, 480);
		cent_points[4] = new Point2D(((cent_points[0].x() + cent_points[2].x()) / 2 + (cent_points[1].x() + cent_points[3].x()) / 2) / 2,
				((cent_points[0].y() + cent_points[2].y()) / 2 + (cent_points[1].y() + cent_points[3].y()) / 2) / 2);

		code_points[0] = new Point2D(200, 20);
		code_points[1] = new Point2D(600, 20);
		code_points[2] = new Point2D(600, 40);
		code_points[3] = new Point2D(200, 40);
		code_points[4] = new Point2D(((code_points[0].x() + code_points[2].x()) / 2 + (code_points[1].x() + code_points[3].x()) / 2) / 2,
				((code_points[0].y() + code_points[2].y()) / 2 + (code_points[1].y() + code_points[3].y()) / 2) / 2);

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


		StdDraw.setPenColor(StdDraw.BLUE);
		for (int i = 0; i < sample_num; i++)
		{
			StdDraw.filledCircle(cent_points[i].x(), cent_points[i].y(), 2);
		}
		StdDraw.setPenColor(StdDraw.MAGENTA);
		for (int i = 0; i < sample_num; i++)
		{
			StdDraw.filledCircle(code_points[i].x(), code_points[i].y(), 2);
		}

	}

	public void isOverlap()
	{

	}

	public static void main(String[] args)
	{
		DecoCentering_TR dc = new DecoCentering_TR();

		dc.initCanva();
		dc.initRegions();
		dc.drawRegions();
	}
}
