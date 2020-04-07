
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
	
	protected User user;
	protected int seatNum;
	
	/**
	 * Constructs a Ticket object.
	 * @param show	The show the Ticket is for.
	 * @param price	The price of the Ticket.
	 */
	public Ticket(Show show, User user, double price, int seatNum) {
		this.show = show;
		this.price = price;
		this.user = user;
		this.seatNum = seatNum;
	}
	
	/**
	 * Returns the information of the Ticket object in String format.
	 * @return the Ticket object in String format
	 */
	public String toString() {
		return "The ticket to " + show.getName() + " costs $" + price;
	}
	
	/**
	 * Method to set the ticket output to be printed or loaded
	 * @return the string of the ticket to either be printed or loaded
	 */
	public String ticketOutput() {
		return "**************************************************" + 
				"\n**************************************************" +
				"\n\n" + show.type + " TICKET" +
				"\n\n" + show.name + "\nPrice: " + show.price + "\nTime:" + show.time +
				"\nSeat: " + seatNum +
				"\n" + user.toString() + "\n" +
				"\n**************************************************" +
				"\n**************************************************\n\n";
	}
	
}
