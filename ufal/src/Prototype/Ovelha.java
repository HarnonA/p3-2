package Prototype;

public class Ovelha implements AnimalPrototype {
	private int patas;
	
	public Ovelha(int patas) {
		this.patas = patas;
		
		System.out.println("Ovelha Criada");
	}
	
	
	public AnimalPrototype clonar() {
		
		System.out.println("Ovelha sendo clonada");
		
		Ovelha ovelhaObject = null;
		
		try {
			ovelhaObject = (Ovelha) super.clone();
			
		}		
		catch (CloneNotSupportedException e) {	  
			System.out.println("Erro CloneException");
			e.printStackTrace();			  
		 }
		
		return ovelhaObject;
	}
	
	
	public String toString(){
		
		return "Ovelha tem " + patas +" patas";
	}
	
}

	

