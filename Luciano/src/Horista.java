

public class Horista extends Empregado{
	
	private int qntHorasTrabalhadas;
	private float valorDaHora;
	private float aReceber;
	
	public Horista(int cod, String name, String end, boolean sind, 
			float taxaSind, int tipo, int qntHoras, float valorHora ) {
		super(cod, name, end, sind, taxaSind, tipo);
		this.setQntHorasTrabalhadas(qntHoras);
		this.setValorDaHora(valorHora);;
		this.setaReceber(CalculaSalario(qntHoras, valorHora));
	}
	
	public float CalculaSalario(int horas, float valor){
		return (horas*valor);
	}

	public float getValorDaHora() {
		return valorDaHora;
	}
	
	public int getQntHorasTrabalhadas() {
		return qntHorasTrabalhadas;
	}

	public float getaReceber() {
		return aReceber;
	}
	
	public void setValorDaHora(float valorDaHora) {
		this.valorDaHora = valorDaHora;
	}

	public void setQntHorasTrabalhadas(int qntHoras) {
		this.qntHorasTrabalhadas = qntHoras;
	}
	
	public void setaReceber(float aReceber) {
		this.aReceber = aReceber;
	}
	
}
