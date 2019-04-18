import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Main {
	public static void main(String[] args) {
		
		
		
		//Map<Customer, Account> data = new HashMap<Customer, Account>();
		
		
		
		Map<Customer, Account> data = new HashMap<Customer, Account>();
		
		Customer customer = new Customer("Marcio", "marcio@ic.ufal.br", new Date());

		double randomNumber = Math.random();
		Account account = null;
		double balance = 2000.00;
		System.out.println(customer.toString());

		if (randomNumber < 0.5) {
			account = new StandardAccount(customer, balance);
		} else {
			double limit = 0.2;
			account = new CreditCardAccount(customer, balance, limit);
		}
		
		account.deposit(1000);
		
		
		
		
		
		
		
	}
}
