package test;

import java.util.List;

import control.command.Command;
import control.command.OpenCommand;
import control.command.RemoteControl;
import car.visitor.Car;
import car.visitor.ConstructVisitor;
import car.visitor.PrintVisitor;
import machine.Machine;
import junit.framework.TestCase;
import find.CarType;
import find.Color;
import find.Product;
import find.Repository;
import find.interpreter.*;
import find.interpreter.Finder;
import find.interpreter.Specifica;

public class TesteRefatorado extends TestCase {

	private Finder finder;

	private Product cupe = new Product("f1234", "Cupe", Color.red, 8.95,
			CarType.CUPE);
	private Product hatch = new Product("b7654", "Hatch", Color.black, 15.95,
			CarType.HATCH);
	private Product picapes = new Product("f4321", "Picapes", Color.white,
			9.99, CarType.PICAPES);
	private Product sedan = new Product("b2343", "Sedan", Color.white, 15.95,
			CarType.SEDAN);

	protected void setUp() {
		finder = new Finder(createProductRepository());
	}

	private Repository createProductRepository() {
		Repository repository = new Repository();

		repository.add(cupe);
		repository.add(hatch);

		return repository;
	}

	public void textFindByColorSizeAndBelowPrice() {

		// Specifica and = new And(Color.white, 10.00);

		// List foundProducts = finder.by(and);
	}

	public void textFindBelowPriceAvoidingAColor() {
		// List foundProducts = finder.by(new And(Color.red, 9);
	}

	/* Teste do pacote machine.satate */
	public void machineTest() {
		Machine gumballMachine = new Machine(5);

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

	/* Teste do pacote control.command */
	public void removeControlTest() {
		Command comando = new OpenCommand();
		RemoteControl controle = new RemoteControl();
		controle.execute(comando);
	}

	/* Teste do pacote car.visitor */
	public void operationsTest() {
		Car car = new Car();
		car.eccept(new PrintVisitor());
		car.eccept(new ConstructVisitor());

	}

}
