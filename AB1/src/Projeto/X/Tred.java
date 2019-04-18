package Projeto.X;


public class Tred implements Runnable{
	
	private String strg;
	private Colleague colleague;
	private OSubject observado;
	
	public Tred(OSubject observado, String strg, Colleague colleague){
		
		this.observado = observado;
		this.strg = strg;
		this.colleague = colleague;
		
	}
	
	public void run(){
		
		for(int i = 1; i <= 20; i++){
		
			try{
				
				// Sleep for 2 seconds
				Thread.sleep(2000);
				
			}
			catch(InterruptedException e)
			{}
			
			
			
			
			if(strg == "Tam") ((Observavel) observado).setTamObserve(colleague);
			if(strg == "Gol") ((Observavel) observado).setGolObserve(colleague);
			if(strg == "Azul") ((Observavel) observado).setAzulObserve(colleague);
	
			
			System.out.println("=====");
		
		}
	}

}
