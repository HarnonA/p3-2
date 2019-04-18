import java.util.Date;


public class Customer {
	private String name;
	private String email;
	private Date date;
	
	public Customer(String name, String adress, Date date ){
		this.name = name;
		this.email = adress;
		this.date = date;
		
	}
	

	
	public String toString(){
		String s = "";
		s += "Name: " + name + "\nEmail: " + email + "\nDate: " + date;
		return s;
		
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getName(){
		return name;	
	}
	
	
	
}
