package elements;

public class Body implements Item {

	@Override
	public void accept(I_BuildPlan visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
		
	}


}
