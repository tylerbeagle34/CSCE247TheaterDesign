/**
 * JUnit Test for Refreshment Class
 * @author Warren Beagle
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RefreshmentTest {

	Refreshment refreshment = new Refreshment("Name", "Description", "Info", 5.00); 
	
	@Test
	public void testRefreshmentConstructor() {
		assertEquals("Name", refreshment.name);
		assertEquals("Description", refreshment.description);
		assertEquals("Info", refreshment.nutritionalInfo);
		assertEquals(5.00, refreshment.price);
	}
	
	@Test
	public void testRefreshmentToString() {
		assertEquals("\nName: " + refreshment.name.toUpperCase() + "\nDescription: " + refreshment.description 
				+ "\nNutritional Facts: " + refreshment.nutritionalInfo + "\nPrice: $" + refreshment.price, refreshment.toString());
	}

}
