/**
 * JUnit Test for Review Class
 * @author Warren Beagle
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReviewTest {

	User author = new User("Author", "User");
	Theater theater = new Theater("Theater", 1);
	Show show = new Movie(theater, "Name", "Description", "Genre", 5.00, 120.0, "PG", "1730", "Movie", 10, 10);
	Review review = new Review(author, show, 5, "Review");
	
	@Test
	public void testReviewConstructor() {
		assertEquals(author, review.author);
		assertEquals(show, review.show);
		assertEquals(5, review.rating);
		assertEquals("Review", review.review);
	}
	
	@Test
	public void testReviewToString() {
		assertEquals("\nRating (Out of 10): " + review.rating + "\nComments: " + review.review + "\nAuthor: " + review.author.name, review.toString());
	}

}
