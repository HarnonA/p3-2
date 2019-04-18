package Bank;

public class Main {
	
	public static void main(String[] args) {
		Bank banco = new Bank(1,"do Brasil");
		
		Cliente cliente = new Cliente("Harnon", 013131, "rua tal");
		Account conta = new CurrentAccountHeran(cliente, 10, 100.1, 500.0);
		System.out.println( conta.getConta() );
		
		
	}

}
