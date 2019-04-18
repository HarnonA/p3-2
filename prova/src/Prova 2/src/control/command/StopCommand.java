package control.command;

public class StopCommand implements Command {
	Ignition ign = new Ignition();

	@Override
	public void execute() {
		ign.stop();
	}

}
