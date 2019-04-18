package Projeto;

import java.util.ArrayList;

public class ConcreteTransacao implements Mediator {
	
	private ArrayList<EmpresaAerea> empresas;
	
	public ConcreteTransacao(){
		empresas = new ArrayList<EmpresaAerea>();
	}
	
	public void addEmpresa(EmpresaAerea e){
		empresas.add(e);
	}

	@Override
	public void comprarPorEmpresa(EmpresaAerea e) {
		System.out.println("Por empresa");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comrarPorDestino(String destino) {
		System.out.println("Por destino");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comprarPorSaida(String saida) {
		System.out.println("Normal");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comprarRota(String destino, String chegada) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
