package Projeto;

public class Aviao implements PrototipoAviao {
	
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

	@Override
	public Aviao prototipo() {
		Aviao a = null;
		try {
			a = (Aviao) super.clone();
			
		}		
		catch (CloneNotSupportedException e) {	  
			System.out.println("Erro CloneException");
			e.printStackTrace();			  
		 }
		
		return a;
	}
	
	public String toString(){
		String s = "";
		s += "Modelo: " + tipo + " Assentos: " + colunas*filas + " " + destino +"\n";
		return s;
		
	}
	

}
