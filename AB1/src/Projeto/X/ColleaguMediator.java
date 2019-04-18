package Projeto.X;

import java.util.ArrayList;

public class ColleaguMediator implements Mediator {

	private ArrayList<Colleague> colleagues;
	private ArrayList<Oferta> vooDisponiveis;
	private ArrayList<Aviao> disp;

	Memento memento;

	private int colleagueID = 0;

	public ColleaguMediator() {

		colleagues = new ArrayList<Colleague>();
		vooDisponiveis = new ArrayList<Oferta>();
		disp = new ArrayList<Aviao>();
		memento = new Memento();
	}

	public void addColleague(Colleague newColleague) {
		colleagues.add(newColleague);
		memento.addNovo(this);
		// colleagueID++;
		// newColleague.setId(colleagueID);

	}

	@Override
	public void oferecerVoo(String nomeEmpresa, Aviao aviao, String o, String d) {
		// String o = "Rio";
		// String d = "Sao Paulo";

		Oferta oferta = new Oferta(nomeEmpresa, aviao, ++colleagueID);
		vooDisponiveis.add(oferta);

		Aviao x = aviao;// .prototipo();
		x.marcarViajem(o, d);
		disp.add(x);

	}

	@Override
	public void retirarVoo(Aviao aviao) {
		System.out.println("Voo cancelado");
		// TODO Auto-generated method stub

	}

	public void agenda() {
		System.out.println("================");
		for (int i = 0; i < vooDisponiveis.size(); i++) {
			Oferta o = vooDisponiveis.get(i);
			System.out.println(o.toString());
		}

		System.out.println("================");

	}

	public void empresas() {
		System.out.println("================");
		for (int i = 0; i < colleagues.size(); i++) {
			Colleague c = colleagues.get(i);
			c.mostrar();
			System.out.println("================");
		}
	}

	@Override
	public void vender(int numeroViajem) {
		Oferta oferta = null;
		for (int i = 0; i < vooDisponiveis.size(); i++) {
			if (numeroViajem == vooDisponiveis.get(i).getCollCode())
				oferta = vooDisponiveis.get(i);

		}
		if (oferta != null) {
			Aviao a = oferta.getAviao();
			// a.mostrarPoltronas();

			a.marcarPoltrono(1, 1);
			// a.mostrarPoltronas();

		}
	}
}
