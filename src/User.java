/**
 * User Class to be extended by Children
 * Children: AccountHolder and Manager
 * Creates a user based upon attributes
 * Used to create guests
 * Imports java.util to use ArrayList
 * @author Warren Beagle
 */
import java.util.*;
public class User {
	
	/**
	 * Protected instance variables to be accessed within the class and by the children
	 * Each user has a name, a type of user, tickets and refreshments purchased
	 */
	protected String name;
	protected String type;
	protected ArrayList<Ticket> tickets;
	protected ArrayList<Refreshment> refreshments;
	protected Scanner keyboard;
	
	/**
	 * Constructor to create a user
	 * @param name of user
	 * @param type of user
	 */
	public User(String name, String type) {
		this.name = name;
		this.type = type;
		tickets = new ArrayList<Ticket>();
		refreshments = new ArrayList<Refreshment>();
	}
	
	/**
	 * Constructor to create a user from a manager
	 * Each manager is a user
	 * @param manager to create user
	 */
	public User(Manager manager) {
		this.name = manager.name;
		this.type = manager.type;
	}
	
	/**
	 * Constructor to create a user from an account holder
	 * Each account holder is a user
	 * @param account to create user
	 */
	public User(AccountHolder account) {
		this.name = account.name;
		this.type = account.type;
		tickets = new ArrayList<Ticket>();
		refreshments = new ArrayList<Refreshment>();
	}
	
	/**
	 * To string method to print user attributes
	 */
	public String toString() {
		return "\nUser Name: " + name;
	}

}
