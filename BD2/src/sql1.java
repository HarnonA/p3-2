
import java.sql.*;

public class sql1 {
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
    		
    		
    		//rs = st.executeQuery(consulta.getNomeDataApelidoAtivo());
    		//consulta.buscaNomeDataApelidoAtivo(rs);
    		
    		rs = st.executeQuery(consulta.getNomeIdadeRG());
    		consulta.nomeIdadeRG(rs);
    		
    		//rs = st.executeQuery(consulta.getNomeDataApelidoAtivo());
    		//consulta.buscaNomeDataApelidoAtivo(rs);
    		
    		
    		
    		
    	//	st.executeUpdate("insert into " + ".tenista " + "values(10,'Har','Apelidosss',1990,'Washington','Las Vegas',1,1)");
    		//st.close();
    		 //st.executeUpdate("INSERT INTO cats_tricks VALUES('mono', 'r')");
    	      //st.executeUpdate("INSERT INTO cats_tricks VALUES('mono', 'j')");

    		//ResultSet rs = st.executeQuery("SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES");
    		
    		//st.execute("ALTER TABLE tenista" + "INSERT INTO `tenis`.`tenista` VALUES" + );
    		//StringBuilder sq = new StringBuilder("INSERT INTO tenista");
    		
    		  
    		
    		//sq.append("id,nome, apelido, ano_nasc, cidade_nascimento, cidade_moradia, esta_ativo, id_padrino");
    		//sq.append( "VALUES(?,?,?,?,?,?,?)" );
    		//gerente.executarComando(sq.toString(),"13", "Harnon", "1993", "Maceio", "Maceio", "0", "12");
    		
    		
    		
    		//listar o nome, apelido e ano de nascimento de cada jogador na ativa
    		/**int c = 0;
    		String busca = "SELECT nome, apelido, ano_nasc FROM tenista WHERE esta_ativo = '1' ";
    		rs = st.executeQuery(busca);
    		while(rs.next()){
    			System.out.print("Tenista" + c++ + ":");
    			System.out.print(" " + rs.getString("nome"));
    			System.out.print(" " + rs.getInt("ano_nasc"));
    			System.out.println(" " + rs.getString("apelido"));
    			
    			
    			//System.out.print(" " + rs.getInt("id"));
    			//System.out.println(" " + rs.getString("nome"));
    		
    			
    		}
    		
    		
    		//Listar o nome e a idade dos jogadores que já disputaram o torneio de 'Roland Garros'
    		c = 0;
    		busca = "SELECT nome, ano_nasc FROM tenista WHERE esta_ativo = '1' ";
    		rs = st.executeQuery(busca);
    		while(rs.next()){
    			System.out.print("Tenista" + c++ + ":");
    			System.out.print(" " + rs.getString("nome"));
    			int ano = 2014 - rs.getInt("ano_nasc");
    			System.out.println(" " + ano );
    		}
    		
    		//Quantos torneios foram disputados ao longo da carreira de cada jogador.
    		c = 0;
    		busca = ("SELECT COUNT(*) FROM participar");
    		rs = st.executeQuery(busca);
    		while(rs.next()){
    			System.out.print("Tenista" + c++ + ":");
    			System.out.print(" " + rs.getInt("COUNT(*)"));
    			
    			
    		}
    		*/
    		
    		
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