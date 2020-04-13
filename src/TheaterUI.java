/**
 * TheaterUI class to create the user interface for the theater system
 * Incorporates the functionality of the system similar to a ticketing system
 * Imports java.io and java.util to use print writer, scanner, and array list
 * @author Team Leaking Memory
 */
import java.io.*;
import java.util.*;
public class TheaterUI {

	/**
	 * Private instance variables to be accessed throughout the UI
	 */
	private static final String WELCOME_MESSAGE = "********** Welcome to the Leaking Memory Ticket System **********";
	private static final String CLOSING_MESSAGE = "********** Thank you for using the Leaking Memory Ticket System! Have a nice day! **********";
	private static final String LOGIN_MESSAGE = "********** Logging In **********";
	private static final String SHOWS_MESSAGE = "********** SHOWS **********";
	private static final String MOVIES_MESSAGE = "********** MOVIES **********";
	private static final String PLAYS_MESSAGE = "********** PLAYS **********";
	private static final String CONCERTS_MESSAGE = "********** CONCERTS **********";
	private static final String REFRESHMENTS_MESSAGE = "********** REFRESHMENTS **********";
	private String[] guestMenuOptions = {"View Shows", "Buy Tickets","Create Account","Login","Read Reviews","Exit"};
	private String[] accountMenuOptions = {"View Shows", "Buy Tickets","View Refreshments","Buy Refreshments","Write a Review","Read Reviews","Logout"};
	private String[] managerMenuOptions = {"Add Show","Remove Show","Add Refreshment","Remove Refreshment","Logout"};
	private Scanner scanner;
	private User user;
	private ArrayList<User> users;
	private ArrayList<Manager> managers;
	private ArrayList<AccountHolder> accounts;
	private ArrayList<Theater> theaters;
	protected ArrayList<Show> shows;
	private ArrayList<Movie> movies;
	private ArrayList<Play> plays;
	private ArrayList<Concert> concerts;
	protected ArrayList<Refreshment> refreshments;
	
	/**
	 * TheaterUI constructor
	 * Creates a new theater UI
	 */
	public TheaterUI() {
		scanner = new Scanner(System.in);
		user = new User("Guest", "guest");
		users = new ArrayList<User>();
		managers = new ArrayList<Manager>();
		accounts = new ArrayList<AccountHolder>();
		theaters = new ArrayList<Theater>();
		shows = new ArrayList<Show>();
		movies = new ArrayList<Movie>();
		plays = new ArrayList<Play>();
		concerts = new ArrayList<Concert>();
		refreshments = new ArrayList<Refreshment>();
	}
	
	/**
	 * Method to load data into the system
	 */
	private void loadData() {
		Theater movieTheater = new Theater("Columbia Movie Theater", 10);
		Theater playsRUs = new Theater("PlaysRUs", 2);
		Theater concertVenue = new Theater("Colonial Life Arena", 1);
		theaters.add(movieTheater);
		theaters.add(playsRUs);
		theaters.add(concertVenue);
		Movie frozen2 = new Movie(movieTheater, "Frozen 2", "Family friendly disney movie about the snow queen Elsa", "Kids", 8.00, 122, "PG", "1200", "movie", 10, 10);
		Movie jungleBook = new Movie(movieTheater, "The Jungle Book", "Remake of the Disney Original", "Family", 8.00, 118, "PG", "1330", "movie", 8, 8);
		movies.add(frozen2);
		movies.add(jungleBook);
		shows.add(frozen2);
		shows.add(jungleBook);
		
		AccountHolder existing = new AccountHolder("Exisiting User", "account", "existing", "existing", 21, "Cash", false, "student");
		accounts.add(existing);
		users.add(existing);
		
		Manager employee = new Manager("Playhouse Manager", "manager", "12345", 30, "manager", playsRUs);
		managers.add(employee);
		users.add(employee);
	}
	
