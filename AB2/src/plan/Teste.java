package plan;

import java.util.LinkedList;
import java.util.List;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Action> list = new LinkedList<Action>(); 
		list.add(Action.TRASH);
		Plan plan = new Plan(list);
		plan.buildPlan();
		//plan.execute();

	}

}
