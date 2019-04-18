package Projeto.ObserverT;

import java.util.ArrayList;

//Uses the Subject interface to update all Observers

public class StockGrabber implements Subject{
	
	private ArrayList<Observer> observers;
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	private boolean bool;
	
	public StockGrabber(){
	
		observers = new ArrayList<Observer>();
	}
	
	public void register(Observer newObserver) {
		
		observers.add(newObserver);
		
	}

	public void unregister(Observer deleteObserver) {
		
		// Get the index of the observer to delete
		
		int observerIndex = observers.indexOf(deleteObserver);
		
		// Print out message (Have to increment index to match)
		
		System.out.println("Observer " + (observerIndex+1) + " deleted");
		
		// Removes observer from the ArrayList
		
		observers.remove(observerIndex);
		
	}

	public void notifyObserver() {
		
		// Cycle through all observers and notifies them of
		// price changes
		
		for(Observer observer : observers){
			
			observer.update(ibmPrice, aaplPrice, googPrice, bool);
			
		}
	}
	
	// Change prices for all stocks and notifies observers of changes
	
	public void setIBMPrice(double newIBMPrice){
		
		this.ibmPrice = newIBMPrice;
		if(bool == true)
			bool = false;
		else bool = true;
		
		notifyObserver();
		
	}
	
	public void setAAPLPrice(double newAAPLPrice){
		
		this.aaplPrice = newAAPLPrice;
		if(bool == true)
			bool = false;
		else bool = true;
		
		notifyObserver();
		
	}

	public void setGOOGPrice(double newGOOGPrice){
	
		this.googPrice = newGOOGPrice;
		if(bool == true)
			bool = false;
		else bool = true;
	
		notifyObserver();
	
	}
	
}
