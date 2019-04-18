package control.command;

public class Teste {
public static void main(String[] args) {
	
	Command comando = new OpenCommand();
	RemoteControl controle = new RemoteControl();
	controle.execute(comando);
}
}
