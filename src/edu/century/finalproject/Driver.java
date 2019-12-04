package edu.century.finalproject;

import java.util.Hashtable;

public class Driver {
	
	public static void main(String[] args) {
		
//		// Create Movies
//		Movie movie1 = new Movie();
//		movie1.setTitle("Terminator: Dark Fate");
//		movie1.setDescription("");
//		movie1.setDuration(100);
//		
//		Movie movie2 = new Movie();
//		movie2.setTitle("Zombieland: Double Tap");
//		movie2.setDescription("");
//		movie2.setDuration(100);
//		
//		Movie movie3 = new Movie();
//		movie3.setTitle("Maleficent: Mistress of Evil");
//		movie3.setDescription("");
//		movie3.setDuration(100);
//		
//		Movie movie4 = new Movie();
//		movie4.setTitle("Joker");
//		movie4.setDescription("");
//		movie4.setDuration(100);
//		
//		Movie movie5 = new Movie();
//		movie5.setTitle("Countdown");
//		movie5.setDescription("");
//		movie5.setDuration(100);
//		// Create Movies
//		
//		
//		// Create Theaters
//		Theater theater1 = new Theater();
//		theater1.setName("Theater 1");
//		theater1.setNumberSeats(30);
//		
//		Theater theater2 = new Theater();
//		theater2.setName("Theater 2");
//		theater2.setNumberSeats(50);
//		
//		Theater theater3 = new Theater();
//		theater3.setName("Theater 3");
//		theater3.setNumberSeats(40);
//		// End Create Theaters
//		
//		
//		// Create Persons
//		Person person1 = new Person();
//		person1.setFirstName("John");
//		person1.setLastName("Doe");
//		person1.setEmail("john.doe@gmail.com");
//		
//		Person person2 = new Person();
//		person2.setFirstName("Jane");
//		person2.setLastName("Doe");
//		person2.setEmail("jane.doe@gmail.com");
//		
//		Person person3 = new Person();
//		person3.setFirstName("Jake");
//		person3.setLastName("Doe");
//		person3.setEmail("jake.doe@gmail.com");
//		// End Create Persons
//		
//		
//		System.out.println("===== Movies =====");
//		System.out.println(movie1);
//		System.out.println(movie2);
//		System.out.println(movie3);
//		System.out.println(movie4);
//		System.out.println(movie5);
//		System.out.println("/-----------------------------------/");
//		System.out.println("");
//		
//		
//		System.out.println("===== Theaters =====");
//		System.out.println(theater1);
//		System.out.println(theater2);
//		System.out.println(theater3);
//		System.out.println("/-----------------------------------/");
//		System.out.println("");
//		
//		
//		System.out.println("===== Persons =====");
//		System.out.println(person1);
//		System.out.println(person2);
//		System.out.println(person3);
//		System.out.println("/-----------------------------------/");
//		System.out.println("");
		
		
		Movie movie1 = new Movie("Doctor Sleep", 151, "")
    			.addGenre(new Genre("Horror"))
    			.addGenre(new Genre("Suspense/Thriller"))
    			.addTime("7:00p")
    			.addTime("8:30p")
    			.addTime("9:30p")
    			.setImage("DoctorSleep2019.jpg");
    	
    	
		Movie movie2 = new Movie("Last Christmas", 102, "")
    			.addGenre(new Genre("Comedy"))
    			.addGenre(new Genre("Romance"))
    			.addTime("7:00p")
    			.addTime("9:30p")
    			.setImage("LastChristmas2019.jpg");
    	
		Movie movie3 = new Movie("Midway", 138, "")
    			.addGenre(new Genre("Action/Adventure"))
    			.addGenre(new Genre("Drama"))
    			.addGenre(new Genre("War"))
    			.addTime("10:30p")
    			.addTime("11:30p")
    			.setImage("Midway.jpg");
    	
		Hashtable<String, Movie> movies = new Hashtable<String, Movie>();
		
		
		movies.put(movie1.getTitle(), movie1);
		movies.put(movie2.getTitle(), movie2);
		movies.put(movie3.getTitle(), movie3);
		
		System.out.println(movies);
		System.out.println(movies.containsKey("Midw"));
		System.out.println(movies.get("Midway"));
		
		
		
	}

}
