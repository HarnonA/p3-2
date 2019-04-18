package planning;

import configuration.Configuration;

public class Planning {

	private Configuration configuration = null;
	
	public Planning(Configuration configuration) {
		System.out.println("Configuration: " + configuration);
		this.configuration = configuration;
	}
	
	public Configuration getConfiguration() {
		return configuration;
	}
	
}
