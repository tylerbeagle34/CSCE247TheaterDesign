/**
 * JUnit Test for AccountHolder Class
 * @author Warren Beagle
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountHolderTest {

	AccountHolder account = new AccountHolder("AccountHolder", "Account", "Username", "Password", 21, "PaymentInfo", false, "Attribute");
	AccountHolder teacher = new AccountHolder("Teacher", "Account", "Username", "Password", 21, "PaymentInfo", false, "Teacher");
	AccountHolder military = new AccountHolder("Military", "Account", "Username", "Password", 21, "PaymentInfo", false, "Military");
	AccountHolder student = new AccountHolder("Student", "Account", "Username", "Password", 21, "PaymentInfo", false, "Student");
	AccountHolder retired = new AccountHolder("Retired", "Account", "Username", "Password", 21, "PaymentInfo", false, "Retired");
	AccountHolder noDiscount = new AccountHolder("Teacher", "Account", "Username", "Password", 21, "PaymentInfo", false, "None");
	
	@Test
	public void testAccountHolderConstructor() {
		assertEquals("AccountHolder", account.name);
		assertEquals("Account", account.type);
		assertEquals("Username", account.username);
		assertEquals("Password", account.password);
		assertEquals(21, account.age);
		assertEquals("PaymentInfo", account.paymentInfo);
		assertEquals(false, account.isHandicap);
	}
	
	@Test
	public void testAccountHolderToString() {
		assertEquals("\nUser Name: " + account.name + "\tUsername: " + account.username, account.toString());
	}
	
	@Test
	public void testAccountHolderTeacherDiscount() {
		assertEquals(0.2, teacher.discount);
	}
	
	@Test
	public void testAccountHolderMilitaryDiscount() {
		assertEquals(0.3, military.discount);
	}
	
	@Test
	public void testAccountHolderStudentDiscount() {
		assertEquals(0.1, student.discount);
	}
	
	@Test
	public void testAccountHolderRetiredDiscount() {
		assertEquals(0.2, retired.discount);
	}
	
	@Test
	public void testAccountHolderNoDiscount() {
		assertEquals(0.0, noDiscount.discount);
	}
	
	@Test
	public void testAccountHolderInvalidDiscount() {
		assertEquals(0.0, account.discount);
	}

}
