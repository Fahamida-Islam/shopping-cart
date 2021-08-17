/**
 * 
 */
package shopping_Cart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Iterator;

/**
 * This is the test class to test all classes of Shopping Cart System
 * @author P2511485
 *
 */
public class Cart_Test {

	
	public static void main(String[] args) {

		String cartId = "CART001";
		Date delivery_Date = new Date(9, 1, 2020);
		Name name = new Name("Joe", "Biden");
		Customer customer = new Customer("CUSTOMER511", name, 5);
		Product p1 = new Product("P103", "Product 3 is : Kitkat", 10);
		Product p2 = new Product("P101", "Product 1 is : Bounty", 11);
		Product p3 = new Discount_Product("P102", "Product 2 is : Dairy Milk", 15, 0.4);
		Product p4 = new Product("P104", "Product 4 is : Milk Chocolate", 20);
		Product p5 = new Discount_Product("P105", "Product 5 is : Caramilk", 22, 0.5);

		Cart cart = new Cart(cartId, customer, delivery_Date);

		// order with default price policy
		cart.addOrder(new Order(5, p1));

		// order with Buy 1 get 1 free price policy
		cart.addOrder(new Order(14, p2));

		// order with Buy 2 get 1 free price policy
		cart.addOrder(new Order(10, p3));
		
		// order with Buy 5 get 1 free price policy
		cart.addOrder(new Order(11, p4));

		// order with default price policy
		cart.addOrder(new Order(15, p5));

		System.out.println("====> USE CASE 1 <====\n");
		cart.forEach((Order) -> System.out.println(Order));
		System.out.println("Number of items in the cart : " + cart.size());
		System.out.println("Overall total price : " + cart.getTotalCost());
		System.out.println();
		System.out.println();
		
		

		System.out.println("====> USE CASE 2 <====\n");
		System.out.println("==>Initial Cart<==");
		cart.forEach((order) -> System.out.println(order));
		System.out.println();
		System.out.println("==> Sorting Cart <==");
		cart.sortOrders();
		cart.forEach((order) -> System.out.println(order));
		System.out.println();
		cart.sortOrders(new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {

				if (o1.getCost() - o2.getCost() != 0)
					return o1.getCost() - o2.getCost();
				return o2.getProduct().compareTo(o1.getProduct());
			}
		});
		System.out.println("==>Sorting Cart by passing Comparator<==");
		cart.forEach((order) -> System.out.println(order));
		System.out.println();
		System.out.println();
		
		
		

		System.out.println("====> USE CASE 3 <====\n");

		System.out.println();
		System.out.println("==>Initial Cart<==");
		cart.forEach((order) -> System.out.println(order));
		System.out.println();
		Product p7 = new Product("P007", "Product 7 is: Orange.", 11);
		Product p8 = new Discount_Product("P008", "Product 8 is: Banana.", 15, 0.4);
		Product p9 = new Product("P009", "Product 9 is: Apple.", 20);

		System.out.println("Testing contains ...");
		System.out.println("Contains order with product code P102: " + cart.containsOrder(new Order(1, p7)));
		System.out.println("Contains order with product code P103: " + cart.containsOrder(new Order(1, p8)));
		System.out.println("Contains order with product code P104: " + cart.containsOrder(new Order(1, p9)));

		System.out.println("\nTesting Remove ...");
		System.out.println("Remove order with product code P107.");
		System.out.println("Remove order with product code P108.");
		System.out.println("Remove order with product code P109.");

		cart.removeOrder(new Order(1, p7));
		cart.removeOrder(new Order(1, p8));
		cart.removeOrder(new Order(1, p9));

		System.out.println("\n==>Final Cart<==");
		cart.forEach((order) -> System.out.println(order));

		try {
			final

			PrintWriter pw = new PrintWriter(new File("src/Cart.txt"));
			pw.println(cart.toString());
			cart.forEach((order) -> pw.println(order.toString()));

			pw.println();

			pw.println("Number of items in the cart : " + cart.size());
			pw.println("Overall total price : " + cart.getTotalCost());

			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("'Cart.txt' file created successfully.");
		System.out.println();
		System.out.println();

		
		
		System.out.println("====> USE CASE 4 <====\n");
		System.out.println();
		System.out.println("==>Initial Cart by iterator");
		Iterator<Order> itr = cart.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		System.out.println("");
		System.out.println("Contains order with product code P101: " + cart.containsOrder(new Order(14, p2)));
		System.out.println("Contains order with product code P104: " + cart.containsOrder(new Order(1, p3)));
		System.out.println();

		System.out.println("FindOrder with product Code P102 : " + cart.findOrder("P102")); // search by product code
		System.out.println("");
		System.out.println("Sorting Orders...");
		cart.sortOrders();
		System.out.println("incrementing Order quantity with product code P104");
		cart.findOrder("P104").increaseQuantity();
		System.out.println("incrementing Order quantity with product code P104");
		cart.findOrder("P104").increaseQuantity();
		System.out.println("decrementing Order quantity with product code P105");
		cart.findOrder("P105").decreaseQuantity();
		System.out.println("\nFinal Cart by Iterator: ");
		itr = cart.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		System.out.println();
		System.out.println();
		
		

		System.out.println("====> USE CASE 5 <====\n");
		RewardProcessor processor = new RewardProcessor();
		processor.addProduct(p2);
		processor.addProduct(p3);
		processor.addProduct(new Product("1", "test desc", 10));
		processor.addProduct(new Product("2", "test desc", 10));
		System.out.println("Initial reward points of customer : " + cart.getCustomer().getRewardPoints());
		System.out.println("rewardPoints(cart) returned : " + processor.rewardPoints(cart));
		System.out.println("Updated reward points for customer : " + cart.getCustomer().getRewardPoints());
		System.out.println();
		System.out.println();
		
		

		System.out.println("====> USE CASE 6 <====\n");

		PricePolicy B1G1 = new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				return quantity / 2 * price;
			}
		};

		PricePolicy B2G1 = new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				int fPrice1 = (quantity / 3) * (price * 2);
				int fPrice2 = (quantity % 3) * price;
				return fPrice1 + fPrice2;
			}
		};

		PricePolicy B5G1 = new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				int fPrice1 = (quantity / 6) * (price * 5);
				int fPrice2 = (quantity % 6) * price;
				return fPrice1 + fPrice2;
			}
		};

		System.out.println("Initial cart : ");
		cart.forEach((order) -> System.out.println(order));
		System.out.println("Number of items in the cart : " + cart.size());
		System.out.println("Overall total price : " + cart.getTotalCost());
		System.out.println();
		System.out.println();
		System.out.println("Setting price policy...");
		System.out.println("Order with product code P103 : Default Price Policy");
		System.out.println("Order with product code P101 : Buy 1 Get 1 Free Price Policy");
		System.out.println("Order with product code P102 : Buy 2 Get 1 Free Price Policy");
		System.out.println("Order with product code P104 : Buy 5 Get 1 Free Price Policy");

		cart.findOrder("P101").setPricePolicy(B1G1);
		cart.findOrder("P102").setPricePolicy(B2G1);
		cart.findOrder("P104").setPricePolicy(B5G1);
		System.out.println();
		System.out.println();

		System.out.println("Final cart : ");
		cart.forEach((order) -> System.out.println(order));
		System.out.println("Number of items in the cart : " + cart.size());
		System.out.println("Overall total price : " + cart.getTotalCost());
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
