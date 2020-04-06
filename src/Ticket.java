
public class Ticket {
	private Show show;
	private double price;
	
	public Ticket(Show show, double price) {
		this.show = show;
		this.price = price;
	}
	
	public String toString() {
		return "The ticket to " + show.getName() + " costs $" + price;
	}
}
