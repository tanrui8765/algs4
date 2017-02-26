import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 26/2/2017.
 */
public class Mercator2WGS84
{
	static double M_PI = Math.PI;

	//经纬度转墨卡托
	// 经度(lon)，纬度(lat)
	public static double[] lonLat2Mercator(double lon, double lat)
	{
		double[] xy = new double[2];
		double x = lon * 20037508.342789 / 180;
		double y = Math.log(Math.tan((90 + lat) * M_PI / 360)) / (M_PI / 180);
		y = y * 20037508.34789 / 180;
		xy[0] = x;
		xy[1] = y;
		return xy;
	}

	//墨卡托转经纬度
	public static double[] Mercator2lonLat(double mercatorX, double mercatorY)
	{
		double[] xy = new double[2];
		double x = mercatorX / 20037508.34 * 180;
		double y = mercatorY / 20037508.34 * 180;
		y = 180 / M_PI * (2 * Math.atan(Math.exp(y * M_PI / 180)) - M_PI / 2);
		xy[0] = x;
		xy[1] = y;
		return xy;
	}

	public static void main(String[] args)
	{
		In in = new In("dataLat.txt");

		String[] input = in.readAllLines();

		for (int i = 0; i < input.length; i++)
		{
			String[] line_str = input[i].split(",");
			StdOut.println("[" + i + "]" + line_str[0] + ", " + "mer_x: " + line_str[12] + ", " + "mer_y: " + line_str[13]);

			if (i == 0)
			{
				StdOut.println();
			}
			else
			{
				double[] num;
				StdOut.print("Mer2Lat: ");

				double mer_x = Double.parseDouble(line_str[12]);
				double mer_y = Double.parseDouble(line_str[13]);
				num = Mercator2lonLat(mer_x, mer_y);
				StdOut.printf("lat_x: %6f, lat_y: %6f", num[0], num[1]);
				StdOut.println();
				StdOut.println();
			}
		}


//			double[] num;
//			num = lonLat2Mercator(120.385222, 36.061416);
//			for (int i = 0; i < num.length; i++)
//			{
//				System.out.println(num[i]);
//			}

//			double[] num;
//			StdOut.println("Mer to Lat: ");
//
//			num = Mercator2lonLat(13401221.612075035,4309075.414032666);
//			for(int i=0;i<num.length;i++)
//			{
//				System.out.println(num[i]);
//			}
	}
}
