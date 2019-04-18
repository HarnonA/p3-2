

public class Assalariado extends Empregado {
	
	private float salarioMes;
		
	public Assalariado(int cod, String name, String end, 
			boolean sind, float taxaSind, int pagamento, float salM){
		super(cod, name, end, sind, taxaSind, pagamento);
		this.salarioMes = salM;		
	}
	
	public float getSalarioMes() {
		return salarioMes;
	}

	public void setSalarioMes(int salarioMes) {
		this.salarioMes = salarioMes;
	}
}	
