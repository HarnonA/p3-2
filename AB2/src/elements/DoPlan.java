package elements;

public class DoPlan implements I_BuildPlan {
	
	@Override
	public void visit(BuildPlan buildPlan) {
		// TODO Auto-generated method stub
		System.out.println("Starting BuildPlan");
	}

	@Override
	public void visit(Body body) {
		// TODO Auto-generated method stub
		System.out.println("Constructing Body");
	}

	@Override
	public void visit(Engine engine) {
		// TODO Auto-generated method stub
		System.out.println("Constructing Engine");

	}

	@Override
	public void visit(Invocation invocation) {
		// TODO Auto-generated method stub
		System.out.println("Constructing Invocation");

	}

}
