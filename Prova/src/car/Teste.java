package car;

public class Teste {
	public static void main(String[] args) {
		/*BadSmell de varios if com instanceof, vamos usar o padrão visitor para resolver esse tipo de problema!*/
		Car  car = new Car();
		
		Element[] elements = car.getElements();
		for(Element elem: elements){
			if(elem instanceof Body){
				elem.print("The Body");
			}
			if(elem instanceof Engine){
				elem.print("The Engine");
			}
			if(elem instanceof Wheel){
				elem.print("The Wheel");
			}
		}
		
	}
}
