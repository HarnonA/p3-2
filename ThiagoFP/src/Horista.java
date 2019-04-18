

import java.util.Calendar;
import java.util.LinkedList;

public class Horista extends Empregado{

	protected String dataEntrada;
	protected float salarioHora, salarioLiquido;
	//protected LinkedList<Integer> horasDiarias = new LinkedList();
	protected int [] horasDiarias = new int[7];
	Calendar c = Calendar.getInstance();

	//CONSTRUTOR
	public Horista(long cpf, long idSind, int metodoPag, float taxaSindical,
			String nome, String endereco, boolean sindicato, int agenda, float salarioHora) {
		super(cpf, idSind, metodoPag, taxaSindical, nome, endereco, sindicato, agenda);
		super.agenda = 5;
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
		//horasDiarias.add(horas);
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
	
	public String toString(){
		String s = "";
		s = super.toString() + "\nHorista";
		return s;
	}
	
	public float calculaSalario() {
		salarioLiquido = 0;
		float deducoes;
		deducoes = super.calculaSalario();
		for (int i = 0; i < 7; i++)
			if (horasDiarias[i] <= 8.0)
				salarioLiquido += horasDiarias[i];
			else
				salarioLiquido += (((horasDiarias[i] - 8.0) * (1.5)) + 8);
		return (salarioLiquido * salarioHora) - deducoes;
	}
	
	
}
