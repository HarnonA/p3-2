import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class BancoDados {
	LinkedList<Empregado> banco;// BANCO COM DADOS DE EMPREGADOS
	LinkedList<LinkedList<Empregado>> bancoBackup;// BANCO COM DADOS DE
													// EMPREGADOS
	LinkedList<LinkedList<Empregado>> bancoAux;// BANCO COM DADOS DE EMPREGADOS

	/*
	 * 
	 */
	public void x() {
		Empregado ex = new Comissionado(0001, 02, 1, 100, "Juquinha", "Rua tal",
				true, 0, 1000, 1);
		banco.add(ex);
		ex = new Horista(0002, 03, 0, 0, "Joaozinho", "Rua x", false, 1, 50);
		banco.add(ex);
		ex = new Assalariado(0003, 03, 0, 0, "Lulu", "Rua x", false, 4, 1000);
		//ex.setAgenda(4);
		banco.add(ex);

		ex.getAgenda();
	}
	
	private int lerInt(){
		int num = 0;
		try {
			num = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Digite um valor valido!");
			s.nextLine();
			num = -1;
		}
		return num;
		
	}
	
	private float lerFloat(){
		float num = 0;
		try {
			num = s.nextFloat();
		} catch (InputMismatchException e) {
			System.out.println("Digite um valor valido!");
			s.nextLine();
			num = -1;
		}
		return num;
		
	}
	
	private long lerLong(){
		long num = 0;
		try {
			num = s.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("Digite um valor valido!");
			s.nextLine();
			num = -1;
		}
		return num;
		
	}

	private boolean continuar;
	Scanner s = new Scanner(System.in);

	long cpf = 0, idSindi = 0;
	int tipoPag = 0, op = 0, tipoEmpre = 0;
	float taxaSindi = 0, salario = 0, comissao = 0;
	boolean sindicato;
	String nome, endereco;

	DateFormat dataf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar c = Calendar.getInstance();

	final float impostos = 100;// supoe que os impostos ao todo custa 100

	// CONSTRUTOR
	public BancoDados() {
		banco = new LinkedList<Empregado>();
		bancoBackup = new LinkedList<LinkedList<Empregado>>();// BANCO COM DADOS
																// DE EMPREGADOS
		bancoAux = new LinkedList<LinkedList<Empregado>>();
	}

	// ===========================

	// METODO CRIAR UM EMPREGADO
	public Empregado criarEmpregado() throws NullPointerException {

			continuar = false;
				do {
					System.out.println("Digite CPF do empregado: ");
					cpf = lerLong();
					//cpf = s.nextLong();
					for (int i = 0; i < banco.size(); i++) {
						Empregado emp = banco.get(i);
						if (cpf == emp.getCpf()) {
							System.out.println("CPF já cadastrado!\n");
							cpf = -1;
						}
					}

				} while (cpf < 0);

		s.nextLine();
		System.out.println("Digite o nome do empregado:");
		nome = s.nextLine();
		System.out.println("Digite o endereco do empregado:");
		endereco = s.nextLine();

		do {
				System.out.println("Metodo de pagamento:\n"
						+ "1 - Receber cheque pelos correios\n"
						+ "2 - Receber cheque em maos\n"
						+ "3 - Deposito em conta bancaria");
				tipoPag = lerInt();
				//tipoPag = s.nextInt();
		} while (tipoPag > 3 || tipoPag < 1);

		do {
				System.out
						.println("Faz parte de sindicato? 1 - Sim || 2 - Nao");
				op = lerInt();
				//op = s.nextInt();// FAZER TRATAMENTO
		} while (op > 2 || op < 1);
		if (op == 1) {
			sindicato = true;
			do {
				continuar = false;
				try {
					System.out.println("Digite seu ID no sindicato: ");
					idSindi = s.nextLong() + 1;
				} catch (InputMismatchException e) {
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar = true;
				}
			} while (continuar);
			do {
				continuar = false;
				try {
					System.out.println("Digite a taxa sindical:");
					taxaSindi = s.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar = true;
				}
			} while (continuar);
		} else
			sindicato = false;

		do {
			
				System.out.println("Tipo de empregado:\n" + "1 - Horista\n"
						+ "2 - Assalariado\n" + "3 - Comissionado");
				tipoEmpre = lerInt();
				//tipoEmpre = s.nextInt();
		} while (tipoEmpre > 3 || tipoEmpre < 1);

		Empregado emp = null;
		switch (tipoEmpre) {
		case 1:
			do {
				continuar = false;
				try {
					System.out.println("Digite o salario horario:");
					salario = s.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar = true;
				}
			} while (continuar);

			emp = new Horista(cpf, idSindi, tipoPag, taxaSindi, nome, endereco,
					sindicato, 0, salario);
			break;
		case 2:
			do {
				continuar = false;
				try {
					System.out.println("Digite o salario horario fixo:");
					salario = s.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar = true;
				}
			} while (continuar);
			emp = new Assalariado(cpf, idSindi, tipoPag, taxaSindi, nome,
					endereco, sindicato, 0, salario);
			break;
		case 3:
			do {
				continuar = false;
				try {
					System.out.println("Digite o salario horario fixo:");
					salario = s.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar = true;
				}
			} while (continuar);
			do {
				continuar = false;
				try {
					System.out.println("Digite o valor da comissao:");
					comissao = s.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar = true;
				}
			} while (continuar);
			emp = new Comissionado(cpf, idSindi, tipoPag, taxaSindi, nome,
					endereco, sindicato, 0, salario, comissao);
			break;
		default:
			System.out.println("Tipo de empregado invalido!");
		}

		return emp;
	}

	// ===========================

	// METODO ADICIONAR UM EMPREGADO FUNCIONALIDADE 1
	public void adicionarEmpregado() {
		bancoBackup.addFirst((LinkedList) banco.clone());
		banco.add(criarEmpregado());
	}

	// ===========================

	// METODO BUSCAR UM EMPREGADO
	public Empregado buscarEmpregado() {
		do {
				System.out.println("Digite CPF do empregado: ");
				cpf = lerLong();
		} while (cpf < 0);
		
		for (int i = 0; i < banco.size(); i++) {
			Empregado emp = banco.get(i);
			if (emp.getCpf() == cpf) {
				return emp;
			}
		}
		return null;
	}

	// ===========================

	// METODO REMOVER UM EMPREGADO FUNCIONALIDADE 2
	public void removerEmpregado() {
		bancoBackup.addFirst((LinkedList) banco.clone());
		Empregado emp = buscarEmpregado();
		int op = 0;
		if (emp == null)
			System.out.println("Empregado nao encontrado!");
		else {
			do {
				System.out
						.println("Deseja remover o empregado? 1 - SIM || 2 - NAO");
				op = lerInt();	
			} while (op > 2 || op < 1);
			
			if (op == 1) {
				banco.remove(emp);
				System.out.println("Empregado Removido!");
				return;
			} else
				System.out.println("Empregado nao removido!");
		}
	}

	// ===========================

	// METODO LANCAR CARTAO DE PONTO FUNCIONALIDADE 3
	public void lancarCartao() throws NullPointerException {
		bancoBackup.addFirst((LinkedList) banco.clone());
		Horista horista = null;
		
		do {
				System.out.println("Digite CPF do empregado: ");
				cpf = lerLong();
			
		} while (cpf < 0);
		
		for (int i = 0; i < banco.size(); i++) {
			if (cpf == banco.get(i).getCpf()) {
				if (banco.get(i) instanceof Horista) {
					horista = (Horista) banco.get(i);
					horista.setDataEntrada(dataf.format(c.getTime()));
					System.out.println("Data de entrada: "
							+ horista.getDataEntrada());
					int hora = 0;
					do {
						System.out.println("Digite a a quantidade de horas:");
						hora = lerInt();
						horista.setHorasDiarias(hora);
					} while (hora < 0 || hora > 24);
					return;
				}
			}
		}
		System.out.println("Empregado nao encontrado ou nao horista!");
	}

	// ===========================

	// METODO QUE LANCA UMA VENDA
	public void lancarVenda() throws NullPointerException {
		bancoBackup.addFirst((LinkedList) banco.clone());
		float venda1 = 0, venda2 = 0;
		Comissionado comissionado = null;
		
		do {
			System.out.println("Digite CPF do empregado: ");
			cpf = lerLong();
		} while (cpf < 0);
		
		for (int i = 0; i < banco.size(); i++) {
			if (cpf == banco.get(i).getCpf()) {
				if (banco.get(i) instanceof Comissionado) {
					comissionado = (Comissionado) banco.get(i);
					venda1 = comissionado.getVendas();
					do {
							System.out.println("Digite o valor da venda:");
							venda2 = lerFloat();
					} while (venda2 < 0);
					comissionado.setVendas(venda1 + venda2);
					return;
				}
			}
		}
		System.out.println("Empregado nao encontrado ou nao comissionado!");

	}

	// ===========================

	// METODO PARA LANCAR UMA TAXA DE SERVICO A UM EMPREGADO FUNCIONALIDADE 5
	public void lancarServico() throws NullPointerException {
		bancoBackup.addFirst((LinkedList) banco.clone());// FAZ O BACKUP
		Empregado emp = buscarEmpregado();
		float taxa = 0;
		if (emp != null) {
			do {
				System.out.println("Digite o valor da taxa de servico: ");
				taxa = lerFloat();
			} while (taxa < 0);
			emp.setTaxaServico(taxa);
		} else
			System.out.println("Empregado nao encontrado!");
	}

	// ===========================

	// METODO QUE ALTERA OS DADOS DO EMPREGADO FUNCIONALIDADE 6
	public void alterarEmpregado() throws NullPointerException {
		bancoBackup.addFirst((LinkedList) banco.clone());

		int aux = -1;
		Empregado emp = buscarEmpregado();
		

		long cpf1 = 0;
		long idSind1 = 0;
		int metodoPag1 = 0; 
		float taxaSindical1 = 0;
		
		String nome1, endereco1;
		boolean sindicato1;
		int agenda1 = 0;
		Empregado emp1 = null;
		int tipoDoEmpregado = 0;
		float salario1 = 0;
		float comissao1 = 0;
		
		cpf1 = emp.getCpf();
		idSind1 = emp.getIdSind();
		metodoPag1 = emp.getMetodoPag();
		taxaSindical1 = emp.getTaxaSindical();
		nome1 = emp.getNome();
		endereco1 = emp.getEndereco();
		sindicato1 = emp.getSindicato();
		agenda1 = emp.getAgenda();
		
		if(emp instanceof Assalariado)
			tipoDoEmpregado = 1;
		else if(emp instanceof Horista)
			tipoDoEmpregado = 2;
		else if(emp instanceof Comissionado)
			tipoDoEmpregado = 3;
		
	
	
		
		if (emp != null) {
			emp.toString();
			System.out
					.println("\nAlterar?\n1 - Nome\n2 - Endereco\n3 - Metodo de pagamento\n4 - Pertence ao sindicato\n"
							+ "5 - Identificacao do sindicato\n6 - Taxa Sindical\n7 - Tipo Empregado\n"
							+ "8 - Agenda");

			aux = lerInt();

			if (aux == 1) {
				s.nextLine();
				System.out.println("Digite o nome: ");
				nome1 = s.nextLine();
			} else if (aux == 2) {
				System.out.println("Digite o endereco: ");
				endereco1 = s.nextLine();
			} else if (aux == 3) {
				do {
					try {
						System.out
								.println("Metodo de pagamento:\n1 - Receber cheque pelos correios\n2 - Receber cheque em maos\n3 - Deposito em conta bancaria");

						metodoPag1 = s.nextInt();

					} catch (InputMismatchException e) {
						System.out.println("Digite um valor valido!");
						metodoPag1 = 0;
						s.nextLine();
					}
				} while (metodoPag1 < 1 || metodoPag1 > 3);
			}

			else if (aux == 4) {
				do {
					try {

						System.out
								.println("Faz parte de sindicato? 1 - Sim || 2 - Nao");
						op = s.nextInt();// FAZER TRATAMENTO

					} catch (InputMismatchException e) {
						System.out.println("Digite um valor valido!");
						s.nextLine();
						continuar = false;
						op = 0;
					}
				} while (op < 1 || op > 2);

				if (op == 1) {
					sindicato1 = true;
					try {
						System.out.println("Digite seu ID no sindicato: ");
						idSind1 = s.nextLong();
						System.out.println("Digite a taxa sindical:");
						taxaSindical1 = s.nextFloat();

					} catch (InputMismatchException e) {
						System.out.println("Digite um valor valido!");
						s.nextLine();
						continuar = false;
					}

				} else {
					sindicato = false;
					taxaSindical1 = 0;
					idSind1 = 0;
				}

			} else if (aux == 5) {
				do {
					try {
						System.out.println("Digite seu ID no sindicato: ");
						idSind1 = s.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Digite um valor valido!");
						s.nextLine();
						idSind1 = 0;
						continuar = false;
					}

				} while (idSind1 < 0);

			} else if (aux == 6) {
				do {
					try {
						System.out.println("Digite a taxa sindical:");
						taxaSindical1 = s.nextFloat();
					} catch (InputMismatchException e) {
						System.out.println("Digite um valor valido!");
						s.nextLine();
						taxaSindical1 = -1;
						continuar = false;
					}
				} while (taxaSindical1 < 0);
			} else if (aux == 7) {
				System.out.println("Escolha tipo: ");
				System.out.println("1 - Assalariado");
				System.out.println("2 - Horista");
				System.out.println("3 - Comissionado");
				do {
					try {
						op = s.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Digite um valor valido!");
						s.nextLine();
						op = 0;
						continuar = false;
					}

				} while (op < 0 || op > 3);

				if (op == 1) {
					tipoDoEmpregado = 1;
					System.out.println("Digita Valor do salario");
					do {
						try {
							salario1 = s.nextFloat();
						} catch (InputMismatchException e) {
							System.out.println("Digite um valor valido!");
							s.nextLine();
							salario1 = 0;
						}

					} while (salario1 < 0);

					/*Empregado assalariado = new Assalariado(cpf1, idSind1,
							metodoPag1, taxaSindical1, nome1, endereco1,
							sindicato1, agenda1, salarioFixo1);
					banco.remove(emp);
					banco.add(assalariado);*/

				} else if (op == 2) {
					tipoDoEmpregado = 2;
					do {
						System.out.println("Digite o salario horario:");
						try {
							salario1 = s.nextFloat();
						} catch (InputMismatchException e) {
							System.out.println("Digite um valor valido!");
							s.nextLine();
							salario1 = 0;
						}

					} while (salario1 < 0);
					/*
					Empregado horista = new Horista(cpf1, idSind1, metodoPag1,
							taxaSindical1, nome1, endereco1, sindicato1,
							agenda1, salario);
					banco.remove(emp);
					banco.add(horista);
					*/

				} else if (op == 3) {
					tipoDoEmpregado = 3;
					do {

						try {
							System.out
									.println("Digite o salario horario fixo:");
							salario1 = s.nextFloat();
							System.out.println("Digite o comissao:");
							comissao1 = s.nextFloat();
						} catch (InputMismatchException e) {
							System.out.println("Digite um valor valido!");
							s.nextLine();
							salario1 = 0;
						}

					} while (salario1 < 0);
					/*
					Empregado comissionado = new Comissionado(cpf1, idSind1,
							metodoPag1, taxaSindical1, nome1, endereco1,
							sindicato1, agenda1, salario1, comissao1);
					banco.remove(emp);
					banco.add(comissionado);
					*/
				}

			}else if(aux == 8){
				do{
					System.out.print("\nPossibilidades para agendas de pagamento:");
					System.out.print("\n\t1 - mensal 1: dia 1 de todo mes\n");
					System.out.print("\t2 - mensal 7: dia 7 de todo mes\n");
					System.out
							.print("\t3 - mensal $: ultimo dia util de todo mes\n");
					System.out
							.print("\t4 - semanal 1 segunda: toda semana as segundas-feiras\n");
					System.out
							.print("\t5 - semanal 1 sexta: toda semana as sextas-feiras\n");
					System.out
							.print("\t6 - semanal 2 segunda: a cada 2 semanas as segundas-feiras\n");
					agenda1 = lerInt();
					
				}while(agenda1 < 0 || agenda1 > 6);
			}

		}

		
		if(tipoDoEmpregado == 1)
			 emp1 = new Assalariado(cpf1, idSind1, metodoPag1, taxaSindical1,
					nome1, endereco1, sindicato1, agenda1, salario1);
		
			if(tipoDoEmpregado == 2)
				emp1 = new Horista(cpf1, idSind1, metodoPag1, taxaSindical1,
						nome1, endereco1, sindicato1, agenda1, salario1);
			if(tipoDoEmpregado == 3)
				emp1 = new Comissionado(cpf1, idSind1, metodoPag1, taxaSindical1,
						nome1, endereco1, sindicato1, agenda1, salario1, comissao1);		
		banco.remove(emp);
		banco.add(emp1);				
			
			
	}

	// ===========================

	// METODO QUE CALCULA O ULTIMO DIA DO MES
	public Calendar calculaUltimoDiaUtilMes(Calendar calendar) {
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		// enquanto for sabado, domingo
		while (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			// decrementa a data em um dia
			calendar.add(Calendar.DATE, -1);
		}
		return calendar;
	}

	// ===========================

	
	// ===========================
	
	public void folhaPagamento() throws NullPointerException {
		bancoBackup.addFirst((LinkedList) banco.clone());
		DateFormat DF = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		Calendar ultimoDiaUtilDoMes = calculaUltimoDiaUtilMes(c);
		int ultimoDiaUtil = Integer.parseInt(DF.format(ultimoDiaUtilDoMes
				.getTime()));
		int diaAtual = cal.get(Calendar.DAY_OF_MONTH);

		//System.out.println("x" + cal.get(Calendar.DAY_OF_WEEK));

		String[] meses = { "Janeiro", "Fevereiro", "Marco", "Abril", "Maio",
				"Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro",
				"Dezembro" };
		System.out.println("Mes: " + meses[c.get(Calendar.MONTH)]);
		System.out.println("Dia: " + diaAtual);
		for (int i = 0; i < banco.size(); i++) {
			if(diaAtual == 1 && banco.get(i).getAgenda() == 1)
				System.out.println(banco.get(i).calculaSalario());
			else if(diaAtual == 7 && banco.get(i).getAgenda() == 2)
				System.out.println(banco.get(i).calculaSalario());
			else if (cal.get(Calendar.DAY_OF_WEEK) == 2 && banco.get(i).getAgenda() == 4)
				System.out.println(banco.get(i).calculaSalario());			
			else if(cal.get(Calendar.DAY_OF_WEEK) == 6 && banco.get(i).getAgenda() == 5)
				System.out.println(banco.get(i).calculaSalario());
			else if (cal.get(Calendar.WEEK_OF_YEAR) % 2 == 0 && banco.get(i).getAgenda() == 6)
				System.out.println(banco.get(i).calculaSalario());
				
		}
	}

	// ===========================

	public void listarEmpregados() throws NullPointerException {
		for (int i = 0; i < banco.size(); i++) {
			Empregado emp = banco.get(i);
			System.out.println(emp.toString());
			// imprimeEmpregado(emp);
			System.out.println("\n");
		}
	}

	// ===========================

	// METODOS UNDO E REDO FUNCIONALIDADE 8
	public void desfazerUltimaAlteracao() {
		if (!bancoBackup.isEmpty()) {
			bancoAux.addFirst((LinkedList) banco.clone());
			banco = (LinkedList<Empregado>) bancoBackup.getFirst();
			bancoBackup.poll();
		}
		System.out.println(bancoBackup);
		/*
		 * bancoAux.addAll(banco); banco = new LinkedList<Empregado>();
		 * banco.addAll(bancoBackup);
		 * System.out.println("ultima alteracao desfeita " + banco.size());
		 */
	}

	// ===========================

	public void refazerUltimaAlteracao() {

		if (!bancoAux.isEmpty()) {
			banco = (LinkedList<Empregado>) bancoAux.getFirst();
			bancoBackup.addFirst((LinkedList<Empregado>) bancoAux.poll());
		}
		/*
		 * bancoBackup.addAll(banco); banco = new LinkedList<Empregado>();
		 * banco.addAll(bancoAux);
		 * System.out.println("ultima alteracao refeita " + banco.size());
		 */
	}

	public void agendaPagamento() {
		long idAlterar = 0;
		int opcao = 0;
		Empregado emp = null;
		System.out.print("Escolha um Id: ");
		try {
			idAlterar = s.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("Digite um valor valido!");
			s.nextLine();
		}
		boolean encontrado = false;
		for (int i = 0; i < banco.size(); i++) {
			emp = (Empregado) banco.get(i);
			if (emp.getCpf() == idAlterar) {
				encontrado = true;
				break;
			}
		}

		if (encontrado == true) {
			do {
				System.out.print("\nPossibilidades para agendas de pagamento:");
				System.out.print("\n\t1 - mensal 1: dia 1 de todo mes\n");
				System.out.print("\t2 - mensal 7: dia 7 de todo mes\n");
				System.out
						.print("\t3 - mensal $: ultimo dia util de todo mes\n");
				System.out
						.print("\t4 - semanal 1 segunda: toda semana as segundas-feiras\n");
				System.out
						.print("\t5 - semanal 1 sexta: toda semana as sextas-feiras\n");
				System.out
						.print("\t6 - semanal 2 segunda: a cada 2 semanas as segundas-feiras\n");
				System.out.print("Digite uma opcao valida:");
				try {
					opcao = s.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Digite um valor valido!");
					s.nextLine();
				}
			} while (opcao < 1 || opcao > 6);
			emp.setAgenda(opcao);
			System.out.println("\n\nAlterado");
		} else
			System.out.println("\nEmpregado nao encontrado!\n");

	}

}
