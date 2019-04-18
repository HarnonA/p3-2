package Projeto.GUI;

import java.awt.Color;
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

import Projeto.CompraVenda.ColleaguMediator;
import Projeto.CompraVenda.Colleague;
import Projeto.CompraVenda.Emp_Azul;
import Projeto.CompraVenda.Emp_Gol;
import Projeto.CompraVenda.Emp_Tam;

public class GUI_Cliente extends JFrame implements ActionListener {
	JButton botao_comprar = new JButton("Comprar");
	JButton botao_voos = new JButton("Voos Disponiveis");
	ColleaguMediator m;
	String nome;

	public GUI_Cliente(ColleaguMediator m) {
		// TODO Auto-generated constructor stub
		super("Compra E Venda");
		this.m = m;
		JTable tabela = new JTable();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		GridLayout grid = new GridLayout(2, 1, 10, 10);
		
		container.setLayout(grid);
		setSize(250, 200);
		
		
		container.add(botao_comprar);
		container.add(botao_voos);
		
		botao_comprar.addActionListener(this);
		botao_voos.addActionListener(this);
		
		
		
		setVisible(true);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Colleague empresa = null;
		Scanner scnr = new Scanner(System.in);
		
		
		
		if(ae.getSource() == botao_comprar){
			System.out.println("Escolha numero da viajem");
			int e = scnr.nextInt();
			m.vender(e);
			
		}
		else if(ae.getSource() == botao_voos){
			m.agenda();
		}
		
		
	}

}
