package principal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import empregado.Assalariado;
import empregado.Comissionado;
import empregado.Empregado;
import empregado.Horista;

public class bancoDados {
	ArrayList<Empregado> banco;//BANCO COM DADOS DE EMPREGADOS
	ArrayList<Empregado> bancoBackup;//BANCO COM DADOS DE EMPREGADOS
	ArrayList<Empregado> bancoAux;//BANCO COM DADOS DE EMPREGADOS
	
	private boolean continuar; 
	Scanner s = new Scanner(System.in);
	
	long cpf = 0, idSindi = 0;
	int tipoPag = 0, op = 0, tipoEmpre=0;
	float taxaSindi = 0, salario = 0, comissao = 0;
	boolean sindicato;
	String nome, endereco;
	
	DateFormat dataf = new SimpleDateFormat("dd/MM/yyyy");    
	Calendar c = Calendar.getInstance();
	
	final float impostos = 100;//supoe que os impostos ao todo custa 100
	
	
	//CONSTRUTOR
	public bancoDados(){
		banco = new ArrayList<Empregado>();
		bancoBackup = new ArrayList<Empregado>();//BANCO COM DADOS DE EMPREGADOS
		bancoAux = new ArrayList<Empregado>();
	}
	
	//METODO CRIAR UM EMPREGADO
	public Empregado criarEmpregado(){
		Empregado emp = null;
		//cpf=+1;
		do{
			continuar = false;
			try{
				do{
					System.out.println("Digite CPF do empregado: ");
					cpf = s.nextLong();
				}while(cpf<0);
				for (int i = 0; i < banco.size(); i++) {
					emp = banco.get(i);
					if(cpf==emp.getCpf()){
						System.out.println("CPF cadastrado!");
						return null;
					}
				}
			}catch (InputMismatchException e){
				System.out.println("Digite um valor valido!");
				s.nextLine();
				continuar =true;
			}
		}while(continuar);
	
		s.nextLine();
		System.out.println("Digite o nome do empregado:");
		nome = s.nextLine();		
		System.out.println("Digite o endereco do empregado:");
		endereco = s.nextLine();
		
		do{
			try{
				System.out.println("Metodo de pagamento:\n1 - Receber cheque pelos correios\n2 - Receber cheque em maos\n3 - Deposito em conta bancaria");
				tipoPag = s.nextInt();
			}catch (InputMismatchException e){
				System.out.println("Digite um valor valido!");
				s.nextLine();
			}
		}while(tipoPag>3||tipoPag<1);
		do{	
			try{
				System.out.println("Faz parte de sindicato? 1 - Sim || 2 - Nao");
				op = s.nextInt();// FAZER TRATAMENTO
			}catch (InputMismatchException e){
				System.out.println("Digite um valor valido!");
				s.nextLine();
				continuar = false;
			}
		}while(op>2||op<1);
		if(op == 1){
			sindicato = true;
			do{
				continuar = false;
				try{
					System.out.println("Digite seu ID no sindicato: ");
					idSindi = s.nextLong();
				}catch (InputMismatchException e){
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar =true;
				}
			}while(continuar);
			do{
				continuar = false;
				try{
					System.out.println("Digite a taxa sindical:");
					taxaSindi = s.nextFloat();
				}catch (InputMismatchException e){
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar = true;
				}
			}while(continuar);
		}
		else 
			sindicato = false;
		do{		
			try{	
				System.out.println("Tipo de empregado:\n1 - Horista\n2 - Assalariado\n3 - Comissionado");
				tipoEmpre = s.nextInt() ;
			}catch (InputMismatchException e){
				System.out.println("Digite um valor valido!");
				s.nextLine();
			}
		}while(tipoEmpre>3||tipoEmpre<1);
		switch(tipoEmpre){
			case 1:
				do{
					continuar = false;
					try{
						System.out.println("Digite o salario horario:");
						salario = s.nextFloat();
					}catch (InputMismatchException e){
						System.out.println("Digite um valor valido!");
						s.nextLine();
						continuar = true;
					}
				}while(continuar);
				emp = new Horista(cpf, idSindi, tipoPag, taxaSindi, nome, endereco, sindicato, salario);
				break;
			case 2:
				do{
					continuar = false;
					try{
						System.out.println("Digite o salario horario fixo:");
						salario = s.nextFloat();
					}catch (InputMismatchException e){
						System.out.println("Digite um valor valido!");
						s.nextLine();
						continuar = true;
					}
				}while(continuar);
				emp  = new Assalariado(cpf, idSindi, tipoPag, taxaSindi, nome, endereco, sindicato, salario);
				break;
			case 3:
				do{
					continuar = false;
					try{
						System.out.println("Digite o salario horario fixo:");
						salario = s.nextFloat();
					}catch (InputMismatchException e){
						System.out.println("Digite um valor valido!");
						s.nextLine();
						continuar = true;
					}
				}while(continuar);
				do{
					continuar = false;
					try{
						System.out.println("Digite o valor da comissao:");
						comissao = s.nextFloat();
					}catch (InputMismatchException e){
						System.out.println("Digite um valor valido!");
						s.nextLine();
						continuar = true;
					}
				}while(continuar);
				emp  = new Comissionado(cpf, idSindi, tipoPag, taxaSindi, nome, endereco, sindicato, salario, comissao);
				break;
			default:
				System.out.println("Tipo de empregado invalido!");
		}
		return emp;
	}
	
