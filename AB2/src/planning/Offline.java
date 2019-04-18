package planning;

import java.util.ArrayList;
import java.util.List;

import plan.Action;
import plan.Plan;
import configuration.Configuration;

public class Offline extends Planning {
	
	private Plan plan = null;

	public Offline(Configuration configuration) {
		super(configuration);
		
		List<Action> actions = new ArrayList<Action>();
		actions.add(Action.INCUBATE);
		actions.add(Action.TRASH);
		
		this.plan = new Plan(actions);
	}

	private void initializePlannin(){
		System.out.println("Initialize Planning");
		createOfflinePlan();
		verifyPlan();
	}

	private void verifyPlan() {
	}

	private void createOfflinePlan() {
	}
	
	public void playOfflinePlanning(){
		System.out.println("Play Offline Planning");
		initializePlannin();
		this.plan.execute();
		
	}
}
