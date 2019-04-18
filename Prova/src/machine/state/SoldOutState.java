package machine.state;

public class SoldOutState implements State{

	@Override
	public void insertMoney() {
		System.out.println("You can't insert money, the machine is sold out");		
	}

	@Override
	public void requestMoney() {
    	System.out.println("You can't, you haven't inserted money yet");
		
	}

	@Override
	public void requestCar() {
		System.out.println("You requested, but there are no cars");
		
	}

	@Override
	public void dispense() {
		System.out.println("No car dispensed");
		
	}

}
