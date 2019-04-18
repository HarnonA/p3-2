package finder;

import java.util.ArrayList;
import java.util.List;

public class Repository {
	
	private List<Resource> resources = new ArrayList<Resource>();

	public void add(Resource resource) {
		this.resources.add(resource);
	}
	
	public List<Resource> getResources() {
		return resources;
	}

}
