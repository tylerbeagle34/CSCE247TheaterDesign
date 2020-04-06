
public abstract class Show {
	protected String name;
	protected String description;
	protected String genre;
	protected double viewerRating;
	protected double price;
	protected double length;
	protected String ratingMPAA;
	protected double time;
	protected String type;
	
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getGenre() {
		return genre;
	}
	public double getViewerRating() {
		return viewerRating;
	}
	public double getPrice() {
		return price;
	}
	public double getLength() {
		return length;
	}
	public String getRatingMPAA() {
		return ratingMPAA;
	}
	public double getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Here is the information for your upcoming" + type +"! name =" + name + ", description =" + description + ", genre =" + genre + ", viewerRating ="
				+ viewerRating + ", price =" + price + ", length =" + length + ", ratingMPAA =" + ratingMPAA + ", time ="
				+ time;
	}	
	
}
