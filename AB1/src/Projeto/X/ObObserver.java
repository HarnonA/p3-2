package Projeto.X;

public class ObObserver implements Observer {
	
	private Colleague tam;
	private Colleague azul;
	private Colleague gol;
	
	private static int iDTracker = 0;
	
	private int observerID;
		
	private OSubject oservado;
	
	public ObObserver(OSubject observado){
	
		this.oservado = observado;		
		this.observerID = ++iDTracker;
		
		
		System.out.println("Observer " + this.observerID);		
		observado.registra(this);
		
	}
	
	public void update(Colleague tam, Colleague azul, Colleague gol) {
		
		this.tam = tam;
		this.gol = gol;
		this.azul = azul;
		
		print();
		
	}
	
	public void print(){
		
		System.out.println(observerID + "\nIBM: " + azul + "\nAAPL: " + 
				gol + "\nGOOG: " + tam + "\n");
		
	}
	
}