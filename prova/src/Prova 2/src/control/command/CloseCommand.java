package control.command;

public class CloseCommand implements Command{
	CarDoor car = new CarDoor();
	@Override
	public void execute() {
		car.close();
		
	}

}
