package Bank;

public class CurrentAccountHeran extends Account {
	private double limiteCheque;
	
	public CurrentAccountHeran(Cliente cliente, int numConta, double saldo, double limiteCheque ){
		super(cliente, numConta, saldo);
		this.limiteCheque = limiteCheque;
	}
}
