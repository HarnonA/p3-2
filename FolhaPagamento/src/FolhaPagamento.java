import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FolhaPagamento {
	private double salarioMensalMinimo = 724.00;
	private double salarioHorarioMinimo = 3.29;
	private Scanner scanner = new Scanner(System.in);
	private Scanner in;

	// =====================================================
	public int lerInt() {
		in = new Scanner(System.in);
		int inteiro = 0;
		try {
			inteiro = in.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Apenas números inteiros!");
			// e.printStackTrace();
			in.nextLine();
			System.out.print("<Enter>");
			in.nextLine();
			inteiro = -1;
		}
		return inteiro;

	}

// =====================================================
	public double lerDouble() {
		in = new Scanner(System.in);
		double doub = 0;
		try {
			doub = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Apenas números!\n\n");
			// e.printStackTrace();
			in.nextLine();
			System.out.print("<Enter>");
			in.nextLine();
			doub = 0.0;
		}
		return doub;

	}
	
//=====================================================
	public Empregado addEmpregado(int id) {
		int opcao = 0;
		Empregado empregado = new Empregado(0, " ", " ", 0, 0);

		String nome = "";
		String endereco = "";
		double sindicato = 0;
		int tipoPagamento = 0;
		int participa = 0;

		do {
			System.out.println("Escolha opção adicionar Empregado: ");
			System.out.println("1 - Assalariado ");
			System.out.println("2 - Comissionado ");
			System.out.println("3 - Horista ");
			opcao = lerInt();
		} while (opcao <= 0 || opcao >= 4);
		System.out.println("Nome");
		nome = scanner.nextLine();

		System.out.println("Endereco");
		endereco = scanner.nextLine();

		do {
			System.out.println("Paticipa do Sindicato?");
			System.out.println("1 - sim\n2 - nao");
			participa = lerInt();
			if (participa == 1) {
				do {
					System.out.println("Valor do sindicato");
					sindicato = lerDouble();
				} while (sindicato < 0.1);
			}
		} while (participa < 1 || participa > 2);

		do {
			System.out.println("Tipo de pagamento");
			System.out.println("0 - Cheque Correios");
			System.out.println("1 - Cheque em Maos");
			System.out.println("2 - Deposito em conta");
			tipoPagamento = lerInt();
		} while (tipoPagamento < 0 || tipoPagamento > 2);
		
		// ======

		if (opcao == 1) { // Assalariado

			double salario = 0;
			do {
				System.out.println("Salario (>= que salario minimo)");
				salario = lerDouble();
			} while (salario < salarioMensalMinimo);
			
			empregado = new Emp_Assalariado(id, nome, endereco, sindicato,
					tipoPagamento, salario);
		}

		// ======

		else if (opcao == 2) { // Comissionado
			double salario;
			double comissao;

			do {
				System.out.println("Salario");
				salario = lerDouble();
			} while (salario < salarioMensalMinimo);

			do {
				System.out.println("Percentual da comissão, de 0 a 1");
				comissao = lerDouble();
			} while (comissao < 0 || comissao > 1);
			empregado = new Emp_Comissionado(id, nome, endereco, sindicato,
					tipoPagamento, salario, comissao, null, null);
		}

		// ======

		else if (opcao == 3) { // Horista
			empregado = new Emp_Horista(id, nome, endereco, sindicato,
					tipoPagamento, null);

		}
		
		// ======
		
		System.out.println("Usuario cadastrado" + empregado.toString());

		return empregado;
	}

//=======================================================================
	
	public void removeEmpregado(LinkedList listaEmpregados){
		int idRemover;
		boolean encontrado = false;
		Empregado empregado;// = new Empregado(0, "", "", false);

		System.out.println("Remover dados de funcionario");
		System.out.print("Escolha Id de funcionario: ");
		idRemover = lerInt();

		// remove um nó da lista caso o id seja igual ao selecionado
		for (int index = 0; index < listaEmpregados.size(); index++) {
			empregado = (Empregado) listaEmpregados.get(index);
			if (empregado.getId() == idRemover) {
				listaEmpregados.remove(index);
				encontrado = true;
			}
		}
		if (encontrado == false)
			System.out.println("* Id nao existe *");
	}
	
//=======================================================================
	
	public void alterarEmpregado(LinkedList listaEmpregados) {
		int idAlterar;
		int opcao;
		int index = 0;
		boolean encontrado = false;
		Empregado emp = new Empregado(0, "", "", 0, 0);

		System.out.println("Alterar dados de funcionario");
		System.out.print("Escolha Id de funcionario: ");
		idAlterar = lerInt();

		// procura por um id na lista de empregados
		for (index = 0; index < listaEmpregados.size(); index++) {
			emp = (Empregado) listaEmpregados.get(index);
			if (emp.getId() == idAlterar) {
				encontrado = true;
				break;
			}
		}

		if (encontrado == true) {

			System.out.println("1 - Nome");
			System.out.println("2 - Endereço");
			System.out.println("3 - Tipo");
			System.out.println("4 - Metodo pagamento");
			System.out.println("5 - Sindicato");
			System.out.println("6 - Tipo pagamento");
			opcao = lerInt();
			
			// opcao para mudança de campo
			
			// mudar nome
			if (opcao == 1) {
				System.out.println("Novo nome: ");
				emp.alterarNome(scanner.nextLine());
			}

			// mudar endereço
			else if (opcao == 2) {
				System.out.println("Novo endereço: ");
				emp.alterarEndereco(scanner.nextLine());
			}

			// mudar tipo de empregado
			else if (opcao == 3) {

				// dados fixos do empregado sao mantidos
				String nome = emp.getNome();
				String endereco = emp.getEndereco();
				double sindicato = emp.getSindicato();
				int tipoPagamento = emp.getTipoPagamento();
				
				do {
					System.out.println("Novo tipo: ");
					System.out.println("1 - Assalariado ");
					System.out.println("2 - Comissionado ");
					System.out.println("3 - Horista ");
					//opcao = scanner.nextInt();
					opcao = lerInt();
				} while (opcao < 1 || opcao > 3);
				
				// remove cadastro anterior e recria um novo tipo com
				// mesmo id, nome e endereço, opção de sindicato e tipo de
				// pagamento
				listaEmpregados.remove(index);
				if (opcao == 1) {
					System.out.println("Novo Salario: ");
					Empregado empregado = new Emp_Assalariado(idAlterar, nome,
							endereco, sindicato, tipoPagamento, lerDouble());
					listaEmpregados.add(empregado);

				} else if (opcao == 2) {
					System.out.println("Novo Salario e comissao ");
					Empregado empregado = new Emp_Comissionado(idAlterar, nome,
							endereco, sindicato, tipoPagamento, lerDouble(),
							lerDouble(), null, null);
					listaEmpregados.add(empregado);

				} else if (opcao == 3) {
					System.out.println("Horas trabalhadas ");
					Empregado empregado = new Emp_Horista(idAlterar, nome,
							endereco, sindicato, tipoPagamento, null);
							// sindicato, tipoPagamento, scanner.nextDouble());
							
					listaEmpregados.add(empregado);
				} 
			}

			// mudar metodo de pagamento
			else if (opcao == 4) {
				int tipo = 0;
				do {
					System.out.println("Tipo de pagamento");
					System.out.println("0 - Cheque Correios");
					System.out.println("1 - Cheque em Maos");
					System.out.println("2 - Deposito em conta");
					tipo = lerInt();
				} while (tipo < 0 || tipo > 2);
				
				emp.alterarMetodoPagamento(tipo);
			}

			// mudar opçao de sindicato
			else if (opcao == 5) {
				System.out.println("Muda sindicato");
				emp.mudaSindicato();
				System.out.print("<Enter>");
				scanner.nextLine();
								
			}

			// mudar forma pagamento
			else if (opcao == 6) {
				int tipo;
				// tipo = scanner.nextInt();
				do {
					System.out.println("Escolha opção");
					System.out.println("0 - Cheque Correios");
					System.out.println("1 - Cheque em Maos");
					System.out.println("2 - Deposito em conta");
					tipo = lerInt();
				} while (tipo < 0 || tipo > 2);
				emp.mudaTipoPagamento(tipo);
			}
			else{
				System.out.println("Opcao nao existe");
				System.out.print("<Enter>");
				scanner.nextLine();
			}

		} else {
			System.out.println("* Id nao existe *");
			System.out.print("<Enter>");
			scanner.nextLine();
		}
	}

//=======================================================================	
	
	public LinkedList paga(LinkedList listaEmpregados) {

		Calendar calendario = Calendar.getInstance();
		Empregado emp;
		LinkedList lista = new LinkedList();

		int index;

		// procura por todos empregados que devem ser pagos no dia atual
		// diferentes tipos de empregado, sao pagos em diferentes dias
		// int index;
		for (index = 0; index < listaEmpregados.size(); index++) {

			if (listaEmpregados.get(index) instanceof Emp_Assalariado) {
				Emp_Assalariado empregado = (Emp_Assalariado) listaEmpregados
						.get(index);
				emp = empregado;
				lista.add(emp);
				empregado.pagaAssalariado(calendario.get(Calendar.MONTH),
						calendario.get(Calendar.DAY_OF_MONTH));

			} else if (listaEmpregados.get(index) instanceof Emp_Horista) {
				Emp_Horista empregado = (Emp_Horista) listaEmpregados
						.get(index);
				emp = empregado;
				lista.add(emp);
				empregado.pagaHorista(calendario.get(Calendar.DAY_OF_WEEK));

			} else {
				Emp_Comissionado empregado = (Emp_Comissionado) listaEmpregados
						.get(index);
				emp = empregado;
				lista.add(emp);
				empregado.pagaComissionado(
						calendario.get(Calendar.DAY_OF_WEEK_IN_MONTH),
						calendario.get(Calendar.DAY_OF_WEEK));

			}
		}
		return lista;
	}

//=======================================================================
	
	public LinkedList clona(LinkedList listaEmpregados) {
		int index;
		LinkedList retorno = new LinkedList();
		for (index = 0; index < listaEmpregados.size(); index++) {
			Empregado emp = (Empregado) listaEmpregados.get(index);
			retorno.add(emp.clonar());

		}

		return retorno;
	}
		
//=======================================================================
	
	public LinkedList lancarPonto(LinkedList listaEmpregados,
			Calendar calendario) {

		int idEmpProcurado = 0;
		double horas = 0;
		boolean localizado = false;

		System.out.println("Escolha id de empregado Horista");
		idEmpProcurado = lerInt();

		for (int index = 0; index < listaEmpregados.size(); index++) {
			if (listaEmpregados.get(index) instanceof Emp_Horista) {
				Emp_Horista empHorista = (Emp_Horista) listaEmpregados
						.get(index);

				if (idEmpProcurado == empHorista.getId()) {
					localizado = true;
					do {
						System.out.println("Horas trabalhadas no dia (0-23)");
						horas = lerDouble();
					} while (horas < 0 || horas > 23);
					empHorista.setHorasTrabalhadas(horas,
							calendario.get(Calendar.DAY_OF_WEEK) - 1);
				}
			}
		}
		if(localizado == false){
			System.out.println("Id nao existe ou nao horista");
			System.out.print("<Enter>");
			scanner.nextLine();
		}
		
		return listaEmpregados;
	}

//=======================================================================
	
	public void lancarVenda(LinkedList listaEmpregados, Calendar calendario) {
		
		int idEmpProcurado = 0;
		double valorVenda = 0;
		boolean localizado = false;
		String data;
		
		
		
		do {
			System.out.println("Escolha id de empregado comissionado");
			idEmpProcurado = lerInt();
		} while (idEmpProcurado < 0);
		
		for( int index = 0 ; index < listaEmpregados.size() ;index++){
			if( listaEmpregados.get(index) instanceof Emp_Comissionado){				
				Emp_Comissionado empComissionado = (Emp_Comissionado)listaEmpregados.get(index);
										
				if( idEmpProcurado == empComissionado.getId() ){
					localizado = true;
					System.out.println("Valor venda");
					valorVenda = lerDouble();
					data = Integer.toString( calendario.get(Calendar.DAY_OF_MONTH) );
					data += "/" + Integer.toString( calendario.get(Calendar.MONTH) );
					data += "/" + Integer.toString( calendario.get(Calendar.YEAR) );
					System.out.println(data);
					empComissionado.setVenda(data, valorVenda);
				}
			}					
		}
		if(localizado == false){
			System.out.println("Id nao existe ou nao comissionado");
			System.out.print("<Enter>");
			scanner.nextLine();
			
		}
		
	}
	
//=======================================================================
	
	public void taxaServico(LinkedList listaEmpregados) {
		
		int idProcurado;
		double taxa;
		Empregado empregado;
		boolean localizado = false;
		
		System.out.println("Id procurado");
		idProcurado = lerInt();

		for (int index = 0; index < listaEmpregados.size(); index++) {
			empregado = (Empregado) listaEmpregados.get(index);
			if (empregado.getId() == idProcurado) {
				localizado = true;
				System.out.println("Taxa de serviço");
				taxa = lerDouble();
				empregado.addServico(taxa);
			}
		}
		if(localizado == false){
			System.out.println("Id nao existe");
			System.out.print("<Enter>");
			scanner.nextLine();			
		}
	}

//=======================================================================
	
}
