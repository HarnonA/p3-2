package Projeto.GUI;

import java.awt.GridLayout;



public class Main {
	
	public static void main(String[] args) {
		Usuario usuario = null;
		
		
		//Versao v = new Versao();
		//GUI_Cliente c = new GUI_Cliente();
		
		
		
		Versao janela = new Versao();
		janela.addUsuario(new Usuario("Joao", "123"));
		janela.addUsuario(new Usuario("lucas", "123"));
		
		//GUI_Cliente gui = new GUI_Cliente();


	}

	

}
