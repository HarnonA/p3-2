
public class CreditCardAccount extends Account{
	private double limit;
	private double credit;

	public CreditCardAccount(Customer customer, double balance,double limit) {	
		super(customer, balance);
		this.limit = limit;
		// TODO Auto-generated constructor stub
	}
	
	public void withdraw(double value){
		if( balance >=  ( balance * credit) )
			balance =  ( balance * credit)  ;
	}

}
