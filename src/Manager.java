/**
 * Manager Class that extends User
 * Each manager is a user and has the user name and user type
 * Creates a manager based upon attributes
 * @author Warren Beagle
 */
public class Manager extends User {

	/**
	 * Protected attributes that can be accessed by the class
	 * Attributes uniquely describe managers
	 */
	protected String empID;
	protected int age;
	protected String password;
	protected Theater theater;
	
	/**
	 * Constructor to create a manager
	 * @param name of the user
	 * @param type of user
	 * @param empID of the manager
	 * @param age of the manager
	 * @param password of the manager
	 * @param theater the manager works at
	 */
	public Manager(String name, String empID, int age, String password, Theater theater) {
		super(name);
		type = "manager";
		this.empID = empID;
		this.age = age;
		this.password = password;
		this.theater = theater;
	}
	
	/**
	 * To string method to print manager attributes
	 */
	public String toString() {
		return super.toString() + "\tEmployee ID: " + empID;
	}
	
}
