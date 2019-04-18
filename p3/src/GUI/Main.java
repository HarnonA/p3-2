package GUI;

import java.awt.GridLayout;



public class Main {
	
	public static void main(String[] args) {
		Usuario usuario = null;
		Contain c = new Contain();
		
		
		//Versao v = new Versao();
		//GUI_Cliente c = new GUI_Cliente();
		
		
		
		Versao janela = new Versao(new GridLayout(3, 2, 10, 10), c);
		Versao j1;
		j1 =janela;
		j1.show();
		janela.addUsuario(new Usuario("Joao", "123"));
		janela.addUsuario(new Usuario("lucas", "123"));
		
		//GUI_Cliente gui = new GUI_Cliente();


	}

	

}
