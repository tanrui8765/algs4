import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 20/4/2017.
 *
 * Three reference websites, demonstrate a better solution:
 * "http://stackoverflow.com/questions/18525179/find-local-minimum-in-n-x-n-matrix-in-on-time"
 * "http://www.filipekberg.se/2014/02/10/understanding-peak-finding/"
 * "http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec01.pdf"
 */
public class LocalMinMatrix_TR
{
	// Return
	// -1: Not a conner point
	// 0: left top point
	// 1: right top point
	// 2: right bottom point
	// 3: left bottom point
	public static int isConnerPoint(int[][] mat, int x, int y)
	{
		int ret_val = -1;

		if ((x == 0) && (y == 0))
		{
			ret_val = 0;
		}
		else if ((x == mat[0].length - 1) && (y == 0))
		{
			ret_val = 1;
		}
		else if ((x == mat[0].length - 1) && (y == mat.length - 1))
		{
			ret_val = 2;
		}
		else if ((x == 0) && (y == mat.length - 1))
		{
			ret_val = 3;
		}

		return ret_val;
	}

	// Return
	// -1: Not a side point
	// 0: top side
	// 1: right side
	// 2: bottom side
	// 3: left side
	public static int isSidePoint(int[][] mat, int x, int y)
	{
		int ret_val = -1;

		if (((x > 0) && (x < mat[0].length - 1)) && (y == 0))
		{
			ret_val = 0;
		}
		else if ((x == mat[0].length - 1) && ((y > 0) && (y < mat.length - 1)))
		{
			ret_val = 1;
		}
		else if (((x > 0) && (x < mat[0].length - 1)) && (y == mat.length - 1))
		{
			ret_val = 2;
		}
		else if ((x == 0) && ((y > 0) && (y < mat.length - 1)))
		{
			ret_val = 3;
		}

		return ret_val;
	}


	public static boolean isLocalMin(int[][] matrix, int x, int y)
	{
		boolean is_local_min = false;
		int is_conner_point = isConnerPoint(matrix, x, y);
		if (is_conner_point == -1)
		{
			int is_side_point = isSidePoint(matrix, x, y);
			if (is_side_point == -1)
			{
				// Normal Points
				if ((matrix[x][y] < matrix[x - 1][y]) &&
						(matrix[x][y] < matrix[x + 1][y]) &&
						(matrix[x][y] < matrix[x][y - 1]) &&
						(matrix[x][y] < matrix[x][y + 1]))
				{
					is_local_min = true;
				}

			}
			else
			{
				// Side Points
				if (is_side_point == 0)      // top side
				{
					if ((matrix[x][y] < matrix[x - 1][y]) &&
							(matrix[x][y] < matrix[x + 1][y]) &&
							(matrix[x][y] < matrix[x][y + 1]))
					{
						is_local_min = true;
					}
				}
				else if (is_side_point == 1) // right side
				{
					if ((matrix[x][y] < matrix[x - 1][y]) &&
							(matrix[x][y] < matrix[x][y - 1]) &&
							(matrix[x][y] < matrix[x][y + 1]))
					{
						is_local_min = true;
					}
				}
				else if (is_side_point == 2) // bottom side
				{
					if ((matrix[x][y] < matrix[x - 1][y]) &&
							(matrix[x][y] < matrix[x + 1][y]) &&
							(matrix[x][y] < matrix[x][y - 1]))
					{
						is_local_min = true;
					}
				}
				else if (is_side_point == 3) // left side
				{
					if ((matrix[x][y] < matrix[x + 1][y]) &&
							(matrix[x][y] < matrix[x][y - 1]) &&
							(matrix[x][y] < matrix[x][y + 1]))
					{
						is_local_min = true;
					}
				}
			}
		}
		else
		{
			// Conner Points
			if (is_conner_point == 0)        // left top
			{
				if ((matrix[x][y] < matrix[x + 1][y]) &&
						(matrix[x][y] < matrix[x][y + 1]))
				{
					is_local_min = true;
				}
			}
			else if (is_conner_point == 1)   // right top
			{
				if ((matrix[x][y] < matrix[x - 1][y]) &&
						(matrix[x][y] < matrix[x][y + 1]))
				{
					is_local_min = true;
				}
			}
			else if (is_conner_point == 2)   // right bottom
			{
				if ((matrix[x][y] < matrix[x - 1][y]) &&
						(matrix[x][y] < matrix[x][y - 1]))
				{
					is_local_min = true;
				}
			}
			else if (is_conner_point == 3)   // left bottom
			{
				if ((matrix[x][y] < matrix[x + 1][y]) &&
						(matrix[x][y] < matrix[x][y - 1]))
				{
					is_local_min = true;
				}
			}
		}

		return is_local_min;
	}


	public static void main(String[] args)
	{
		int[][] a = {{10, 2, 3}, {4, 5, 6}, {7, 1, 9}};

		for (int j = 0; j < a.length; j++)
		{
			for (int i = 0; i < a[0].length; i++)
			{

				// this function is not well written, the x and y are inverted.
				// will fix this later.
				boolean is_local_min = isLocalMin(a, i, j);
				if (is_local_min == true)
				{
					StdOut.println("local min: " + a[i][j] + "; " + "x is " + i + "; " + "y is " + j + ";");
				}
			}
		}
	}
}
