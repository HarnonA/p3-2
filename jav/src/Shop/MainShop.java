package Shop;

public class MainShop {

	public static void main(String[] args) {
		Product dvd = new Product("DVD", 12.99,"Samsung");
		Product cd = new Product("CD", 1, "Som livre");
		Product wardrobe = new Wardrobe("Guarda-roupa", 399, "Marca",6);
		//Product blueray = new Product("Blueray", 99.99);
		//Product game = new Product("Game", 200);
		
		Customer customer = new Customer(10,"Harnon", "Rua Qualquer");
		Product novaTV = new TV("TV", 2999.1, "Sony", 52);
		
		TV pp = new TV("TV", 2999.1, "Sony", 52);
		System.out.println( pp.toString() );
		
		ShoppingCart shoppingCart4 = new ShoppingCart( customer );
		shoppingCart4.addProduct(dvd);
		shoppingCart4.addProduct(cd);
		shoppingCart4.addProduct(wardrobe);
		
		
		
		//System.out.println(shoppingCart4.getContents());
		//System.out.println(customer.showCustomer() );
		//System.out.println("Quantidade de itens = " + shoppingCart4.getItemCount());
		//System.out.println("TOTAL = " + shoppingCart4.getTotalPrice());
	}
	
}
