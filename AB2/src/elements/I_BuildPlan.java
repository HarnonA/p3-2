package elements;

public interface I_BuildPlan {

	void visit(BuildPlan buildPlan);

	void visit(Body body);

	void visit(Engine engine);

	void visit(Invocation invocation);

}
