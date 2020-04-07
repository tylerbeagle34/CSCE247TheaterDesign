/**
<<<<<<< HEAD
 * 
 * This class will generate and store information for users who create an account.
 *
=======
 * AccountHolder Class that extends User
 * Each account holder is a user and has the user name and user type
 * Creates an account holder based upon attributes
 * @author Warren Beagle
>>>>>>> 56e7a9fac3afe845dd99768336e49082a3a57917
 */
public class AccountHolder extends User {

	/**
	 * Protected attributes that can be accessed by the class
	 * Attributes uniquely describe account holders
	 */
	protected String username;
	protected String password;
	protected int age;
	protected String paymentInfo;
	protected boolean isHandicap;
	protected String attribute;
	protected double discount;
	
	/**
	 * Constructor to create an account holder
	 * @param name of the user
	 * @param type of user
	 * @param username of the account holder
	 * @param password of the account holder
	 * @param age of the account holder
	 * @param paymentInfo of the account holder
	 * @param isHandicap; is the account holder handicap
	 * @param attribute; special attributes of the account holder
	 */
	public AccountHolder(String name, String type, String username, String password, int age, String paymentInfo, boolean isHandicap, String attribute) {
		super(name, type);
		this.username = username;
		this.password = password;
		this.age = age;
		this.paymentInfo = paymentInfo;
		this.isHandicap = isHandicap;
		setDiscount(attribute);
	}
	
	/**
	 * To string method to print account holder attributes
	 */
	public String toString() {
		return super.toString() + "\tUsername: " + username;
	}
	
	/**
	 * @return Sets the discount of the account holder based on special attribute
	 * @param attribute of the account holder
>>>>>>> 56e7a9fac3afe845dd99768336e49082a3a57917
	 */
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