/**
 * 
 */
package shopping_Cart;

/**
 * A Discount Product is a more specialised version of Product. It has aDiscount
 * rate associated with it and a method to discount apply. A discount amount
 * should always drop to the nearest whole number, e.g. a calculated discount of
 * 7.9 pence would apply as a discount of 7 pence on the unit price.
 * 
 * @author P2511485
 */
public class Discount_Product extends Product {

	// Fields
	private double discountRate; // e.g.0 and 1.0, e.g. 0.1 represents a 10% discount

	// Constructors
	/**
	 * Creates an Discount_Product with the given initial values.
	 * 
	 * @param product_Code
	 *            the unique code of the product
	 * @param description
	 *            the description of the product
	 * @param unit_Price
	 *            the price of 1 unit product in pence
	 * @param discountRate
	 *            The discount rate for this product.
	 */

	public Discount_Product(String product_Code, String description, int unit_Price, double discountRate) {
		super(product_Code, description, unit_Price); // call the superclass constructor
		this.discountRate = discountRate;
	}

	// Methods

	/**
	 * @return the standard unit price with any discount applied.
	 * 
	 */
	@Override
	public int getUnit_Price() {
		double discount = discountRate * super.getUnit_Price();
		return (int) Math.floor(super.getUnit_Price() - discount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	/**
	 * Returns a textual representation of the Discount_Product.
	 * 
	 * @return A textual representation of the Discount_Product.
	 */
	@Override
	public String toString() {
		// Firstly call superclass toString method, then add specialised field
		// information
		String s = super.toString();
		s += "Discounted Price : " + getUnit_Price() + " [" + discountRate + "]" + System.lineSeparator();
		return s;
	}

}
