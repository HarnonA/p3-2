package machine.state;

public class SoldState implements State{

	Machine machine = new Machine(0);
	
	@Override
	public void insertMoney() {
		System.out.println("Please wait, we're already giving you a car");		
	}

	@Override
	public void requestMoney() {
		System.out.println("Sorry");
		
	}

	@Override
	public void requestCar() {
		System.out.println("Requesting twice doesn't get you another car!");		
	}

	@Override
	public void dispense() {
		System.out.println("A car comes rolling out");
		int count = machine.getCount() - 1;
		machine.setCount(count);
		
		if (machine.getCount() == 0) {
			System.out.println("Oops, out of cars!");
			machine.setState(new SoldOutState());

		} else {
			machine.setState(new NoMoneyState());
		}		
	}

}