	/**
	 * Main user interface
	 * Run when the user is a guest
	 */
	public void runMain() {
		loadData();
		boolean isRunning = true;
		System.out.println(WELCOME_MESSAGE);
		while(isRunning) {
			displayMainMenu(user.type.toUpperCase());
			int userCommand = scanner.nextInt();
			switch(userCommand) {
				case(1): 
					viewShows();
					break;
				case(2):
					buyTickets();
					break;
				case(3):
					createAccount();
					break;
				case(4):
					scanner.nextLine();
					login();
					break;
				case(5):
					displayReviews();
					break;
				default: 
					isRunning = false;
					break;
			}
		}
		System.out.println(CLOSING_MESSAGE);
	}
	
	/**
	 * Account user interface
	 * Runs when the user is an account holder
	 */
	public void runAccount() {
		boolean isAccount = true;
		while(isAccount) {
			displayMainMenu(user.type.toUpperCase());
			int userCommand = scanner.nextInt();
			switch(userCommand) {
				case(1): 
					viewShows();
					break;
				case(2):
					buyTickets();
					break;
				case(3):
					buyRefreshments();
					break;
				case(4):
					printAllRefreshments();
					break;
				case(5):
					writeReview();
					break;
				case(6):
					displayReviews();
					break;
				default:
					isAccount = false;
					logout();
					break;
			}
		}
	}
	
	/**
	 * Manager user interface
	 * Runs when the user is a manager
	 */
	public void runManager() {
		boolean isRunning = true;
		while(isRunning) {
			displayMainMenu(user.type.toUpperCase());
			int userCommand = scanner.nextInt();
			switch(userCommand) {
				case(1):
					addShow();
					break;
				case(2):
					removeShow();
					break;
				case(3):
					addRefreshment();
					break;
				case(4):
					removeRefreshment();
					break;
				default:
					isRunning = false;
					logout();
					break;
			}
		}
	}
	
	/**
	 * Method to display the main menu given the user type
	 * @param type of user
	 */
	private void displayMainMenu(String type) {
		System.out.println("\n************ " + type + " Main Menu *************");
		if(user.type.equalsIgnoreCase("account")) {
			for(int i=0; i < accountMenuOptions.length; i++) {
				System.out.println((i+1) + ". " + accountMenuOptions[i]);
			}
		} else if(user.type.equalsIgnoreCase("manager")) {
			for(int i=0; i < managerMenuOptions.length; i++) {
				System.out.println((i+1) + ". " + managerMenuOptions[i]);
			}
		} else {
			for(int i=0; i < guestMenuOptions.length; i++) {
				System.out.println((i+1) + ". " + guestMenuOptions[i]);
			}
		}
		System.out.println("\n");
	}
	
	/**
	 * Prints the shows based on user input
	 */
	private void viewShows() {
		System.out.println("Do you want to view MOVIES, PLAYS, CONCERTS, or ALL SHOWS");
		scanner.nextLine();
		String input = scanner.nextLine();
		if(input.equalsIgnoreCase("movies")) {
			printMovies();
		} else if(input.equalsIgnoreCase("plays")) {
			printPlays();
		} else if(input.equalsIgnoreCase("concerts")) {
			printConcerts();
		} else if(input.equalsIgnoreCase("all shows")) {
			printAllShows();
		} else {
			System.out.println("Invalid Input. Printing All Shows");
			printAllShows();
		}
	}
	
	/**
	 * Prints all shows
	 * Checks if there are shows
	 */
	private void printAllShows() {
		if(!checkShows()) {
			return;
		}
		System.out.println(SHOWS_MESSAGE);
		for(Show show : shows) {
			System.out.println(show.toString());
			System.out.println("Tickets Remaining: " + show.numTickets);
		}
	}
	
	/**
	 * Prints only movies
	 * Checks if there are movies
	 */
	private void printMovies() {
		if(!checkMovies()) {
			return;
		}
		System.out.println(MOVIES_MESSAGE);
		for(Movie movie : movies) {
			System.out.println(movie.toString());
			System.out.println("Tickets Remaining: " + movie.numTickets);
		}
	}
	
