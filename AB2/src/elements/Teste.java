package elements;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoPlan plan = new DoPlan();
		Engine engine = new Engine();
		engine.accept(plan);
		
		Body body = new Body();
		body.accept(plan);
		

	}

}
