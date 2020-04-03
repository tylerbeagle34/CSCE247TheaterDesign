
public class AccountHolder extends User {

	protected String username;
	protected String password;
	protected int age;
	protected String paymentInfo;
	private ArrayList<Show> savedShows;
	private ArrayList<Theater> savedTheaters;
	
	public AccountHolder(String name, String username, String password, int age, String paymentInfo) {
		super(name);
		this.username = username;
		this.password = password;
		this.age = age;
		this.paymentInfo = paymentInfo;
	}
	
	public void rateShow(int rating) {
		
	}
	
	public void rateTheater(int rating) {
		
	}
	
	public void rentTheater(Theater theater) {
		
	}
	
	public void saveShow(Show show) {
		
	}
	
	public void saveTheater(Theater theater) {
		
	}
	
}
