import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicketTest {

	Theater theater = new Theater("Theater", 1);
	Show show = new Movie(theater, "Name", "Description", "Genre", 5.00, 120.0, "PG", "1730", "Movie", 10, 10);
	User user = new User("Guest");
	Ticket ticket = new Ticket(show, user, show.price, 1);
	
	@Test
	public void testTicketConstructor() {
		assertEquals("Name", ticket.show.name);
		assertEquals("Guest", ticket.user.name);
		assertEquals(5.00, ticket.show.price);
		assertEquals(1, ticket.seatNum);
	}
	
	@Test
	public void testTicketToString() {
		assertEquals("The ticket to " + ticket.show.name + " costs $" + ticket.show.price, ticket.toString());
	}
	
	@Test
	public void testTicketOutput() {
		String ticketOutput = "**************************************************" + 
				"\n**************************************************" +
				"\n\n" + ticket.show.type + " TICKET" +
				"\n\n" + ticket.show.name + "\nPrice: " + ticket.show.price + "\nTime:" + ticket.show.time +
				"\nSeat: " + ticket.seatNum +
				"\n" + user.toString() + "\n" +
				"\n**************************************************" +
				"\n**************************************************\n\n";
		assertEquals(ticketOutput, ticket.ticketOutput());
	}

}
