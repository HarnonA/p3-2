package find;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Finder {
	
	private Repository repository;

	public Finder(Repository createProductRepository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}

	public List byColor(Color colorOfProductToFind) {
		List foundProducts = new ArrayList();
		Iterator<Product> products = null;
		while(products.hasNext()){
			Product product = (Product)products.next();
			if (product.getColor().equals(colorOfProductToFind)) {
				foundProducts.add(product);
			}
		}
		return foundProducts;
	}

	public List byPrice(double priceLimit) {
		List foundProducts = new ArrayList();
		Iterator<Product> products = null;
		while(products.hasNext()){
			Product product = (Product)products.next();
			if (product.getPrice() == priceLimit) {
				foundProducts.add(product);
			}
		}
		return foundProducts;
	}

	public List byColorSizeAndBelowPrice(Color color, CarType size, float price) {
		List foundProducts = new ArrayList();
		Iterator<Product> products = null;
		while(products.hasNext()){
			Product product = (Product)products.next();
			if (product.getColor() == color && 
				product.getType() == size &&
				product.getPrice() < price) {
				foundProducts.add(product);
			}
		}
		return foundProducts;
	}

	public List belowPriceAvoidingAColor(float price, Color color) {
		List foundProducts = new ArrayList();
		Iterator<Product> products = null;
		while(products.hasNext()){
			Product product = (Product)products.next();
			if (product.getColor() != color &&
				product.getPrice() < price) {
				foundProducts.add(product);
			}
		}
		return foundProducts;
	}

}
