package car.visitor;

public class ConstructVisitor implements Visitor {

	@Override
	public void visit(Body body) {
		body.print("Constructing Body");		
		
	}

	@Override
	public void visit(Engine engine) {
		engine.print("Constructing Engine");		
		
	}

	@Override
	public void visit(Wheel wheel) {
		wheel.print("Constructing left");		
	}

}
