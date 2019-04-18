package Bank;

public class Account {
	private Cliente cliente;
	private int numConta;
	private double saldo;
	
	public Account(Cliente cliente, int numConta, double saldo ){
		this.cliente = cliente;
		this.numConta = numConta;
		this.saldo = saldo;
		
	}
	
	
	public int getNumConta(){
		return numConta;
		
	}
	
	public double getSaldo(){
		return saldo;
		
	}

	
	public String getConta(){
	String s = "";
	
	s += cliente.getCliente() + "\nConta nº: " + getNumConta() +"\nSaldo: $ " + getSaldo();
	return s;
	}
	
	
}
