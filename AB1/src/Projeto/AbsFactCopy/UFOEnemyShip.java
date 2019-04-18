package Projeto.AbsFact;

public class UFOEnemyShip extends EnemyShip {
	
	public UFOEnemyShip(){
		
		setName("UFO Enemy Ship");
		
		
		
	}
	
	public void executa(){
		super.executa();
		for(int i = 0;i<5;i++)
			System.out.println(i);
	}
	
}