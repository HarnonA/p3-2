package Projeto.X;

import java.util.LinkedList;

public abstract class Colleague{
	
	private Mediator mediator;
	private String nome;
	private LinkedList<Aviao> aviao;
	private int id;
	
	
	public Colleague(Mediator newMediator, String nome){ 
		mediator = newMediator; 
		this.nome = nome;
		aviao = new LinkedList<Aviao>();
		
		mediator.addColleague(this);
	
	}
	
	public void oferecerVoo(String nomeEmpresa, Aviao a, String o, String d){
		mediator.oferecerVoo(nome, a, o, d);
		//aviao.add(a);
		
	}
	
	public void retirarVoo(Aviao aviao){
		mediator.retirarVoo(aviao);
		
	}

	public void setId(int collCode) {
		id = collCode;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void mostrar(){
		System.out.println(nome);
		for(int i = 0 ; i < aviao.size() ; i++){
			Aviao a = aviao.get(i);
			System.out.println(a.toString());
		}
	}
	
	public void addFrota(Aviao a){
		aviao.add(a);
	}
	
	public String toString(){
		return nome;
	}
	/*
	public void marcarViajem(int nSerie, String origem, String destino){
		Aviao a = null;
		for(int i = 0 ; i < aviao.size() ; i++){
			a = aviao.get(i);
			if( a.getNSerie() == nSerie )
				a.marcarViajem(origem, destino);
			
		}
		
	}
	*/
	
	
	
}
