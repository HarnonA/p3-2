package finder;

import java.util.ArrayList;
import java.util.List;

public class Finder {
	
	private Repository repository;

	public Finder(Repository repository) {
		this.repository = repository;
	}
	
	public List<Resource> selectBy(Spec spec) {
		List<Resource> foundResources = new ArrayList<Resource>();

		for (Resource resource : this.repository.getResources()) {
			if (spec.isSatisfied(resource)) {
				System.out.println("Satisfeito");
				foundResources.add(resource);
			}
		}
		return foundResources;
	}

}
