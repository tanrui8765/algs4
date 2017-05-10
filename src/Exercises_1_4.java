import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

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

	public static void exercise_1_4_6(String[] args)
	{
		// In FragmentsOrderOfGrowth.java
		// refereed from:
		// "https://github.com/HatlessFox/SelfStudy/blob/6fe07048d4ed0e8b8d1cd3b438a2e8dbd5a6f9f6/problem_solving/algorithms/algorithms_4th-sedgewick_wayne/Solutions/src/chapter_1/section_4/Task_06.java"
	}

	public static void exercise_1_4_7(String[] args)
	{
		// the cost model variable is in ThreeSum_TR.java
	}

	public static void exercise_1_4_8(String[] args)
	{
		// the quadratic version is in TwoEqual_TR.java
		// the linear version is in TwoEqualFast_TR.java
	}

	public static void exercise_1_4_9(String[] args)
	{
		// Am I right ???

		// based on Proposition C. (Doubling ratio) on page 193.
		// the formula is (~ a * N^b * lgN)
	}

	public static void exercise_1_4_10(String[] args)
	{
		// BinarySearch_SmallestIndex.java
	}

	public static void exercise_1_4_11(String[] args)
	{
		// code is in StaticSETofInts_TR.java
		// I tried two methods:
		// [1] ordinary count with binary search for the key first, and then traverse to both side to count the same key.
		// [2] binary count with binary search for the key first, and then keep binary searching until the lo > hi (search complete)
		//      then calculate the gap.

		// However, [2] didn't give a better time complexity than [1].
		// I think, maybe [1] is better for the small arrays, and [2] is better for the larger ones with large amount of same keys.
		// I tested in the main(), Am I doing right ???

		// GitHub::Hatless Fox has a cleaner and better binary search version, which I copied to "StaticSETofInts_HatlessFox.java"

		// In general, both binary search versions, require the search fall into the same key section, and spread to both sides.
	}

	public static void exercise_1_4_12(String[] args)
	{
		int N = 5;
		int[] a = {3, 3, 3, 4, 5};
		int[] b = {3, 4, 5, 6, 7};
		int[] same = new int[N];
		int same_index = 0;

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (b[j] == a[i])
				{
					if ((same_index == 0) || (b[j] != same[same_index - 1]))
						same[same_index++] = a[i];
				}
			}
		}

		StdOut.println(Arrays.toString(same));
	}

	public static void exercise_1_4_13(String[] args)
	{
		// Am I Right ???

		// Accumulator: 32 bytes. (class 16 + double 8 + int 4 + padding 4)
		// Transaction: 112 + 2N bytes, where N is the length of the String who.
		//              (class 16 + String 56+2N + Date 32 + double 8)

		// FixedCapacityStackOfStrings with capacity C and N entries
		//              20 + 24*C + (32+2*L)*N, where L is the length of the existing String entries' length.
		//              (class 16 + String array header 24*(C-N) + String array entries (56+2*L)*N + int 4)

		// Point2D: 32 bytes. (class 16 + double 8 + double 8)
		// Interval1D: 32 bytes. (class 16 + double 8 + double 8)
		// Interval2D: 80 bytes. (class 16 + Interval1D 32 + Interval 32)
		// Double: 24 bytes. (class 16 + double 8)
	}

	public static void exercise_1_4_14(String[] args)
	{
		// the code is in FourSum_TR.java
	}

	public static void exercise_1_4_15(String[] args)
	{
		// two sum faster is in TwoSumFaster_TR.java
		// three sum quadratic algorithm? do you mean brute force one? it's in ThreeSum_TR.java
	}

	public static void exercise_1_4_16(String[] args)
	{
		// In ClosestPair_TR.java
		// The code in this page is copied from:
		// "https://github.com/HatlessFox/SelfStudy/blob/master/problem_solving/algorithms/algorithms_4th-sedgewick_wayne/Solutions/src/chapter_1/section_4/Task_16.java"
	}

	public static void exercise_1_4_17(String[] args)
	{
		// In FarthestPair_TR.java
		// The code in this page is from:
		// "https://github.com/HatlessFox/SelfStudy/blob/master/problem_solving/algorithms/algorithms_4th-sedgewick_wayne/Solutions/src/chapter_1/section_4/Task_17.java"

		// What a Genius!!!
	}

	public static void exercise_1_4_18(String[] args)
	{
		// In LocalMinArray_TR.java
		// The code in this page is from:
		// "https://github.com/HatlessFox/SelfStudy/blob/master/problem_solving/algorithms/algorithms_4th-sedgewick_wayne/Solutions/src/chapter_1/section_4/Task_18.java"
	}

	public static void exercise_1_4_19(String[] args)
	{
		/*
		 * Three reference websites, demonstrate a better solution:
         * "http://stackoverflow.com/questions/18525179/find-local-minimum-in-n-x-n-matrix-in-on-time"
		 * "http://www.filipekberg.se/2014/02/10/understanding-peak-finding/"
		 * "http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec01.pdf"
		 */

		// the purpose of this exercise is to find a local min, but not THE global min.
		// this means once we found the local min, we can output it, then its done.

		// In LocalMinMatrix_TR.java, there is a slowest version.
		// In LocalMinMatrix_TR2.java, the algs is referenced from websites above, which is expected to be more efficient.
	}

	public static void exercise_1_4_20(String[] args)
	{
		// In BitonicSearch_TR.java
	}

	public static void exercise_1_4_21(String[] args)
	{
		// The constructor code is in StaticSETofInts_TR.java
		// Function "StaticSETofInts_TR2" is referenced from web:"https://ask.julyedu.com/question/558#!answer_form";

		// this solution is trying to change the constructor to create a sorted distinct element array.
		// In this case the binary search's running time would be guaranteed to be ~lg(R). (Not tested yet)

		// However, is this really RIGHT ?
	}

	public static void exercise_1_4_22(String[] args)
	{
	}

	public static void main(String[] args)
	{
		exercise_1_4_12(args);
	}
}
