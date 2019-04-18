package car.visitor;

public class Body implements CarElement {

	public void print(String activity) {
		System.out.println("Body:" + activity);
	}

	@Override
	public void eccept(Visitor visitor) {
		visitor.visit(this);
	}
}
