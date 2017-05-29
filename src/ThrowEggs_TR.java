import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by the_real_Rui on 28/5/2017.
 */
public class ThrowEggs_TR
{
	int N_story = 0; // N story building, starts from 1.
	int F_break = 0; // F floor or above will break the egg, starts from 1.

	int floor_idx = 0; // floor index for throwing the egg, starts from 1.
	public static int egg_cnt = 0; // count the egg consumed to find the F floor, starts from 0.

	public ThrowEggs_TR(int N, int F)
	{
		if ((N < 0) || (F < 0)) throw new RuntimeException("Error of N_story or F_break");
		N_story = N;
		F_break = F;
		egg_cnt = 0;
		floor_idx = 1;  // this var starts from 1
	}

	// throw egg once to test whether the egg will be broken or not
	public static boolean throw_egg_once(int F, int f_index)
	{
		boolean is_egg_break = false;
		if (f_index >= F) is_egg_break = true;
		else is_egg_break = false;

		return is_egg_break;
	}

	// test through floors to see how many tries to find the threshold floor, with Binary Search.
	public static int building_test_binary(int N, int F)
	{
		boolean is_egg_break = false;
		int test_cnt = 0;

		int lo = 1;
		int hi = N;
		int mid = 0;

		while (lo <= hi)
		{
			test_cnt++;
			mid = lo + (hi - lo) / 2;
			is_egg_break = throw_egg_once(F, mid);

			if (is_egg_break == true)
			{
				egg_cnt++;
			}

			if ((is_egg_break == true) && (mid == F))
			{
				break;
			}
			else if (is_egg_break == true)
			{
				hi = mid - 1;
			}
			else // is_egg_break == false
			{
				lo = mid + 1;
			}
		}

		return test_cnt;
	}

	// test through floors to see how many tries to find the threshold floor.
	public static int building_test_basic(int N, int F)
	{
		boolean is_egg_break = false;
		int test_cnt = 0;

		for (int i = 1; i <= N; i++)
		{
			test_cnt++;
			is_egg_break = throw_egg_once(F, i);

			if (is_egg_break == true)
			{
				egg_cnt++;
			}

			if ((is_egg_break == true) && (i == F))
			{
				break;
			}
		}

		return test_cnt;
	}

	public static void unit_test(int N, int T)
	{
		int build_story_num = N;
		int egg_break_floor = 0;
		int worst_case_cnt = 0;
		int worst_case_atmp = 0;
		int find_thresh_cnt = 0;

		StdOut.println("----------------------------------");
		StdOut.println("Test Start:");
		StdOut.println("--> story num: " + build_story_num);

		for (int i = 1; i <= T; i++)
		{
			if (i == 1)
			{
				egg_break_floor = 1;
			}
			else if (i == 2)
			{
				egg_break_floor = build_story_num;
			}
			else if (i == 3)
			{
				egg_break_floor = build_story_num + 1;
			}
			else
			{
				egg_break_floor = StdRandom.uniform(2, build_story_num);
			}
			egg_cnt = 0;

//			find_thresh_cnt = building_test_basic(build_story_num, egg_break_floor);
			find_thresh_cnt = building_test_binary(build_story_num, egg_break_floor);

			if (find_thresh_cnt > worst_case_cnt)
			{
				worst_case_cnt = find_thresh_cnt;
				worst_case_atmp = i;
			}

			StdOut.println("Atmpt: " + i + ", N:" + build_story_num + ", F: " + egg_break_floor + ", Cnt: " + find_thresh_cnt + ", Egg Brk: " + egg_cnt);
		}
		StdOut.println();

		StdOut.println("Test Done:");
		StdOut.println("--> worst cnt: " + worst_case_cnt + ", in attempt " + worst_case_atmp);
		StdOut.println();
	}

	public static void main(String[] args)
	{
		int N = 10;
		int T = 10;


		for (int i = 1; i <= (T / 2); i++)
		{
			N = N * i;
			unit_test(N, T);
		}

	}
}
