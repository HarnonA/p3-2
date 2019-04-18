package control.command;

public class OpenCommand implements Command {
	CarDoor car = new CarDoor();
	@Override
	public void execute() {
		car.open();
	}

}
