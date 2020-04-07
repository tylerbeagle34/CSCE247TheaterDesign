import java.util.ArrayList;

public class Movie extends Show {
	
	public Movie(Theater theater, String name, String description, String genre, double price, 
			double length, String ratingMPAA, double time, String type, int rows, int cols) {
		super(theater, name, description, genre, price, length, ratingMPAA, time, type, rows, cols);
		numTickets = rows * cols;
		seats = new int[rows][cols];
		chosenSeats = new int[rows][cols];
		initChosenSeats();
		reviews = new ArrayList<Review>();
	}
	
}
