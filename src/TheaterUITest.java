import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TheaterUITest {
	
	TheaterUI theaterUI = new TheaterUI();
	User user = new User("User", "User");
	Theater theater = new Theater("Theater", 1);
	Show show = new Movie(theater, "Name", "Description", "Genre", 5.00, 120.0, "PG", "1730", "Movie", 10, 10);

	@Test
	public void testPrintSingleTicket() {
		Ticket[] tickets = new Ticket[1];
		tickets[0] = new Ticket(show, user, 5.00, 1);
		assertEquals(1, theaterUI.printTickets(tickets));
	}
	
	@Test
	public void testPrintMultipleTickets() {
		int numTickets = 3;
		Ticket[] tickets = new Ticket[numTickets];
		for(int i = 0; i < numTickets; i++) {
			tickets[i] = new Ticket(show, user, 5.00, i + 1);
		}
		assertEquals(numTickets, theaterUI.printTickets(tickets));
	}
	
	@Test
	public void testPrintNoTickets() {
		Ticket[] tickets = null;
		assertEquals(-1, theaterUI.printTickets(tickets));
	}
	
	@Test
	public void testLoadSingleTickets() {
		Ticket[] tickets = new Ticket[1];
		tickets[0] = new Ticket(show, user, 5.00, 1);
		assertEquals(1, theaterUI.loadTickets(tickets));
	}
	
	@Test
	public void testLoadMultipleTickets() {
		int numTickets = 5;
		Ticket[] tickets = new Ticket[numTickets];
		for(int i = 0; i < numTickets; i++) {
			tickets[i] = new Ticket(show, user, 5.00, i + 1);
		}
		assertEquals(numTickets, theaterUI.loadTickets(tickets));
	}
	
	@Test
	public void testLoadNoTickets() {
		Ticket[] tickets = null;
		assertEquals(-1, theaterUI.loadTickets(tickets));
	}

}
