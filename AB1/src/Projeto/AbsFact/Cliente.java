package Projeto.AbsFact;

import java.util.Scanner;

public class Cliente extends Usuario {
	
	public Cliente(){
		
		
		System.out.println("Ola cliente");		
	}
	
	public Cliente(String cpf, String nome, String endereco, String fone, String senha){
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
		setSenha(senha);
		setFone(fone);
		
	}
	
	@Override
	public void executa(){
		Scanner scnr = new Scanner(System.in);
		//scnr.nextLine();
		int n = 0;
		do{
			System.out.println("Executando Cliente");
			n = scnr.nextInt();
			System.out.println(n);
			
			
			if( n == 2){
				System.out.println("Ok");
			}
			
			
		}while(n != 0);
		
	}
	public String toString(){
		String s = "";
		s += "Cliente " + super.toString();
		return s;
	}
	public String getName(){
		return super.getName();
	}
	

	


	
}