package planning;

import java.util.ArrayList;
import java.util.List;

import plan.Action;
import plan.Plan;
import configuration.Configuration;

public class Online extends Planning {

	private Plan plan = null;
	
	public Online(Configuration configuration) {
		super(configuration);
		
		List<Action> actions = new ArrayList<Action>();
		actions.add(Action.DEFER);
		actions.add(Action.NEXT);
		actions.add(Action.SCHEDULED);
		actions.add(Action.DELEGATE);
		actions.add(Action.DO);
		
		this.plan = new Plan(actions);
	}

	private void initializePlanning(){
		System.out.println("Initialize Planning");
		evaluateOnlinePlan();
		estimateTime();
	}

	private void estimateTime() {
	}

	private void evaluateOnlinePlan() {
	}
	
	public void playOnlinePlanning(){
		System.out.println("Play Online Planning");
		
		initializePlanning();
		this.plan.execute();
		
	}
}
