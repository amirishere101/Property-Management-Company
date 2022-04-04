

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5,p6;
	ManagementCompany m;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("Roots", "1752", 4);
		//student add three properties, with plots, to mgmt co
		p1 = new Property("Damascus", "Maryland", 5422, "Darren", 1, 1, 2, 2);
		p2 = new Property("Rockville", "Maryland", 4875, "James", 4, 1, 3, 3);
		p3 = new Property("Germantown", "Maryland", 3645, "Jake", 1, 4, 2, 2);
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		m = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property("Las Vegas", "Nevada", 1075, "Joe");
		assertEquals(m.addProperty(p4), 3, 0.3);
		//student should add property with 8 args
		p5 = new Property("Miami", "Florida", 2150, "Max", 3, 3, 5, 4);
		assertEquals(m.addProperty(p5), 4, 0.3);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		p6 = new Property("Toronto", "Canada", 3547, "Brady", 2,3,4,5);
		assertEquals(m.addProperty(p4), -1, 0.3);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(), 5000, 0.5);
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(), 4500, 0.3);
	}

 }