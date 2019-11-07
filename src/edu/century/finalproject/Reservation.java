package edu.century.finalproject;

import java.util.Date;

public class Reservation {

	String   reservationNumber;
	Ticket[] tickets;
	int      numberTickets;
	Payment  payment;
	Date     date;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Ticket[] getTickets() {
		return tickets;
	}

	public void setTickets(Ticket[] tickets) {
		this.tickets = tickets;
	}

	public int getNumberTickets() {
		return numberTickets;
	}

	public void setNumberTickets(int numberTickets) {
		this.numberTickets = numberTickets;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String printTicket(int index) {
		
		String info = "";
		
		
		return info;
	}

	public String printTickets() {
		
		String info = "";
		
		
		return info;
	}
	
	public String printReservation() {
		
		String info = "";
		
		
		return info;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
