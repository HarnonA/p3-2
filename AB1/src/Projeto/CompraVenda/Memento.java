package Projeto.CompraVenda;

import java.util.LinkedList;

public class Memento {
	protected LinkedList<ColleaguMediator> estados;

	public Memento() {
		estados = new LinkedList<ColleaguMediator>();
	}

	public void addNovo(ColleaguMediator mediador) {
		estados.add(mediador);

	}

	public void removeEstado() {
		estados.poll();
	}

	public LinkedList v() {
		String s = "";
		s = estados.toString();
		return estados;

	}

}
