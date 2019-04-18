package plan;

public class C_Scheduled implements Acao{
	Actionable act;
	
	public C_Scheduled(Actionable act){
		this.act = act;
	}
	
	public void executa(){
		act.schedule();
		Plan.schedule();
		Plan.store();
		Plan.buildPlan();
		
		
	}

}
