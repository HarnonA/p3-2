package Projeto.Singleton;

public class Singleton {

	   private static Singleton singleton = new Singleton( );
	   private int contador = 0;
	   
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private Singleton(){	}
	   
	   /* Static 'instance' method */
	   public static Singleton getInstance( ) {
	      return singleton;
	   }
	   
	   public int x(){
		   return contador++;
				   
	   }
	   
	}
