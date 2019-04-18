package Shop;

import java.util.ArrayList;

public class Customer {
	
	private int customerID;
	private String nameCustomer;
	private String adress;
	
	
	public Customer( int customerID, String nameCustomer, String adress){
		this.customerID = customerID;
		this.nameCustomer = nameCustomer; 
		this.adress = adress;
	}
	
	public int getID(){
		return customerID;
			
	}
	
	public String getAdress(){
		return adress;
		
		
	}
	
	public String getNameCustomer(){
		return nameCustomer;
		
	}
	
	public String showCustomer(){
		String result = "";
		result = "Client " + getNameCustomer() + " Adress " + getAdress();
		return result;
		
	}
		
}
