package Mediator.SemMediator;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args){
		ArrayList<Object> contatos = new ArrayList<>();
		Android android = new Android();
		IOS ios = new IOS();
		Symbian symbian = new Symbian();
		BlackBarry blackBarry = new BlackBarry();
		
		contatos.add(android);
		contatos.add(ios);
		contatos.add(symbian);
		contatos.add(blackBarry);
		
		android.mensagem(contatos);
		System.out.println("====");
		ios.mensagem(contatos);
		System.out.println("====");
		symbian.mensagem(contatos);
		System.out.println("====");
		blackBarry.mensagem(contatos);
		
		
	}

}
