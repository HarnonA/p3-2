
import java.util.ArrayList;
import Factory.*;
import Mediator.*;
import Prototype.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Singleton sing = Singleton.getInstance();
		Scanner scanner = new Scanner(System.in);

		ColleaguMediator mediador = new ColleaguMediator();

		Emp_Tam tam = new Emp_Tam(mediador);
		Emp_Gol gol = new Emp_Gol(mediador);
		Emp_Azul azul = new Emp_Azul(mediador);

		// ========

		Aviao boeing747 = new Aviao(8, 58, "Boeing 747", null, null, 0);
		Aviao boeing757 = new Aviao(6, 46, "Boeing 757", null, null, 0);
		Aviao airbusA3 = new Aviao(6, 42, "Airbus A3", null, null, 0);
		Aviao fokker100 = new Aviao(5, 21, "Fokker100", null, null, 0);

		// ========

		tam.addFrota(boeing747.prototipo(), sing.x());
		tam.addFrota(boeing757.prototipo(), sing.x());
		tam.addFrota(boeing757.prototipo(), sing.x());
		tam.addFrota(boeing757.prototipo(), sing.x());
		gol.addFrota(airbusA3.prototipo(), sing.x());
		azul.addFrota(fokker100.prototipo(), sing.x());

		// mediador.empresas();

		// ========

		tam.oferecerVoo(tam.getNome(), boeing747.prototipo(), "Maceio",
				"Recife");
		tam.oferecerVoo(tam.getNome(), boeing757.prototipo(), "Florianopolis",
				"Sao Paulo");
		gol.oferecerVoo(gol.getNome(), boeing747.prototipo(), "Rio de Janeiro",
				"Brasilia");
		tam.oferecerVoo(tam.getNome(), boeing757.prototipo(), "Rio Branco",
				"Teresina");
		azul.oferecerVoo(azul.getNome(), fokker100.prototipo(), "Sergipe",
				"Maceio");
		// azul.mostrar();
		// mediador.agenda();

		// =======

		LinkedList<Cliente> bdClientes = new LinkedList<Cliente>();
		Cliente cliente = null;
		String senha = "";
		String nome = "";

		UsuarioFactory fabrica = new UsuarioFactory();
		ArrayList<Usuario> arr = new ArrayList<Usuario>();
		Usuario usuario = null;

		usuario = new Cliente("0101", "Joaozinho", "Rua x", "8888-8888", "123");
		arr.add(usuario);
		usuario = new Gerente("0101", "Tam", "Rua x", "8888-7777", "123");
		arr.add(usuario);
		usuario = new Cliente("0101", "Lucas", "Rua x", "8888-6666", "123");
		arr.add(usuario);
		usuario = new Gerente("0101", "Gol", "Rua x", "8888-5555", "123");
		arr.add(usuario);
		usuario = new Gerente("0101", "Azul", "Rua x", "8888-1234", "123");
		arr.add(usuario);

		/*
		 * 
		 */

		// GUI_Gerente g = new GUI_Gerente(mediador);
		// Versao versao = new Versao(mediador);
		// versao.addArray(arr);

		/*
		 * 
		 */

		try {
			System.out.println("Nome");
			nome = scanner.nextLine();
			System.out.println("Senha");
			senha = scanner.nextLine();
			usuario = fabrica.criarUsuario(nome, senha, arr);
			usuario.executa(mediador);
		} catch (Exception e) {
			System.out.println("O sistema se comportou de forma inesperada");
		}

	}

}