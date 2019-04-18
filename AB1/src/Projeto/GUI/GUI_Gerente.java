package Projeto.GUI;

import java.awt.Color;
import Projeto.CompraVenda.ColleaguMediator;
import Projeto.CompraVenda.Colleague;
import Projeto.CompraVenda.Emp_Azul;
import Projeto.CompraVenda.Emp_Gol;
import Projeto.CompraVenda.Emp_Tam;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GUI_Gerente extends JFrame implements ActionListener {
	JButton botao_oferecer = new JButton("Oferecer voo");
	JButton botao_frota = new JButton("Listar frota");
	JButton botao_mostrar = new JButton("Mostrar voos");
	JButton botao_remover = new JButton("Remover voo");
	ColleaguMediator m;
	String nome;

	public GUI_Gerente(ColleaguMediator m, String nome) {
		// TODO Auto-generated constructor stub
		super("Compra E Venda");
		this.m = m;
		this.nome = nome;
		JTable tabela = new JTable();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		GridLayout grid = new GridLayout(4, 1, 10, 10);
		
		container.setLayout(grid);
		setSize(250, 200);
		
		
		container.add(botao_oferecer);
		container.add(botao_frota);
		container.add(botao_mostrar);
		container.add(botao_remover);
	
		botao_oferecer.addActionListener(this);
		botao_frota.addActionListener(this);
		botao_mostrar.addActionListener(this);
		botao_remover.addActionListener(this);
		//botao.setBackground(Color.yellow);
		
		
		setVisible(true);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Colleague empresa = null;
		Scanner scnr = new Scanner(System.in);
		
		if (nome.equals("Tam")) {
			Emp_Tam tam = (Emp_Tam) m.getTam();
			empresa = tam;
		} else if (nome.equals("Gol")) {
			empresa = (Emp_Gol) m.getGol();
		} else if (nome.equals("Azul")) {
			Emp_Azul azul = (Emp_Azul) m.getAzul();
			empresa = azul;
		}
		
		if(ae.getSource() == botao_oferecer){
			
			String origem, destino;
			System.out.println("Origem");
			origem = scnr.nextLine();
			System.out.println("Destino");
			destino = scnr.nextLine();
			empresa.mostrar();
		}
		else if(ae.getSource() == botao_frota){
			empresa.mostrar();
		}
		else if(ae.getSource() == botao_mostrar){
			m.mostrarVooEmpresa(empresa.getNome());
		}
		else if(ae.getSource() == botao_remover){
			m.retirarVoo(scnr.nextInt(), empresa.getNome());
		}
		
		
	
		
	}

}
