/**
 * 
 */
package shopping_Cart;

import java.text.DecimalFormat;

/**
 * A simple date record with day, month, year number values.
 * There is no validation in this class.
 * 
 * @author P2511485
 *
 */
public class Date {

	// Fields
	private int day; // 1..31
	private int month; // 1..12
	private int year;

	// Constructors

	/**
	 * @param day
	 *            the day of the delivery date
	 * @param month
	 *            the month of the delivery date
	 * @param year
	 *            the year of the delivery date
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// Methods

	/**
	 * Returns a formatted date string.
	 * 
	 * @return A date in the format dd/mm/yyyy
	 */
	public String getDateString() {
		DecimalFormat f = new DecimalFormat("00"); // used to ensure 1 outputs as 01
		return f.format(day) + "/" + f.format(month) + "/" + year;
	}

}
