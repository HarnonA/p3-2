package Bank;

public class CurrentAccount {
	
	private Cliente cliente;
	private int numConta;
	private double saldo;
	private double limiteCheque;
	
	public CurrentAccount(Cliente cliente, int numConta, double saldo, double limiteCheque ){
		this.cliente = cliente;
		this.numConta = numConta;
		this.saldo = saldo;
		this.limiteCheque = limiteCheque;
		
	}
	
	
	public int getNumConta(){
		return numConta;
		
	}
	
	public double getSaldo(){
		return saldo;
		
	}

	public double getLimiteCheque(){
		return limiteCheque;
		
	}
	
	public String getConta(){
	String s = "";
	
	s += cliente.getCliente() + "\nConta nº: " + getNumConta() +"\nSaldo: $ " + getSaldo() +"\nLimite cheque: $ " +
			"" + getLimiteCheque();
	return s;
	}
	
	
}
