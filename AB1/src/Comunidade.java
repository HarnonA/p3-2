
public class Comunidade {
	private String nome;
	private String descricao;
	private Usuario dono;
	
	public Comunidade(String nome, String descricao, Usuario usuario){
		this.nome = nome;
		this.descricao = descricao;
		this.dono = usuario;
	}
}
