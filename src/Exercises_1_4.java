/**
 * Created by the_real_Rui on 18/3/2017.
 *
 */
public class Exercises_1_4
{
	public static void exercise_1_4_1(String[] args)
	{
		// this is an combination problem.
		// chosen different triples from N items, the total number is C3/N.
		// C3/N = P3/N / 3! = N! / (N-3)! / 3!
		//      = N(N-1)(N-2)/6
		//
		// for fundamental permutation and combination explanation, please refer to
		// "http://www.cnblogs.com/simbon/p/6074575.html"
	}

	public static void exercise_1_4_2(String[] args)
	{
		// if two values are int values, and add them will cause overflow, the result would be negative value.
		// I think this won't be cause the original ThreeSum work fail.
		// Am I right ???
	}

	public static void exercise_1_4_3(String[] args)
	{
		// in DoublingTest_TR, not implemented very well, will be refined in the future.
	}

	public static void exercise_1_4_4(String[] args)
	{
		// you could extend this question from TwoSum_TR.java
	}

	// My BAD math...... T^T, if you know the right answer, please leave me a message.
	// Thanks!!!!!
	public static void exercise_1_4_5(String[] args)
	{
		// Am I Right???

		// a: N+1                       : ~ N
		// b: 1+1/N                     : ~ 1/N
		// c: (1+1/N)(1+2/N)            : ~ 2/N^2
		// d: (2N^3)-(15N^2)+N          : ~ 2N^3
		// e: lg(2N)/lgN                : ~ lg2/lgN
		// f: lg(N^2+1)/lgN             : ~ lg(N^2+1)/lgN
		// g: N^100/2^N                 : ~ ???
	}


}
