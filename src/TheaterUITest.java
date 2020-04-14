import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TheaterUITest {
	
	TheaterUI theaterUI = new TheaterUI();
	User user = new User("User");
	Theater theater = new Theater("Theater", 1);
	Show show = new Movie(theater, "Name", "Description", "Genre", 5.00, 120.0, "PG", "1730", "Movie", 10, 10);
	
	@Test
	public void testLogoutAccountHolder() {
		
	}
	
	@Test
	public void testLogoutManager() {
		
	}
	
	@Test
	public void testAddShowMovie() {
		int showSize = theaterUI.shows.size();
		int movieSize = theaterUI.movies.size();
		assertEquals(true, theaterUI.addShow());
		assertEquals(showSize + 1, theater.shows.size());
		assertEquals(movieSize + 1, theater.movies.size());
		assertNotNull(theater.shows);
		assertNotNull(theater.movies);
	}
	
	@Test
	public void testAddShowPlay() {
		int showSize = theaterUI.shows.size();
		int playSize = theaterUI.plays.size();
		assertEquals(true, theaterUI.addShow());
		assertEquals(showSize + 1, theater.plays.size());
		assertEquals(playSize + 1, theater.plays.size());
		assertNotNull(theater.shows);
		assertNotNull(theater.plays);
	}
	
	@Test
	public void testAddShowConcert() {
		int showSize = theaterUI.shows.size();
		int concertSize = theaterUI.concerts.size();
		assertEquals(true, theaterUI.addShow());
		assertEquals(showSize + 1, theater.shows.size());
		assertEquals(concertSize + 1, theater.concerts.size());
		assertNotNull(theater.shows);
		assertNotNull(theater.concerts);
	}
	
	@Test
	public void testAddShowInvalidType() {
		assertEquals(false, theaterUI.addShow());
	}
	
	@Test
	public void testAddShowInvalidTheater() {
		assertEquals(false, theaterUI.addShow());
	}
	
	@Test
	public void testAddShowPriceLessThanZero() {
		assertEquals(false, theaterUI.addShow());
	}
	
	@Test
	public void testValidRemoveShow() {
		theaterUI.shows.add(new Movie(theater, "Name", "Description", "Genre", 5.00, 120.0, "PG", "1730", "Movie", 10, 10));
		assertEquals(true, theaterUI.removeShow());
	}
	
	@Test
	public void testInvalidRemoveShow() {
		theaterUI.shows.add(new Movie(theater, "Name", "Description", "Genre", 5.00, 120.0, "PG", "1730", "Movie", 10, 10));
		assertEquals(false, theaterUI.removeShow());
	}
	
	@Test
	public void testRemoveShowWithNoShows() {
		assertEquals(false, theaterUI.removeShow());
	}
	
	@Test
	public void testValidAddRefreshment() {
		assertEquals(true, theaterUI.addRefreshment());
	}
	
	@Test
	public void testAddRefreshmentAlreadyAvailable() {
		theaterUI.refreshments.add(new Refreshment("Popcorn", "Buttered Popcorn", "Unhealthy", 5.0));
		assertEquals(false, theaterUI.addRefreshment());
	}
	
	@Test
	public void testAddRefreshmentPriceLessThanZero() {
		assertEquals(false, theaterUI.addRefreshment());
	}

	@Test
	public void testValidRemoveRefreshment() {
		theaterUI.refreshments.add(new Refreshment("Popcorn", "Buttered Popcorn", "Unhealthy", 5.0));
		assertEquals(true, theaterUI.removeRefreshment());
	}
	
	@Test
	public void testInvalidRemoveRefreshment() {
		theaterUI.refreshments.add(new Refreshment("Popcorn", "Buttered Popcorn", "Unhealthy", 5.0));
		assertEquals(false, theaterUI.removeRefreshment());
	}
	
	@Test
	public void testRemoveRefreshmentWithNoRefreshments() {
		assertEquals(false, theaterUI.removeRefreshment());
	}
	
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
