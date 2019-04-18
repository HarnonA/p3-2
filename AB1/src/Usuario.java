
import java.util.LinkedList;



public class Usuario {
	private String nome;
	private String senha;
	private String login;
	private LinkedList<Comunidade> comunidade;
	private LinkedList alteracoes;
	
	
	public Usuario(String nome, String senha, String login){
		this.nome = nome;
		this.senha = senha;
		this.login = login;
		this.comunidade = new LinkedList<Comunidade>();
		this.alteracoes = new LinkedList();
	}
	
	public void setNome(String nome){
		this.nome = nome;
		
	}
	public void setSenha(String senha){
		this.senha = senha;
		
	}
	public void setLogin(String login){
		this.login = login;
		
	}
	public String getLogin(){
		return login;
	}
	public String getNome(){
		return nome;
	}
	public String getSenha(){
		return senha;
	}
	public void addComunidade(Comunidade comu){
		comunidade.addFirst(comu);
	}
	

	

	

}
