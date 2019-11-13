package edu.century.finalproject;

public class Payment {
	
	private Person person;
	private double total;
	private String card;
	private int numTickets;
	
	public Payment(Person person,int numTickets, String card) {
		this.person = person;
		total= calculation(numTickets);
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
		double price = 5.00;
		total = num*price;
		return total;
	}

	
	
	
	@Override
	public String toString() {
		return "Payment [person=" + person + ", total=" + total + ", card=" + card + "]";
	}
	
	

}
