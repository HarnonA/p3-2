package Projeto.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;

import javax.swing.JFrame;

public class GUI_Aviao extends JFrame implements ActionListener {
	JButton[][] botao = new JButton[5][5];
	
	
	public GUI_Aviao() {
		// TODO Auto-generated constructor stub
		super("Compra E Venda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		
		GridLayout grid = new GridLayout(5, 5, 5, 5);
		
		container.setLayout(grid);
		setSize(200, 200);
		
		for (int i = 0; i < 5; i++) {
			for(int j = 0 ; j < 5; j++){
				botao[i][j] = new JButton();
				container.add(botao[i][j]);
				botao[i][j].setBackground(Color.GREEN);
				botao[i][j].addActionListener(this);
			}

		}
		
		
		setVisible(true);

	}
	
    private void mudarBotao(ActionEvent evt){  
        try{  
             JButton btnAux = (JButton) evt.getSource();  
            
             btnAux.setBackground(Color.yellow);  
             
             evt.notifyAll();
        }catch(Exception e){}   
}  
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		for (int i = 0; i < 5; i++) 
			for(int j = 0 ; j < 5; j++)
		if(botao[i][j].getBackground() == Color.GREEN)
		mudarBotao(arg0);
		
		System.out.println("X");
		
		//this.update(getGraphics());
		
		//this.hide();
		//GUI_Cliente  c= new GUI_Cliente();
		
		
		
		// TODO Auto-generated method stub
		
		
	}

}
