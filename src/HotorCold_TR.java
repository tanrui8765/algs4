import edu.princeton.cs.algs4.StdOut;
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

	public static int new_guess(int min_num, int max_num, int prev_guess_value, int prev_guess_rate)
	{

	}

	public static boolean is_guess_hit(int secret_num, int guess_num)
	{
		return (secret_num == guess_num);
	}

	// return result: guess doesn't go further or closer 0; closer 1; further -1;
	public static int guess_result_rating(int secret_num, int guess_num, int prev_guess_num)
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

	public static void guess_progress_trace(int guess_index, boolean is_rlt_hit, int new_val, int new_rate, int prev_val, int prev_rate)
	{
		StdOut.println(guess_index + ", "
				+ is_rlt_hit + ", "
				+ new_val + ", "
				+ new_rate + ", "
				+ prev_val + ", "
				+ prev_rate);
	}

	public static void guess_secret_num(int secret_num, int min_num, int max_num)
	{
		boolean is_secret_num_found = false; // this value mean is guess hit the secret number?

		int new_guess_val = 0;
		int prev_guess_val = 0;

		int new_guess_rate = 0;
		int prev_guess_rate = 0;

		int guess_cnt = 0;

		do
		{
			guess_cnt++;

			new_guess_val = new_guess(min_num, max_num, prev_guess_val, prev_guess_rate);
			is_secret_num_found = is_guess_hit(secret_num, new_guess_val);
			new_guess_rate = guess_result_rating(secret_num, new_guess_val, prev_guess_val);

			if (is_secret_num_found == false)
			{
				prev_guess_val = new_guess_val;
				prev_guess_rate = new_guess_rate;
			}
			else
			{
				;
			}

			guess_progress_trace(guess_cnt, is_secret_num_found, new_guess_val, new_guess_rate, prev_guess_val, prev_guess_rate);
		}
		while (is_secret_num_found == false);

	}

	public static void main(String[] args)
	{
		int N = 100;
		int secret_num = 0;


		secret_num = generate_a_secret_num(1, N);

		guess_secret_num(secret_num, 1, N);


	}
}
