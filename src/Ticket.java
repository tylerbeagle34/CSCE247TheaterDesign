
/**
 * Defines a Ticket object and holds the object's information.
 * @author Nicholas Mims
 */
public class Ticket {
	/**
	 * The Show the Ticket is for.
	 */
	protected Show show;
	/**
	 * The price of the Ticket.
	 */
	protected double price;
	
	/**
	 * Constructs a Ticket object.
	 * @param show	The show the Ticket is for.
	 * @param price	The price of the Ticket.
	 */
	public Ticket(Show show, double price) {
		this.show = show;
		this.price = price;
	}
	
	/**
	 * Returns the information of the Ticket object in String format.
	 * @return the Ticket object in String format
	 */
	public String toString() {
		return "The ticket to " + show.getName() + " costs $" + price;
	}
}
