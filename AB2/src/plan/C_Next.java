package plan;

public class C_Next implements Acao{
	Actionable act;
	
	public C_Next(Actionable act){
		this.act = act;
	}
	
	public void executa(){
		act.next();
		Plan.defineTime(Plan.time);
		Plan.buildPlan();
		
		
	}

}
