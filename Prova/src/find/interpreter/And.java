package find.interpreter;

public class And implements Specifica {

	Color cor;
	int price;

	public And(Color cor, int price) {
		this.cor = cor;
		this.price = price;
	}

	@Override
	public boolean isSatisfaid(Product product) {

		if (product.getPrice() < price && product.getColor().equals(cor)) {
			return true;
		} else {
			return false;
		}
	}

}
