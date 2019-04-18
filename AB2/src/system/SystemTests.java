package system;


import java.util.List;

import planning.Offline;
import planning.Online;
import planning.Planning;
import configuration.Configuration;
import junit.framework.TestCase;
import finder.Finder;
import finder.Repository;
import finder.Resource;
import finder.Size;
import finder.Type;

public class SystemTests extends TestCase {

	private Finder finder; 
	
	private Resource resource1 = new Resource("f1234", "resource1", Type.database, 8.95, Size.MEDIUM);
	private Resource resource2 = new Resource("b7654", "resource2", Type.file, 15.95, Size.SMALL);
	private Resource resource3 = new Resource("f4321", "resource3", Type.database, 9.99, Size.LARGE);
	private Resource resource4 = new Resource("b2343", "resource4", Type.database, 15.95, Size.NOT_APPLICABLE);
	private Resource resource5 = new Resource("p1112", "resource5", Type.database, 230.00, Size.NOT_APPLICABLE);
	
	protected void setUp(){
		finder = new Finder(createProductRepository());
	}
	
	private Repository createProductRepository(){
		Repository repository = new Repository();
		
		repository.add(resource1);
		repository.add(resource3);
		repository.add(resource2);
		repository.add(resource4);
		repository.add(resource5);
		
		
		return repository;
	}
	
	public void testFindByType(){
		List<Resource> foundProducts =finder.byType(Type.database);
		
		assertEquals("found 4 resources", 4, foundProducts.size());
	}
	
	public void testFindByCost(){
		List<Resource> foundProducts = finder.byCost(8.95);
		assertEquals("found resource that cost 8.95", 1, foundProducts.size());
		for (Resource resource : foundProducts) {
			assertTrue(resource.getCost() == 8.95);
		}
	}
	
	public void testOnlineSystem(){
		Configuration configuration = new Configuration(10, 1, 1, 100, 10, finder);
		Planning planning = new Online(configuration);
		PlanningSystem system = new PlanningSystem(planning);
		system.makeRequest();
		system.check();
	}
	
	public void testOfflineSystem(){
		Configuration configuration = new Configuration(7, 6, 3, 3, 10, finder);
		Planning planning = new Offline(configuration);
		PlanningSystem system = new PlanningSystem(planning);
		system.makeRequest();
		system.check();
	}
	
}
