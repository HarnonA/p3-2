package Prototype;

public class Main {
	
	public static void main(String[] args){
			
		CriarClones clonagem = new CriarClones();
		
		Ovelha sally = new Ovelha(4);
				
		Ovelha dolly = (Ovelha) clonagem.realizarClone(sally);
		
		System.out.print("Sally: ");
		System.out.println(sally);
		
		System.out.print("Dolly: ");
		System.out.println(dolly);
		
	}

}
