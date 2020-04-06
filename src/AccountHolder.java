import java.util.*;
public class AccountHolder extends User {

	protected String username;
	protected String password;
	protected int age;
	protected String paymentInfo;
	protected boolean isHandicap;
	protected String attribute;
	protected double discount;
	protected ArrayList<Show> savedShows;
	protected ArrayList<Theater> savedTheaters;
	
	public AccountHolder(String name, String username, String password, int age, String paymentInfo, boolean isHandicap, String attribute) {
		super(name);
		this.username = username;
		this.password = password;
		this.age = age;
		this.paymentInfo = paymentInfo;
		this.isHandicap = isHandicap;
		setDiscount(attribute);
		savedShows = new ArrayList<Show>();
		savedTheaters = new ArrayList<savedTheaters>();
	}
	
	public void rateShow(Show show, int rating, String comment) {
		
	}
	
	public void rateTheater(Theater theater, int rating) {
		
	}
	
	public void rentTheater(Theater theater) {
		
	}
	
	public void saveShow(Show show) {
		
	}
	
	public void saveTheater(Theater theater) {
		
	}
	
	private void setDiscount(String attribute) {
		if(attribute.equalsIgnoreCase("teacher")) {
			this.discount = 0.2;
		}
		else if(attribute.equalsIgnoreCase("military")) {
			this.discount = 0.3;
		}
		else if(attribute.equalsIgnoreCase("student")) {
			this.discount = 0.1;
		}
		else if(attribute.equalsIgnoreCase("retired")) {
			this.discount = 0.2;
		}
		else {
			this.discount = 0.0;
		}
	}
	
}
