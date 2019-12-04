package edu.century.finalproject;

public class Payment {
	
	private Person person;
	private double total;
	private String card;
	private int numTickets;
	
	final double TICKET_PRICE = 5.0;
	
	public int getNumTickets() {
		return numTickets;
	}


	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}


	public Payment(Person person,int numTickets, String card) {
		this.person = person;
		this.numTickets = numTickets;
		total = calculation(numTickets);
		this.card = card;
	}
	

	public Payment() {
		super();
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
	
	public double calculation(int num) {
		double total;
		total = num * TICKET_PRICE;
		return total;
	}

	
	
	
	@Override
	public String toString() {
		return "Payment [person=" + person + ", total=" + total + ", card=" + card + "]";
	}
	
	

}
