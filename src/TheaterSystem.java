import java.io.PrintWriter;
import java.util.*;
public class TheaterSystem {

	private static final String WELCOME_MESSAGE = "********** Welcome to the Leaking Memory Ticket System **********";
	private static final String CLOSING_MESSAGE = "********** Thank you for using the Leaking Memory Ticket System! Have a nice day! **********";
	private static final String LOGIN_MESSAGE = "********** Logging In **********";
	private String[] guestMenuOptions = {"Buy Tickets","Create Account","Login","Read Reviews","Exit"};
	private String[] accountMenuOptions = {"Buy Tickets","Buy Refreshments","Write a Review","Read Reviews","Logout"};
	private String[] managerMenuOptions = {"Add Show","Remove Show","Add Refreshment","Remove Refreshment","Logout"};
	private Scanner scanner;
	private User user;
	private ArrayList<User> users;
	private ArrayList<Manager> managers;
	private ArrayList<AccountHolder> accounts;
	private ArrayList<Show> shows;
	private ArrayList<Refreshment> refreshments;
	
	public TheaterSystem() {
		scanner = new Scanner(System.in);
		user = new User("Guest", "guest");
		users = new ArrayList<User>();
		managers = new ArrayList<Manager>();
		accounts = new ArrayList<AccountHolder>();
		shows = new ArrayList<Show>();
		refreshments = new ArrayList<Refreshment>();
	}
	
	private void loadData() {
		Theater movieTheater = new Theater("Columbia Movie Theater");
		Theater playTheater = new Theater("Columbia Play Theater");
		Theater concertVenue = new Theater("Columbia Concert Venue");
		Show frozen2 = new Show(movieTheater, "Frozen 2", "Kids", 8.00, "1200", "PG", 10, 10);
		Show jungleBook = new Show(movieTheater, "The Jungle Book", "Family", 8.00, "1430", "PG", 8, 8);
		shows.add(frozen2);
		shows.add(jungleBook);
		
		AccountHolder existing = new AccountHolder("Exisiting User", "account", "existing", "existing", 21, "Cash", false, "student");
		accounts.add(existing);
		users.add(existing);
		
		Manager employee = new Manager("Playhouse Manager", "manager", "12345", 30, "manager", playTheater);
		managers.add(employee);
		users.add(employee);
	}
	
	public void runMain() {
		loadData();
		boolean isRunning = true;
		System.out.println(WELCOME_MESSAGE);
		while(isRunning) {
			displayMainMenu(user.type.toUpperCase());
			int userCommand = scanner.nextInt();
			switch(userCommand) {
				case(1):
					buyTickets();
					break;
				case(2):
					createAccount();
					break;
				case(3):
					scanner.nextLine();
					login();
					break;
				case(4):
					displayReviews();
					break;
				default: 
					isRunning = false;
					break;
			}
		}
		System.out.println(CLOSING_MESSAGE);
	}
	
	public void runAccount() {
		boolean isAccount = true;
		while(isAccount) {
			displayMainMenu(user.type.toUpperCase());
			int userCommand = scanner.nextInt();
			switch(userCommand) {
				case(1):
					buyTickets();
					break;
				case(2):
					buyRefreshments();
					break;
				case(3):
					writeReview();
					break;
				case(4):
					displayReviews();
					break;
				default:
					isAccount = false;
					logout();
					break;
			}
		}
	}
	
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
	
	private void buyTickets() {
		if(!checkShows()) {
			return;
		}
		System.out.println("Enter the name of the show you would like to buy tickets to");
		printShows();
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
					Ticket purTix = new Ticket(show, user, seat);
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
	
	private void printShows() {
		for(Show show : shows) {
			System.out.println(show.toString());
			System.out.println("Tickets Remaining: " + show.numTickets);
		}
	}
	
	private boolean checkShows() {
		if(shows.size() == 0) {
			System.out.println("There are no shows at this time");
			return false;
		}
		return true;
	}
	
	private void buyRefreshments() {
		if(!checkRefreshments()) {
			return;
		}
		System.out.println("Enter the name of the refreshment you would like to buy");
		printRefreshments();
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
	
	private void printRefreshments() {
		for(Refreshment refreshment : refreshments) {
			System.out.println(refreshment.toString());
		}
	}
	
	private boolean checkRefreshments() {
		if(refreshments.size() == 0) {
			System.out.println("There are no refreshments at this time");
			return false;
		}
		return true;
	}
	
	private void writeReview() {
		if(!checkShows()) {
			return;
		}
		System.out.println("Enter the name of the show you would like review");
		printShows();
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
	
	private void displayReviews() {
		System.out.println("Enter the name of the show you want to read about");
		printShows();
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
	
	private void logout() {
		System.out.println(user.name+ " has logged out");
		user = new User("Guest", "guest");
	}
	
	private void addShow() {
		
	}
	
	private void removeShow() {
		System.out.println("Enter the name of the show you want to remove");
		printShows();
		scanner.nextLine();
		String input = scanner.nextLine();
		for(Show show : shows) {
			if(show.name.equalsIgnoreCase(input)) {
				shows.remove(show);
				return;
			}
		}
		System.out.println("Sorry we couldn't find that show");
	}
	
	private void addRefreshment() {
		System.out.println("Enter the name of the refreshment to add");
		scanner.nextLine();
		String newRef = scanner.nextLine().toUpperCase();
		for(Refreshment refreshment : refreshments) {
			if(refreshment.name.equalsIgnoreCase(newRef)) {
				System.out.println("This refreshment is already available");
				return;
			}
		}
		System.out.println("Enter a description of the refreshment");
		String des = scanner.nextLine();
		System.out.println("Enter the nutritional information of the refreshment");
		String nI = scanner.nextLine();
		System.out.println("How much does this refreshment cost");
		double newPrice = scanner.nextDouble();
		refreshments.add(new Refreshment(newRef, des, nI, newPrice));
		System.out.println(newRef + " was successfully added to the menu");
	}
	
	private void removeRefreshment() {
		System.out.println("Enter the refreshment you want to remove");
		for(Refreshment refreshment : refreshments) {
			System.out.println(refreshment.toString());
		}
		scanner.nextLine();
		String input = scanner.nextLine();
		for(Refreshment refreshment : refreshments) {
			if(refreshment.name.equalsIgnoreCase(input)) {
				refreshments.remove(refreshment);
				return;
			}
		}
		System.out.println("Sorry we couldn't find that refreshment");
	}
	
	public void printTickets(Ticket[] tickets) {
		System.out.println("Your " + tickets.length + " tickets for " + tickets[0].show.name + " have been printed successfully");
		try {
			PrintWriter printTix = new PrintWriter("Printed Tickets", "UTF-8");
			for(int i = 0; i < tickets.length; i++) {
				printTix.print(tickets[i].ticketOutput());
			}
			printTix.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadTickets(Ticket[] tickets) {
		System.out.println("Here are your " + tickets.length + " tickets for " + tickets[0].show.name + "\n");
		for(int i = 0; i < tickets.length; i++) {
			System.out.println(tickets[i].ticketOutput() + "\n");
		}
	}

}
