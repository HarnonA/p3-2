package Projeto.Singleton;

public class Main {
	public static void main(String[] args) {
	      Singleton tmp = Singleton.getInstance( );
	      
	      int a = 0;
	      int b = 0;
	      a = tmp.x();
	      b = tmp.x();
	      System.out.println(a + " " + b);
	      
	   }
	}
