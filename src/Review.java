
public class Review {

	protected User author;
	protected Show show;
	protected int rating;
	protected String review;
	
	public Review(User author, Show show, int rating, String review) {
		this.author = author;
		this.show = show;
		this.rating = rating;
		this.review = review;
	}
	
	public String toString() {
		return "\nRating (Out of 10): " + rating + "\nComments: " + review + "\nAuthor: " + author.name;
	}
	
}
