package empregado;

public class Empregado {
	private long cpf, idSind;
	private int metodoPag; 
	private float taxaSindical, taxaServico;
	private String nome, endere�o;
	private boolean sindicato;
	
	public Empregado(long cpf, long idSind, int metodoPag, float taxaSindical,
			String nome, String endere�o, boolean sindicato) {
		super();
		this.cpf = cpf;
		this.idSind = idSind;
		this.metodoPag = metodoPag;
		this.taxaSindical = taxaSindical;
		this.nome = nome;
		this.endere�o = endere�o;
		this.sindicato = sindicato;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
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

	
}


