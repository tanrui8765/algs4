import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 25/4/2017.
 */
public class LocalMinMatrix_TR2
{
	public static int findColumnMin(int[][] array, int column)
	{
		int min = Integer.MAX_VALUE;
		int index = 0;

		for (int i = 0; i < array.length; i++)
		{
			if (min > array[i][column])
			{
				min = array[i][column];
				index = i;
			}
		}

		return index;
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
