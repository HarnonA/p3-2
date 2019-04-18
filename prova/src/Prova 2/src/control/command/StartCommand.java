package control.command;

public class StartCommand implements Command {

	Ignition ign = new Ignition();

	@Override
	public void execute() {
		ign.start();
	}

}