	/**
	 * Prints only plays
	 * Checks if there are plays
	 */
	private void printPlays() {
		if(!checkPlays()) {
			return;
		}
		System.out.println(PLAYS_MESSAGE);
		for(Play play : plays) {
			System.out.println(play.toString());
			System.out.println("Tickets Remaining: " + play.numTickets);
		}
	}
	
	/**
	 * Prints only concerts
	 * Checks if there are concerts
	 */
	private void printConcerts() {
		if(!checkConcerts()) {
			return;
		}
		System.out.println(CONCERTS_MESSAGE);
		for(Concert concert : concerts) {
			System.out.println(concert.toString());
			System.out.println("Tickets Remaining: " + concert.numTickets);
		}
	}
	
	/**
	 * Allows users and account holders to buy tickets
	 * Checks if there are shows to purchase
	 * Checks to make sure the show exists
	 * Allows users to purchase multiple tickets and choose options
	 */
	private void buyTickets() {
		if(!checkShows()) {
			return;
		}
		System.out.println("Enter the name of the show you would like to buy tickets to");
		printAllShows();
		scanner.nextLine();
		String input = scanner.nextLine();
		for(Show show : shows) {
			if(show.name.equalsIgnoreCase(input)) {
				if(show.numTickets == 0) {
					System.out.println("Sorry this show is sold out");
					return;
				}
				System.out.println("How many tickets would you like?");
				int numTix = scanner.nextInt();
				Ticket[] tickets = new Ticket[numTix];
				for(int i = 0; i < numTix; i++) {
					boolean pickingSeat = true;
					int seat = 0;
					while(pickingSeat) {
						System.out.println("\nEnter the seat number you would like for TICKET " + (i + 1) + ". Those labeled zero have been sold");
						show.printSeats();
						seat = scanner.nextInt();
						if(seat > show.rows * show.cols || seat == 0) {
							System.out.println("That seat does not exist or has been sold");
						}
						else {
							for(int seatRow = 0; seatRow < show.rows; seatRow++) {
								for(int seatCol = 0; seatCol < show.cols; seatCol++) {
									if(show.seats[seatRow][seatCol] == seat) {
										show.chosenSeats[seatRow][seatCol] = 0;
										pickingSeat = false;
									}
								}
							}
						}
					}
					Ticket purTix = new Ticket(show, user, show.price, seat);
					tickets[i] = purTix;
					user.tickets.add(purTix);
					show.numTickets--;
				}
				System.out.println("Would you like to (1) print the tickets or (2) load them?");
				int choice = scanner.nextInt();
				switch(choice) {
					case(1):
						printTickets(tickets);
						break;
					case(2):
						loadTickets(tickets);
						break;
					default:
						System.out.println("Invalid Command. Tickets will be loaded");
						loadTickets(tickets);
						break;
				}
				return;
			}
		}
		System.out.println("Sorry we couldn't find that show");
	}
	
