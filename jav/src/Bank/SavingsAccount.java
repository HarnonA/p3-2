package Bank;

public class SavingsAccount {
	
	private Cliente cliente;
	private int numConta;
	private double saldo;
	private double juros;
	
	public SavingsAccount(Cliente cliente, int numConta, double saldo, double juros ){
		this.cliente = cliente;
		this.numConta = numConta;
		this.saldo = saldo;
		this.juros = juros;
		
	}
	
	
	public int getNumConta(){
		return numConta;
		
	}
	
	public double getSaldo(){
		return saldo;
		
	}

	public double getJuros(){
		return juros;
		
	}
	
	public String getConta(){
	String s = "";
	
	s += cliente.getCliente() + "\nConta nº: " + getNumConta() +"\nSaldo: $ " + getSaldo() +"\nLimite cheque: $ " +
			"" + getJuros();
	return s;
	}
	

}
