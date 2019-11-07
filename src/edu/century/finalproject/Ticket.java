package edu.century.finalproject;

import java.util.Date;

public class Ticket {

	String  ticketNumber;
	Movie   movie;
	Theater theater;
	Person  person;
	double  total;
	Date date;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String printTicket() {
		
		String info = "";
		
		
		return info;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", movie=" + movie + ", theater=" + theater + ", person="
				+ person + ", total=" + total + ", date=" + date + "]";
	}
}