	/**
	 * Checks whether the array list of shows is empty
	 * @return true or false based on if the array list is not empty
	 */
	private boolean checkShows() {
		if(shows.size() == 0) {
			System.out.println("There are no shows at this time");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks whether the array list of movies is empty
	 * @return true or false based on if the array list is not empty
	 */
	private boolean checkMovies() {
		if(movies.size() == 0) {
			System.out.println("There are no movies at this time");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks whether the array list of plays is empty
	 * @return true or false based on if the array list is not empty
	 */
	private boolean checkPlays() {
		if(plays.size() == 0) {
			System.out.println("There are no plays at this time");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks whether the array list of concerts is empty
	 * @return true or false based on if the array list is not empty
	 */
	private boolean checkConcerts() {
		if(concerts.size() == 0) {
			System.out.println("There are no concerts at this time");
			return false;
		}
		return true;
	}
	
	/**
	 * Allows users and account holders to buy refreshments
	 * Checks if there are refreshments to purchase
	 * Checks to make sure the refreshment exists
	 */
	private void buyRefreshments() {
		if(!checkRefreshments()) {
			return;
		}
		System.out.println("Enter the name of the refreshment you would like to buy");
		printAllRefreshments();
		scanner.nextLine();
		String input = scanner.nextLine();
		for(Refreshment refreshment : refreshments) {
			if(refreshment.name.equalsIgnoreCase(input)) {
				user.refreshments.add(refreshment);
				System.out.println(refreshment.name + " was bought successfully");
				return;
			}
		}
		System.out.println("Sorry we couldn't find that refreshment");
	}
	
	/**
	 * Prints all refreshments
	 * Checks if there are refreshments available
	 */
	private void printAllRefreshments() {
		if(!checkRefreshments()) {
			return;
		}
		System.out.println(REFRESHMENTS_MESSAGE);
		for(Refreshment refreshment : refreshments) {
			System.out.println(refreshment.toString());
		}
	}
	
	/**
	 * Checks if there are refreshments for purchase
	 * @return true or false based on whether the array list is not empty
	 */
	private boolean checkRefreshments() {
		if(refreshments.size() == 0) {
			System.out.println("There are no refreshments at this time");
			return false;
		}
		return true;
	}
	
	/**
	 * Allows users to write a review of a show
	 * Checks to see if there are shows to review
	 * Checks whether the show exists
	 */
	private void writeReview() {
		if(!checkShows()) {
			return;
		}
		System.out.println("Enter the name of the show you would like review");
		printAllShows();
		scanner.nextLine();
		String input = scanner.nextLine();
		for(Show show : shows) {
			if(show.name.equalsIgnoreCase(input)) {
				System.out.println("Rate the movie 0-10");
				int rate = scanner.nextInt();
				if(rate > 10 || rate < 0) {
					System.out.println("Invalid rating. Defaulted to 5");
					rate = 5;
				}
				System.out.println("Enter comments");
				scanner.nextLine();
				String comment = scanner.nextLine();
				show.reviews.add(new Review(user, show, rate, comment));
				return;
			}
		}
		System.out.println("Sorry we couldn't find that show");
	}
	
	/**
	 * Prints the reviews of a show
	 * Checks whether the show exists
	 * Checks whether there are reviews for the show
	 */
	private void displayReviews() {
		System.out.println("Enter the name of the show you want to read about");
		printAllShows();
		scanner.nextLine();
		String input = scanner.nextLine();
		for(Show show : shows) {
			if(show.name.equalsIgnoreCase(input)) {
				if(show.reviews.size() == 0) {
					System.out.println("Currently, there are no reviews for this show");
					return;
				}
				System.out.println("********** Reviews for " + show.name.toUpperCase() + " **********");
				for(Review review : show.reviews) {
					System.out.println(review.toString());
				}
				return;
			}
		}
		System.out.println("Sorry we couldn't find that show");
	}
	
	/**
	 * Allows guests to create an account
	 * Enter all the attributes of an account holder
	 * Moves to log in when an account is created
	 */
	private void createAccount() {
		System.out.println("Enter your name");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Enter a username");
		String username = scanner.nextLine();
		System.out.println("Enter a password");
		String password = scanner.nextLine();
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		System.out.println("Main mode of payment: Cash, Credit Card, or Gift Card?");
		scanner.nextLine();
		String payment = scanner.nextLine();
		if(!payment.equalsIgnoreCase("cash") && !payment.equalsIgnoreCase("credit card") && !payment.equalsIgnoreCase("gift card")) {
			System.out.println("Invalid payment type. Defulted to Cash");
			payment = "cash";
		}
		System.out.println("Are you handicapped? (Y or N)");
		String handicap = scanner.nextLine();
		boolean isHandicap = false;
		if(handicap.equalsIgnoreCase("Y")) {
			isHandicap = true;
		}
		System.out.println("Are you one of the following: Teacher, Military, Student, or Retired");
		String attribute = scanner.nextLine();
		if(!attribute.equalsIgnoreCase("teacher") && !attribute.equalsIgnoreCase("military") && !attribute.equalsIgnoreCase("student") && !attribute.equalsIgnoreCase("retired")) {
			System.out.println("Invalid attribute type. Defulted to none");
			payment = "none";
		}
		AccountHolder newAccount = new AccountHolder(name, "account", username, password, age, payment, isHandicap, attribute);
		accounts.add(newAccount);
		users.add(newAccount);
		login();
	}
	
	/**
	 * Allows current managers and account holders to log in
	 * Checks whether the manager or account exists
	 */
	private void login() {
		System.out.println(LOGIN_MESSAGE);
		System.out.println("Are you an employee? (Y or N)");
		String yesNo = scanner.nextLine();
		if(yesNo.equalsIgnoreCase("y")) {
			System.out.println("Enter your employee ID");
			String userInput = scanner.nextLine();
			for(Manager manager : managers) {
				if(manager.empID.equalsIgnoreCase(userInput)) {
					System.out.println("Enter your password");
					String passInput = scanner.nextLine();
					if(manager.password.equalsIgnoreCase(passInput)) {
						user = new User(manager);
						System.out.println("Welcome " + user.name + " (" + user.type.toUpperCase() + ")");
						runManager();
						return;
					}
				}
			}
		} else {
			System.out.println("Enter your username");
			String userInput = scanner.nextLine();
			for(AccountHolder account : accounts) {
				if(account.username.equalsIgnoreCase(userInput)) {
					System.out.println("Enter your password");
					String passInput = scanner.nextLine();
					if(account.password.equalsIgnoreCase(passInput)) {
						System.out.println("Welcome " + account.name + " (" + account.type.toUpperCase() + ")");
						user = new User(account);
						runAccount();
						return;
					}
				}
			}
		}
		System.out.println("Invalid username or password");
	}
	
	/**
	 * Logs users out if they are logged in
	 */
	private void logout() {
		System.out.println(user.name+ " has logged out");
		user = new User("Guest", "guest");
	}
	
	/**
	 * Allows managers to add shows to their theater
	 * Enter all the attributes of a show
	 * Creates a play, concert, or movie based on input show type
	 */
	public boolean addShow() {
		System.out.println("Enter the theater with this show");
		scanner.nextLine();
		String newTheater = scanner.nextLine();
		for(Theater theater : theaters) {
			if(theater.name.equalsIgnoreCase(newTheater)) {
				System.out.println("Enter the name of the show to add");
				String newShow = scanner.nextLine();
				System.out.println("Enter a description of the show");
				String des = scanner.nextLine();
				System.out.println("Enter the genre of the show");
				String gen = scanner.nextLine();
				System.out.println("How much does a ticket to this show cost");
				double newPri = scanner.nextDouble();
				System.out.println("How long does this show last");
				double newLen = scanner.nextDouble();
				System.out.println("What is the show's MPAA rating");
				scanner.nextLine();
				String newRat = scanner.nextLine();
				System.out.println("What time is this show");
				String newTime = scanner.nextLine();
				System.out.println("Is this show a MOVIE, CONCERT, or PLAY");
				String newType = scanner.nextLine().toUpperCase();
				System.out.println("How many rows of seats will this show have");
				int newRows = scanner.nextInt();
				System.out.println("How many columns of seats will this show have");
				int newCols = scanner.nextInt();
				if(newType.equalsIgnoreCase("movie")) {
					Movie newMovie = new Movie(theater, newShow, des, gen, newPri, newLen, newRat, newTime, newType, newRows, newCols);
					movies.add(newMovie);
					shows.add(newMovie);
				} else if(newType.equalsIgnoreCase("play")) {
					Play newPlay = new Play(theater, newShow, des, gen, newPri, newLen, newRat, newTime, newType, newRows, newCols);
					plays.add(newPlay);
					shows.add(newPlay);
				} else if(newType.equalsIgnoreCase("concert")) {
					Concert newConcert = new Concert(theater, newShow, des, gen, newPri, newLen, newRat, newTime, newType, newRows, newCols);
					concerts.add(newConcert);
					shows.add(newConcert);
				} else {
					System.out.println("Invalid show type. Show not added");
					return false;
				}
				System.out.println(newShow.toUpperCase() + " was successfully added");
				return true;
			}
		}
		System.out.println("That theater does not exist");
		return false;
	}
	
	/**
	 * Allows managers to remove shows with a certain name
	 * Checks whether the show exists
	 */
	public boolean removeShow() {
		if(!checkShows()) {
			return false;
		}
		System.out.println("Enter the name of the show you want to remove");
		printAllShows();
		scanner.nextLine();
		String input = scanner.nextLine();
		for(Show show : shows) {
			if(show.name.equalsIgnoreCase(input)) {
				shows.remove(show);
				return true;
			}
		}
		System.out.println("Sorry we couldn't find " + input.toUpperCase());
		return false;
	}
	
	/**
	 * Allows managers to add refreshments
	 * Enter all the attributes of a refreshment
	 * Checks whether the refreshment already exists
	 */
	public boolean addRefreshment() {
		System.out.println("Enter the name of the refreshment to add");
		scanner.nextLine();
		String newRef = scanner.nextLine().toUpperCase();
		for(Refreshment refreshment : refreshments) {
			if(refreshment.name.equalsIgnoreCase(newRef)) {
				System.out.println(refreshment.name.toUpperCase() + " is already available");
				return false;
			}
		}
		System.out.println("Enter a description of the refreshment");
		String des = scanner.nextLine();
		System.out.println("Enter the nutritional information of the refreshment");
		String nI = scanner.nextLine();
		System.out.println("How much does this refreshment cost");
		double newPrice = scanner.nextDouble();
		if(newPrice < 0.0) {
			System.out.println("Price must be greater than or equal to $0");
			return false;
		}
		refreshments.add(new Refreshment(newRef, des, nI, newPrice));
		System.out.println(newRef.toUpperCase() + " was successfully added to the menu");
		return true;
	}
	
	/**
	 * Allows managers to remove refreshments
	 * Checks whether the refreshment exists
	 */
	public boolean removeRefreshment() {
		if(!checkRefreshments()) {
			return false;
		}
		System.out.println("Enter the refreshment you want to remove");
		for(Refreshment refreshment : refreshments) {
			System.out.println(refreshment.toString());
		}
		scanner.nextLine();
		String input = scanner.nextLine();
		for(Refreshment refreshment : refreshments) {
			if(refreshment.name.equalsIgnoreCase(input)) {
				refreshments.remove(refreshment);
				System.out.println(refreshment.name.toUpperCase() + " was successfully removed");
				return true;
			}
		}
		System.out.println("Sorry we couldn't find " + input.toUpperCase() + " in the refreshments");
		return false;
	}
	
	/**
	 * Prints the tickets purchased by a user to a text file
	 * @param tickets to be printed
	 */
	public int printTickets(Ticket[] tickets) {
		int ticketsPrinted = 0;
		if(tickets == null) {
			ticketsPrinted = -1;
			return ticketsPrinted;
		}
		System.out.println("Your " + tickets.length + " tickets for " + tickets[0].show.name + " have been printed successfully");
		try {
			PrintWriter printTix = new PrintWriter("Printed Tickets", "UTF-8");
			for(int i = 0; i < tickets.length; i++) {
				printTix.print(tickets[i].ticketOutput());
				ticketsPrinted++;
			}
			printTix.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticketsPrinted;
	}
	
	/**
	 * Prints the tickets purchased by a user to the screen
	 * @param tickets to be printed
	 */
	public int loadTickets(Ticket[] tickets) {
		int ticketsLoaded = 0;
		if(tickets == null) {
			ticketsLoaded = -1;
			return ticketsLoaded;
		}
		System.out.println("Here are your " + tickets.length + " tickets for " + tickets[0].show.name + "\n");
		for(int i = 0; i < tickets.length; i++) {
			System.out.println(tickets[i].ticketOutput() + "\n");
			ticketsLoaded++;
		}
		return ticketsLoaded;
	}

}
