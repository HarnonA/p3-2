package empregado;

import java.util.Calendar;

public class Horista extends Empregado{

	private final int semana = 7;
	protected String dataEntrada;
	protected float salarioHora, salarioLiquido;
	
	protected int [] horasDiarias = new int[semana];
	Calendar c = Calendar.getInstance();

	//CONSTRUTOR
	public Horista(long cpf, long idSind, int metodoPag, float taxaSindical,
			String nome, String endereço, boolean sindicato, float salarioHora) {
		super(cpf, idSind, metodoPag, taxaSindical, nome, endereço, sindicato);
		this.salarioHora = salarioHora;
	}

	public float getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(float salarioHora) {
		this.salarioHora = salarioHora;
	}

	public int getHorasDiarias(int i) {
		return horasDiarias[i];
	}

	public void setHorasDiarias(int horas) {
		this.horasDiarias[c.get(Calendar.DAY_OF_WEEK)-1] = horas;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public float getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(float salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	
}
