package find.interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Finder {
	
	private Repository repository;

	public Finder(find.Repository repository2) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}

	public List by(Specifica spec){
		List produtos = new ArrayList<Product>();
		Iterator<Product> products = null;
		while(products.hasNext()){
			Product product = (Product)products.next();
			if (spec.isSatisfaid(product)) {
				produtos.add(product);
			}
		}
		return produtos;	
	}
	
}
