/**
 * 
 */
package shopping_Cart;

/**
 * The Product class has a product_Code, description and unit_Price The price is
 * given in pence.
 * 
 * @author P2511485
 *
 */

public class Product implements Comparable<Product> {

	// Fields
	private String product_Code;
	private String description;
	private int unit_Price; // pence

	// Constructors
	/**
	 * Creates a Product with the given product_Code, description, unit_Price.
	 * 
	 * @param product_Code
	 *            the unique code of the product
	 * @param description
	 *            the description of the product
	 * @param unit_Price
	 *            the price of 1 unit product in pence
	 * 
	 */
	public Product(String product_Code, String description, int unit_Price) {

		this.product_Code = product_Code;
		this.description = description;
		this.unit_Price = unit_Price;
	}

	// Methods
	/**
	 * Return the product_Code of this Product
	 * 
	 * @return the product_Code of this Product
	 */
	public String getProduct_Code() {
		return product_Code;
	}

	/**
	 * @param product_Code
	 *            the product_Code to set
	 */
	public void setProduct_Code(String product_Code) {
		this.product_Code = product_Code;
	}

	/**
	 * Return the description of this product
	 * 
	 * @return the description of this product
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Return the Product unit_price of this product
	 * 
	 * @return The unit_price in pence of this product
	 */
	public int getUnit_Price() {
		return unit_Price;
	}

	/**
	 * @param unit_Price
	 *            the unit_Price to set
	 */
	public void setUnit_Price(int unit_Price) {
		this.unit_Price = unit_Price;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((product_Code == null) ? 0 : product_Code.hashCode());
		result = prime * result + unit_Price;
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
		Product product = (Product) obj;
		if (description == null) {
			if (product.description != null)
				return false;
		} else if (!description.equals(product.description))
			return false;
		if (product_Code == null) {
			if (product.product_Code != null)
				return false;
		} else if (!product_Code.equals(product.product_Code))
			return false;
		if (unit_Price != product.unit_Price)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Product other) {
		if (product_Code.compareTo(other.product_Code) != 0)
			return product_Code.compareTo(other.product_Code);
		if (description.compareTo(other.description) != 0)
			return description.compareTo(other.description);
		return unit_Price - other.unit_Price;
	}

	/**
	 * Return a textual representation of the Product.
	 * 
	 * @return a textual representation of the Product.
	 */

	@Override
	public String toString() {
		String s = product_Code + " [" + description + "]" + System.lineSeparator();
		s += "Unit Price : " + unit_Price + System.lineSeparator();
		return s;
	}

}
