
/**
 * 
 * This class will construct a refreshment object
 *
 */
public class Refreshment {
	protected String name;
	protected String description;
	protected String nutritionalInfo;
	protected double price;
	
	/**
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
		return "A(n) " + name + " costs $" + price + ", is a(n) " + description +
				" and its nutritional information follows: " + nutritionalInfo;
	}
}
