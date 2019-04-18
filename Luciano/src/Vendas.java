

import java.util.Calendar;	//Classe do Java para data

public class Vendas {
	
	private Calendar dataVenda;		//data do sistema
	private float valorVenda;		//valor da venda que sera armazenado no array
									//do empregado
	
	//Nao precisa de metodos get e set pois os dados ficaram armazenados
	//no ArrayList
	
	public Vendas(float valorDaVenda){
		this.dataVenda = Calendar.getInstance();
		this.valorVenda = valorDaVenda;
	}

}
 