package Mediator.SemMediator;

import java.util.ArrayList;

public class Android {
	
	public void mensagem(ArrayList contatos){
		Object o = new Object();
		for(int i = 0; i < contatos.size() ; i++ ){
			o = contatos.get(i);
			if(o instanceof IOS){
				System.out.println("Oi, IOS");
			}
			else if(o instanceof Symbian){
				System.out.println("Oi, Symbian");
			}
			else if(o instanceof BlackBarry){
				System.out.println("Oi, BlackBarry");
			}
			
			
		}
		System.out.println("Eu sou o Android");
	}

}
