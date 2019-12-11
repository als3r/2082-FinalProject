package edu.century.finalproject;

public class testing {

	public static void main(String[] args) {
		Person person;
		Ticket ticket1;
		Theater theater1 = theater1 = new Theater("Theater A", 30);
		;
		Movie movie1;
		Payment pay;
		
		System.out.println(theater1.toString());
		person = new Person("John", "Doe", "Doe@email.com");
		pay = new Payment(person, 31, "51515151");
	
		
		movie1 = new Movie("Days Gone", 126, "Zombies");

		ticket1 = new Ticket(movie1, theater1, person, pay);

		Reservation reserve1 = new Reservation(ticket1);
		reserve1.setReserveDate("12/05/19");
		theater1.setCapacity(reserve1.openSeat(ticket1));

		System.out.println(theater1.toString());
		System.out.println(ticket1.toString());
		// System.out.println(reserve1.toString());

	}

}
