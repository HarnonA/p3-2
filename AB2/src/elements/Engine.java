package elements;

public class Engine implements Item {

	public Engine(){}
	
	@Override
	public void accept(I_BuildPlan visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
		
	}
}
