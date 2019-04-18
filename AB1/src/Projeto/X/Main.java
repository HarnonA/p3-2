package Projeto.X;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Singleton sing = Singleton.getInstance( );
		Scanner scanner = new Scanner(System.in);

		ColleaguMediator mediador = new ColleaguMediator();
	
		Emp_Tam tam = new Emp_Tam(mediador);
		Emp_Gol gol = new Emp_Gol(mediador);
		Emp_Azul azul = new Emp_Azul(mediador);
		
		

		// ========

		Aviao boeing747 = new Aviao(8, 58, "Boeing 747", null, null, 0);
		Aviao boeing757 = new Aviao(6, 46, "Boeing 757", null, null, 0);
		Aviao airbusA3 = new Aviao(6, 42, "Airbus A3", null, null, 0);
		Aviao fokker100 = new Aviao(5, 21, "Fokker100", null, null, 0);

		// ========

		tam.addFrota(boeing747.prototipo(), sing.x());
		tam.addFrota(boeing757.prototipo(), sing.x());
		tam.addFrota(boeing757.prototipo(), sing.x());
		tam.addFrota(boeing757.prototipo(), sing.x());
		

		gol.addFrota(airbusA3.prototipo(), sing.x());

		azul.addFrota(fokker100.prototipo(), sing.x());

		//mediador.empresas();

		// ========

		tam.oferecerVoo(tam.getNome(), boeing747.prototipo(), "Maceio", "Recife");
		tam.oferecerVoo(tam.getNome(), boeing757.prototipo(), "Florianopolis", "Sao Paulo");
		gol.oferecerVoo(tam.getNome(), boeing747.prototipo(), "Rio de Janeiro", "Brasilia");
		tam.oferecerVoo(tam.getNome(), boeing757.prototipo(), "Rio Branco","Teresina");
		azul.oferecerVoo(azul.getNome(), fokker100.prototipo(), "Sergipe", "Maceio");
		//mediador.agenda();

		// =======
		/*
		Observavel stockGrabber = new Observavel();
		
		// Create an Observer that will be sent updates from Subject
		
		ObObserver observer1 = new ObObserver(stockGrabber);
		
		stockGrabber.setIBMPrice(tam);
		stockGrabber.setAAPLPrice(gol);
		stockGrabber.setGOOGPrice(azul);
		
		/*
		
		Runnable getIBM = new Tred(stockGrabber, 2, "IBM", 197.00);
		Runnable getAAPL = new Tred(stockGrabber, 2, "AAPL", 677.60);
		Runnable getGOOG = new Tred(stockGrabber, 2, "GOOG", 676.40);
		
		// Call for the code in run to execute 
		
		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();
		*/
		
		
		
		
		LinkedList<Cliente> bdClientes = new LinkedList<Cliente>() ;
		
		Cliente cliente = null;
		cliente = new Cliente("0101", "Joaozinho", "Rua x", "8888-8888", "123");
		bdClientes.add(cliente);
		cliente = new Cliente("01", "Pedrinho", "Rua y", "8888-9999", "123");
		bdClientes.add(cliente);
		cliente = new Cliente("01", "Luizinho", "Rua w", "8888-7777", "123");
		bdClientes.add(cliente);
		System.out.println("Entre nome e senha");
		String senha = "";
		String nome = "";
		nome = scanner.nextLine();
		senha = scanner.nextLine();
		
		
		
		for(int i = 0 ; i < bdClientes.size() ; i++){
			if(bdClientes.get(i).comparar(nome, senha) == true){
				cliente = bdClientes.get(i); 
				System.out.println("Acesso garantido");
			}

		}
			
		
		
		int opcao = 0;
		opcao = scanner.nextInt();
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Utilizar sistema");
		if (opcao == 1) {
			opcao = scanner.nextInt();
			System.out.println("1 - Cliente");
			System.out.println("2 - Gerente");
			if(opcao == 1){
				
				
			}
			else if(opcao == 2){
				
			}

		}

		else {
			do {
				System.out.println("Escolha opçcao:");
				System.out.println("1 - Lista de Voos");
				System.out.println("2 - Comprar viajem");
				System.out.println("3 - Oferecer viajem");
				System.out.println("0 - Sair");

				opcao = scanner.nextInt();

				if (opcao == 1)
					mediador.agenda();

				else if (opcao == 2) {
					System.out.println("Escolha numero da viajem");
					int e = scanner.nextInt();
					mediador.vender(e);
					// mediador.vender(2);

				}

				else if (opcao == 3) {
					scanner.nextLine();
					String origem, destino;
					System.out.println("Origem");
					origem = scanner.nextLine();
					System.out.println("Destino");
					destino = scanner.nextLine();

					tam.oferecerVoo(tam.getNome(), boeing747.prototipo(),
							origem, destino);
					System.out.println("Viagem disponivel para venda");

				}
			} while (opcao != 0);
			System.out.println("Volte Sempre");
		}
		

		
	}
	
}