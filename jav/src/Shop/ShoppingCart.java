package Shop;

import java.util.ArrayList;

/*
 * This class models the cart that will be used in our e-commerce system.
 */
public class ShoppingCart {

	//private int customerID;
	private ArrayList productsList;
	private Customer customer;
	
	/*
	 * Constructor of the ShoppingCart class.
	 * We only allow the customerID to avoid a complete product list.
	 * 
	 *  @param customerID the customer ID
	 */
	public ShoppingCart(Customer customer) {
		this.customer = customer;
		productsList = new ArrayList();
	}

	public void addProduct(Product product) {
		productsList.add(product);
	}
	
	public double getTotalPrice() {
		double totalPrice = 0;
		for (int i = 0; i < productsList.size(); i++) {
			Product product = (Product) productsList.get(i);
			totalPrice = totalPrice + product.getPrice();
		}
		return totalPrice;
	}
	
	public int getItemCount() {
		return productsList.size();
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void removeProduct(Product product) {
		productsList.remove(product);
	}
	
	public String getContents() {
		String result = "";
		
		for (int i = 0; i < productsList.size(); i++) {
			Product product = (Product) productsList.get(i);
			result = result + "Name: " + product.getName() + "; Price = " + product.getPrice(); 
			result = result + "; Brand " + product.getBrand() + "\n";
		}
		
		return result;
	}
	
}