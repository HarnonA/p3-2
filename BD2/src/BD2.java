import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BD2 {
    public static void main(String[] args) {
    	
    	String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/tenis";
    	String usuario = "root";
    	String senha = "anizio";
    	
    	
    	try{
    		Class.forName(driver);
    		Connection con = DriverManager.getConnection(url, usuario, senha);
    		Statement st = null; 
    		st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT id, nome FROM tenista");
    		Consultas consulta = new Consultas();
    		
    		Scanner scanner = new Scanner( System.in );
    		int option;
    		
    		System.out.println("1 - Nome, apelido e ano de nascimento de jogador na ativo ");
  
    		option = scanner.nextInt();
    		if(option == 1){
    			rs = st.executeQuery(consulta.getNomeDataApelidoAtivo());
    			consulta.buscaNomeDataApelidoAtivo(rs);
    		}
    		else if(option == 2){
    			rs = st.executeQuery(consulta.getNomeIdadeRG());
    			consulta.nomeIdadeRG(rs);
    		}else if(option == 3){    		
    			rs = st.executeQuery(consulta.getTorneioDisputado());
    			consulta.torneioDisputadoPorJogador(rs);
    		}
    		//else if( option == 4 ){
    			//Tenist t1 = new Tenist("Jones", "Jô", 1978, "Macei0", "São Paulo", 1);
    			//st.execute( consulta.x(t1) );
    			
    		//}
    		else
    			System.out.println("ERRO");
    		
    		scanner.close();
    		
    		
    		
    	}catch(ClassNotFoundException e){
    		System.out.println("erro 1");
    		e.printStackTrace();
    	}
    	catch(SQLException esql){
    		System.out.println("erro 2");
    		esql.printStackTrace();
    		
    	}
    	
    	
    }
}
