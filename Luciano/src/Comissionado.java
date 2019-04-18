

public class Comissionado extends Empregado {

	private float salarioVaria;
	private float comissao;
	
	public Comissionado(int cod, String name, String end, 
			boolean sind, float taxaSind, int tipoPag, float salVa, float comissao){
		super(cod, name, end, sind, taxaSind, tipoPag);
		this.salarioVaria = salVa;	
		this.comissao = comissao;
	}
	
	public void setComissao(int SalVa) {
		salarioVaria = SalVa;		
	}
	
	public float getSalarioVaria(){
		return salarioVaria;
	}

}
