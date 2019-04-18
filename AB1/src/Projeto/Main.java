package Projeto;

public class Main {
	public static void main(String[] args) {
		
		//===========================================
		
		Aviao boeing747 = new Aviao(8, 58, "Boeing 747", null);
		Aviao boeing757 = new Aviao(6, 46, "Boeing 757", null);
		Aviao airbusA3 = new Aviao(6, 42, "Airbus A3", null);
		Aviao fokker100 = new Aviao(5, 21, "Fokker100", null);
		
		
		EmpresaAerea tam = new EmpresaAerea("Tam");
		EmpresaAerea gol = new EmpresaAerea("Gol");
		EmpresaAerea azul = new EmpresaAerea("Azul");
		
		tam.addAviao(boeing747.prototipo());
		tam.addAviao(boeing747.prototipo());
		tam.addAviao(boeing747.prototipo());
		
		gol.addAviao(boeing757.prototipo());
		gol.addAviao(airbusA3.prototipo());
		
		azul.addAviao(fokker100.prototipo());
		azul.addAviao(fokker100.prototipo());
		azul.addAviao(fokker100.prototipo());
		
		
		//boeing747.destino("rio", "sampa");
		//tam.addAviao(boeing747.prototipo());
		System.out.println(tam.lista.toString());
		System.out.println(gol.lista.toString());
		System.out.println(azul.lista.toString());
		
		//===========================================
		
		ConcreteTransacao transacao = new ConcreteTransacao();
		transacao.addEmpresa(tam);
		transacao.addEmpresa(gol);
		transacao.addEmpresa(azul);
		
		Cliente cliente = new Cliente("0001", "Nome", "Rua x", "8888", "123");
		
		
		
		
	}

}
