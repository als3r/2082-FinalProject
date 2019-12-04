package edu.century.finalproject;

import java.util.Date;
import java.util.*;

public class Reservation {

	private int reservationNumber;
	private Ticket ticketInfo;
	private int numberTickets;
	private Date date;
	
	public Reservation() {
		super();
		Random ran = new Random();
		this.reservationNumber = ran.nextInt(10000);
	}

	public Reservation(Ticket ticketInfo, Payment payment, Date date) {
		super();
		Random ran = new Random();
		this.reservationNumber = ran.nextInt(10000);
		this.ticketInfo = ticketInfo;
		this.date = date;
	}

	public int getNumberTickets() {
		return numberTickets;
	}

	public void setNumberTickets(int numberTickets) {
		this.numberTickets = numberTickets;
	}
	
	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Ticket getTicketInfo() {
		return ticketInfo;
	}

	public void setTicketInfo(Ticket ticketInfo) {
		this.ticketInfo = ticketInfo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Reservation [reservationNumber:" + reservationNumber + ", ticketInfo:" + ticketInfo.toString()
				+ ", date=" + date + "]";
	}

	public String toStringAdmin() {
		return "Reservation [reservationNumber:" + reservationNumber + ", ticketInfo:" + ticketInfo.toString()
				+ ", date=" + date + "]";
	}

}
