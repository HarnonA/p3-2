package Projeto.MediatorTest;

public abstract class Colleague {
	
	protected Mediator mediator;
	
	public Colleague(Mediator m) {
		mediator = m;
    }
	
	public void x(){
		System.out.println("X");
	}

}
