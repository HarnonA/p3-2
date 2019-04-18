package Projeto.CompraVenda;

public class Singleton {

	private static Singleton singleton = new Singleton();
	private int contador = 0;

	private Singleton() {
	}

	public static Singleton getInstance() {
		return singleton;
	}

	public int x() {
		return contador++;

	}

}
