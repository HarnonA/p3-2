package Folhapagamento;

public class Assalariado extends Empregado {
	private double salarioMensal;
	
	public Assalariado(String name, String endereco, int tipoPagamento, double salarioMensal){
		super(name, endereco, tipoPagamento);
		this.salarioMensal = salarioMensal;
		
	}
	
	public double getSalarioMensal(){
		return salarioMensal;
	}
	
	public double getSalario(){
		return getSalarioMensal();
		
	}
	
	public String toString(){
		String result = super.toString() + " | " + getSalario();
		return result;
	}

}
