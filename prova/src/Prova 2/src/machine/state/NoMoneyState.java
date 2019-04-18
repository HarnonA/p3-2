package machine.state;

public class NoMoneyState implements State{

	Machine machine = new Machine(0);
	@Override
	public void insertMoney() {
		machine.setState(new HasMoneyState());
		System.out.println("You inserted money");		
	}

	@Override
	public void requestMoney() {
		System.out.println("You haven't inserted money");		
	}

	@Override
	public void requestCar() {
		System.out.println("You requested but there's no money");		
	}

	@Override
	public void dispense() {
		System.out.println("You need to pay first");
		
	}

}
