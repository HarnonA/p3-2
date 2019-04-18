package plan;

import java.util.List;

import elements.Body;
import elements.BuildPlan;
import elements.DoPlan;
import elements.Engine;
import elements.Invocation;
import elements.Item;
import elements.PrintPlan;

public class Plan {

	private Actionable actionable = null;
	private NoActionable noActionable = null;
	private List<Action> actions = null;
	protected static double time = 0.005;

	public Plan(List<Action> actions) {
		this.actions = actions;
		actionable = new Actionable();
		noActionable = new NoActionable();
	}

	protected static void buildPlan() {
		BuildPlan buildPlan = new BuildPlan();

		buildPlan.accept(new DoPlan());
		buildPlan.accept(new PrintPlan());
	}

	public void execute() {

	}

	protected static void remove() {
	}

	protected static void register() {
	}

	protected static void done() {
	}

	protected static void select() {
	}

	protected static void schedule() {
	}

	protected static void defineTime(double time2) {
	}

	protected void notifyUser() {
	}

	protected static void store() {
	}

}
