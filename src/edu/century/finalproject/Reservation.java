package edu.century.finalproject;

import java.util.Date;
import java.util.*;

public class Reservation {

	private int reservationNumber;
	private Ticket ticketInfo;
	private Date date;
	private String reserveDate;
	public static int count;

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
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

	public Reservation(Ticket ticketInfo) {
		super();
		count++;
		this.reservationNumber = 32000+((count-1)*10) ;
		this.ticketInfo = ticketInfo;
		this.date = new Date();
	}
	
	
	
	public int openSeat(Ticket ticketInfo) {
		
			int start = ticketInfo.getTheater().getNumberSeats();
			int take = ticketInfo.getPay().getNumTickets();
			int newSeats= start - take;
			
			if(newSeats == 0 || newSeats <=0) {
				return 0;
			}else
				return newSeats;
	}
	
	public int refundSeats(Ticket ticket) {
		int start = ticketInfo.getTheater().getNumberSeats();
		int take = ticketInfo.getPay().getNumTickets();
		int newSeats= start + take;
		
		if(newSeats == 30 || newSeats >=30) {
			return 30;
		}else
			return newSeats;
	}

	@Override
	public String toString() {
		String x= " ";
		return String.format("%5sReservation"+"%n-------------------------------"+ "%n%s"+ ticketInfo.getPerson().toString()+ "%n%s"+ ticketInfo.toString()+ "%n%s"+ "Reservation Date: "+
		reserveDate, x,x,x,x);
	}

	
}
