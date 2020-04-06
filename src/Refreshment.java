
/**
 * Defines a Refreshment object and holds the object's information.
 * @author Nicholas Mims
 */
public class Refreshment {
	/**
	 * The name of the refreshment.
	 */
	private String name;
	/**
	 * A description of the refreshment.
	 */
	private String description;
	/**
	 * The nutritional information of the refreshment.
	 */
	private String nutritionalInfo;
	/**
	 * The price of the refreshment.
	 */
	private double price;
	
	/**
	 * Constructs a Refreshment object.
	 * @param name				The name of the Refreshment.
	 * @param description		A description of the Refreshment.
	 * @param nutritionalInfo	The nutritional information of the refreshment.
	 * @param price				The price of the refreshment.
	 */
	public Refreshment(String name, String description, String nutritionalInfo, double price) {
		this.name = name;
		this.description = description;
		this.nutritionalInfo = nutritionalInfo;
		this.price = price;
	}
	
	/**
	 * Returns the information of the Refreshment object in String format.
	 * @return the Refreshment object in String format
	 */
	public String toString() {
		return "A(n) " + name + " costs $" + price + ", is a(n) " + description +
				" and its nutritional information follows: " + nutritionalInfo;
	}
}
