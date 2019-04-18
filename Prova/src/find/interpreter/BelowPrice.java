package find.interpreter;

public class BelowPrice implements Specifica {

	int belowPrice;

	public BelowPrice(int belowPrice) {
		this.belowPrice = belowPrice;
	}

	@Override
	public boolean isSatisfaid(Product product) {

		if (product.getPrice() < belowPrice) {
			return true;
		} else {
			return false;
		}
	}

}
