package find.interpreter;

public class ByColor implements Specifica {

	Color corProcurada;

	public ByColor(Color corProcurada) {
		this.corProcurada = corProcurada;
	}

	@Override
	public boolean isSatisfaid(Product product) {
		if (product.getColor().equals(corProcurada)) {
			return true;
		} else {
			return false;
		}
	}
}