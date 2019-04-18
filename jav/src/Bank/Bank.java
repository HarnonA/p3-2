package Bank;

import java.util.ArrayList;

public class Bank {

	private String bankNome;
	private int bankId;
	private ArrayList contas;
	
	public Bank(int bandId, String bankNome) {
		this.bankId = bandId;
		this.bankNome = bankNome;
		contas = new ArrayList();
	}
	
	
}
