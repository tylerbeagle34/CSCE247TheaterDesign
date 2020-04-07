import java.util.*;
/**
 * 
 *This class creates a user object which other classes will inherit from
 *
 */
public class User {
	
	protected String name;
	protected String type;
	protected ArrayList<Ticket> tickets;
	protected ArrayList<Refreshment> refreshments;
	protected Scanner keyboard;
	/**
	 * 
	 * @param name
	 * @param type
	 * @return Returns a generic user object
	 */
	public User(String name, String type) {
		this.name = name;
		this.type = type;
		tickets = new ArrayList<Ticket>();
		refreshments = new ArrayList<Refreshment>();
	}
	/**
	 * 
	 * @param manager
	 * @return Creates a manager object
	 */
	public User(Manager manager) {
		this.name = manager.name;
		this.type = manager.type;
	}
	/**
	 * 
	 * @param account
	 * @return creates a user object
	 */
	public User(AccountHolder account) {
		this.name = account.name;
		this.type = account.type;
		tickets = new ArrayList<Ticket>();
		refreshments = new ArrayList<Refreshment>();
	}
	
	public String toString() {
		return "\nUser Name: " + name;
	}

}
