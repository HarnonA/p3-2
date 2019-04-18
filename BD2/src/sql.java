

import java.sql.*;


public class sql {
    public static void main(String[] args) {//throws SQLException {
    	
    	//Class.forName("com.mysql.jdbc.Driver");
    	
    	//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
    	
    	String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://127.0.0.1:3306/sakila_full";
    	String usuario = "root";
    	String senha = "123456";
    	Class.forName(driver);
    	//Connection con = DriverManager.getConnection(url, usuario, senha);
    	try{
    		Class.forName(driver);
    		//Connection con = DriverManager.getConnection(url, usuario, senha);
    		Statement state = con.createStatement();
    		ResultSet result = state.executeQuery("SELECT EMPLOYEE_ID,FIRST_NAME FROM EMPLOYEES");
    		
    		int c=0;

    		while (result.next()) {

    		System.out.println("Dados do Empregado "+ c++ + ":");
    		System.out.println("\t " + result.getInt("EMPLOYEE_ID"));
    		System.out.println("\t " + result.getString("FIRST_NAME"));
    		}
    		
    	}catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch (SQLException esql) {
    		esql.printStackTrace();
    	}
    	
    	//Connection con = DriverManager.getConnection(driver,usuario, senha);
    	
    	
    	
    	//Connection con = DriverManager.getConnection(url, usuario, senha);
    	//Statement stmt = con.createStatement();
        //Class.forName("com.mysql.jdbc.Driver");
    }
}

