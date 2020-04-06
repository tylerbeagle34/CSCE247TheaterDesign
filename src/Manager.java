
public class Manager extends User {

	protected String empID;
	protected int age;
	protected String password;
	protected Theater theater;
	
	public Manager(String name, String type, String empID, int age, String password, Theater theater) {
		super(name, type);
		this.empID = empID;
		this.age = age;
		this.password = password;
		this.theater = theater;
	}
	
	public String toString() {
		return super.toString() + "\tEmployee ID: " + empID;
	}
	
}
