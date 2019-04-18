import java.util.Calendar;
import java.util.GregorianCalendar;

public class Emp_Assalariado extends Empregado {
	private double salarioMensal;
	
//========================================================
	
	// construtor
	public Emp_Assalariado(int id, String name, String endereco,
			double sindicato, int tipoPagamento, double salarioMensal) throws NullPointerException {
		super(id, name, endereco, sindicato, tipoPagamento);
		this.salarioMensal = salarioMensal;

	}
	
//========================================================
	
	public String toString() {
		String result = super.toString() + " | R$ " + calcSalario();
		return result;
	}
	
//========================================================	
	
	public double calcSalario() {
		return salarioMensal - getValorSindicato();
	}
	
//========================================================		
	
	public void pagaAssalariado(int mes, int dia) {
		
		// mes com 31 dias
		if (mes == 0 || mes == 2 || mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11) {
			if (dia == 31)
				System.out.println("Assalariado " + getNome() + " R$ "
						+ calcSalario() + stringTipoPagamento());
		}

		// mes com 30 dias
		else if (mes == 3 || mes == 5 || mes == 8 || mes == 10) {
			if (dia == 30)
				System.out.println("Assalariado " + getNome() + " R$ "
						+ calcSalario() + stringTipoPagamento());
		}

		// fevereiro
		else {
			// booleano de mes bissexto
			if (new GregorianCalendar().isLeapYear(Calendar.DAY_OF_YEAR)) {
				if (dia == 28)
					System.out.println("Assalariado " + getNome() + " R$ "
							+ calcSalario() + stringTipoPagamento());
			} else if (dia == 29)
				System.out.println("Assalariado " + getNome() + " R$ "
						+ calcSalario() + stringTipoPagamento());
		}

	}
	
//========================================================
	
	public double getSalarioMensal(){
		return salarioMensal;
	}
	
//========================================================
	
	public Emp_Assalariado clonar() {
		int id1 = this.getId();
		String nome1 = this.getNome();
		String endereco1 = this.getEndereco();
		double valorSindicato1 = this.getSindicato();
		int tipoPagamento1 = this.getTipoPagamento();
		double salarioMensal1 = this.salarioMensal;

		Emp_Assalariado emp = new Emp_Assalariado(id1, nome1, endereco1,
				valorSindicato1, tipoPagamento1, salarioMensal1);

		return emp;

	}
	
//========================================================	
	
}