package plan;

public class C_Defer implements Acao{
	Actionable act;
	
	public C_Defer(Actionable act){
		this.act = act;
	}
	
	public void executa(){
		act.defer();
		Plan.store();
		Plan.buildPlan();
		
		
	}

}
