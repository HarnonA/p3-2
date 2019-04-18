

import java.util.*;

public class Empregado{
	
	protected int code;					//codigo do empregado
	protected String nome;				//nome do empregado
	protected String endereco;			//endere�o do empregado
	protected Boolean sindicalizado;	//� ou n�o sindicalizado
	protected float taxaSindicato;		//taxa para sindicalizados
	protected int tipoPagamento;		//de que forma o empregado quer ser pago
	protected boolean[] diaTrabalho = new boolean[32];	//1=trabalhou ; 0=faltou
	protected List<Vendas> vendasEmpregado = new LinkedList<Vendas>();
	
	//Construtor
	public Empregado(int cod, String name, String end, boolean sindicato, float taxaSin, int pag){
		this.setCode(cod);
		this.setNome(name);
		this.setEndereco(end);
		this.setSindicalizado(sindicato);
		this.setTaxaSindicato(taxaSin);
		this.setTipoPagamento(pag);		
	}

	//Armazena o codigo do empregado
	public void setCode(int code) {
		this.code = code;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setSindicalizado(boolean sindicato) {
		this.sindicalizado = sindicato;		
	}

	public void setTaxaSindicato(float taxaSin) {
		this.taxaSindicato = taxaSin;
	}

	public void setTipoPagamento(int pag) {
		this.tipoPagamento = pag;
	}

	public int getCode() {
		return code;
	}

	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public Boolean getSindicalizado() {
		return sindicalizado;
	}
	
	public int getTipoPagamento() {
		return tipoPagamento;
	}
	
	public float getTaxaSindicato() {
		return taxaSindicato;
	}	
}