	//METODO ADICIONAR UM EMPREGADO FUNCIONALIDADE 1
	public void adicionarEmpregado(){
		bancoBackup.addAll(banco);
		Empregado emp = criarEmpregado();
		banco.add(emp);
		//System.out.println("Tama " + banco.size());
	}
	
	//METODO IMPRIME UM USUARIO
	public void imprimeEmpregado (Empregado emp){
		System.out.println("Nome: "+emp.getNome());
		System.out.println("Endereco: "+emp.getEndereço());
		System.out.println("Metodo de pagamento:");
		if(emp.getMetodoPag()==1){
			System.out.println("\tRecebe cheque pelos correios.");
		} else if(emp.getMetodoPag()==2){
			System.out.println("\tRecebe cheque em maos.");
		}else System.out.println("\tDeposito em conta bancaria.");
		if(emp.isSindicato()==true){
			System.out.println("Empregado pertence ao sindicato.");
			System.out.println("Id do sindicato: "+emp.getIdSind());
			System.out.println("Taxa sindical: "+emp.getTaxaSindical());
		}
		else System.out.println("Empregado nao pertence ao sindicato");
		if(emp instanceof Assalariado)
			System.out.println("Empregado Assalariado.");
		else if(emp instanceof Horista)
			System.out.println("Empregado Horista.");
		else System.out.println("Empregado Comissionado");
		
	}
	//METODO BUSCAR UM EMPREGADO
	public Empregado buscarEmpregado(){
		do{
			continuar = false;
			try{
				System.out.println("Digite CPF do empregado: ");
				cpf = s.nextLong();
			}catch (InputMismatchException e){
				System.out.println("Digite um valor valido!");
				s.nextLine();
				continuar =true;
			}
		}while(continuar);
		for (int i = 0; i < banco.size(); i++) {
			Empregado emp = banco.get(i);
			if(emp.getCpf()==cpf){
				return emp;
			}
		}
		return null;		
	}
		
	//METODO REMOVER UM EMPREGADO FUNCIONALIDADE 2
	public void removerEmpregado(){
		bancoBackup.addAll(banco);
		Empregado emp = buscarEmpregado();
		int op=0;
		if(emp==null)
			System.out.println("Empregado nao encontrado!");
		else{
			do{
				continuar = false;
				try{	
					System.out.println("Deseja remover o empregado? 1 - SIM || 2 - NAO");
					op = s.nextInt() ;
				}catch (InputMismatchException e){
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar = true;
				}
			}while(op>2||op<1);
			if(op==1){
				banco.remove(emp);
				System.out.println("Empregado Removido!");
				return;
			}
			else System.out.println("Empregado nao removido!");	
		}
	}
	
