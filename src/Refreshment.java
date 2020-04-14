
/**
 * Defines a Refreshment object and holds the object's information.
 * @author Garrison Davis, Nicholas Mims, Tyler Beagle
 */
public class Refreshment {
	/**
	 * The name of the refreshment.
	 */
	protected String name;
	/**
	 * A description of the refreshment.
	 */
	protected String description;
	/**
	 * The nutritional information of the refreshment.
	 */
	protected String nutritionalInfo;
	/**
	 * The price of the refreshment.
	 */
	protected double price;
	
	/**
	 * Constructs a Refreshment Object.
	 * @param name			The name of the Refreshment.
	 * @param description		A description of the Refreshment.
	 * @param nutritionalInfo	The nutritional information of the refreshment.
	 * @param price			The price of the refreshment.
	 * @return Creates a refreshment object
	 */
	public Refreshment(String name, String description, String nutritionalInfo, double price) {
		this.name = name;
		this.description = description;
		this.nutritionalInfo = nutritionalInfo;
		this.price = price;
	}
	
	/**
	 * @return the Refreshment object in String format
	 */
	public String toString() {
		return "\nName: " + name.toUpperCase() + "\nDescription: " + description + "\nNutritional Facts: " + nutritionalInfo + "\nPrice: $" + price;
	}
}
