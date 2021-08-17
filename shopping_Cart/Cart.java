/**
 * 
 */
package shopping_Cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * A Cart has a cartId, date of delivery, and customer. It consists of a list of
 * product orders This example shows how a Cart is a Composition of Customer and
 * Date objects.
 * 
 * @author P2511485
 *
 */

/* Composition of Customer and Date */
public class Cart implements Iterable<Order> {

	// Fields
	private String cartId;
	private Date delivery_Date;
	private Customer customer;
	private List<Order> productOrders;

	// Constructors
	/**
	 * @param cartId
	 *            the unique id of the cart
	 * @param customer
	 *            the customer of the cart
	 * @param delivery_Date
	 *            the delivery_Date of the cart
	 */
	public Cart(String cartId, Customer customer, Date delivery_Date) {

		this.cartId = cartId;
		this.customer = customer;
		this.delivery_Date = delivery_Date;
		this.productOrders = new ArrayList<Order>();

	}

	// Methods
	/**
	 * Return the cardId of this Cart
	 * 
	 * @return the cartId of this Cart
	 */
	public String getCartId() {
		return cartId;
	}

	/**
	 * add passed order to the list of product orders
	 * 
	 * @param order
	 *            the new order to be added to the list of product orders
	 */
	public void addOrder(Order order) {
		productOrders.add(order);
	}

	/**
	 * remove the passed order from the list of product orders
	 * 
	 * @param order
	 *            the order to be removed from the list of product orders
	 */
	public void removeOrder(Order order) {
		productOrders.remove(order);
	}

	/**
	 * check whether passed order exist in the list of product orders
	 * 
	 * @param order
	 *            the new order check in the list of product orders
	 * @return true if order contain and false otherwise
	 */
	public boolean containsOrder(Order order) {
		return productOrders.contains(order);
	}

	/**
	 * find and return an Order with the passed product code
	 * 
	 * @param product_Code
	 *            the product code of the product to find
	 * @return the Order with the passed product code
	 */

	public Order findOrder(String product_Code) {
		for (Order order : productOrders) {
			if (order.getProduct().getProduct_Code().compareTo(product_Code) == 0)

				return order;
		}

		return null;
	}

	/**
	 * Return the delivery_Date of this cart
	 * 
	 * @return the delivery_Date of this cart
	 */
	public Date getdelivery_Date() {
		return delivery_Date;
	}

	/**
	 * Return the customer of this cart
	 * 
	 * @return the customer of this cart
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Return the total cost of this cart
	 * 
	 * @return the total cost of this cart
	 */
	public int getTotalCost() {

		int total = 0;
		for (Order order : productOrders) {
			total += order.getCost();
		}
		return total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Order> iterator() {

		return productOrders.iterator();
	}

	/**
	 * sort the list of product orders
	 */
	public void sortOrders() {
		productOrders.sort(Comparator.naturalOrder());

	}

	/**
	 * sort the list of product orders according to the passed comparator
	 * 
	 * @param comparator
	 *            the new comparator to be used for sorting
	 */
	public void sortOrders(Comparator<Order> comparator) {
		Collections.sort(productOrders, comparator);

	}

	/**
	 * Return the number of orders in this cart
	 * 
	 * @return the number of orders in this cart
	 */
	public int size() {
		return productOrders.size();
	}

	/**
	 * Return a textual representation of the Cart.
	 * 
	 * @return a textual representation of the Cart.
	 */
	@Override
	public String toString() {

		String s = cartId + " : [" + delivery_Date.getDateString() + "] : " + customer.toString();
		return s;
	}

}
