

public class Emp_Horista extends Empregado {
	private static double precohora = 50;
	private double horasTrabalhadas[] = new double[7];
	
//========================================================	

	// construtor
	public Emp_Horista(int id, String name, String endereco, double sindicato,
			int tipoPagamento, double horasTrabalhadas[]) throws NullPointerException {

		super(id, name, endereco, sindicato, tipoPagamento);

		if (horasTrabalhadas == null)
			horasTrabalhadas = new double[7];
		else

			for (int i = 0; i < horasTrabalhadas.length; i++) {
				this.horasTrabalhadas[i] = horasTrabalhadas[i];
			}

	}
	
//========================================================
	
	public void exHora() {
		horasTrabalhadas[0] = 0;
		horasTrabalhadas[1] = 5;
		horasTrabalhadas[2] = 5;
		horasTrabalhadas[3] = 5;
		horasTrabalhadas[4] = 5;
		horasTrabalhadas[5] = 5;
		horasTrabalhadas[6] = 5;
	}
	
//========================================================	
	
	// diaSemana = { 1 = Domingo, 2 = segunda,...}
	public void setHorasTrabalhadas(double horas, int diaSemana) {
		this.horasTrabalhadas[diaSemana] = horas;

	}
	
//========================================================
	
	public String toString() {

		String result = super.toString() + " | R$ " + calcSalario();
		return result;
	}
	
//========================================================		
	
	public double calcSalario() {
		double salario = 0;
		int i;
		for (i = 0; i < 7; i++)
			if (horasTrabalhadas[i] <= 8.0)
				salario += horasTrabalhadas[i];
			else
				salario += (((horasTrabalhadas[i] - 8.0) * (1.5)) + 8);
		return (salario * precohora) - getValorSindicato();
	}

//========================================================	
	
	public void pagaHorista(int diaSemana) {

		// sexta-feira = 6
		if (diaSemana == 6) {
			System.out.println("Horista " + getNome() + " R$ " + calcSalario()
					+ stringTipoPagamento());

			// apos pago, limpa as horas
			int index;
			for (index = 0; index < 7; index++)
				horasTrabalhadas[index] = 0;
		}

	}
	
//========================================================	
	
	public double[] getHoras(){
		return horasTrabalhadas;
	}
		
//========================================================	
		
	public Emp_Horista clonar() {
		int id1 = getId();
		String nome1 = getNome();
		String end1 = getEndereco();
		double sind = getSindicato();
		int tipo = getTipoPagamento();
		double a[] = horasTrabalhadas.clone();// getHoras();
		Emp_Horista horista = new Emp_Horista(id1, nome1, end1, sind, tipo, a);

		return horista;

	}
	
//========================================================	
	
	
}