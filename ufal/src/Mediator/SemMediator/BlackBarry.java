package Mediator.SemMediator;

import java.util.ArrayList;

public class BlackBarry {
	
	public void mensagem(ArrayList contatos){
		Object o = new Object();
		for(int i = 0; i < contatos.size() ; i++ ){
			o = contatos.get(i);
			if( o instanceof Android){
				System.out.println("Oi, android");
			} else if(o instanceof IOS){
				System.out.println("Oi, IOS");
			}
			else if(o instanceof Symbian){
				System.out.println("Oi, Symbian");
			}	
			
		}
		System.out.println("Eu sou o BlackBarry");
	}

}
