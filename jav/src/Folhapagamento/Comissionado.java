package Folhapagamento;

public class Comissionado extends Assalariado{
	private double salarioMensal;
	private double comissao;
	private double totalVendas;
	
	public Comissionado(String name, String endereco, int tipoPagamento, double salarioMensal, double comissao){
		super(name, endereco, tipoPagamento, salarioMensal);
		this.comissao = comissao;
		this.totalVendas = 0;
		
	}
	
	public double getSalarioQuinzenal(){
		return super.getSalarioMensal() * 0.5;
	}
	
	
	public double getSalario(){
		double retorna = (getSalarioQuinzenal() + getComissao());
		zeraVendas();
		return retorna;
	}
	
	public double getComissao(){
		return totalVendas * comissao;
		
	}
	
	
	public double vendaEfetivada(int valorVenda){
		this.totalVendas = totalVendas + valorVenda;
		return totalVendas;
	}
	
	public void zeraVendas(){
		totalVendas = 0;
		
	}
	
	public String toString(){
		String result = super.toString();
		result += " | " + comissao;
		return result;
		
	}
	

}
