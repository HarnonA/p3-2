package Projeto.X;

import java.util.ArrayList;

import Projeto.MediatorYoutube.StockOffer;

public class StockMediator implements Mediator {

	private ArrayList<Colleague> colleagues;
	private ArrayList<Oferta> vooDisponiveis;
	private ArrayList<Aviao> disp; 
	

	private int colleagueID = 0;

	public StockMediator() {

		colleagues = new ArrayList<Colleague>();
		vooDisponiveis = new ArrayList<Oferta>();
		disp = new ArrayList<Aviao>();
	}

	public void addColleague(Colleague newColleague) {
		colleagues.add(newColleague);
		//colleagueID++;
		//newColleague.setId(colleagueID);

	}

	@Override
	public void oferecerVoo(String nomeEmpresa, Aviao aviao, String o, String d) {
		//String o = "Rio";
		//String d = "Sao Paulo";
		
		Oferta oferta = new Oferta(nomeEmpresa, aviao, ++colleagueID);
		vooDisponiveis.add(oferta);
		
		
		Aviao x = aviao;//.prototipo();
		x.marcarViajem(o, d);
		disp.add(x);
		
		
		//stockSaleOffers.add(a);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirarVoo(Aviao aviao) {
		System.out.println("Voo cancelado");
		// TODO Auto-generated method stub
		
	}
	
	public void agenda(){
		System.out.println("================");
		for(int i = 0; i < vooDisponiveis.size(); i++){
			Oferta o = vooDisponiveis.get(i);
			System.out.println(o.toString());
		}
		//for(int i = 0; i < disp.size(); i++){
			//Aviao a = disp.get(i);
			//System.out.println(a.toString());
		//}
			
			System.out.println("================");
		
		/*
		System.out.println("================");
		for(int i = 0; i < colleagues.size(); i++){
			Colleague c = colleagues.get(i);
			c.mostrar();
			System.out.println("================");
		}
		*/
	}
	
	public void empresas(){
		System.out.println("================");
		for(int i = 0; i < colleagues.size(); i++){
			Colleague c = colleagues.get(i);
			c.mostrar();
			System.out.println("================");
		}
	}
	/*
	public void getstockOfferings() {

		System.out.println("\nVoos Disponiveis");

		for (Oferta offer : stockSaleOffers) {

			System.out.println(offer.getstockShares() + " of "
					+ offer.getStockSymbol());

		}

		System.out.println("\nStock Buy Offers");

		for (StockOffer offer : stockBuyOffers) {

			System.out.println(offer.getstockShares() + " of "
					+ offer.getStockSymbol());

		}

	}
	*/

	@Override
	public void vender(int numeroViajem) {
		Oferta oferta = null;
		for(int i = 0 ; i < vooDisponiveis.size() ; i++){
			if(numeroViajem == vooDisponiveis.get(i).getCollCode())
				oferta = vooDisponiveis.get(i);
							
		}
		if(oferta != null){
			Aviao a = oferta.getAviao();
			//a.mostrarPoltronas();
			
			a.marcarPoltrono(1, 1);
			//a.mostrarPoltronas();
			
			
		}
		
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	public void oferecerVoo(int shares, String nome) {

		boolean stockSold = false;
		for (StockOffer offer : stockBuyOffers) {

			/*if ((offer.getStockSymbol() == stock)
					&& (offer.getstockShares() == shares)) {

				System.out.println(shares + " shares of " + stock
						+ " sold to colleague code " + offer.getCollCode());

				stockBuyOffers.remove(offer);

				stockSold = true;

			}

			if (stockSold) {
				break;
			}

		}

		if (!stockSold) {

			System.out.println(shares + " shares of "
					+ " added to inventory");

			StockOffer newOffering = new StockOffer( nome);

			stockSaleOffers.add(newOffering);

		}

	}

	public void retirarVoo(String stock, int shares, String nome) {

		boolean stockBought = false;

		for (StockOffer offer : stockSaleOffers) {

			if ((offer.getStockSymbol() == stock)
					&& (offer.getstockShares() == shares)) {

				System.out.println(shares + " shares of " + stock
						+ " bought by colleague code " + offer.getCollCode());

				stockSaleOffers.remove(offer);

				stockBought = true;

			}

			if (stockBought) {
				break;
			}

		}

		if (!stockBought) {

			System.out.println(shares + " shares of " + stock
					+ " added to inventory");

			StockOffer newOffering = new StockOffer(nome);

			stockBuyOffers.add(newOffering);

		}

	}

	public void getstockOfferings() {

		System.out.println("\nVoos Disponiveis");

		for (StockOffer offer : stockSaleOffers) {

			System.out.println(offer.getstockShares() + " of "
					+ offer.getStockSymbol());

		}

		System.out.println("\nStock Buy Offers");

		for (StockOffer offer : stockBuyOffers) {

			System.out.println(offer.getstockShares() + " of "
					+ offer.getStockSymbol());

		}

	}*/
	

	

}
