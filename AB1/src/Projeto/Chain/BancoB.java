package Projeto.ObserverTest;

public class BancoB extends BancoChain {
	 
    public BancoB() {
        super(IDBancos.bancoB);
    }
 
    @Override
    protected void efetuaPagamento() {
        System.out.println("Pagamento efetuado no banco b");
    }
}