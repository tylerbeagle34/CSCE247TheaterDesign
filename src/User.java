import java.util.*;
public class User {
	
	protected String name;
	protected ArrayList<Ticket> tickets;
	protected ArrayList<Refreshment> refreshments;
	
	public User(String name) {
		this.name = name;
		tickets = new ArrayList<Ticket>();
		refreshments = new ArrayList<Refreshment>();
	}
	
}
