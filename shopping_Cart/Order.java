/**
 * 
 */
package shopping_Cart;

/**
 * The Order class models a order object. It has product and quantity of a
 * product of the order. It also has a price policy This example shows how a
 * Order is a Composition of Product and PricePolicy objects.
 * 
 * @author P2511485
 *
 */

/* Composition of Product and PricePolicy */
public class Order implements Comparable<Order> {

	// Fields
	private int quantity;
	private Product product;
	private PricePolicy policy;

	// Constructors

	/**
	 * @param quantity
	 *            the quantity of the product
	 * @param product
	 *            the product of the order
	 */
	public Order(int quantity, Product product) {

		this.quantity = quantity;
		this.product = product;
		this.policy = new PricePolicy()

		{
			/*
			 * (non-Javadoc)
			 * 
			 * @see shopping_Cart.PricePolicy#calculateCost(int, int)
			 */
			@Override
			public int calculateCost(int quantity, int price) {
				return quantity * price;
			}
		};

	}

	// Methods

	/**
	 * Return the quantity of this order
	 * 
	 * @return the quantity of this order
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Return the product for the cart
	 * 
	 * @return the product for the cart
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Return the cost of this order according to the associated price policy
	 * 
	 * @return the cost of this order according to the associated price policy
	 */

	public int getCost() {

		return policy.calculateCost(quantity, product.getUnit_Price());
	}

	/**
	 * increase the quantity of this order by 1
	 */
	public void increaseQuantity() {
		this.quantity = this.quantity + 1;
	}

	/**
	 * decrease the quantity of this order by 1 only if the quantity is greater than
	 * 0
	 */
	public void decreaseQuantity() {
		if (this.quantity > 0)
			this.quantity = this.quantity - 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order order = (Order) obj;
		if (quantity != order.quantity)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */

	@Override
	public int compareTo(Order other) {
		if (product.compareTo(other.product) != 0)
			return product.compareTo(other.product);
		return quantity - other.quantity;
	}

	/**
	 * set the new price policy for this order
	 * 
	 * @param pricePolicy
	 *            the new price pricePolicy for this order
	 */
	public void setPricePolicy(PricePolicy pricePolicy) {
		this.policy = pricePolicy;
	}

	/**
	 * Returns a textual representation of the order.
	 * 
	 * @return A textual representation of the order.
	 */
	@Override
	public String toString() {
		String s = product.toString();
		s += "Quantity    : " + quantity + System.lineSeparator();
		s += "Total Price : " + getCost() + System.lineSeparator();
		return s;
	}

}
