import java.util.ArrayList;
import java.io.*;

public class Theater {
	private ArrayList<Play> plays = new ArrayList<Play>();
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	private ArrayList<Concert> concerts = new ArrayList<Concert>();
	private ArrayList<Refreshment> refreshments = new ArrayList<Refreshment>();
	private char[][] layout = new char [50][50];
	private String name;
	private int theaters;
	
	public Theater(String name, int theaters, ArrayList <Play> plays, ArrayList <Movie> movies,
					ArrayList <Concert> concerts, ArrayList <Refreshment> refreshments, char[][]layout){
		this.movies = movies;
		this.concerts = concerts;
		this.plays = plays;
		this.refreshments = refreshments;
		this.layout = layout;
		this.name = name;
		this.theaters = theaters;				
	}
	
	public void addShow(String name, String description, String genre, String ratingMPAA, double viewerRating, double price, 
			double length, double time, String type){
		if(type.equalsIgnoreCase("Movie")) {
			Movie movie = new Movie(name,description,genre,ratingMPAA,viewerRating,price, length, time);
			this.movies.add(movie);
		} else if (type.equalsIgnoreCase("Play")) {
			Play play = new Play(name,description,genre,ratingMPAA,viewerRating,price, length, time);
			this.plays.add(play);		
		} else if (type.equalsIgnoreCase("Concert")) {
			Concert concert = new Concert(name,description,genre,ratingMPAA,viewerRating,price, length, time);
			this.concerts.add(concert);
			
		} else {
			System.out.println("Invalid show type");
		}		
	}
	public String search(String showName, String type) {
		//TODO Make a check to ensure the show name is valid
		if(type.equalsIgnoreCase("Movie")) {
			for(Movie movie : this.movies) {
				if(movie.getName().equalsIgnoreCase(showName)) {
					return "The movie " + movie.getName() + " starts at " + movie.getTime()+ " and costs"
							+ movie.getPrice();
				}
			}
		} else if (type.equalsIgnoreCase("Play")) {
			for(Play play : this.plays) {
				if(play.getName().equalsIgnoreCase(showName)) {
					return "The play " + play.getName() + " starts at " + play.getTime()+ " and costs"
							+ play.getPrice();
				}
			}		
		} else if (type.equalsIgnoreCase("Concert")) {
			for(Concert concert: this.concerts) {
				if(concert.getName().equalsIgnoreCase(showName)) {
					return "The concert" + concert.getName() + " starts at " + concert.getTime()
					+ " and costs" + concert.getPrice();
				}
			}			
		} else {
			return "Invalid show type";
		}		
	}
	public void printTicket(String customerName, String type, String showName,int num){
		BufferedWriter ticketPrint = null;
		try {
			ticketPrint = new BufferedWriter(new FileWriter("ticket.txt"));
			ticketPrint.write("This serves as confirmation that " + customerName + " has purchased "
					+ num + " tickets for the following show: " + showName 
					+".\n**********Show information can be found below**********\n" + this.search(showName, type));
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if(ticketPrint != null)
					ticketPrint.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}		
	}
}
