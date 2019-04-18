package Mediator.ComMediator;

public class BlackBerryColleague extends Colleague {

	public BlackBerryColleague(Mediator m) {
		super(m);
	}

	@Override
	public void receberMensagem(String mensagem) {
		System.out.println("BlackBarry recebeu: " + mensagem + "\n");
	}
}
