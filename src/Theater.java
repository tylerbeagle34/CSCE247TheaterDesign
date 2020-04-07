import java.util.ArrayList;
import java.io.*;

public class Theater {
	protected ArrayList<Show> shows;
	protected ArrayList<Play> plays;
	protected ArrayList<Movie> movies;
	protected ArrayList<Concert> concerts;
	protected ArrayList<Refreshment> refreshments;
	protected String name;
	protected int theaters;
	
	public Theater(String name, int theaters) {
		shows = new ArrayList<Show>();
		movies = new ArrayList<Movie>();
		concerts = new ArrayList<Concert>();
		plays = new ArrayList<Play>();
		refreshments = new ArrayList<Refreshment>();
		this.name = name;
		this.theaters = theaters;				
	}
	
	public String toString() {
		return "\nTheater Name: " + name;
	}
	
}
