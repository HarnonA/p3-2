package Projeto.ObserverT;

public class Main{
	
	public static void main(String[] args){
		
		// Create the Subject object
		// It will handle updating all observers 
		// as well as deleting and adding them
		
		StockGrabber stockGrabber = new StockGrabber();
		
		// Create an Observer that will be sent updates from Subject
		
		StockObserver observer1 = new StockObserver(stockGrabber);
		
		stockGrabber.setIBMPrice(100.00);
		stockGrabber.setAAPLPrice(200.60);
		stockGrabber.setGOOGPrice(300.40);
		
		
		// Delete one of the observers
		
		//stockGrabber.unregister(observer1);
		
		// Create 3 threads using the Runnable interface
		// GetTheStock implements Runnable, so it doesn't waste 
		// its one extendable class option
		
		Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 100.00);
		Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 200.60);
		Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 300.40);
		
		// Call for the code in run to execute 
		
		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();
		
		
	}
	
}