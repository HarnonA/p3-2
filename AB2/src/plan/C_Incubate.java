package plan;

public class C_Incubate implements Acao {
	NoActionable notAct;

	public C_Incubate(NoActionable notAct) {
		this.notAct = notAct;
	}

	public void executa() {
		notAct.incubate();
		Plan.store();
		Plan.register();
		Plan.buildPlan();

	}

}
