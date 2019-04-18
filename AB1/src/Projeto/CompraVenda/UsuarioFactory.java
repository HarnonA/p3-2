package Projeto.CompraVenda;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioFactory{
	Usuario user;
	
	
	public Usuario criarUsuario(String nome, String senha, ArrayList<Usuario> arr){
		for (int i = 0 ; i < arr.size() ; i++) {
			if (nome.equals(arr.get(i).getName())
					&& senha.equals(arr.get(i).getSenha())){
				System.out.println("Localizado");
				return arr.get(i);
			}

		}
		System.out.println("Usuario nao cadastrado");
		System.out.println("Vamos te cadastrar");
		Usuario cliente = null;
		String cpf, endereco, telefone;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("cpf");
		cpf = scanner.nextLine();
		
		System.out.println("Telefone");
		telefone = scanner.nextLine();
		System.out.println("Endereco");
		endereco = scanner.nextLine();
		cliente = new Cliente(cpf, nome, endereco, telefone, senha);
		return cliente;
	
	}
	
	public String toString(){
		return user.toString();
	}
	
}