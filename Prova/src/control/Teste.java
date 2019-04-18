package control;

public class Teste {

	public static void main(String[] args) {
		RemoteControl controle = new RemoteControl();
		
		controle.execute(Command.CLOSE);
		
	}
}
