package Projeto.CompraVenda;

import java.util.ArrayList;

public class Observavel implements OSubject {

	private ArrayList<Observer> observers;
	private Colleague tam;
	private Colleague azul;
	private Colleague gol;

	public Observavel() {

		observers = new ArrayList<Observer>();
	}

	public void registra(Observer newObserver) {

		observers.add(newObserver);

	}

	public void retira(Observer deleteObserver) {

		int index = observers.indexOf(deleteObserver);
		System.out.println("Observer " + (index + 1) + " removido");

		observers.remove(index);

	}

	public void notificaObserver() {

		for (Observer observer : observers) {
			observer.update(tam, azul, gol);

		}
	}

	public void setTamObserve(Colleague Tam) {

		this.tam = Tam;

		notificaObserver();

	}

	public void setGolObserve(Colleague Gol) {

		this.gol = Gol;

		notificaObserver();

	}

	public void setAzulObserve(Colleague Azul) {

		this.azul = Azul;

		notificaObserver();

	}

}
