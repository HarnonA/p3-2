package TXT;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {

	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(12002);
		
		while(true){
			System.out.println("x");
			Socket socket  = server.accept();
			try (PrintWriter pw = new PrintWriter(socket.getOutputStream())){
			pw.println("xXxxxX");
			}
		}
	   
   }
}
