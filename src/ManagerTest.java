/**
 * JUnit Test for Manager Class
 * @author Warren Beagle
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagerTest {

	Theater theater = new Theater("Theater", 1);
	Manager manager = new Manager("Manager", "EmpID", 21, "Password", theater);
	
	@Test
	public void testManagerConstructor() {
		assertEquals("Manager", manager.name);
		assertEquals("manager", manager.type);
		assertEquals("EmpID", manager.empID);
		assertEquals(21, manager.age);
		assertEquals("Password", manager.password);
		assertEquals(theater, manager.theater);
	}
	
	@Test
	public void testManagerToString() {
		assertEquals("\nUser Name: " + manager.name + "\tEmployee ID: " + manager.empID, manager.toString());
	}

}
