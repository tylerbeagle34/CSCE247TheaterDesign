
public class Concert extends Show {
	public Concert(String name, String description, String genre, String ratingMPAA, double viewerRating, double price, 
			double length, double time){
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.ratingMPAA = ratingMPAA;
		this.viewerRating = viewerRating;
		this.price = price;
		this.length = length;
		this.time = time;
		this.type = "concert";
	}	
}
