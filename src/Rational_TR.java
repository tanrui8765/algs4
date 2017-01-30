import edu.princeton.cs.algs4.StdOut;

/**
 * Created by the_real_Rui on 29/1/2017.
 */
public class Rational_TR
{


	// numerator: the dividend of a fraction.
	private long numer;
	// denominator: in mathematics, the denominator is the number
	//              which appears under the line in a fraction.
	private long denom;

	public Rational_TR(int numerator, int denominator)
	{
		if (denominator == 0)
		{
			throw new IllegalArgumentException("Invalid denominator");
		}

		this.numer = numerator;
		this.denom = denominator;
	}

	public static int gcd(int p, int q)
	{
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}

	public static long gcd(long p, long q)
	{
		if (q == 0) return p;
		long r = p % q;
		return gcd(q, r);
	}

	// sum this number and b
	public Rational_TR plus(Rational_TR b)
	{
		if (b.denom == 0)
		{
			throw new IllegalArgumentException("Invalid denominator");
		}

		Rational_TR new_this = new Rational_TR((int) this.numer, (int) this.denom);
		Rational_TR new_b = new Rational_TR((int) b.numer, (int) b.denom);

		new_this.numer = this.numer * b.denom;
		new_this.denom = this.denom * b.denom;

		new_b.numer = b.numer * this.denom;
		new_b.denom = b.denom * this.denom;

		// the denominator should be the same
		if (new_this.denom != new_b.denom)
		{
			throw new IllegalArgumentException("Calculate Error");
		}

		new_this.numer += new_b.numer;

		// get the common divider
		if (new_this.numer == 0)
		{
		}
		else if (new_this.numer == new_this.denom)
		{
			new_this.numer = 1;
			new_this.denom = 1;
		}
		else if (new_this.numer > new_this.denom)
		{
			long times = new_this.numer / new_this.denom;
			long remainder = new_this.numer % new_this.denom;
			long gcd = gcd(new_this.denom, remainder);

			long new_remain = remainder / gcd;
			long new_denom = new_this.denom / gcd;

			new_this.numer = times * new_denom + new_remain;
			new_this.denom = new_denom;
		}
		else if (new_this.numer < new_this.denom)
		{
			long gcd = gcd(new_this.denom, new_this.numer);

			new_this.numer /= gcd;
			new_this.denom /= gcd;
		}

		return new_this;
	}

	// difference of this number and b
	public Rational_TR minus(Rational_TR b)
	{
		if (b.denom == 0)
		{
			throw new IllegalArgumentException("Invalid denominator");
		}

		Rational_TR new_this = new Rational_TR((int) this.numer, (int) this.denom);
		Rational_TR new_b = new Rational_TR((int) b.numer, (int) b.denom);

		new_this.numer = this.numer * b.denom;
		new_this.denom = this.denom * b.denom;

		new_b.numer = b.numer * this.denom;
		new_b.denom = b.denom * this.denom;

		// the denominator should be the same
		if (new_this.denom != new_b.denom)
		{
			throw new IllegalArgumentException("Calculate Error");
		}

		new_this.numer -= new_b.numer;
		long diff_abs = Math.abs(new_this.numer);

		// get the common divider
		if (new_this.numer == 0)
		{
		}
		else if (diff_abs == new_this.denom)
		{
			new_this.numer = 1;
			new_this.denom = 1;
		}
		else if (diff_abs > new_this.denom)
		{
			long times = diff_abs / new_this.denom;
			long remainder = diff_abs % new_this.denom;
			long gcd = gcd(new_this.denom, remainder);

			long new_remain = remainder / gcd;
			long new_denom = new_this.denom / gcd;

			// the second part is to got the sign of the number.
			new_this.numer = (times * new_denom + new_remain) * (new_this.numer / diff_abs);
			new_this.denom = new_denom;
		}
		else if (diff_abs < new_this.denom)
		{
			long gcd = gcd(new_this.denom, diff_abs);

			new_this.numer /= gcd;
			new_this.denom /= gcd;
		}

		return new_this;
	}

	// product of this number and b
	public Rational_TR times(Rational_TR b)
	{
		if (b.denom == 0)
		{
			throw new IllegalArgumentException("Invalid denominator");
		}

		Rational_TR new_this = new Rational_TR((int) this.numer, (int) this.denom);

		new_this.numer = this.numer * b.numer;
		new_this.denom = this.denom * b.denom;

		long numer_abs = Math.abs(new_this.numer);

		// get the common divider
		if (new_this.numer == 0)
		{
		}
		else if (numer_abs == new_this.denom)
		{
			new_this.numer = 1;
			new_this.denom = 1;
		}
		else if (numer_abs > new_this.denom)
		{

			long times = numer_abs / new_this.denom;
			long remainder = numer_abs % new_this.denom;
			long gcd = gcd(new_this.denom, remainder);

			long new_remain = remainder / gcd;
			long new_denom = new_this.denom / gcd;

			// the second part is to got the sign of the number.
			new_this.numer = (times * new_denom + new_remain) * (new_this.numer / numer_abs);
			new_this.denom = new_denom;
		}
		else if (numer_abs < new_this.denom)
		{
			long gcd = gcd(new_this.denom, numer_abs);

			new_this.numer /= gcd;
			new_this.denom /= gcd;
		}

		return new_this;
	}

	// quotient of this number and b
	public Rational_TR divides(Rational_TR b)
	{
		if (b.denom == 0)
		{
			throw new IllegalArgumentException("Invalid denominator");
		}

		Rational_TR new_this = new Rational_TR((int) this.numer, (int) this.denom);

		new_this.numer = this.numer * b.denom;
		new_this.denom = this.denom * b.numer;

		long numer_abs = Math.abs(new_this.numer);

		// get the common divider
		if (new_this.numer == 0)
		{
		}
		else if (numer_abs == new_this.denom)
		{
			new_this.numer = 1;
			new_this.denom = 1;
		}
		else if (numer_abs > new_this.denom)
		{

			long times = numer_abs / new_this.denom;
			long remainder = numer_abs % new_this.denom;
			long gcd = gcd(new_this.denom, remainder);

			long new_remain = remainder / gcd;
			long new_denom = new_this.denom / gcd;

			// the second part is to got the sign of the number.
			new_this.numer = (times * new_denom + new_remain) * (new_this.numer / numer_abs);
			new_this.denom = new_denom;
		}
		else if (numer_abs < new_this.denom)
		{
			long gcd = gcd(new_this.denom, numer_abs);

			new_this.numer /= gcd;
			new_this.denom /= gcd;
		}

		return new_this;
	}

	// is this number equal to that?
	boolean equals(Rational_TR that)
	{
		return ((this.numer == that.numer) && (this.denom == that.denom));
	}

	// string representation
	public String toString()
	{
		String str = this.numer + "/" + this.denom;
		return str;
	}

	// TODO: this algorithm is not finished yet: negative numbers, display issues(too many minus signs).
	public static void main(String[] args)
	{
		Rational_TR test1 = new Rational_TR(1, 5);
		Rational_TR test2 = new Rational_TR(1, 4);

		StdOut.println("test1: " + test1);
		StdOut.println("test2: " + test2);
		StdOut.println();

		Rational_TR test_plus = test1.plus(test2);
		StdOut.println("plus: " + test_plus);

		Rational_TR test_minus = test1.minus(test2);
		StdOut.println("minus: " + test_minus);

		Rational_TR test_times = test1.times(test2);
		StdOut.println("times: " + test_times);

		Rational_TR test_divides = test1.divides(test2);
		StdOut.println("divides: " + test_divides);

		StdOut.println("equals: " + test1.equals(test2));
	}
}
