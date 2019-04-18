package plan;

public class Fabrica {
	public Acao Fabrica(Action action) {
		
		if (action.equals(Action.DEFER))
			return new Defer();
		if (action.equals(Action.NEXT))
			return new Next();
		if (action.equals(Action.SCHEDULED))
			return new Actionable();
		if (action.equals(Action.DELEGATE))
			return new Actionable();
		if (action.equals(Action.DO))
			return new Actionable();
		if (action.equals(Action.INCUBATE))
			return new NoActionable();
		if (action.equals(Action.TRASH))
			return new NoActionable();
		return null;

	}
	

}
