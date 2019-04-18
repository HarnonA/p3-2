package machine;


public class Machine {
 
	final static int SOLD_OUT = 0;
	final static int NO_MONEY = 1;
	final static int HAS_MONEY = 2;
	final static int SOLD = 3;
 
	int state = SOLD_OUT;
	int count = 0;
  
	public Machine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_MONEY;
		}
	}
  
	public void insertMoney() {
		if (state == HAS_MONEY) {
			System.out.println("You can't insert more money");
		} else if (state == NO_MONEY) {
			state = HAS_MONEY;
			System.out.println("You inserted money");
		} else if (state == SOLD_OUT) {
			System.out.println("You can't insert money, the machine is sold out");
		} else if (state == SOLD) {
        	System.out.println("Please wait, we're already giving you a car");
		}
	}

	public void requestMoney() {
		if (state == HAS_MONEY) {
			System.out.println("Money returned");
			state = NO_MONEY;
		} else if (state == NO_MONEY) {
			System.out.println("You haven't inserted money");
		} else if (state == SOLD) {
			System.out.println("Sorry");
		} else if (state == SOLD_OUT) {
        	System.out.println("You can't, you haven't inserted money yet");
		}
	}
 

 
 
	public void requestCar() {
		if (state == SOLD) {
			System.out.println("Requesting twice doesn't get you another car!");
		} else if (state == NO_MONEY) {
			System.out.println("You requested but there's no money");
		} else if (state == SOLD_OUT) {
			System.out.println("You requested, but there are no cars");
		} else if (state == HAS_MONEY) {
			System.out.println("You requested...");
			state = SOLD;
			dispense();
		}
	}
 
	public void dispense() {
		if (state == SOLD) {
			System.out.println("A car comes rolling out");
			count = count - 1;
			if (count == 0) {
				System.out.println("Oops, out of cars!");
				state = SOLD_OUT;
			} else {
				state = NO_MONEY;
			}
		} else if (state == NO_MONEY) {
			System.out.println("You need to pay first");
		} else if (state == SOLD_OUT) {
			System.out.println("No car dispensed");
		} else if (state == HAS_MONEY) {
			System.out.println("No car dispensed");
		}
	}
 
	public void refill(int numCars) {
		this.count = numCars;
		state = NO_MONEY;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is ");
		if (state == SOLD_OUT) {
			result.append("sold out");
		} else if (state == NO_MONEY) {
			result.append("waiting for quarter");
		} else if (state == HAS_MONEY) {
			result.append("waiting for turn of crank");
		} else if (state == SOLD) {
			result.append("delivering a gumball");
		}
		result.append("\n");
		return result.toString();
	}
}


