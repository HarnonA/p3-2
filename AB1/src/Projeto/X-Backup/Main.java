package Projeto.X;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		StockMediator mediador = new StockMediator();

		Emp_Tam tam = new Emp_Tam(mediador);
		Emp_Gol gol = new Emp_Gol(mediador);
		Emp_Azul azul = new Emp_Azul(mediador);

		// ========

		Aviao boeing747 = new Aviao(8, 58, "Boeing 747", null, null, 1001);
		Aviao boeing757 = new Aviao(6, 46, "Boeing 757", null, null, 2002);
		Aviao airbusA3 = new Aviao(6, 42, "Airbus A3", null, null, 3003);
		Aviao fokker100 = new Aviao(5, 21, "Fokker100", null, null, 4004);

		// ========

		tam.addFrota(boeing747.prototipo());
		tam.addFrota(boeing757.prototipo());

		gol.addFrota(airbusA3.prototipo());

		azul.addFrota(fokker100.prototipo());

		// mediador.empresas();

		// ========

		tam.oferecerVoo(tam.getNome(), boeing747.prototipo(), "Maceio", "Recife");
		tam.oferecerVoo(tam.getNome(), boeing757.prototipo(), "Florianopolis", "Sao Paulo");
		gol.oferecerVoo(tam.getNome(), boeing747.prototipo(), "Rio de Janeiro", "Brasilia");
		tam.oferecerVoo(tam.getNome(), boeing757.prototipo(), "Rio Branco","Teresina");
		azul.oferecerVoo(azul.getNome(), fokker100.prototipo(), "Sergipe", "Maceio");
		//mediador.agenda();

		// =======

		Cliente cliente = new Cliente("0101", "Joaozinho", "Rua x",
				"8888-8888", "123");
		int opcao = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Escolha opçcao:");
		System.out.println("1 - Lista de Voos");
		System.out.println("2 - Comprar viajem");
		System.out.println("3 - Oferecer viajem");
		System.out.println("0 - Sair");

		do {
			opcao = scanner.nextInt();

			if (opcao == 1)
				mediador.agenda();
			
			else if (opcao == 2) {
				System.out.println("Escolha numero da viajem");
				int e = scanner.nextInt();
				mediador.vender(e);
				//mediador.vender(2);

			}
			
			else if(opcao == 3){
				scanner.nextLine();
				String origem, destino;
				System.out.println("Origem");
				origem = scanner.nextLine();
				System.out.println("Destino");
				destino = scanner.nextLine();
				
				tam.oferecerVoo(tam.getNome(), boeing747.prototipo(), origem, destino);
				System.out.println("Viagem disponivel para venda");
				
			}
		} while (opcao != 0);
		System.out.println("Volte Sempre");
		
		

		
	}
	
}