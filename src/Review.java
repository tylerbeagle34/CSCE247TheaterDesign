/**
 * Review class to create a review for a show
 * @author Warren Beagle
 */
public class Review {

	/**
	 * Protected attributes to describe the review
	 * Each show has an array list of reviews from users
	 */
	protected User author;
	protected Show show;
	protected int rating;
	protected String review;
	
	/**
	 * Constructor to create a review
	 * @param author of the review, a user
	 * @param show that the review is written for
	 * @param rating of the show
	 * @param review of the show
	 */
	public Review(User author, Show show, int rating, String review) {
		this.author = author;
		this.show = show;
		this.rating = rating;
		this.review = review;
	}
	
	/**
	 * To String method to print out the review
	 */
	public String toString() {
		return "\nRating (Out of 10): " + rating + "\nComments: " + review + "\nAuthor: " + author.name;
	}
	
}
