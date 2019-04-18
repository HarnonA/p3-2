package Projeto.CompraVenda;

import java.util.Scanner;

public class Cliente extends Usuario {

	public Cliente() {

		System.out.println("Ola cliente");
	}

	public Cliente(String cpf, String nome, String endereco, String fone,
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
		// scnr.nextLine();
		int n = 0;
		do {
			System.out.println("Ola Cliente " + super.getName());
			System.out.println("Escolha opçcao:");
			System.out.println("1 - Lista de Voos");
			System.out.println("2 - Comprar viajem");
			System.out.println("0 - Sair");

			n = scnr.nextInt();
			System.out.println(n);

			if (n == 1) {
				m.agenda();
			} else if (n == 2) {
				System.out.println("Escolha numero da viajem");
				int e = scnr.nextInt();
				m.vender(e);
			}

		} while (n != 0);

	}

	public String toString() {
		String s = "";
		s += "Cliente " + super.toString();
		return s;
	}

}