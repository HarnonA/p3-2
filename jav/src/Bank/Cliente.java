package Bank;

public class Cliente {
	
	private String name;
	private int cpf;
	private String endereco;
	
	public Cliente( String name, int cpf, String endereco){
		this.name = name;
		this.cpf = cpf;
		this.endereco = endereco;
		
	}
	
	public String getName(){
		return name;
		
	}

	public int getCpf(){
		return cpf;
		
	}
	
	public String getEndereco(){
		return endereco;
		
	}
	
	public String getCliente(){
		String s = "";
		
		s += "Nome: " + getName() + "\nCpf: " + getCpf() +" | Endreco: " + getEndereco();
		return s;
	}
}
