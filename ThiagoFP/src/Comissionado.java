import java.util.ArrayList;
import java.util.LinkedList;



public class Comissionado extends Empregado{

	protected float comissao, salarioFixo, salarioLiquido;
	//protected float vendas;
	private LinkedList<Float> vendas;
	private LinkedList<String> datas;

	public Comissionado(long cpf, long idSind, int metodoPag,
			float taxaSindical, String nome, String endereco, boolean sindicato, int agenda, float salarioFixo, float comissao) {
		super(cpf, idSind, metodoPag, taxaSindical, nome, endereco, sindicato, agenda);
		super.agenda = 6;
		this.salarioFixo = salarioFixo;
		this.comissao = comissao;
		this.vendas = new LinkedList<Float>();
		this.datas = new LinkedList<String>();
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
		float soma = 0;
		for(int i = 0; i < vendas.size() ; i++)
			soma += vendas.get(i);
		return soma;
	}

	public void setVendas(float venda) {
		vendas.add(venda);
		//this.vendas = vendas;
	}
	
	public float getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(float salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	
	public String toString(){
		String s = "";
		s = super.toString() + "\nComissionado ";
		return s;
	}
	
	public float paga(){
		return (salarioLiquido);
		
	}
	public float calculaSalario() {
		float deducoes;
		deducoes = super.calculaSalario();
		float x = 0;
		
		salarioLiquido = salarioFixo+(getVendas() * (comissao / 100)) - deducoes;
		if(agenda == 1)
			x =  salarioLiquido;
		else if(agenda == 2)
			x =  salarioLiquido;
		else if(agenda == 3)
			x =  salarioLiquido;
		else if(agenda == 4)
			x =  (salarioLiquido/4);
		else if(agenda == 5)
			x =  salarioLiquido/4;
		else if(agenda == 6)
			x =  salarioLiquido/2;
		
		
		
		return x;
	}
	
	
}
