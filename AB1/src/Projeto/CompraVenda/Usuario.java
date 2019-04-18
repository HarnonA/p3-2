package Projeto.CompraVenda;

import java.util.Scanner;

public abstract class Usuario {

	private String cpf;
	private String nome;
	private String endereco;
	private String fone;
	private String senha;

	public String getName() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String toString(){
		String s = "";
		s += nome + " " + senha;
		return s;
	}

	
	

	public abstract void executa(ColleaguMediator m);

}