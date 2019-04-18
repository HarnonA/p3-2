import java.util.LinkedList;


public class Emp_Comissionado extends Empregado {
	private double salarioMensal;
	private double comissao;
	private LinkedList<Double> vendas;
	private LinkedList<String> datas;
	
	
//========================================================	
	
	// construtor
	public Emp_Comissionado(int id, String name, String endereco,
			double sindicato, int tipoPagamento, double salarioMensal,
			double comissao, LinkedList<Double> vendas, LinkedList<String> datas) 
			throws NullPointerException {

		super(id, name, endereco, sindicato, tipoPagamento);
		this.salarioMensal = salarioMensal;
		this.comissao = comissao;
		if (vendas == null && datas == null) {
			this.vendas = new LinkedList<Double>();
			this.datas = new LinkedList<String>();
		} else {
			this.vendas = new LinkedList<Double>();
			this.datas = new LinkedList<String>();
			this.vendas = vendas;
			this.datas = datas;

		}
	}
	
//========================================================		
	
	public String toString() {
		String result = super.toString() + " | R$ " + calcSalario();
		return result;
	}
	
//========================================================
	
	public double calcSalario() throws NullPointerException {
		double totalVenda = 0;
		int i;

		if (vendas.size() > 0)
			for (i = 0; i < vendas.size(); i++)
				totalVenda += (Double) vendas.get(i);
		else
			totalVenda = 0;

		return (salarioMensal / 2) + (totalVenda * (comissao)) - getValorSindicato();
	}
		
//========================================================

	// Paga toda sexta na 1 ou 3 semana do mes(14-14 dias)
	public void pagaComissionado(int nSemana, int diaSemana) {
		if ((diaSemana == 6 && nSemana == 1)
				|| (diaSemana == 6 && nSemana == 3)) {
			System.out.println("Comissionado " + getNome()
					+ stringTipoPagamento());
			vendas = new LinkedList<Double>();
			datas = new LinkedList<String>();
		}

	}
	
//========================================================	
	
	public void setVenda(String data, double valorVenda) {
		try {
			vendas.add(valorVenda);
			datas.add(data);
		} catch (NullPointerException e) {
			System.out.println("Erro setVenda");
		}

	}
	
//========================================================
	
	public double getSalario(){
		return salarioMensal;
	}
	
//========================================================
	
	public double getComissao(){
		return comissao;
	}
	
//========================================================
	
	public void showVenda(){
		int i;
		for( i = 0 ; i < vendas.size() ; i++)
			System.out.println(datas.get(i) + " R$ " + vendas.get(i) );
	}
	
//========================================================
	
	public Emp_Comissionado clonar() {
		int id1 = this.getId();
		String nome1 = this.getNome();
		String endereco1 = this.getEndereco();
		double valorSindicato1 = this.getSindicato();
		int tipoPagamento1 = this.getTipoPagamento();
		double salarioMensal1 = this.salarioMensal;
		double comissao = this.comissao;
		LinkedList<Double> vendas1 = new LinkedList<Double>();
		LinkedList<String> datas1 = new LinkedList<String>();
		vendas1.addAll((LinkedList) this.vendas.clone());
		datas1.addAll((LinkedList) this.datas.clone());

		Emp_Comissionado emp = new Emp_Comissionado(id1, nome1, endereco1,
				valorSindicato1, tipoPagamento1, salarioMensal1, comissao,
				vendas1, datas1);

		return emp;
	}

	
	
	
	
}