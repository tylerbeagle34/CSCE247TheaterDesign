import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToString() {
		Theater theater = new Theater("Theater", 1);
		Show show = new Play(theater, "Name", "Description", "Genre", 5.00, 120.0, "PG", "1730", "Movie", 10, 10);
		String toString = show.toString();
		assertEquals("\nShow Name: Name\nDescription: Description\nGenre: Genre\nPrice: $5.0\nRating: PG" 
				+ "\nTime: 120.0\nType: MOVIE\nTheater: Theater", toString);
		
	}

}
