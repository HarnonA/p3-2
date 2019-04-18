package Projeto.X;

public class Aviao implements PrototipoAviao {
	
	private int colunas;
	private int filas;
	private String tipo;
	private String origem;
	private String destino;
	private boolean[][] assentos;
	private int nSerie;
	
	public Aviao(int poltronas, int filas, String tipo, String origem, String destino, int nSerie){
		this.colunas = poltronas;
		this.filas = filas;
		this.origem = origem;
		this.destino = destino;
		this.tipo = tipo;
		this.assentos = new boolean[colunas][filas];
		this.nSerie = nSerie;
	}


	@Override
	public Aviao prototipo() {
		Aviao a = null;
		try {
			a = (Aviao) super.clone();
			
		}		
		catch (CloneNotSupportedException e) {	  
			System.out.println("Erro CloneException");
			e.printStackTrace();			  
		 }
		
		return a;
	}
	
	public String toString(){
		String s = "";
		/*
		s += "Num Serie: " + nSerie;
		s += " | Modelo: " + tipo + " | Assentos: " + colunas * filas + "\nDe "
				+ origem + " para " + destino + "\n";
		*/
		s += "Assentos: " + colunas * filas + " | De " + origem + " para "
				+ destino + "\n";
		return s;
		
	}
	
	public int getNSerie(){
		return nSerie;
	}
	
	public void marcarViajem(String o, String d){
		destino = d;
		origem = o;
		
	}
	
	public void marcarPoltrono(int coluna, int fila){
		if(assentos[fila][coluna] == false){
			assentos[fila][coluna] = true;
			System.out.println("Poltrona Disponivel");
		}
		else
			System.out.println("Poltrona Indisponivel");
			
	}

	public void mostrarPoltronas() {
		System.out.print("  ");
		for (int i = 0; i < filas; i++) {
			if (i < 10)
				System.out.print("0" + i + " ");// numeros com 2 casas decimais
			else
				System.out.print(i + " ");
		}

		System.out.println();

		for (int j = 0; j < colunas; j++) {
			System.out.print(j + " ");
			for (int i = 0; i < filas; i++) {

				if (assentos[j][i] == false)
					System.out.print("V  ");
				else
					System.out.print("X  ");

			}
			System.out.println();
		}
	}

}
