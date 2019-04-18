
public class Sing {
	private static Sing first = null;
	private int numb;
	private String ss;
	
	
	private Sing(){	}
	
	public static synchronized Sing getInstance(){
		
		if(first == null){
			first = new Sing();
		}
		return first;
	}
	
	
		public static void main(String[] args) {
			Sing sing = Sing.getInstance();
			sing.setnum(4);
			sing.setString("Set This");
			
			Sing s1 = Sing. getInstance();
			s1.setnum(-11);
			s1.setString("String");
			System.out.println( sing.getNumb());
			System.out.println( s1.getNumb());
			//S s = new S(12, "name");
	//		ss = s;
		//	System.out.println( ss);
		}
	public int getNumb(){
		return numb;
	}
	
	public void setnum(int a){
		numb = a;
	}
	
	public void setString(String s){
		ss = s;
	}
	
}

