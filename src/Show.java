
/**
 * This is a super call Show in which Movie, Concert, and Play will all inherit from
 */
import java.util.*;
public abstract class Show {
	
	protected Theater theater;
	protected String name;
	protected String description;
	protected String genre;
	protected double price;
	protected double length;
	protected String ratingMPAA;
	protected String time;
	protected String type;
	protected int rows;
	protected int cols;
	protected int numTickets;
	protected int[][] seats;
	protected int[][] chosenSeats;
	protected ArrayList<Review> reviews;
	private static final String SEATING_MESSAGE = "********** SCREEN / STAGE **********";
	
	/**
	 * 
	 * @param theater: Theater object
	 * @param name
	 * @param description
	 * @param genre
	 * @param price
	 * @param length
	 * @param ratingMPAA: Rating of the movie from G to NC-17
	 * @param time: Start time of the movie
	 * @param type
	 * @param rows
	 * @param cols
	 */
	public Show(Theater theater, String name, String description, String genre, double price, 
			double length, String ratingMPAA, String time, String type, int rows, int cols) {
		this.theater = theater;
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.price = price;
		this.length = length;
		this.ratingMPAA = ratingMPAA;
		this.time = time;
		this.type = type.toUpperCase();
		this.rows = rows;
		this.cols = cols;
		numTickets = rows * cols;
		seats = new int[rows][cols];
		chosenSeats = new int[rows][cols];
		initChosenSeats();
		reviews = new ArrayList<Review>();
	}
	
	/**
	 * @return Prints the array of seats to choose from
	 */
	public void printSeats() {
		int seatNum = 1;
		System.out.println(SEATING_MESSAGE);
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(chosenSeats[i][j] == 0) {
					seats[i][j] = 0;
				} else {
					seats[i][j] = seatNum;
				}
				System.out.print(seats[i][j] + " | ");
				seatNum++;
			}
			System.out.println();
		}
	}
	
	public void initChosenSeats() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				chosenSeats[i][j] = 1;
			}
		}
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getGenre() {
		return genre;
	}
	public double getPrice() {
		return price;
	}
	public double getLength() {
		return length;
	}
	public String getRatingMPAA() {
		return ratingMPAA;
	}
	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "\nShow Name: " + name + "\nDescription: " + description + "\nGenre: " + genre + 
				"\nPrice: $" + price + "\nRating: " + ratingMPAA + "\nTime: " + length + "\nType: " + type + "\nTheater: " + theater.name;
	}
	
}
