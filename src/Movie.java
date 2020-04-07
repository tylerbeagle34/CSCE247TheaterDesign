import java.util.ArrayList;

public class Movie extends Show {
	/**
	 * 
	 * @param theater
	 * @param name
	 * @param description
	 * @param genre
	 * @param price
	 * @param length
	 * @param ratingMPAA = rating from G to NC-17
	 * @param time
	 * @param type
	 * @param rows
	 * @param cols
	 * 
	 * @return The class will create a movie object
	 */
	
	public Movie(Theater theater, String name, String description, String genre, double price, 
			double length, String ratingMPAA, String time, String type, int rows, int cols) {
		super(theater, name, description, genre, price, length, ratingMPAA, time, type, rows, cols);
		numTickets = rows * cols;
		seats = new int[rows][cols];
		chosenSeats = new int[rows][cols];
		initChosenSeats();
		reviews = new ArrayList<Review>();
	}
	
}
