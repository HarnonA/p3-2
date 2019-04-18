package Thread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame implements Runnable{
	
	
	String v = "";
	int f = 2;
	
	public Main(){
		
		super("Janela");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		JButton botao = new JButton("X");
		botao.addActionListener(new ouv());
		Container c = new JPanel();
		c.setLayout(new BorderLayout());
		c.add(BorderLayout.CENTER, botao);
		getContentPane().add(BorderLayout.SOUTH, c);
		setVisible(true);
		
	}
	
	public void run() {
		try {
			for (int i = 0; i < 5; i++){
				System.out.println(v);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			return;

		}
	}
	
	private class ouv implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			v += "x";
			f++;
			System.out.println("COco");
			
		}
		
	}
	
	public String z(){
		return v;
	}
	
	public int l(){
		return f;
	}

	public static void main(String[] args) {
		String v = "x";
		//Runnable r = new Main("SSSS", 2000);
		//new Thread(r).start();
		
		System.out.println("X X X");
		new Main();
		System.out.println(v);
		System.out.println("X X X");
		
		
		//Container c = new JPanel();
		//c.setLayout(new BorderLayout());
		
		
        
        
		
		
	}



}
