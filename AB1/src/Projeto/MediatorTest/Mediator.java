package Projeto.MediatorTest;

public interface Mediator {
	void comprarPorEmpresa(Colleague c);
	void comrarPorDestino(String destino);
	void comprarPorSaida(String saida);
	void comprarRota(String destino, String chegada);

}
