package edu.century.finalproject;

import java.util.Date;
import java.util.Random;

public class Ticket {
	
	private int ticketNumber;
	private Movie movie;
	private Theater theater;
	private Person person;
	private Payment info;
	private Date date;
	
	
	

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



	public Payment getInfo() {
		return info;
	}



	public void setInfo(Payment info) {
		this.info = info;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Ticket( Movie movie, Theater theater,Payment info, Date date) {
		super();
		Random ran = new Random();
		this.ticketNumber = ran.nextInt(10000);
		this.movie = movie;
		this.theater = theater;
		this.info = info;
		this.date = date;
	}

	

	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", movie=" + movie + ", theater=" + theater + ", person="
				+ person + ", total=" + info.getTotal() + ", date=" + date + "]";
	}
}
