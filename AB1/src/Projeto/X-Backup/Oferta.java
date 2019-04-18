package Projeto.X;

import java.util.ArrayList;

public class Oferta{
	
	private ArrayList<Aviao> disponiveis;
	private int colleagueID = 0;
	private String nome;
	private Aviao aviao;
	
	public Oferta(String nome, Aviao aviao, int id){
		
		this.nome = nome;
		this.aviao = aviao;
		colleagueID = id;

		
	}
	
	public int getCollCode() { return colleagueID; }
	public void addVoo(Aviao a){
		disponiveis.add(a);
	}
	
	public Aviao getAviao(){
		return aviao;
	}
	
	public String toString(){
		String s = "";
		s += "#" + colleagueID + " " + nome + " | " + aviao.toString(); 
		return s;
	}
	
	
}
