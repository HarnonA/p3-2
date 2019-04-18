package test;


import java.util.List;

import car.Body;
import car.Car;
import car.Element;
import car.Engine;
import car.Wheel;
import machine.Machine;
import junit.framework.TestCase;
import control.Command;
import control.RemoteControl;
import find.CarType;
import find.Color;
import find.Finder;
import find.Product;
import find.Repository;

public class Test extends TestCase {

private Finder finder; 
	
	private Product cupe = new Product("f1234", "Cupe", Color.red, 8.95, CarType.CUPE);
	private Product hatch = new Product("b7654", "Hatch", Color.black, 15.95, CarType.HATCH);
	private Product picapes = new Product("f4321", "Picapes", Color.white, 9.99, CarType.PICAPES);
	private Product sedan = new Product("b2343", "Sedan", Color.white, 15.95, CarType.SEDAN);
	
	protected void setUp(){
		finder = new Finder(createProductRepository());
	}
	
	private Repository createProductRepository(){
		Repository repository = new Repository();
		
		repository.add(cupe);
		repository.add(hatch);
		
		return repository;
	}
	
	
	
	public void textFindByColorSizeAndBelowPrice(){
		List foundProducts = finder.byColorSizeAndBelowPrice(Color.red, CarType.SEDAN, 10.00f);
	}
	
	public void textFindBelowPriceAvoidingAColor(){
		List foundProducts = finder.belowPriceAvoidingAColor(9.00f, Color.red);
	}
	
	public void machineTest(){
		Machine gumballMachine = new Machine(5);

		System.out.println(gumballMachine);

		gumballMachine.insertMoney();
		gumballMachine.requestCar();

		System.out.println(gumballMachine);

		gumballMachine.insertMoney();
		gumballMachine.requestMoney();
		gumballMachine.requestCar();

		System.out.println(gumballMachine);

		gumballMachine.insertMoney();
		gumballMachine.requestCar();
		gumballMachine.insertMoney();
		gumballMachine.requestCar();
		gumballMachine.requestMoney();

		System.out.println(gumballMachine);

		gumballMachine.insertMoney();
		gumballMachine.insertMoney();
		gumballMachine.requestCar();
		gumballMachine.insertMoney();
		gumballMachine.requestCar();
		gumballMachine.insertMoney();
		gumballMachine.requestCar();

		System.out.println(gumballMachine);
	}

	public void removeControlTest( ){
		RemoteControl remoteControl = new RemoteControl();
		
		remoteControl.execute(Command.CLOSE);
	}
	
	public void operationsTest(){
		Car car = new Car();
		
		for (Element element : car.getElements()) {
			if (element instanceof Wheel) {
				Wheel wheel = (Wheel) element;
				wheel.print("Constructing left");
			}if (element instanceof Body) {
				Body body = (Body) element;
				body.print("Constructing Body");
			}if (element instanceof Engine) {
				Engine engine = (Engine) element;
				engine.print("Constructing Engine");
			}
		}for (Element element : car.getElements()) {
			if (element instanceof Wheel) {
				Wheel wheel = (Wheel) element;
				wheel.print("Printing left");
			}if (element instanceof Body) {
				Body body = (Body) element;
				body.print("Printing Body");
			}if (element instanceof Engine) {
				Engine engine = (Engine) element;
				engine.print("Printing Engine");
			}
		}
	}
}
