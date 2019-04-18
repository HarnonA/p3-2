package testes;

import java.sql.*;

 


public class sql {
    public static void main(String[] args) throws SQLException {
    	String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/hr";
    	String usuario = "root";
    	String senha = "123456";
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	
    	//Connection con = DriverManager.getConnection(url, usuario, senha);
    	//Statement stmt = con.createStatement();
        //Class.forName("com.mysql.jdbc.Driver");
    }
}
