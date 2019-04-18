package car.visitor;

public class Engine implements CarElement {


	public void print(String activity) {
		System.out.println("Engine: "+activity);
	}

	@Override
	public void eccept(Visitor visitor) {
		visitor.visit(this);
	}
}
