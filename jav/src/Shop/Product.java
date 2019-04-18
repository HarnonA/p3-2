package Shop;

/*
 * This class models the products that will be in the cart.
 */
public class Product {

	//Product name
	private String name;
	
	//Product price
	protected double price;
	
	//Product brand
	private String brand;

	/*
	 * Product constructor
	 * 
	 * @param name the product name
	 * @param price the product price
	 */
	public Product(String name, double price,String brand) {
		this.name = name;
		this.price = price;
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public String getBrand(){
		return brand;
	}
	
	public String toString(){
		String s = super.toString();
		s += "brand";
		return s;
		
	}
	
}