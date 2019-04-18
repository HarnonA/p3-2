package finder;

public class ByTypeSizeCost implements Spec {
	/*
	private double cost;
	private Size size;
	private Type type;
	
	public ByTypeSizeCost(double cost, Size size,Type type){
		this.cost = cost;
		this.size = size;
		this.type = type;
		
	}
	*/
	private ByType type;
	private BySize size;
	private ByCost cost;
	
	public ByTypeSizeCost(ByType type, BySize size, ByCost cost){
		this.type = type;
		this.size = size;
		this.cost = cost;
	}
	
	public boolean isSatisfied(Resource resource) {
		return resource.getCost() <= cost.getCost()
				&& resource.getSize().equals(size.getSize())
				&& resource.getType().equals(type.getType());
	}

}
