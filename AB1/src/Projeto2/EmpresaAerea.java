package Projeto2;

import java.util.ArrayList;

public class EmpresaAerea {
	
	private String nome;
	ArrayList<Aviao> lista;
	
	public EmpresaAerea(String nome){
		this.nome = nome;
		lista = new ArrayList<Aviao>();
	}
	
	public void addAviao(Aviao a){
		lista.add(a);
	}
	

}
