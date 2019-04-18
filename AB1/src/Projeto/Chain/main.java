package Projeto.ObserverTest;

public class main {
	public static void main(String[] args) {
		BancoChain bancos = null;;
		int i = 0;
		if (i == 0)
			bancos = new BancoA();
		else if (i == 1)
			bancos = new BancoB();
		else if (i == 2)
			bancos = new BancoC();
		else if (i == 3)
			bancos = new BancoD();
			
		/*
	    BancoChain bancos = new BancoA();
	    bancos.setNext(new BancoB());
	    bancos.setNext(new BancoC());
	    bancos.setNext(new BancoD());
	     */
	    try {
	    	bancos.efetuaPagamento();
	       // bancos.efetuarPagamento(IDBancos.bancoC);
	       // bancos.efetuarPagamento(IDBancos.bancoD);
	       // bancos.efetuarPagamento(IDBancos.bancoA);
	       // bancos.efetuarPagamento(IDBancos.bancoB);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
