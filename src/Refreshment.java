
public class Refreshment {
	private String name;
	private String description;
	private String nutritionalInfo;
	private double price;
	
	public Refreshment(String name, String description, String nutritionalInfo, double price) {
		this.name = name;
		this.description = description;
		this.nutritionalInfo = nutritionalInfo;
		this.price = price;
	}
	
	public String toString() {
		return "A(n) " + name + " costs $" + price + ", is a(n) " + description +
				" and its nutritional information follows: " + nutritionalInfo;
	}
}
