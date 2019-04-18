package Folhapagamento;

import java.util.ArrayList;

public class FolhaPagamento {
	
	private ArrayList folhaPagamento;
	private Empregado empregado;
	
	public FolhaPagamento(){
		this.empregado = empregado;
		folhaPagamento = new ArrayList();		
	}
	

	
	public void addEmpregado(Object empregado){
		folhaPagamento.add(empregado);

		
	}
	
	public void a(){
		for(int i = 0; i < folhaPagamento.size(); i++){
			System.out.println( folhaPagamento.get(i));
		}
		
		
	}
	
	public void pagaEmpregados(int dia){
		for(int i = 0; i < folhaPagamento.size(); i++){
			Empregado obj = (Empregado)folhaPagamento.get(i);

			if( obj instanceof Horista){
				if(dia == 6 || dia ==13 || dia == 20 || dia == 27){
					System.out.println("Horista Pago! - ");						
				}
			
			}else if( obj instanceof Comissionado){
				Comissionado emp = (Comissionado) folhaPagamento.get(i);
				if(dia == 13 || dia == 27){
					System.out.println("Comissionado Pago!");
				}
			
			}else{
				if(dia == 30)
					System.out.println("Assalariado Pago!");
			}
			System.out.println("Salario " + obj.getSalario());
		}
	}
	
	
	public String toString(){
		String result = "";
		for (int i = 0; i < folhaPagamento.size(); i++) {
			Empregado empreg = (Empregado) folhaPagamento.get(i);
			result += empreg.toString() + "\n";
		}
		return result;
		
	}
	

}
