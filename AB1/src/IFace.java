import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;




public class IFace {
	
	
	
	public static void main(String[] args) {
		LinkedList<Usuario> todosUsuarios = new LinkedList<Usuario>();
		Scanner s = new Scanner(System.in);
		Operacoes op = new Operacoes();
		int opcao = 0;
		boolean cadastrado = false;
		
		Usuario user = new Usuario("Artur", "123", "artur@gmail.com");
		todosUsuarios.addFirst(user);
		user = new Usuario("Bruno", "123", "bruno@gmail.com");
		todosUsuarios.addFirst(user);
		user = new Usuario("Caio", "123", "caio@gmail.com");
		todosUsuarios.addFirst(user);
		user = new Usuario("Davi", "123", "davi@gmail.com");
		todosUsuarios.addFirst(user);
	
		// ============================
		
		for (;;) {

			do {
				System.out.println("1 - Entrar login");
				System.out.println("2 - Nao possuo conta");
				System.out.println("3 - Sair");

				try {
					opcao = s.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nDigite um valor valido!");
					s.nextLine();
					opcao = 0;
				}
			} while (opcao < 1 || opcao > 3);
			s.nextLine();

			// ============================

			if (opcao == 1) {
				do {
					System.out.println("Insira login   <0-Sair>");
					String log;
					log = s.nextLine();
					if (log.equals("0")) {
						System.out.println("Tchau");
						break;
					}
					user = op.procurar(log, todosUsuarios);
					if (user != null)
						cadastrado = true;
				} while (!cadastrado);
			}

			else if (opcao == 2) {
				System.out.println("Criar usuario");
				todosUsuarios.addFirst(op.cadastrar());
				cadastrado = true;

			} else if (opcao == 3) {
				System.out.println("Tchau");
				break;
			}

			// ============================

			if (cadastrado == true) {
				do {
					System.out.println("Escolha opcao:");
					System.out.println("1 - Editar Perfil");
					System.out.println("2 - Adicionar amigos");
					System.out.println("3 - Chat");
					System.out.println("4 - Criar comunidade");
					System.out.println("5 - Adicioar membros");
					System.out.println("6 - Recuperar");
					System.out.println("7 - Remover conta");

					try {
						opcao = s.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Digite um valor valido!");
						s.nextLine();
						opcao = 0;
					}
				} while (opcao < 0 || opcao > 8);

				if (opcao == 1) {
					op.editarPerfil(user);
				}
					
				if (opcao == 3) {
					String nomeProcurado;
					nomeProcurado = s.nextLine();
					System.out.println("Procurar nome usuario");
					for (int index = 0; index < todosUsuarios.size(); index++) {
						if (todosUsuarios.get(index).getNome().equals(nomeProcurado)) {
							System.out.println("Deseja adicionar amigo?");
							System.out.println("1- Sim");
							System.out.println("2- Nao");
							int add = 0;
							add = op.lerInt();
							if(add == 1)
								System.out.println("Solicitacao enviada");
						}
					}

					
				

				} else if (opcao == 5) {
					String nomeComu, descricao;
					System.out.println("Nome da comunidade");
					nomeComu = s.nextLine();
					System.out.println("Descricao dessa comunidade");
					descricao = s.nextLine();
					Comunidade comunidade = new Comunidade(nomeComu, descricao,
							user);
					user.addComunidade(comunidade);
				}

				else if (opcao == 7) {
					System.out.println("Sua conta foi removida");
					todosUsuarios.remove(user);
				}
				else if(opcao == 8){
					System.out.println("Ate a proxima...");
					cadastrado = false;
				}
					
			}
		}

	}

	/*
	 * ==================
	 */

}
