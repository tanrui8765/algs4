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

		if ()



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
