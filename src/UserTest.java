/**
 * JUnit Test for User Class
 * @author Warren Beagle
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	User user;
	
	@Test
	public void testConstructUser() {
		user = new User("User", "User");
		assertEquals("User", user.name);
		assertEquals("User", user.type);
	}
	
	@Test
	public void testConstructUserFromManager() {
		Theater theater = new Theater("Theater", 1);
		Manager manager = new Manager("Manager", "Manager", "EmpID", 21, "Password", theater);
		user = new User(manager);
		assertEquals("Manager", user.name);
		assertEquals("Manager", user.type);
	}
	
	@Test
	public void testConstructUserFromAccountHolder() {
		AccountHolder account = new AccountHolder("AccountHolder", "Account", "Username", "Password", 21, "PaymentInfo", false, "Attribute");
		user = new User(account);
		assertEquals("AccountHolder", user.name);
		assertEquals("Account", user.type);
	}
	
	@Test
	public void testUserToString() {
		user = new User("Name", "Type");
		assertEquals("\nUser Name: " + user.name, user.toString());
	}

}
