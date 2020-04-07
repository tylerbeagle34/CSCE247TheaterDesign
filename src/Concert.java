import java.util.ArrayList;

public class Concert extends Show {
	
	public Concert(Theater theater, String name, String description, String genre, double price, 
			double length, String ratingMPAA, String time, String type, int rows, int cols) {
		super(theater, name, description, genre, price, length, ratingMPAA, time, type, rows, cols);
		numTickets = rows * cols;
		seats = new int[rows][cols];
		chosenSeats = new int[rows][cols];
		initChosenSeats();
		reviews = new ArrayList<Review>();
	}
	
}