	//METODO LANCAR CARTAO DE PONTO FUNCIONALIDADE 3
	public void lancarCartao(){
		bancoBackup.addAll(banco);
		do{
			continuar = false;
			try{
				System.out.println("Digite CPF do empregado: ");
				cpf = s.nextLong();
			}catch (InputMismatchException e){
				System.out.println("Digite um valor valido!");
				s.nextLine();
				continuar =true;
			}
		}while(continuar);
		Horista horista = null;
		for (int i = 0; i < banco.size(); i++) {
			if(cpf == banco.get(i).getCpf()){
				if(banco.get(i) instanceof Horista){
					horista = (Horista) banco.get(i);
					horista.setDataEntrada(dataf.format(c.getTime()));
					System.out.println("Data de entrada: "+horista.getDataEntrada());
					do{
						continuar = false;
						try{
							System.out.println("Digite a a quantidade de horas:");
							horista.setHorasDiarias(s.nextInt());
						}catch (InputMismatchException e){
							System.out.println("Digite um valor valido!");
							s.nextLine();
							continuar = true;
						}
					}while(continuar);
					return;
				}
			}
		} System.out.println("Empregado nao encontrado!");
	}
		
	//METODO QUE LANCA UMA VENDA
	public void lancarVenda(){
		bancoBackup.addAll(banco);
		float venda1 = 0, venda2 = 0;
		do{
			continuar = false;
			try{
				System.out.println("Digite CPF do empregado: ");
				cpf = s.nextLong();
			}catch (InputMismatchException e){
				System.out.println("Digite um valor valido!");
				s.nextLine();
				continuar =true;
			}
		}while(continuar);
		Comissionado comissionado = null;
		for (int i = 0; i < banco.size(); i++) {
			if(cpf==banco.get(i).getCpf()){	
				if(banco.get(i) instanceof Comissionado){
					comissionado = (Comissionado) banco.get(i);
					venda1 = comissionado.getVendas();
					do{
						continuar = false;
						try{						
							System.out.println("Digite o valor da venda:");
							venda2 = s.nextFloat();
						}catch (InputMismatchException e){
							System.out.println("Digite um valor valido!");
							s.nextLine();
							continuar = true;
						}
					}while(continuar);
					comissionado.setVendas(venda1+venda2);
					return;
				}
			}
		} System.out.println("Empregado nao encontrado!");
		
	}
	
	//METODO PARA LANCAR UMA TAXA DE SERVICO A UM EMPREGADO FUNCIONALIDADE 5
	public void lancarServico(){
		bancoBackup.addAll(banco);//FAZ O BACKUP
		Empregado emp = buscarEmpregado();
		if(emp!=null){
			do{
				continuar = false;
				try{
					System.out.println("Digite o valor da taxa de servico: ");
					emp.setTaxaServico(s.nextFloat());
				}catch (InputMismatchException e){
					System.out.println("Digite um valor valido!");
					s.nextLine();
					continuar = true;
				}
			}while(continuar);
		}else System.out.println("Empregado nao encontrado!");
	}
	
