/**
 * 
 */
package shopping_Cart;

import java.util.HashSet;
import java.util.Iterator;

/**
 * A reward processor should store products, which can gain rewards for the
 * customer if they are in their shopping cart. A hash set collection should be
 * used for this. This example shows how a RewardProcessor is a Aggregation of
 * Product object.
 * 
 * @author P2511485
 *
 */

/* Aggregation of Products */
public class RewardProcessor {

	// Fields
	private HashSet<Product> products;

	/**
	 * HashSet of products This set will contain the products which have some
	 * rewards associated with them
	 */

	// Constructors
	public RewardProcessor() {

		products = new HashSet<Product>();

	}

	/**
	 * Add the passed product to the set of products
	 * 
	 * @param product
	 *            the product to be added
	 * @return true only if the product was successfully added else return false
	 */
	public boolean addProduct(Product product) {
		boolean returnValue = products.contains(product);
		products.add(product);
		return returnValue;
	}

	/**
	 * calculate the reward points of a cart
	 * 
	 * @param cart
	 *            the cart to check
	 * @return calculated reward points of the cart
	 */
	public int rewardPoints(Cart cart) {

		int points = 0;
		Iterator<Order> itr = cart.iterator();
		Customer cartCustomer = cart.getCustomer();
		while (itr.hasNext()) {
			Order tempOrder = itr.next();
			Product product = tempOrder.getProduct();
			if (products.contains(product))
				points = points + tempOrder.getQuantity();
		}
		cartCustomer.addRewardPoints(points);
		return points;

	}
}
