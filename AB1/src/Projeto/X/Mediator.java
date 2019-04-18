package Projeto.X;

public interface Mediator {
	
	public void oferecerVoo(String nomeEmpresa, Aviao aviao, String origem, String destino);
	
	public void retirarVoo(Aviao aviao);

	public void addColleague(Colleague colleague);
	
	public void vender(int numeroViagem);
	
}