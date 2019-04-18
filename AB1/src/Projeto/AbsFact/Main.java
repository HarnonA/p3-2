package Projeto.AbsFact;

import java.util.ArrayList;
import java.util.Scanner;




public class Main {

	public static void main(String[] args){
		
		UsuarioFactory fabrica = new UsuarioFactory();
		ArrayList<Usuario> arr = new ArrayList<Usuario>();
		Usuario x = null;
		
		x = new Cliente("0101", "Joaozinho", "Rua x", "8888-8888", "123");
		arr.add(x);
		x = new Gerente("0101", "Jose", "Rua x", "8888-7777", "123");
		arr.add(x);
		x = new Cliente("0101", "Lucas", "Rua x", "8888-6666", "123");
		arr.add(x);
	
		//System.out.println(arr.toString());
		
		Scanner scanner = new Scanner(System.in);
		String nome, senha;
		System.out.println("Nome");
		nome = scanner.nextLine();
		System.out.println("Senha");
		senha = scanner.nextLine();
		fabrica.criarUsuario(nome, senha, arr);
		x.executa();
				
			System.out.println("X");
			
		
		
		
		for(int i = 0 ; i < arr.size() ; i++){
			if(arr.get(i) instanceof Cliente)
				arr.add(fabrica.criarUsuario("", "", arr));
			
		}
		System.out.println(arr);
		
		
		
		
		//System.out.println(bdClientes.toString());
		//System.out.println(bdClientes);
		
		/*
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1 - Cliente");
		System.out.println("2 - Gerente");
		System.out.print("Escolha: ");
		//scanner.nextLine();
		
		if (scanner.hasNextLine()){
			int opcao = scanner.nextInt();
			String s = null;
			String t = null;
			scanner.nextLine();
			s = scanner.nextLine();
			t = scanner.nextLine();
			
			for(int i = 0 ; i < bdClientes.size() ; i++){
				
				
				if(s.equals(bdClientes.get(i).getName()))
					System.out.println("nome ok");
			
			}
			
			if(t.equals(s))
				System.out.println("Ok");
			
			user = shipFactory.criarUsuario(opcao);
			
			if(user != null){
				
				doStuffEnemy(user);
				
			} else System.out.print("Please enter U, R, or B next time");
		
		}
		
		/*
		EnemyShip theEnemy = null;
		
		// Old way of creating objects
		// When we use new we are not being dynamic
		
		EnemyShip ufoShip = new UFOEnemyShip();
		
		doStuffEnemy(ufoShip);
		
		System.out.print("\n");
		
		// -----------------------------------------
		
		// This allows me to make the program more dynamic
		// It doesn't close the code from being modified
		// and that is bad!
		
		// Defines an input stream to watch: keyboard
		Scanner userInput = new Scanner(System.in);
		
		String enemyShipOption = "";
		
		System.out.print("What type of ship? (U or R)");
		
		if (userInput.hasNextLine()){
			
			enemyShipOption = userInput.nextLine();
			
		}
		
		if (enemyShipOption == "U"){
			
			theEnemy = new UFOEnemyShip();

			
		} else 
		
		if (enemyShipOption == "R"){
			
			theEnemy = new RocketEnemyShip();
			
		} else {
			
			theEnemy = new BigUFOEnemyShip();
			
		}
		
		doStuffEnemy(theEnemy);
		
		// --------------------------------------------
		*/
		
	}
	
	// Executes methods of the super class
	
	public static void doStuffEnemy(Usuario anEnemyShip){
		
		anEnemyShip.executa();
		
	}

	
	
	
}

