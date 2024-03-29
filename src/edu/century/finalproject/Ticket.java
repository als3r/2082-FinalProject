package edu.century.finalproject;

import java.text.*;
import java.util.*;

public class Ticket {

	private int       ticketNumber;
	private Movie     movie;
	private Theater   theater;
	private Person    person;
	private String    total;
	private Date      date;
	private String    movieTime;
	private String    movieDate;
	private Payment   pay;
	public static int count;
	public static final NumberFormat USD = NumberFormat.getCurrencyInstance();
	
	public Ticket() {
		super();
		count++;
		this.ticketNumber = 1000+((count-1)*5);
		this.date = new Date();
	}
	
	public Ticket( Movie movie, Theater theater, Person person,Payment pay) {
		super();
		count++;
		
		this.ticketNumber = 1000+((count-1)*5);
		this.movie = movie;
		this.theater = theater;
		this.person = person;
		this.total = USD.format(pay.getTotal());
		this.date = new Date();
		this.pay = pay;
	}
	
	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	
	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public Payment getPay() {
		return pay;
	}

	public void setPay(Payment pay) {
		this.pay = pay;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		String x =" ";
		return String.format("Cinema Ticket #" + ticketNumber + "%n%5s" 
		+ "Movie: "  + movie.getTitle()  + "%n%5s"
		+ "Date: "   + movieDate + "%n%5s"
		+ "Time: "   + movieTime + "%n%5s"
		+ "Theater: "+ theater.getName() + "%n%5s"
		+ "Tickets: "+ pay.getNumTickets() + "%n%5s"
		+ "Total: "  + USD.format(pay.getTotal()) + "%n%5s"+
		"Date: " + date, x,x,x,x,x,x,x);
	}
}
