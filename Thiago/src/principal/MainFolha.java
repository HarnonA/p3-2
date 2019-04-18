package principal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainFolha {
	private static Scanner s;

	public static void main(String[] args) throws IOException{
		s = new Scanner(System.in);	
		boolean continuar = true;
		int escolha = -1;
		int op=0;
		bancoDados b1 = new bancoDados();				
		do{
			try{
				System.out.println("\t1. Adicionar um empregado.\t2. Remover um empregado.\n"
									+ "\t3. Lancar um Cartao de Ponto.\t4. Lancar um resultado de venda.\n"
									+ "\t5. Lancar uma taxa de servico.\t6. Alterar detalhes de um empregado\n"
									+ "\t7. Rodar folha de pagamento.\t8.Listar empregados.\n"
									+ "\t9. Undo/Redo\t\t\t0. Sair.");			
				escolha = s.nextInt();
				s.nextLine();
				}catch(InputMismatchException e){
					System.out.println("Valor; invalido! Digite uma opcao valida:\n");
					s.nextLine();
			}
			if(escolha==0)
				continuar = false;
			else{
				switch(escolha){
				case 1:
					b1.adicionarEmpregado();
					break;
				case 2:
					b1.removerEmpregado();
					break;
				case 3:
					b1.lancarCartao();
					break;
				case 4:
					b1.lancarVenda();
					break;
				case 5:
					b1.lancarServico();
					break;
				case 6:
					b1.alterarEmpregado();
					break;
				case 7:
					b1.folhaPagamento();
					break;
				case 8:
					b1.listarEmpregados();
					break;
				case 9:
					do{	
						try{
							System.out.println("1 - Desfazer a ultima operacao || 2 - Refazer a ultima operacao");
							op = s.nextInt();// FAZER TRATAMENTO
						}catch (InputMismatchException e){
							System.out.println("Digite um valor valido!");
							s.nextLine();
							continuar = false;
						}
					}while(op>2||op<1);
					if(op==1)
						b1.desfazerUltimaAlteracao();
					else 
						b1.refazerUltimaAlteracao();
				
				}
				
			}
		}while(continuar);
	}
}