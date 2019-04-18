package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GUI_Cliente extends JFrame implements ActionListener {

	public GUI_Cliente() {
		// TODO Auto-generated constructor stub
		super("Compra E Venda");
		JTable tabela = new JTable();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		GridLayout grid = new GridLayout(3, 2, 10, 10);
		
		container.setLayout(grid);
		setSize(250, 200);
		JButton botao = new JButton("Comprar");
		botao.addActionListener(this);
		
		container.add(botao);
		container.add(new JButton("Voos Disponiveis"));
		container.add(new JButton("Sair"));
		//botao.setBackground(Color.yellow);
		
		
		setVisible(true);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.hide();
		this.setBackground(Color.YELLOW);
		GUI_Aviao a = Singleton.getSingleton();
		a.show();
		// TODO Auto-generated method stub
		
	}

}
