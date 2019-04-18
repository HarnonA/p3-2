package Shop;

public class Wardrobe extends Product{
	private int doorNumb;
	
	public Wardrobe(String name, double price,String brand, int doorNumb){
		super( name, price, brand );
		this.doorNumb = doorNumb;
	}
	
	public int getDoorNumb(){
		return doorNumb;
	}

}
