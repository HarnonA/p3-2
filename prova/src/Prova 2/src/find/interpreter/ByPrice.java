package find.interpreter;

public class ByPrice implements Specifica {

	int price;

	public ByPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean isSatisfaid(Product product) {

		if (product.getPrice() == price) {
			return true;
		} else {
			return false;
		}
	}

}
