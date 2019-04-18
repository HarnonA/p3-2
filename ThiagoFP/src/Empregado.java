

public class Empregado {
	private long cpf, idSind;
	private int metodoPag; 
	private float taxaSindical, taxaServico;
	private String nome, endereco;
	private boolean sindicato;
	protected int agenda;
	private float impostos = 100;
	
	
	
	public Empregado(long cpf, long idSind, int metodoPag, float taxaSindical,
			String nome, String endereco, boolean sindicato, int agenda) {
		this.cpf = cpf;
		this.idSind = idSind;
		this.metodoPag = metodoPag;
		this.taxaSindical = taxaSindical;
		this.nome = nome;
		this.endereco = endereco;
		this.sindicato = sindicato;
		this.agenda = agenda;
	}


	//GETS E SETS
	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getIdSind() {
		return idSind;
	}

	public void setIdSind(long idSind) {
		this.idSind = idSind;
	}

	public int getMetodoPag() {
		return metodoPag;
	}

	public void setMetodoPag(int metodoPag) {
		this.metodoPag = metodoPag;
	}

	public float getTaxaSindical() {
		return taxaSindical;
	}

	public void setTaxaSindical(float taxaSindical) {
		this.taxaSindical = taxaSindical;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome1) {
		this.nome = nome1;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isSindicato() {
		return sindicato;
	}

	public void setSindicato(boolean sindicato) {
		this.sindicato = sindicato;
	}


	public float getTaxaServico() {
		return taxaServico;
	}


	public void setTaxaServico(float taxaServico) {
		this.taxaServico = taxaServico;
	}
	
	public String metodoPagString(int i) {
		String s = "";
		if (i == 1) {
			s = "Recebe cheque pelos correios.";
		} else if (i == 2) {
			s = "Recebe cheque em maos.";
		} else
			s = "Deposito em conta bancaria.";
		return s;
	}
	
	public String sindicatoString(){
		String s = "";
		if (sindicato == true) {
			s = "Empregado pertence ao sindicato.";
			s += "  Id do sindicato: " + idSind;
			s += "  Taxa sindical: " + taxaSindical;
		} else
			s = "Empregado nao pertence ao sindicato";
		return s;
	}
	
	
	public String toString(){
		String result = "";
		result = "Id #0" + cpf + " Nome: " + nome + "\nEndereco: " + endereco +
				"\nMetodo de pagamento: " + metodoPagString(metodoPag) + "\n" + 
				sindicatoString() + "\nSalario R$ " + calculaSalario();
		return result;
	}
	
	public float getValorGasto(){
		return (taxaSindical+taxaServico);
	}
	
	public void setAgenda(int a){
		this.agenda = a;
	}
	
	public int getAgenda(){
		return agenda;
	}
	
	public boolean getSindicato(){
		return sindicato;
	}
	
	public float calculaSalario() {
		float deducoes;
		deducoes = impostos + taxaSindical + taxaServico;
		return deducoes;

	}
	
	public void calcDespesa(){
		System.out.println("X");
	}
	
	
	
}


