package finder;

public class BySize implements Spec {

	private Size size;
	
	public BySize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return size;
	}
	
	@Override
	public boolean isSatisfied(Resource resource) {
		// TODO Auto-generated method stub
		return resource.getSize().equals(getSize());
	}


}
