package plan;

public class C_Delegate implements Acao{
	Actionable act;
	
	public C_Delegate(Actionable act){
		this.act = act;
	}
	
	public void executa(){
		act.delegate();
		Plan.select();
		Plan.store();
		Plan.buildPlan();
		
		
	}

}
