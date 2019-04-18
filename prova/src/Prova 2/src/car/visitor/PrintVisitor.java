package car.visitor;

public class PrintVisitor implements Visitor {

	@Override
	public void visit(Body body) {
		body.print("Printing Body");		
	}

	@Override
	public void visit(Engine engine) {
		engine.print("Printing Engine");		
	}

	@Override
	public void visit(Wheel wheel) {
		wheel.print("Printing left");
	}

}
