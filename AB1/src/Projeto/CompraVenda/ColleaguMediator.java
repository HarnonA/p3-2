package Projeto.CompraVenda;

import java.util.ArrayList;
import java.util.Scanner;

public class ColleaguMediator implements Mediator {

	private ArrayList<Colleague> colleagues;
	private ArrayList<Oferta> vooDisponiveis;
	private ArrayList<Aviao> frota;
	private int colleagueID = 0;

	public ColleaguMediator() {

		colleagues = new ArrayList<Colleague>();
		vooDisponiveis = new ArrayList<Oferta>();
		frota = new ArrayList<Aviao>();
	}

	public void addColleague(Colleague newColleague) {
		colleagues.add(newColleague);

	}

	@Override
	public void oferecerVoo(String nomeEmpresa, Aviao aviao, String o, String d) {

		Oferta oferta = new Oferta(nomeEmpresa, aviao, ++colleagueID);
		vooDisponiveis.add(oferta);

		Aviao a = aviao;// .prototipo();
		a.marcarViajem(o, d);
		frota.add(a);

	}

	@Override
	public void retirarVoo(int i, String n) {
		if(vooDisponiveis.get(i-1).getNome().equals(n)){
			vooDisponiveis.remove(i-1);
			System.out.println("Voo removido");
		}
		else
			System.out.println("Nao tem acesso");
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
			a.mostrarPoltronas();
			System.out.println("Escolha Fila e coluna");
			Scanner scanner = new Scanner(System.in);
			int fila, coluna;
			fila = scanner.nextInt();
			coluna = scanner.nextInt();

			a.marcarPoltrono(fila, coluna);
			// a.mostrarPoltronas();

		}
	}

	public Colleague getTam() {
		for (int i = 0; i < colleagues.size(); i++) {
			if (colleagues.get(i).getNome().equals("Tam")) {
				return colleagues.get(i);
			}

		}
		return null;
	}

	public Colleague getGol() {
		for (int i = 0; i < colleagues.size(); i++) {
			if (colleagues.get(i).getNome().equals("Gol")) {
				return colleagues.get(i);
			}

		}
		return null;
	}

	public Colleague getAzul() {
		for (int i = 0; i < colleagues.size(); i++) {
			if (colleagues.get(i).getNome().equals("Azul")) {
				return colleagues.get(i);
			}

		}
		return null;
	}

	public void mostrarVooEmpresa(String s) {
		for (int i = 0; i < vooDisponiveis.size(); i++) {
			if (vooDisponiveis.get(i).getNome().equals(s))
				System.out.println(vooDisponiveis.get(i).toString());

		}

	}

}
