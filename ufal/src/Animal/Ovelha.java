package Animal;

public class Ovelha {
	private int patas;
	private String nomeOvelha;
	
	public Ovelha(int patas, String nomeOvelha){
		this.patas = patas;
		this.nomeOvelha = nomeOvelha;
	}
	
	public String toString(){
		String s = nomeOvelha + patas + " patas";
		return s;
		
	}

}
