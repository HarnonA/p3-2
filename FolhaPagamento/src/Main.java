
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
	private static Scanner scanner;

	public static void main(String[] args) {
		LinkedList<Empregado> listaEmpregados = new LinkedList<Empregado>();
		LinkedList<LinkedList> backup = new LinkedList<LinkedList>();
		LinkedList<LinkedList> proximobckp = new LinkedList<LinkedList>();

		
		double taxaMensalSindicato = 100;
		
		Empregado assalariado;
		Emp_Horista horista; 
		Emp_Comissionado comissionado;
		FolhaPagamento folha = new FolhaPagamento();
		
		Calendar calendario = Calendar.getInstance();
		
		//==================================
		//Carrega Banco de Dados
		
		assalariado = new Emp_Assalariado(01,"Artur", "Rua A", taxaMensalSindicato, 1, 3000);
		listaEmpregados.add(assalariado);		
		
		assalariado = new Emp_Assalariado(02,"Bruno", "Rua B", 0, 2, 3000);
		listaEmpregados.add(assalariado);
				
		assalariado = new Emp_Assalariado(03,"Caio", "Rua C", 0, 0, 3000);
		listaEmpregados.add(assalariado);
				
		horista = new Emp_Horista(04,"Danilo", "Rua D", 0, 1, null);
		listaEmpregados.add(horista);
		horista.exHora();	//adiciona horas trabalhas como exemplo
		
		horista = new Emp_Horista(05,"Eurico", "Rua E", 0, 2, null);
		listaEmpregados.add(horista);
		horista.exHora();	//adiciona horas trabalhas como exemplo
		
		comissionado = new Emp_Comissionado(06, "Fabio", "Rua F",
				taxaMensalSindicato, 0, 1000, 0.05, null, null);
		comissionado.setVenda("10/8/2014", 1100);	//adiciona uma venda
		listaEmpregados.add(comissionado);	
		
		comissionado = new Emp_Comissionado(07, "Gabriel", "Rua G", 0, 1, 1000,
				0.08, null, null);
		comissionado.setVenda("10/8/2014", 1100);	//adiciona uma venda
		listaEmpregados.add(comissionado);
				
	
		//==================================
		
		int opcao = 0;
		int contId = 8;	//7 empregados ja cadastrados
		
		for (;;) {
			scanner = new Scanner(System.in);
			System.out.println("Escolha opção");
			System.out.println("1 - Adicionar empregado");
			System.out.println("2 - Remover empregado");
			System.out.println("3 - Lançar cartao de ponto");
			System.out.println("4 - Lançar venda");
			System.out.println("5 - Lançar taxa de serviço");
			System.out.println("6 - Alterar empregado");
			System.out.println("7 - Pagar funcionarios");
			System.out.println("8 - Desfazer");
			System.out.println("9 - Refazer");
			System.out.println("10 - Listar empregados");

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				// e.printStackTrace();
				scanner.nextLine(); // descarta a entrada errada do usuário
				System.out
						.println("\nNão é permitido inserir letras, informe apenas números inteiros!");
				System.out.println("<Enter>");
				scanner.nextLine();

			}

			try {
				// adiciona um empregado a lista de empregados com um id unico
				if (opcao == 1) {
					backup.addFirst((LinkedList) listaEmpregados.clone());
					listaEmpregados.add(folha.addEmpregado(contId));
					contId++;
				}

				// =================

				// remove um empregado da lista
				else if (opcao == 2) {
					backup.addFirst((LinkedList) listaEmpregados.clone());
					folha.removeEmpregado(listaEmpregados);
				}

				// =================

				// procura o id de um empregado Horista
				// compara o id solicitado com o id do empregado
				// se iguais, atribui hora trabalhada a um dia na semana dado
				// pelo
				// sistema
				else if (opcao == 3) {
					backup.addFirst(folha.clona(listaEmpregados));
					folha.lancarPonto(listaEmpregados, calendario);

				}

				// =================

				// procura pelo id de um empregado comissionado
				// fornece uma string de data e um valor de venda
				else if (opcao == 4) {
					backup.addFirst(folha.clona(listaEmpregados));
					folha.lancarVenda(listaEmpregados, calendario);

				}

				// =================

				// adiciona um serviço aos custos de um empregado
				else if (opcao == 5) {
					backup.addFirst(folha.clona(listaEmpregados));
					folha.taxaServico(listaEmpregados);
				}

				// =================

				// alterar dados de um empregado
				else if (opcao == 6) {
					backup.addFirst(folha.clona(listaEmpregados));
					// backup.addFirst(listaEmpregados.clone());
					folha.alterarEmpregado(listaEmpregados);
				}

				// =================

				// realiza pagamento dos funcionarios
				else if (opcao == 7) {
					backup.addFirst(folha.clona(listaEmpregados));
					proximobckp.addFirst(folha.paga(listaEmpregados));
				}

				// =================

				// realiza opção de desfazer
				else if (opcao == 8) {
					if (!backup.isEmpty()) {
						proximobckp.addFirst((LinkedList) listaEmpregados
								.clone());
						listaEmpregados = (LinkedList) backup.getFirst();
						backup.poll();
					}

				}

				// =================

				// realiza opção de refazer
				else if (opcao == 9) {

					if (!proximobckp.isEmpty()) {
						listaEmpregados = (LinkedList) proximobckp.getFirst();
						backup.addFirst((LinkedList) proximobckp.poll());
					}
				}

				// =================

				// lista empregados
				else if (opcao == 10) {
					int index;
					for (index = 0; index < listaEmpregados.size(); index++) {
						// if( folhaPagamento.get(index) instanceof
						// Emp_Assalariado)
						System.out.println(listaEmpregados.get(index)
								.toString());
					}
				}

			} catch (NullPointerException e) {
				System.out.println("\nErro ao cadastrar");

			}
		}
		
		//==================================
			
	}
	
}
