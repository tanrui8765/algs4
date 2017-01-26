import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;

/**
 * Created by the_real_Rui on 26/1/2017.
 */

public class SmartDate_TR
{
	// 1.2.11 Develop an implementation SmartDate of our Date API that
	//        raises an excep- tion if the date is not legal.

	private static int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	private int month;    // month (between 1 and 12)
	private int day;      // day (between 1 and DAYS[month])
	private int year;     // year

	/**
	 * Initializes a new date from the month, day, and year.
	 *
	 * @param month the month (between 1 and 12)
	 * @param day   the day (between 1 and 28-31, depending on the month)
	 * @param year  the year
	 * @throws IllegalArgumentException if this date is invalid
	 */
	public SmartDate_TR(int month, int day, int year)
	{
		if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");

		this.month = month;
		this.day = day;
		this.year = year;
	}

	/**
	 * Initializes new date specified as a string in form MM/DD/YYYY.
	 *
	 * @param date the string representation of this date
	 * @throws IllegalArgumentException if this date is invalid
	 */
	public SmartDate_TR(String date)
	{
		String[] fields = date.split("/");
		if (fields.length != 3)
		{
			throw new IllegalArgumentException("Invalid date");
		}

		month = Integer.parseInt(fields[0]);
		day = Integer.parseInt(fields[1]);
		year = Integer.parseInt(fields[2]);
		if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
	}

	/**
	 * Return the month.
	 *
	 * @return the month (an integer between 1 and 12)
	 */
	public int month()
	{
		return month;
	}

	/**
	 * Returns the day.
	 *
	 * @return the day (an integer between 1 and 31)
	 */
	public int day()
	{
		return day;
	}


	/**
	 * Returns the year.
	 *
	 * @return the year
	 */
	public int year()
	{
		return year;
	}

	// is the given date valid?
	private static boolean isValid(int m, int d, int y)
	{
		if (m < 1 || m > 12) return false;
		if (d < 1 || d > DAYS[m]) return false;
		if (m == 2 && d == 29 && !isLeapYear(y)) return false;
		return true;
	}

	// is y a leap year?
	private static boolean isLeapYear(int y)
	{
		if (y == 3200) return false;
		if (y % 400 == 0) return true;
		if (y % 100 == 0) return false;
		return y % 4 == 0;
	}


	/**
	 * Returns the next date in the calendar.
	 *
	 * @return a date that represents the next day after this day
	 */
	public SmartDate_TR next()
	{
		if (isValid(month, day + 1, year)) return new SmartDate_TR(month, day + 1, year);
		else if (isValid(month + 1, 1, year)) return new SmartDate_TR(month + 1, 1, year);
		else return new SmartDate_TR(1, 1, year + 1);
	}

	/**
	 * Compares two dates chronologically.
	 *
	 * @param that the other date
	 * @return {@code true} if this date is after that date; {@code false} otherwise
	 */
	public boolean isAfter(SmartDate_TR that)
	{
		return compareTo(that) > 0;
	}


	/**
	 * Compares two dates chronologically.
	 *
	 * @param that the other date
	 * @return {@code true} if this date is before that date; {@code false} otherwise
	 */
	public boolean isBefore(SmartDate_TR that)
	{
		return compareTo(that) < 0;
	}


	/**
	 * Compares two dates chronologically.
	 *
	 * @return the value {@code 0} if the argument date is equal to this date;
	 * a negative integer if this date is chronologically less than
	 * the argument date; and a positive ineger if this date is chronologically
	 * after the argument date
	 */
//	@Override
	public int compareTo(SmartDate_TR that)
	{
		if (this.year < that.year) return -1;
		if (this.year > that.year) return +1;
		if (this.month < that.month) return -1;
		if (this.month > that.month) return +1;
		if (this.day < that.day) return -1;
		if (this.day > that.day) return +1;
		return 0;
	}

	/**
	 * Returns a string representation of this date.
	 *
	 * @return the string representation in the format MM/DD/YYYY
	 */
//	@Override
	public String toString()
	{
		return month + "/" + day + "/" + year;
	}

	/**
	 * Compares this date to the specified date.
	 *
	 * @param other the other date
	 * @return {@code true} if this date equals {@code other}; {@code false} otherwise
	 */
//	@Override
	public boolean equals(Object other)
	{
		if (other == this) return true;
		if (other == null) return false;
		if (other.getClass() != this.getClass()) return false;
		SmartDate_TR that = (SmartDate_TR) other;
		return (this.month == this.month) && (this.day == that.day) && (this.year == that.year);
	}


	/**
	 * Returns an integer hash code for this date.
	 *
	 * @return an integer hash code for this date
	 */
//	@Override
	public int hashCode()
	{
		int hash = 17;
		hash = 31 * hash + month;
		hash = 31 * hash + day;
		hash = 31 * hash + year;
		return hash;
	}


	/**
	 * Unit tests the {@code Date} data type.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args)
	{
		SmartDate_TR today = new SmartDate_TR(2, 25, 2004);
		StdOut.println(today);
		for (int i = 0; i < 10; i++)
		{
			today = today.next();
			StdOut.println(today);
		}

		StdOut.println(today.isAfter(today.next()));
		StdOut.println(today.isAfter(today));
		StdOut.println(today.next().isAfter(today));

		SmartDate_TR birthday = new SmartDate_TR(10, 16, 1971);
		StdOut.println(birthday);
		for (int i = 0; i < 10; i++)
		{
			birthday = birthday.next();
			StdOut.println(birthday);
		}
	}
}

