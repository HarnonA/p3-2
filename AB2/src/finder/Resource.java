package finder;

public class Resource {
	
	private String first = new String();
	private String second = new String();
	private Type type = null;
	private double cost = 0;
	private Size size = null;

	public Resource(String first, String second, Type type, double cost,Size size) {
		this.first = first;
		this.second = second;
		this.type = type;
		this.cost = cost;
		this.size = size;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	 
	public String toString(){
		return (first + " " + second);
	}
	

}
