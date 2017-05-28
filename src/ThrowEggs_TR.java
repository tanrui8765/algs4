/**
 * Created by the_real_Rui on 28/5/2017.
 */
public class ThrowEggs_TR
{
	int N_story = 0; // N story building
	int F_break = 0; // F floor or above will break the egg

	int floor_idx = 0; // floor index for throwing the egg
	int egg_cnt = 0; // count the egg consumed to find the F floor

	public ThrowEggs_TR(int N, int F)
	{
		if ((N < 0) || (F < 0)) throw new RuntimeException("Error of N_story or F_break");
		N_story = N;
		F_break = F;
		egg_cnt = 0;
		floor_idx = 1;  // this var starts from 1
	}

	// throw egg once to test whether the egg will be broken or not
	public boolean throw_egg_once(int F, int f_index)
	{
		boolean is_egg_break = false;
		if (f_index >= F) is_egg_break = true;
		else is_egg_break = false;

		return is_egg_break;
	}

	public void building_test(int N, int F)
	{
		for (int i = 0; i < N; i++)
		{

		}
	}


	public static void main(String[] args)
	{

	}
}
