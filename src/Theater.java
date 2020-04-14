import java.util.ArrayList;
import java.io.*;
/*
 * Theater object which holds array lists of all the events taking place, number of theaters,
 * and types refreshments in any given venue.
 */
public class Theater {
	protected ArrayList<Show> shows;
	protected ArrayList<Play> plays;
	protected ArrayList<Movie> movies;
	protected ArrayList<Concert> concerts;
	protected ArrayList<Refreshment> refreshments;
	protected String name;
	protected int theaters;
	
	/**
	 * 
	 * @param name
	 * @param theaters number of theaters in a given venue
	 * @return creates a theater object
	 */
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
		return "\nVenue: " + name + " has " + theaters + " theaters.";
	}
	
}
