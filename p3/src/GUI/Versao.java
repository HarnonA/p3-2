package GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Versao extends JFrame implements ActionListener {

	JTextField user;
	JPasswordField senha;
	JButton botaoOk;
	JButton botaoCancel;
	int i = 0;
	ArrayList<Usuario> array;
	Contain container;

	public Versao(GridLayout grid, Contain c) {
		super("Compra E Venda");
		array = new ArrayList<Usuario>();
		container = c;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Container container = getContentPane();
		container.setLayout(grid);
		container.setLayout(grid);
		setSize(250, 100);

		// criacao de campo e area de texto
		user = new JTextField();
		senha = new JPasswordField();
		container.add(new JLabel("Usuario"));
		container.add(user);
		container.add(new JLabel("Senha"));
		container.add(senha);

		// criaco de botao ok e cancelar
		botaoOk = new JButton("Ok");
		botaoCancel = new JButton("Cancelar");
		container.add(botaoOk);
		container.add(botaoCancel);

		// acoes de click de botao
		botaoOk.addActionListener(this);
		botaoCancel.addActionListener(this);
		setVisible(true);

	}

	public void setGrid(GridLayout grid) {
		// this.grid = grid;
	}

	/*
	 * public static void main(String[] args){ setGrid(new GridLayout(3,2, 10,
	 * 10)); //grid = new GridLayout(3,2, 10, 10); Versao janela = new
	 * Versao(grid); janela = null;
	 * 
	 * 
	 * int x =0; if(x == 1){ grid = new GridLayout(6,2, 100, 100); janela = new
	 * Versao(grid);
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */

	public static void fazer() {
		GridLayout grid = new GridLayout(3, 1, 20, 10);
		ArrayList<JButton> botoes = new ArrayList<JButton>();
		botoes.add(new JButton("X"));
		botoes.add(new JButton("Y"));
		botoes.add(new JButton("z"));
		// GUI janela = new GUI(grid, botoes);
	}

	public static void fazer2() {
		GridLayout grid = new GridLayout(5, 1, 10, 10);
		ArrayList<JButton> botoes = new ArrayList<JButton>();

		botoes.add(new JButton("Y"));
		botoes.add(new JButton("z"));
		botoes.add(new JButton("k"));
		botoes.add(new JButton("w"));
		// GUI janela = new GUI(grid, botoes);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		if (ae.getSource() == botaoOk) {
			String n, s;
			// campo digitado em usuario
			n = (String) user.getText();
			// campo digitando em senha
			s = (String) senha.getText();

			for (int i = 0; i < array.size(); i++) {
				System.out.println(s + " " + n);
				if (s.equals(array.get(i).getNome())
						&& n.equals(array.get(i).getSenha())){
					this.hide();
					
					
				}
				else
					System.out.println("Nao cadastrado");
			}
		} else {
			user.setText(null);
			senha.setText(null);
			System.out.println("NOT OK");
		}

	}

	public void addUsuario(Usuario u) {
		array.add(u);
	}
	
	public class Cla extends JFrame{
		public Cla(GridLayout grid){

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container container = getContentPane();
			container.setLayout(grid);
			setSize(250, 100);

			
		}
	}
	

}
