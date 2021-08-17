/**
 * 
 */
package shopping_Cart;

/**
 * A name has a first name and a family name. There is an option to produce a
 * full name by combining these.
 * 
 * @author P2511485
 *
 */

public class Name {

	// Fields
	private String firstName;
	private String familyName;

	// Constructors
	/**
	 * @param firstName the first name of the customer
	 * @param familyName the family name of the customer
	 */
	public Name(String firstName, String familyName) {

		this.firstName = firstName;
		this.familyName = familyName;
	}

	// Methods
	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param familyName
	 *            the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * Return the full name of the person first+family
	 * 
	 * @return the full name of the person first+family
	 */
	public String getFullName() {

		return this.firstName + " " + this.familyName;
	}

}
