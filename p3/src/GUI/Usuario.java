package GUI;

public class Usuario {

	String senha;
	String nome;
	
	public Usuario(String nome, String senha){
		this.senha = senha;
		this.nome = nome;
		
	}
	
	public String getNome(){
		return senha;
	}
	public String getSenha(){
		return nome;
	}
	public String toString(){
		String s = (nome + " " + senha);
		return s;
	}

}
