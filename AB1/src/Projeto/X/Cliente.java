package Projeto.X;

public class Cliente {
	private String cpf;
	private String nome;
	private String endereco;
	private String fone;
	private String senha;
	
	public Cliente(){
		
	}
	
	public Cliente(String cpf, String nome, String endereco, String fone, String senha){
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.fone = fone;
		this.senha = senha;
	}
	

	
	public String toString(){
		String s = "";
		s += cpf + " " + nome+ " " + fone;
		return s;
	}
	
	public boolean comparar(String n, String s){
		if(nome.equals(n) && senha.equals(s))
			return true;
		return false;
	}

}
