package Projeto.AbsFact;

public abstract class EnemyShip {
	
	private int colunas;
	private int filas;
	private String tipo;
	private String destino;
	private boolean[][] assentos;
	
	
	
	public String getName() { return tipo; }
	public void setName(String newName) { tipo = newName; }
			
	public void executa(){
		
		System.out.println(getName() + " is on the screen");
	}
	
	
}