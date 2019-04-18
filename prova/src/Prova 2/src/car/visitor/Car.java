package car.visitor;

public class Car implements CarElement {

	private CarElement[] elements;
	 
    public Car() {
        //create new Array of elements
        this.elements = new CarElement[] { new Wheel( ), 
            new Wheel( ), new Wheel( ) , 
            new Wheel( ), new Body(), new Engine() };
    }
    
    public CarElement[] getElements() {
		return elements;
	}

	@Override
	public void eccept(Visitor visitor) {
		for(CarElement car: elements){
			car.eccept(visitor);
		}
	}
}
