package control;
public class RemoteControl {

	private CarDoor garageDoor = new CarDoor();
	private Ignition light = new Ignition();
	
	public RemoteControl() {
		
	}
	
	public void execute(Command command) {
		
		if (command.equals(Command.OPEN)) {
			garageDoor.open();
		} if (command.equals(Command.CLOSE)) {
			garageDoor.close();
		} if (command.equals(Command.START)) {
			light.start();
		} if (command.equals(Command.STOP)) {
			light.stop();
		}
	}
	
}
