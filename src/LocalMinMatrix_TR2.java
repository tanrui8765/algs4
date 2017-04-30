import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 25/4/2017.
 */
public class LocalMinMatrix_TR2
{
	public static int findColumnMin(int[][] matrix, int column)
	{
		int min = Integer.MAX_VALUE;
		int index = 0;

		for (int i = 0; i < matrix.length; i++)
		{
			if (min > matrix[i][column])
			{
				min = matrix[i][column];
				index = i;
			}
		}

		return index;
	}

	int findLocalMin(int[][] matrix, int left, int right)
	{
		// if(matrix.length <= 0) return 0;

		int j = (left + right) / 2;
		int column_min = findColumnMin(matrix, j);

		boolean is_local_min = isLocalMin(matrix, j, column_min);

		if (is_local_min == false)
		{

		}
		else
		{

		}

	}

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
				StdOut.print(a[j][i] + " ");
			}
			StdOut.println();
		}

		StdOut.println("Column Min: " + a[findColumnMin(a, 0)][0]);
	}
}
