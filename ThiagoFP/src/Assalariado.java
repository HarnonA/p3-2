
public class Assalariado extends Empregado {

	protected float salarioFixo, salarioLiquido;
	
	//CONSTRUTOR
	public Assalariado(long cpf, long idSind, int metodoPag,
			float taxaSindical, String nome, String endereco, boolean sindicato, int agenda, float salarioFixo) {
		super(cpf, idSind, metodoPag, taxaSindical, nome, endereco, sindicato, agenda);
		super.agenda = 3;
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
	
	public String toString(){
		String s = "";
		s = super.toString() + "\nAssalariado";
		return s;
	}
	public float paga(){
		return (salarioLiquido);
		
	}
	public float calculaSalario() {
		float deducoes;
		deducoes = super.calculaSalario();
		salarioLiquido = salarioFixo - deducoes;
		if(agenda == 1)
			return salarioLiquido;
		else if(agenda == 2)
			return salarioLiquido;
		else if(agenda == 3)
			return salarioLiquido;
		else if(agenda == 4)
			return (salarioLiquido/4);
		else if(agenda == 5)
			return salarioLiquido/4;
		else if(agenda == 6)
			return salarioLiquido/2;
		
		
		return salarioLiquido;
	}
	
	
}
