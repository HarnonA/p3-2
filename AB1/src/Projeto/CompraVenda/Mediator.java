package Projeto.CompraVenda;

public interface Mediator {
	
	public void oferecerVoo(String nomeEmpresa, Aviao aviao, String origem, String destino);
	
	public void retirarVoo(int index, String nome);

	public void addColleague(Colleague colleague);
	
	public void vender(int numeroViagem);
	
}