package TXT;


import java.net.Socket;

import java.util.Scanner;



public class Cliente {

	public static void main(String[] args) throws Exception {

		
			Socket socket = new Socket("127.0.0.1", 12002);
			Scanner s = new Scanner(socket.getInputStream());
			System.out.println("v " + s.nextLine());
			s.close();
		

		}
	
}
