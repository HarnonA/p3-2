
public class Account extends InternetPayable {
	private Customer customer;
	protected double balance;
	
	public Account(Customer customer, double balance){
		this.customer = customer;
		this.balance = balance;
			
	}
	
	public void deposit(double value){
		balance +=value;
		
	}
	
	public void withdraw(double value){
		if(balance >= value)
			balance -= value;
	}
	public double getBalance(){
		return balance;
	}
	
	

}
