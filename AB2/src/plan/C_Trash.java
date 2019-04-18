package plan;

public class C_Trash implements Acao {
	NoActionable notAct;

	public C_Trash(NoActionable notAct) {
		this.notAct = notAct;
	}

	public void executa() {
		notAct.trash();
		Plan.remove();
		Plan.buildPlan();

	}

}
