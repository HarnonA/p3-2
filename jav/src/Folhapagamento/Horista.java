package Folhapagamento;

public class Horista extends Empregado {
	
	private double horasTrabalhadas;
	
	public Horista(String name, String endereco, int tipoPagamento, float horasTrabalhadas){
		super(name, endereco, tipoPagamento);
		this.horasTrabalhadas = horasTrabalhadas;
		
	}
	
	public double getHorasTrab(){
		return horasTrabalhadas;
	}
		
	public double porra(){
		return horasTrabalhadas;
	}
	
	public double getSalarioHoras(){
		double salarioHora = 12.5;
		double horasTotais = getHoraTotal();
		return (horasTotais * salarioHora);
		
	}
	
	public void setHorasTrabalhadas(int h){
		horasTrabalhadas = h;
		
	}
	
	public double getHoraTotal(){
		double salario = horasTrabalhadas % 8;//8horas semanais
		return horasTrabalhadas - salario + (salario*1.5) ;
	}
	
	public double getSalario(){
		return getSalarioHoras();
	}

	

	public String toString(){
		String result = super.toString() + " | " + getSalario();
		return result;
		
	}

}
