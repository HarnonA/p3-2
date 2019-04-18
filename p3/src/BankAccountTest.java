
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class BankAccountTest {

	public void testStore001() throws NoSufficientBalanceException {

		Map<Customer, Account> data = new HashMap<Customer, Account>();

		Customer customer = new Customer("Marcio", "marcio@ic.ufal.br",
				new Date());

		double randomNumber = Math.random();
		Account account = null;
		double balance = 2000.00;

		if (randomNumber < 0.5) {
			account = new StandardAccount(customer, balance);
		} else {
			double limit = 0.2;
			account = new CreditCardAccount(customer, balance, limit);
		}

		// Toda conta  obrigada a implementar os mtodos deposit e withdraw
		account.deposit(1000);

		try {
			// Para StandardAccount, implemente o mtodo withdraw (sacar)
			// normalmente
			// Para CreditCardAccount, implemente o mtodo com um limite
			// adicional para o saque
			account.withdraw(500);
		} catch (NoSufficientBalanceException e) {
			throw e;
		}

		InternetPayable internetPayable = account;
		try {
			// No  preciso implementar o corpo de pay
			internetPayable.pay(300);
		} catch (NoSufficientBalanceException e) {
			throw e;
		}

		// Imprima as informaes da conta
		System.out.println(account.toString());

		// Insere os dados na hash
		// Imagine que isso seria armazenado em algum arquivo ou banco de
		// dados...
		data.put(customer, account);

		Account accountFound = data.get(customer);

		// No precisa implementar o assertEquals
		assertEquals("Marcio", customer.getName());
		assertEquals("marcio@ic.ufal.br", customer.getEmail());
		assertEquals(2200, accountFound.getBalance());
	}

	private void assertEquals(int i, double balance) {
		// TODO Auto-generated method stub

	}

	private void assertEquals(String string, String name) {
		// TODO Auto-generated method stub

	}

}

