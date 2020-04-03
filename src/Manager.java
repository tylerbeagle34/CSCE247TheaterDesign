
public class Manager extends User {

	protected String employeeID;
	protected int age;
	protected String password;
	
	public Manager(String name, String employeeID, int age, String password) {
		super(name);
		this.employeeID = employeeID;
		this.password = password;
	}
	
	public void addShow(Show show) {
		
	}
	
	public void removeShow(Show show) {
		
	}
	
	public void editShow(Show show) {
		
	}
	
}
