/**
 * JUnit Test for User Class
 * @author Warren Beagle
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	Theater theater = new Theater("Theater", 1);
	User user = new User("User");
	User managerUser = new User(new Manager("Manager", "EmpID", 21, "Password", theater));
	User accountUser = new User(new AccountHolder("AccountHolder", "Username", "Password", 21, "PaymentInfo", false, "Attribute"));
	
	@Test
	public void testConstructUser() {
		assertEquals("User", user.name);
		assertEquals("Type", user.type);
	}
	
	@Test
	public void testConstructUserFromManager() {
		assertEquals("Manager", managerUser.name);
		assertEquals("Manager", managerUser.type);
	}
	
	@Test
	public void testConstructUserFromAccountHolder() {
		assertEquals("AccountHolder", accountUser.name);
		assertEquals("Account", accountUser.type);
	}
	
	@Test
	public void testUserToString() {
		assertEquals("\nUser Name: " + user.name, user.toString());
	}

}
