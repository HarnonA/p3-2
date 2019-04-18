package Projeto.GUI;



public class Singleton {

	private static Singleton singleton = new Singleton();
	private static GUI_Aviao aviao = new GUI_Aviao();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return singleton;
	}

	public static GUI_Aviao getSingleton() {
		return aviao;

	}
}
