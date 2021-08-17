/**
 * 
 */
package shopping_Cart;

/**
 * A Customer has a name, customerId, and rewardPoints. This example shows how a
 * customer is a Composition of Name object.
 * 
 * @author P2511485
 *
 */

public class Customer {

	// Fields
	private String customerId;
	private Name name;
	private int rewardPoints;

	// Constructors

	/**
	 * @param customerId
	 *            the unique ID of the customer
	 * @param name
	 *            the name of the customer
	 * @param rewardPoints
	 *            the reward points of the customer
	 */
	public Customer(String customerId, Name name, int rewardPoints) {

		this.customerId = customerId;
		this.name = name;
		this.rewardPoints = rewardPoints;
	}

	// Methods

	/**
	 * Return the cutomerId of the customer
	 * 
	 * @return the customerId of the customer
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Return the rewardPoints for this customer
	 * 
	 * @return the rewardPoints for this customer
	 */
	public int getRewardPoints() {
		return rewardPoints;
	}

	/**
	 * add the passed reward points to the customer reward points
	 * 
	 * @param rewardPoints
	 *            the reward points to be added
	 */
	public void addRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	/**
	 * Return a textual representation of the Customer.
	 * 
	 * @return a textual representation of the Customer.
	 */
	@Override
	public String toString() {
		String s = customerId + " : " + name.getFullName() + " own " + rewardPoints + " Reward Points."
				+ System.lineSeparator();
		return s;
	}

}
