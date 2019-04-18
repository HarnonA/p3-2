package empregado;

public class Comissionado extends Empregado{

	protected float comissao, salarioFixo, salarioLiquido;
	protected float vendas;

	public Comissionado(long cpf, long idSind, int metodoPag,
			float taxaSindical, String nome, String endereço, boolean sindicato, float salarioFixo, float comissao) {
		super(cpf, idSind, metodoPag, taxaSindical, nome, endereço, sindicato);
		this.salarioFixo = salarioFixo;
		this.comissao = comissao;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	public float getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(float salarioFixo) {
		this.salarioFixo = salarioFixo;
	}
	
	public float getVendas() {
		return vendas;
	}

	public void setVendas(float vendas) {
		this.vendas = vendas;
	}
	
	public float getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(float salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	
}
