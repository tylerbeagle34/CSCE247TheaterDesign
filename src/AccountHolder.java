
public class AccountHolder extends User {

	private String username;
	private String password;
	private int age;
	private String paymentInfo;
	private ArrayList<Show> savedShows;
	private ArrayList<Theater> savedTheaters;
	
	public AccountHolder(String name, String username, String password, int age, String paymentInfo) {
		super(name);
		this.username = username;
		this.password = password;
		this.age = age;
		this.paymentInfo = paymentInfo;
	}
	
	public void rateShow(Show show, int rating) {
		
	}
	
	public void rateTheater(Theater theater, int rating) {
		
	}
	
	public void rentTheater(Theater theater) {
		
	}
	
	public void saveShow(Show show) {
		
	}
	
	public void saveTheater(Theater theater) {
		
	}
	
}
