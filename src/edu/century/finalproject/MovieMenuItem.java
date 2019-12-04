package edu.century.finalproject;

public class MovieMenuItem {
	private Movie movie;
	private Theater theater;
	private String time;
	private int openSeats;
	
	
	
	
	public MovieMenuItem (Movie movie, Theater theater, String time) {
		super();
		this.movie = movie;
		this.theater = theater;
		this.time = time;
		this.openSeats = openSeats;
		this.openSeats = theater.getNumberSeats();
	}




	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public Theater getTheater() {
		return theater;
	}


	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}




	public int getOpenSeats() {
		return openSeats;
	}




	public void setOpenSeats(int openSeats) {
		this.openSeats = openSeats;
	}




	@Override
	public String toString() {
		return "Name: " + movie + "\nTheater: "+ theater+ "\nAvailable Seats: "+ openSeats;
	}

}
