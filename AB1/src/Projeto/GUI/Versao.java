package Projeto.GUI;

import java.awt.Container;

import Projeto.CompraVenda.ColleaguMediator;
import Projeto.CompraVenda.Gerente;
import Projeto.CompraVenda.Cliente;
import Projeto.CompraVenda.Usuario;
import Projeto.CompraVenda.UsuarioFactory;

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
	String n, s;
	ColleaguMediator m;

	public Versao(ColleaguMediator m) {
		super("Compra E Venda");
		this.m = m;
		array = new ArrayList<Usuario>();
		GridLayout grid = new GridLayout(3, 2, 10, 10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
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
	public void addArray(ArrayList<Usuario> array){
		this.array = array;
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
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		if (ae.getSource() == botaoOk) {
			// campo digitado em usuario
			n = (String) user.getText();
			// campo digitando em senha
			s = (String) senha.getText();
			
			
			

			for (int i = 0; i < array.size(); i++) {
				if (n.equals(array.get(i).getName())
						&& s.equals(array.get(i).getSenha())){
					this.hide();
					
					if(array.get(i) instanceof Cliente){
						GUI_Cliente gui1 = new GUI_Cliente(m);
					}
					else if(array.get(i) instanceof Gerente){
						GUI_Gerente gui1 = new GUI_Gerente(m,n);
					}
				}
				else{
					
				}
					//System.out.println("Nao cadastrado");
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
