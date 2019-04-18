package empregado;

public class Assalariado extends Empregado {

	protected float salarioFixo, salarioLiquido;
	
	//CONSTRUTOR
	public Assalariado(long cpf, long idSind, int metodoPag,
			float taxaSindical, String nome, String endere�o, boolean sindicato, float salarioFixo) {
		super(cpf, idSind, metodoPag, taxaSindical, nome, endere�o, sindicato);
		this.salarioFixo = salarioFixo;
	}

	public float getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(float salarioFixo) {
		this.salarioFixo = salarioFixo;
	}
	public float getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(float salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	
}
