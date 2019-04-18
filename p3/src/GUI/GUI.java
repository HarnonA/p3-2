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

public class GUI extends JFrame implements ActionListener {
	ArrayList<JButton> botao;
	
	JTextField user;
	JPasswordField senha;
	JButton j;
	
	public GUI(GridLayout grid){
		super("Compra E Venda");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();	
		
		j = new JButton("X");
		
		
		user = new JTextField();
		senha = new JPasswordField();
		
		container.add(new JLabel("Usuario"));
		container.add(user);
		container.add(new JLabel("Senha"));
		container.add(senha);
		
		botao = new ArrayList<JButton>();
		container.add(j);
		
		//container.setLayout(new GridLayout(3,1));
		container.setLayout(grid);
		
		setSize(400, 300);
		setVisible(true);
		
		j.addActionListener(this);
		/*
		for(int i = 0 ; i < array.size() ; i++){
			container.add(array.get(i));
			botao.add(array.get(i));
		}
		botao.add(j);
		j.addActionListener(this);
		for(int i = 0 ; i < array.size(); i++)
		botao.get(i).addActionListener(this);
		*/
		
		//container.add(new JButton("x"));
		//container.add(new JButton("y"));
		//container.add(new JButton("z"));
		
		
		
		/*
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		
		JButton botao = new JButton("xxxxxxxxxxx");
		botao.setAlignmentX(container.CENTER_ALIGNMENT);
		container.add(botao);
		botao = new JButton("zz");
		botao.setAlignmentX(container.CENTER_ALIGNMENT);
		container.add(botao);
		*/
		//container.add(BorderLayout.CENTER, botao);
		//container.add(BorderLayout.WEST, botao1);
		
		
		
		
		
	}
	
	public static void main(String[] args){
		GridLayout grid = new GridLayout(3,2, 10, 10);
		GUI janela = new GUI(grid);
		
		
		int x =0;
		if(x == 0){
			fazer2();
			
		}
			
		
		
	}
	public static void fazer(){
		GridLayout grid = new GridLayout(3,1, 20, 10);
		ArrayList<JButton> botoes = new ArrayList<JButton>();
		botoes.add(new JButton("X"));
		botoes.add(new JButton("Y"));
		botoes.add(new JButton("z"));
		//GUI janela = new GUI(grid, botoes);
	}
	public static void fazer2(){
		GridLayout grid = new GridLayout(5,1, 10, 10);
		ArrayList<JButton> botoes = new ArrayList<JButton>();
		
		
		
		botoes.add(new JButton("Y"));
		botoes.add(new JButton("z"));
		botoes.add(new JButton("k"));
		botoes.add(new JButton("w"));
		//GUI janela = new GUI(grid, botoes);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == j){
			//campo digitado em usuario
			System.out.println(user.getText());
			//campo digitando em senha
			System.out.println(senha.getText());
			
			System.out.println("OK");	
		}
		else
			System.out.println("NOT OK");

		

		
		// TODO Auto-generated method stub
		
	}

}
