package Projeto;

public interface Mediator {
	void comprarPorEmpresa(EmpresaAerea e);
	void comrarPorDestino(String destino);
	void comprarPorSaida(String saida);
	void comprarRota(String destino, String chegada);

}
