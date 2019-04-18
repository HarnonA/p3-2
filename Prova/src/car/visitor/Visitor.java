package car.visitor;

public interface Visitor {
	public void visit(Body body);
	public void visit(Engine engine);
	public void visit(Wheel wheel);

}
