import java.util.*;

public class Main {

	public static void main(String[] args) {

		Random rand = new Random();
		Scanner entrada = new Scanner(System.in);
		Scanner op = new Scanner(System.in);
		ArrayList<Assalariado> assalariado = new ArrayList<Assalariado>();
		ArrayList<Comissionado> comissionado = new ArrayList<Comissionado>();
		ArrayList<Horista> horista = new ArrayList<Horista>();

		int code; // codigo do empregado
		int cont; // contador para imprimir a lista
		int tipoEmpregado; // 1-assalariado, 2-comissionado e 3-horista
		String nome; // nome do empregado
		String endereco; // endere�o do empregado
		Boolean sindicalizado = false; // � ou n�o sindicalizado
		float taxaSindicato = 0; // taxa para sindicalizados
		int tipoPagamento; // de que forma o empregado quer ser pago
		String limpaBuffer;

		int opcao;

		do {
			// entrada.nextLine();
			System.out.print("1 - Adicionar Empregado\n" + "2 - Fazer venda\n"
					+ "3 - Gerar folha de pagamento\n"
					+ "4 - Imprimir lista de Empregados\n" + "0 - Para sair\n"
					+ "Digite a opcao escolhida: ");
			opcao = op.nextInt();
			// System.out.println();

			switch (opcao) {

			// ====================================================================

			case 0: // Programa sera fechado
				System.out.println("Tenha um bom dia! Tchau!");
				break;
			// ====================================================================

			case 1: // Comeca a insercao
				code = rand.nextInt(200) + 1;
				System.out.println("Codigo do empregado: " + code);

				System.out.print("Digite o nome do Empregado: ");
				nome = entrada.nextLine();
				System.out.println(nome);

				System.out.print("\nDigite o endereco do Empregado: ");
				endereco = entrada.nextLine();
				System.out.println(endereco);

				System.out.print("\nParticipa de sindicato? 0-Nao / 1-Sim ");
				int aux = entrada.nextInt();

				if( aux > 1 || aux < 0){
					System.out.println("\nFormato nao valido\n");
					break;
				}
				
				if (aux == 1) { //Se for sindicalista
					System.out
							.print("Digite o valor da taxa cobrada pelo sindicato: ");
					taxaSindicato = entrada.nextFloat();
					System.out.println(taxaSindicato);
					sindicalizado = true;
				}
				
				System.out.println("\n1 - Cheque pelos correios");
				System.out.println("2 - Cheque em Maos");
				System.out.println("3 - Conta Bancaria");
				System.out.print("Tipo de pagamento desejado: ");
				tipoPagamento = entrada.nextInt();

				System.out.print("\n1 - Assalariado\n");
				System.out.print("2 - Comissionado\n");
				System.out.print("3 - Horista\n");
				System.out.print("Tipo do empregado: ");
				tipoEmpregado = entrada.nextInt();

				// =================
				switch (tipoEmpregado) {
				case 1: // Assalariado
					float salarioAssalariado; // Guardar o salario do empregado
					
					System.out.print("Salario do Empregado: ");
					salarioAssalariado = entrada.nextFloat();
					
					Assalariado tempAssalariado = new Assalariado(code, nome,
							endereco, sindicalizado, taxaSindicato,
							tipoPagamento, salarioAssalariado);
					
					assalariado.add(tempAssalariado);
					// System.out.print("Entrada fechada!");
					System.out.println("\nAdicionado com sucesso\n");
					break;

				// =================

				case 2: // Comissioando
					float salarioComissionado;
					float taxa;
					System.out.print("Salario do Empregado: ");
					salarioComissionado = entrada.nextFloat();
					System.out.print("Comissao do Empregado: ");
					taxa = entrada.nextFloat();

					Comissionado tempComissionado = new Comissionado(code,
							nome, endereco, sindicalizado, taxaSindicato,
							tipoPagamento, salarioComissionado, taxa);
					// 0(zero) no ultimo parametro por que o empregado nao tem
					// nada a receber
					comissionado.add(tempComissionado);
					System.out.println("\nAdicionado com sucesso\n");
					break;

				// =================

				case 3: // Horista
					float valorHora;
					int horasTrabalhadas;
					System.out.print("Valor da hora trabalhada: ");
					valorHora = entrada.nextFloat();
					System.out.print("Horas trabalhadas: ");
					horasTrabalhadas = entrada.nextInt();

					Horista tempHorista = new Horista(code, nome, endereco,
							sindicalizado, taxaSindicato, tipoPagamento, horasTrabalhadas,
							valorHora);
					horista.add(tempHorista);
					System.out.println("\nAdicionado com sucesso\n");
					break;

				// =================

				default:
					System.out.println("Tipo de empregado nao existe!\n");
					//entrada.nextLine();
					break;
				// =================
					
				} // Fim de Caso de Tipos de Empregados
				
				
				entrada.nextLine();// limpa buffer
				
				//System.out.println("\n\nAdicionado com sucesso");
			break; // Case 1

			// ====================================================================

			case 4:
				System.out.print("\n1 - Assalariado\n");
				System.out.print("2 - Comissionado\n");
				System.out.print("3 - Horista\n");
				System.out.print("Tipo do empregado: ");
				tipoEmpregado = entrada.nextInt();
				switch (tipoEmpregado) {
				case 1:
					// System.out.println(assalariado);
					for (cont = 0; cont < assalariado.size(); ++cont) {
						System.out.println("Codigo: "
								+ assalariado.get(cont).getCode());
						System.out.println("Nome: "
								+ assalariado.get(cont).getNome());
						System.out.println("Endereco: "
								+ assalariado.get(cont).getEndereco());
						System.out.println("Sindicato: "
								+ assalariado.get(cont).getSindicalizado());
						System.out.println("Taxa do Sindicato: "
								+ assalariado.get(cont).getTaxaSindicato());
						System.out.println("Tipo do pagamento: "
								+ assalariado.get(cont).getTipoPagamento());
						System.out.println("Salario: "
								+ assalariado.get(cont).getSalarioMes());
						System.out.println();
					}
					break;

				// =================

				case 2:
					// System.out.println(comissionado);
					for (cont = 0; cont < comissionado.size(); ++cont) {
						System.out.println("Codigo: "
								+ comissionado.get(cont).getCode());
						System.out.println("Nome: "
								+ comissionado.get(cont).getNome());
						System.out.println("Endere�o: "
								+ comissionado.get(cont).getEndereco());
						System.out.println("Sindicato: "
								+ comissionado.get(cont).getSindicalizado());
						System.out.println("Taxa do Sindicato: "
								+ comissionado.get(cont).getTaxaSindicato());
						System.out.println("Tipo do pagamento: "
								+ comissionado.get(cont).getTipoPagamento());
						System.out.println("Salario: "
								+ comissionado.get(cont).getSalarioVaria());
						System.out.println();
					}
					break;

				// =================

				case 3:
					// System.out.println(horista);
					for (cont = 0; cont < horista.size(); ++cont) {
						System.out.println("Codigo: "
								+ horista.get(cont).getCode());
						System.out.println("Nome: "
								+ horista.get(cont).getNome());
						System.out.println("Endereco: "
								+ horista.get(cont).getEndereco());
						System.out.println("Sindicato: "
								+ horista.get(cont).getSindicalizado());
						System.out.println("Taxa do Sindicato: "
								+ horista.get(cont).getTaxaSindicato());
						System.out.println("Tipo do pagamento: "
								+ horista.get(cont).getTipoPagamento());
						System.out.println("Horas trabalhadas: "
								+ horista.get(cont).getQntHorasTrabalhadas());
						System.out.println("Salario a Receber: "
								+ horista.get(cont).getaReceber());
						System.out.println();
					}
					break;

				// =================

				default:
					System.out.print("Nao existe essa opcao!\n\n");
				}
				break;

			// ====================================================================

			default:
				System.out.print("Opcao errada!\n\n");
				break;

			}
		} while (opcao != 0);
	}
}
