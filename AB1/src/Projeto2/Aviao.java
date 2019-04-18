package Projeto2;

public class Aviao {
	
	private int colunas;
	private int filas;
	private String tipo;
	private String destino;
	private boolean[][] assentos;
	
	public Aviao(int poltronas, int filas, String tipo, String destino){
		this.colunas = poltronas;
		this.filas = filas;
		this.destino = destino;
		this.tipo = tipo;
		this.assentos = new boolean[colunas][filas]; 
	}
	
	public void destino(String partida, String chegada){
		destino = partida + " para " + chegada;
	}

	
	public String toString(){
		String s = "";
		s += "Modelo: " + tipo + " Assentos: " + colunas*filas + " " + destino +"\n";
		return s;
		
	}
	

}
