package Mediator.ComMediator;

public class Main {
	
	public static void main(String[] args) {
	    MensagemMediator mediador = new MensagemMediator();
	 
	    AndroidColleague android = new AndroidColleague(mediador);
	    IOSColleague ios = new IOSColleague(mediador);
	    SymbianColleague symbian = new SymbianColleague(mediador);
	    BlackBerryColleague blackbarry = new BlackBerryColleague(mediador);
	 
	    mediador.adicionarColleague(android);
	    mediador.adicionarColleague(ios);
	    mediador.adicionarColleague(symbian);
	    mediador.adicionarColleague(blackbarry);
	     
	    symbian.enviarMensagem("Oi, eu sou um Symbian!");
	    System.out.println("=========");
	    android.enviarMensagem("Oi Symbian! Eu sou um Android!");
	    System.out.println("=========");
	    ios.enviarMensagem("Olá todos, sou um iOs!");
	}

}