	//METODO QUE ALTERA OS DADOS DO EMPREGADO FUNCIONALIDADE 6
	public void alterarEmpregado(){
		bancoBackup.addAll(banco);
		
		int aux=-1;
		Empregado emp = buscarEmpregado();
		boolean cont = true;
		
		if(emp!=null){
			do{
				try {
					imprimeEmpregado(emp);
					System.out.println("\nAlterar?\n1 - Nome\n2 - Endereco\n3 - Metodo de pagamento\n4 - Pertence ao sindicato\n"
							+ "5 - Identificacao do sindicato\n6 - Taxa Sindical\n7 - Tipo Empregado\n0 - Sair");
					aux = s.nextInt();
				} catch(InputMismatchException e){
					System.out.println("Digite um valor valido!");
					s.nextLine();
				}				
			if(aux==0){
				cont = false;
			}
			else{
				s.nextLine();
				switch(aux){
					case 1:
						System.out.println("Digite o nome: ");
						emp.setNome(s.nextLine());
						break;
					case 2:
						System.out.println("Digite o endereco: ");
						emp.setEndereço(s.nextLine());
						break;
					case 3:
						do{
							try{
								System.out.println("Metodo de pagamento:\n1 - Receber cheque pelos correios\n2 - Receber cheque em maos\n3 - Deposito em conta bancaria");
								tipoPag = s.nextInt();
								emp.setMetodoPag(tipoPag);
							}catch (InputMismatchException e){
								System.out.println("Digite um valor valido!");
								s.nextLine();
							}
						}while(tipoPag>3||tipoPag<1);
						break;
					case 4:
						do{	
							try{
								System.out.println("Faz parte de sindicato? 1 - Sim || 2 - Nao");
								op = s.nextInt();// FAZER TRATAMENTO
							}catch (InputMismatchException e){
								System.out.println("Digite um valor valido!");
								s.nextLine();
								continuar = false;
							}
						}while(op>2||op<1);
						if(op==1){
							emp.setSindicato(true);
							do{
								continuar = false;
								try{
									System.out.println("Digite seu ID no sindicato: ");
									emp.setIdSind(s.nextLong());
								}catch (InputMismatchException e){
									System.out.println("Digite um valor valido!");
									s.nextLine();
									continuar =true;
								}
							}while(continuar);
							do{
								continuar = false;
								try{
									System.out.println("Digite a taxa sindical:");
									emp.setTaxaSindical(s.nextFloat());
								}catch (InputMismatchException e){
									System.out.println("Digite um valor valido!");
									s.nextLine();
									continuar = true;
								}
							}while(continuar);
							break;
						}
						else{
							emp.setSindicato(false);
							emp.setIdSind(0);
							emp.setTaxaSindical(0);
							break;
						}
					case 5:
						if(emp.isSindicato()==true){
							do{
								continuar = false;
								try{
									System.out.println("Digite seu ID no sindicato: ");
									emp.setIdSind(s.nextLong());
								}catch (InputMismatchException e){
									System.out.println("Digite um valor valido!");
									s.nextLine();
									continuar =true;
								}
							}while(continuar);
							
						} 
						else 
							{
								System.out.println("Empregado nao faz parte de sindicato!");
								
							}
						break;
					case 6:
						if(emp.isSindicato()==true){
							do{
								continuar = false;
								try{
									System.out.println("Digite a taxa sindical:");
									emp.setTaxaSindical(s.nextFloat());
								}catch (InputMismatchException e){
									System.out.println("Digite um valor valido!");
									s.nextLine();
									continuar = true;
								}
							}while(continuar);
						}else System.out.println("Empregado nao faz parte de sindicato!");
						break;					
				}
			}
			}while(cont);
		}else System.out.println("Empregado nao encontrado!");
		
	}
	
	
	//METODO QUE CALCULA O ULTIMO DIA DO MES
		public Calendar calculaUltimoDiaUtilMes(Calendar calendar){
			calendar.add(Calendar.MONTH, 1);  
		    calendar.set(Calendar.DAY_OF_MONTH, 1);  
		    calendar.add(Calendar.DATE, -1);
		    //enquanto for sábado, domingo
		    while(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){
		        //decrementa a data em um dia
		        calendar.add(Calendar.DATE, -1);            
		    }
		    return calendar;
		}
		
		//METODO QUE CALCULA O SALARIO DE UM EMPREGADO ASSALARIADO
		public void calculaSalarioAssalariado(Assalariado emp){
			float deducoes;
			deducoes = impostos + emp.getTaxaSindical()+emp.getTaxaServico();
			emp.setSalarioLiquido(emp.getSalarioFixo() - deducoes);
			System.out.println("Nome: "+emp.getNome());
			System.out.println("Endereco: "+emp.getEndereço());
			System.out.println("Salario Liquido: "+emp.getSalarioLiquido());

			emp.setSalarioLiquido(0);
		}
		
