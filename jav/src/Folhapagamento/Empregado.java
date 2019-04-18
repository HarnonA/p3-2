package Folhapagamento;

public class Empregado {
	private String name;
	private String endereco;
	private int tipoPagamento;
	

	
	public Empregado(String name, String endereco, int tipoPagamento){
		this.name = name;
		this.endereco = endereco;
		this.tipoPagamento = tipoPagamento;
	}
	
	public String getName(){
		return name;
	}
	
	public String getEndereco(){
		return endereco;
	}
	
	public String getTipoPagamento(){
		if( tipoPagamento == 0) return "Cheque Correios";
		else if( tipoPagamento == 1) return "Cheque em Maos";
		else return "Deposito em conta";
		
	}
	
	public double getSalario();
	
	public String toString(){
		String result = name + " | " + endereco + " | " + getTipoPagamento();
		return result;
		
	}

}
