/**
 * 
 */
package shopping_Cart;

/**
 * The PricePolicy interface has one public methods that calculateCost of the
 * given for the given price policy.
 * 
 * @author P2511485
 *
 */

// public methods
public interface PricePolicy {

	/**
	 * Calculate the price of product/Discounted Product
	 * 
	 * @param quantity
	 *            the quantity of the product
	 * @param price
	 *            the price of the product (unit price)
	 * @return the calculated price of the product
	 */
	public int calculateCost(int quantity, int price);
}