		public void calculaSalarioComissionado(Comissionado emp){
			float deducoes;
			deducoes = impostos + emp.getTaxaServico() + emp.getTaxaSindical();
			float comissao, salario, venda, salarioTotal;
			comissao = emp.getComissao();
			salario = emp.getSalarioFixo();
			venda = emp.getVendas();
			salarioTotal = (venda*(comissao/100))+salario;
			emp.setSalarioLiquido(salarioTotal - deducoes);
			System.out.println("Nome: "+emp.getNome());
			System.out.println("Endereco: "+emp.getEndereço());
			System.out.println("Salario Liquido: "+emp.getSalarioLiquido());

			emp.setSalarioLiquido(0);
		}
		
		public void calculaSalarioHorista(Horista emp){
			float deducoes;
			deducoes = impostos + emp.getTaxaServico() + emp.getTaxaSindical();
			int somaHora = 0, horaExtra =0;
			float salarioExtra = 0, salarioTotal = 0, salarioHora = 0, salarioNormal = 0;
			for(int i = 0; i<7; i++){
				somaHora = somaHora + emp.getHorasDiarias(i);
			}
			horaExtra = somaHora - 56; //8horas diarias durante os 7 dias da semana
			salarioHora = emp.getSalarioHora();
			salarioExtra = (float) (salarioHora*(1.5/100)*horaExtra);
			salarioNormal = 56*salarioHora;
			salarioTotal = salarioNormal+salarioExtra;
			emp.setSalarioLiquido(salarioTotal-deducoes);
			System.out.println("Nome: "+emp.getNome());
			System.out.println("Endereco: "+emp.getEndereço());
			System.out.println("Salario Liquido: "+emp.getSalarioLiquido());
			emp.setSalarioLiquido(0);
			
		}

	//METODO QUE RODA A FOLHA DE PAGAMENTO DO DIA FUNCIONALIDADE 7
	public void folhaPagamento(){
		bancoBackup.addAll(banco);
		DateFormat DF = new SimpleDateFormat("dd");
	    Calendar cal = Calendar.getInstance();
	    Calendar ultimoDiaUtilDoMes = calculaUltimoDiaUtilMes(c);
	    int ultimoDiaUtil = Integer.parseInt(DF.format(ultimoDiaUtilDoMes.getTime()));
	    int diaAtual =  cal.get(Calendar.DAY_OF_MONTH);;
	    String [] meses = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		System.out.println("Mes: " + meses[c.get(Calendar.MONTH)]);
		System.out.println("Dia: " + diaAtual);
		for (int i = 0; i < banco.size(); i++) {
			if(banco.get(i) instanceof Assalariado){
				Assalariado assa = (Assalariado) banco.get(i);
				if(diaAtual == ultimoDiaUtil){
					calculaSalarioAssalariado(assa);
				}
			}else if(banco.get(i) instanceof Comissionado){
				Comissionado comi = (Comissionado) banco.get(i);
				if(cal.get(Calendar.WEEK_OF_YEAR)%2==0 && cal.get(Calendar.DAY_OF_WEEK)==6)//SO É PAGO NAS SEMANAS PARES, JA QUE ELE É PAGO A CADA DUAS SEXTAS
				{
					calculaSalarioComissionado(comi);
				}
			}
			else if(banco.get(i) instanceof Horista){
				Horista hori = (Horista) banco.get(i);
				if(cal.get(Calendar.DAY_OF_WEEK)==6){
					calculaSalarioHorista(hori);
				}
			}
			
		}
	}
	
	public void listarEmpregados(){
		for (int i = 0; i < banco.size(); i++) {
			Empregado emp = banco.get(i);
			imprimeEmpregado(emp);
			System.out.println("\n");
		}
	}
	//METODOS UNDO E REDO FUNCIONALIDADE 8
	public void desfazerUltimaAlteracao(){
		bancoAux.addAll(banco);
		banco=new ArrayList<Empregado>();
		banco.addAll(bancoBackup);
		System.out.println("ultima alteracao desfeita " + banco.size());
	}
	
	public void refazerUltimaAlteracao(){
		bancoBackup.addAll(banco); 
		banco = new ArrayList<Empregado>();
		banco.addAll(bancoAux);
		System.out.println("ultima alteracao refeita " + banco.size());
	}
}
