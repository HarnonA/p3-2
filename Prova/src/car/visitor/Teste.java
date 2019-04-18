package car.visitor;

public class Teste {

	public static void main(String[] args) {
		Visitor visitor = new PrintVisitor();
		Car car = new Car();
		car.eccept(visitor);
	}
	
}
