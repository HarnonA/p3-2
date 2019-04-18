
public class Empregado implements Cloneable {
	private int id;
	private String nome;
	private String endereco;
	protected double valorSindicato;
	private int tipoPagamento;

	private static double taxaMensalSindicato = 100;

	//====================================
	
	public Empregado(int id, String nome, String endereco,
			double valorSindicato, int tipoPagamento) {

		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.tipoPagamento = tipoPagamento;
		this.valorSindicato = valorSindicato;

		/*
		 * tipoPagamento: 
		 * 0 - horas trabalhadas 
		 * 1 - salario mensal 
		 * 2 - comissionado
		 */
	}
	
	// ====================================

	public void alterarNome(String novoNome) {
		this.nome = novoNome;
	}

	// ====================================

	public void alterarEndereco(String novoEndereco) {
		this.endereco = novoEndereco;
	}

	// ====================================

	public void alterarMetodoPagamento(int metodo) {
		this.tipoPagamento = metodo;
	}

	// ====================================

	public String getNome() {
		return nome;
	}

	// ====================================

	public String getEndereco() {
		return endereco;
	}

	// ====================================

	public int getId() {
		return id;
	}

	// ====================================

	public double getSindicato() {
		return valorSindicato;

	}

	// ====================================

	public int getTipoPagamento() {
		return tipoPagamento;
	}
	
//====================================
	
	public void mudaSindicato() {
		if (valorSindicato == 0)
			valorSindicato = taxaMensalSindicato;
		else {
			valorSindicato = 0;
		}
		System.out.println("Novo valor: "+valorSindicato);

	}
	
//====================================
	
	public String stringTipoPagamento() {
		if (tipoPagamento == 0)
			return " Cheque Correios";
		else if (tipoPagamento == 1)
			return " Cheque em Maos";
		else
			return " Deposito em conta";

	}
	
//====================================

	public String toString() {
		String result = "#00" + id + " " + nome + " | " + endereco + " | "
				+ stringTipoPagamento();
		return result;

	}
	
//====================================	
	
	public void addServico( double valorServico ){
		valorSindicato += valorServico;
	
	}
	
//====================================
	
	public void mudaTipoPagamento(int tipo) {
		if (tipo >= 0 && tipo <= 2)
			this.tipoPagamento = tipo;
		else {
			System.out.println("Valor invalido");
		}

	}
	
//====================================
	
	Empregado getClone() {
		try {
			// call clone in Object.
			return (Empregado) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(" Cloning not allowed. ");
			return this;
		}
	}
	
//====================================
	
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(" Cloning not allowed. ");
			return this;
		}
	}
	
//====================================
	
	public Empregado clonar() {
		int id1 = this.id;
		String nome1 = this.nome;
		String endereco1 = this.endereco;
		double valorSindicato1 = this.valorSindicato;
		int tipoPagamento1 = this.tipoPagamento;

		Empregado emp = new Empregado(id1, nome1, endereco1, valorSindicato1,
				tipoPagamento1);
		return emp;

	}
	
//====================================
	
	public double getValorSindicato(){
		return valorSindicato;
	}
	
//====================================
	

}
