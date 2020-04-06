import java.util.*;
public class User {
	
	protected String name;
	protected String type;
	protected ArrayList<Ticket> tickets;
	protected ArrayList<Refreshment> refreshments;
	protected Scanner keyboard;
	
	public User(String name, String type) {
		this.name = name;
		this.type = type;
		tickets = new ArrayList<Ticket>();
		refreshments = new ArrayList<Refreshment>();
	}
	
	public User(Manager manager) {
		this.name = manager.name;
		this.type = manager.type;
	}
	
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
