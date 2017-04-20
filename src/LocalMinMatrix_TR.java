import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 20/4/2017.
 */
public class LocalMinMatrix_TR
{
	// Return
	// -1: Not a conner point
	// 0: left top point
	// 1: right top point
	// 2: right bottom point
	// 3: left bottom point
	public int isConnerPoint(int[][] mat, int x, int y)
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
	public int isSidePoint(int[][] mat, int x, int y)
	{
		int ret_val = -1;

		return ret_val;
	}

	public boolean isLocalMin(int[][] matrix, int x, int y)
	{

	}


	public static void main(String[] args)
	{
		int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		StdOut.println(a[2][2]);
	}
}
