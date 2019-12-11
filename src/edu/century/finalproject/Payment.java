package edu.century.finalproject;

public class Payment {

	private Person person;
	private double total;
	private String card;
	private int numTickets;
	private double ticketPrice;

	public Payment(Person person, int numTickets, String card, double price) {
		this.person = person;
		this.card = card;
		this.numTickets = numTickets;
		this.ticketPrice = price;
		total = calculation(numTickets);
	}

	public Payment() {
		super();
	}
	
	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
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

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public int getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}

	public double calculation(int num) {
		total = num * ticketPrice;
		return total;
	}

	

	@Override
	public String toString() {
		return "Payment [person=" + person + ", total=" + total + ", card=" + card + "]";
	}

}
