
public class Sing {
	private boolean runningAsApplet = false;
	private boolean setApplet = false;
	
	private static Sing singleton = null;
	
	
	private Sing(){	}
	
	public static synchronized Sing getInstance(){
		
		if(singleton == null){
			singleton = new Sing();
		}
		return singleton;
	}
	
	public void showRunninh(){
		System.out.println(runningAsApplet);
	}
	
	public void setRunning(){
		runningAsApplet = true;
	}
	
	public boolean getRunning(){
		return runningAsApplet;
	}
}
