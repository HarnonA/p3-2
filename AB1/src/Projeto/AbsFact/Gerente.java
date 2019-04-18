package Projeto.AbsFact;

import java.util.LinkedList;
import java.util.Scanner;

public class Gerente extends Usuario {
	
	public Gerente(){
				
		System.out.println("Ola gerente");
	}
	
	public Gerente(String cpf, String nome, String endereco, String fone, String senha){
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
		setSenha(senha);
		setFone(fone);
		
	}

	@Override
	public void executa(){
		Scanner scnr = new Scanner(System.in);
		int n = 0;
		
		do{
			System.out.println("Executando Gerente");
			 n = scnr.nextInt();
			if( n == 1){
				System.out.println("ok");
			}
			if(n==0)
				return;
			
			
		}while(n != 0);
		
	}


	
}
