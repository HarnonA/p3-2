package car;

public class Car {

	private Element[] elements;
	 
    public Car() {
        //create new Array of elements
        this.elements = new Element[] { new Wheel( ), 
            new Wheel( ), new Wheel( ) , 
            new Wheel( ), new Body(), new Engine() };
    }
    
    public Element[] getElements() {
		return elements;
	}
}
