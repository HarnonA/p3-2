package Folhapagamento;


import java.util.Calendar;

public class Main {
	public static void main(String[] args) {
		
		
//		System.out.println(); 

		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
		
		
		double salarioMensal = 1500;
		Empregado empregado = new Horista("Joao", "rua tal",0 , 42);
		Empregado empregado1 = new Assalariado("pedro", "rua x", 1, salarioMensal);
		
		Comissionado f = new Comissionado("maria", "rua otra", 1, salarioMensal, 0.1);
		//Empregado empregado2 = new Comissionado("maria", "rua otra", 1, salarioMensal, 0.1);
		f.vendaEfetivada(200);
		
		Empregado empregado2 = f;
		
		
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		
		folhaPagamento.addEmpregado(empregado);
		folhaPagamento.addEmpregado(empregado1);
		folhaPagamento.addEmpregado(empregado2);
		
		//folhaPagamento.pagaEmpregados(c.get(Calendar.DAY_OF_MONTH));
		folhaPagamento.pagaEmpregados(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.getFirstDayOfWeek());
		
		//folhaPagamento.a();
		//System.out.println(folhaPagamento.toString());
		//System.out.println(empregado.toString());
		//System.out.println(empregado1.toString());
		
	
	
	}
}
