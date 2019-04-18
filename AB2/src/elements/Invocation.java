package elements;

public class Invocation implements Item {

	//@Override
	//public void print(String activity) {
		//System.out.println("Invocation: "+activity);
//	}
	private String name;

	public Invocation(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void accept(I_BuildPlan visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
