package machine.state;

public class HasMoneyState implements State {

	//State hasManey = new HasMoneyState();
	Machine machine = new Machine(0);
	
	@Override
	public void insertMoney() {
		System.out.println("You can't insert more money");		
	}

	@Override
	public void requestMoney() {
		System.out.println("Money returned");
		machine.setState(new NoMoneyState());	
	}

	@Override
	public void requestCar() {
		System.out.println("You requested...");
		machine.setState(new SoldState());
		dispense();		
	}

	@Override
	public void dispense() {
		System.out.println("No car dispensed");
		
	}

}
