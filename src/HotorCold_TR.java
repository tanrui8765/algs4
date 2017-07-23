import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by the_real_Rui on 23/7/2017.
 */
public class HotorCold_TR
{

	public static int generate_a_secret_num(int min_num, int max_num)
	{

		max_num = Integer.min(max_num, (Integer.MAX_VALUE - 1));
		min_num = Integer.max(min_num, Integer.MIN_VALUE);

		return StdRandom.uniform(min_num, (max_num + 1));
	}

	public static int guess_once(int min_num, int max_num)
	{

	}

	public static boolean is_guess_hit(int secret_num, int guess_num)
	{
		return (secret_num == guess_num);
	}

	// return result: guess doesn't go further or closer 0; closer 1; further -1;
	public static int guess_result_dir(int secret_num, int guess_num, int prev_guess_num)
	{
		int ret_val = 0;

		if (Math.abs(guess_num - secret_num) == Math.abs(prev_guess_num - secret_num))
		{
			ret_val = 0;
		}
		else if (Math.abs(guess_num - secret_num) > Math.abs(prev_guess_num - secret_num))
		{
			ret_val = -1;
		}
		else if (Math.abs(guess_num - secret_num) < Math.abs(prev_guess_num - secret_num))
		{
			ret_val = 1;
		}
		else
		{
			throw new RuntimeException("No Such case in guess_result().");
		}

		return ret_val;
	}

	public static int guess_secret_num(int secret_num)
	{

	}

	public static void main(String[] args)
	{
		int N = 100;
		int secret_num = 0;

		secret_num = generate_a_secret_num(1, N);


	}
}
