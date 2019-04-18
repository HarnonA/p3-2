package finder;

public class ByCost implements Spec {
	private double cost;

	public ByCost(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}
	
	public boolean isSatisfied(Resource resource) {
		return resource.getCost() <= getCost();
	}

}
