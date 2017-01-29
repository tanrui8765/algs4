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
		return gcd(p, r);
	}

	public static long gcd(long p, long q)
	{
		if (q == 0) return p;
		long r = p % q;
		return gcd(p, r);
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
		if (new_this.numer == new_this.denom)
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
		if (diff_abs == new_this.denom)
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

}
