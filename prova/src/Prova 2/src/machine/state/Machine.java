package machine.state;


public class Machine {
	
	State soudOut = new SoldOutState();
	State sold = new SoldState();
	State hasMoney = new HasMoneyState();
	State noMoney = new NoMoneyState();
	State state = soudOut;

	int count = 0;
  
	public Machine(int count) {
		this.count = count;
		if (count > 0) {
			state = noMoney;
		}
	}
	public void insertMoney() {
			state.insertMoney();
	}

	public void requestMoney() {
			state.requestMoney();
	}

	public void requestCar() {
			state.requestCar();
	}
 
	public void dispense() {
			state.dispense();
	}
 
	public void refill(int numCars) {
		this.count = numCars;
		state = noMoney;
	}
	
	public void setState(State state){
		this.state = state; 
	}
	public int getCount(){
		return count;
	}
	public void setCount(int valor){
		count = valor;
	}
}


