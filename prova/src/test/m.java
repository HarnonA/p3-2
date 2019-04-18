package test;

import machine.Machine;
import find.CarType;
import find.Color;
import find.Finder;
import find.Product;
import find.Repository;

public class m {
	private Product cupe = new Product("f1234", "Cupe", Color.red, 8.95, CarType.CUPE);
	private Product hatch = new Product("b7654", "Hatch", Color.black, 15.95, CarType.HATCH);
	private Product picapes = new Product("f4321", "Picapes", Color.white, 9.99, CarType.PICAPES);
	private Product sedan = new Product("b2343", "Sedan", Color.white, 15.95, CarType.SEDAN);

	public static void main(String[] args){
		machineTest();
		
	}
		private Finder finder; 
		
		
		
		protected void setUp(){
			finder = new Finder(createProductRepository());
		}
		
		private Repository createProductRepository(){
			Repository repository = new Repository();
			
			repository.add(cupe);
			repository.add(hatch);
			
			return repository;
		}
		
		public static void machineTest(){
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

}
