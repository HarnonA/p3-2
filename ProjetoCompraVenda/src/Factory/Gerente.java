package Factory;

import java.util.Scanner;
import Mediator.*;
import Prototype.Aviao;

public class Gerente extends Usuario {

	public Gerente() {

		System.out.println("Ola gerente");
	}

	public Gerente(String cpf, String nome, String endereco, String fone,
			String senha) {
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
		setSenha(senha);
		setFone(fone);

	}

	@Override
	public void executa(ColleaguMediator m) {
		Scanner scnr = new Scanner(System.in);
		int n = 0;

		do {
			System.out.println("Ola gerente " + super.getName());
			System.out.println("1 - Oferecer voo");
			System.out.println("2 - Listar frota");
			System.out.println("3 - Mostrar voos");
			System.out.println("4 - Remover voo");

			n = scnr.nextInt();
			Colleague empresa = null;
			if (getName().equals("Tam")) {
				Emp_Tam tam = (Emp_Tam) m.getTam();
				empresa = tam;
			} else if (getName().equals("Gol")) {
				empresa = (Emp_Gol) m.getGol();
			} else if (getName().equals("Azul")) {
				Emp_Azul azul = (Emp_Azul) m.getAzul();
				empresa = azul;
			}
			if (n == 1) {

				scnr.nextLine();
				String origem, destino;
				System.out.println("Origem");
				origem = scnr.nextLine();
				System.out.println("Destino");
				destino = scnr.nextLine();
				empresa.mostrar();
				System.out.println("Escolha o aviao");
				int nAviao = 0;
				do{
					scnr.nextInt();
				}while(nAviao> empresa.tamanho());
				Aviao a = empresa.getAviao(nAviao);
				
				
				empresa.oferecerVoo(empresa.getNome(), a, origem, destino);

				System.out.println("Viagem disponivel para venda");
				//m.agenda();
			} else if (n == 2) {
				empresa.mostrar();
			} else if (n == 3) {
				m.mostrarVooEmpresa(empresa.getNome());
			} else if (n == 4){
				m.mostrarVooEmpresa(empresa.getNome());
				System.out.println("Escolha voo pelo numero");
				m.retirarVoo(scnr.nextInt(), empresa.getNome());
			}
			

		} while (n != 0);

	}

}
