/**
 * Created by the_real_Rui on 3/4/2017.
 */
public class BinarySearch_SmallestIndex
{
	private static int lowerBound(int[] data, int k)
	{
		int lo = 0, hi = data.length - 1;

		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (k < data[mid])
			{
				hi = mid - 1;
			}
			else if (k > data[mid] || (mid != 0 && data[mid - 1] == k))
			{
				lo = mid + 1;
			}
		}
	}
}
