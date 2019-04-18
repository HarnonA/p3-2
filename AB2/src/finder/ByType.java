package finder;

public class ByType implements Spec {
	
	private Type type;

	public ByType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	@Override
	public boolean isSatisfied(Resource resource) {
		// TODO Auto-generated method stub
		return resource.getType().equals(getType());
	}

}
