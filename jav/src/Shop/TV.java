package Shop;


public class TV extends Product {
	
	private int inches;
	
	
	public TV(String name, double price,String brand, int inches){
		super( name, price, brand );
		this.inches = inches;
		
	}
	
	public int getInches(){
		return inches;
		
	}
	
	public String toString(){
		String s = super.toString();
		s += "\n" + inches;
		return s;
		
	}

}
