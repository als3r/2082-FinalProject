package edu.century.finalproject;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Driver {
	
	public static void main(String[] args) {
		
		MovieMenuCollection movieMenu = new MovieMenuCollection();
		
		movieMenu.addItem(DefaultData.MENU_ITEM_1);
    	movieMenu.addItem(DefaultData.MENU_ITEM_2);
    	movieMenu.addItem(DefaultData.MENU_ITEM_3);
    	movieMenu.addItem(DefaultData.MENU_ITEM_4);
    	movieMenu.addItem(DefaultData.MENU_ITEM_5);
    	movieMenu.addItem(DefaultData.MENU_ITEM_6);
    	movieMenu.addItem(DefaultData.MENU_ITEM_7);
    	movieMenu.addItem(DefaultData.MENU_ITEM_8);
    	movieMenu.addItem(DefaultData.MENU_ITEM_9);
    	movieMenu.addItem(DefaultData.MENU_ITEM_10);
    	
    	System.out.println(movieMenu);
    	
    	Map<String, MovieMenuItem> collection = movieMenu.getMenuItems().entrySet().stream()
                .filter(map -> map.getKey().contains("Term"))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

//        System.out.println(collection);
        
        Map<String, MovieMenuItem> filteredCollection = movieMenu.search("Ter");
        System.out.println(filteredCollection);
        
        
        System.out.println(DefaultData.MOVIE_1.genres.contains((new Genre("Comedy"))));
        System.out.println(DefaultData.MOVIE_1.genres.contains((new Genre("Suspense"))));
        
        
        MovieTime time1 = new MovieTime ("9:00a");
        MovieTime time2 = new MovieTime ("9:00A");
        
        System.out.println(time1.equals(time2));
		
		
//		System.out.println("===== DEFAULT DATA =====");
//		System.out.println("===== Movies =====");
//		System.out.println(DefaultData.MOVIE_1 + "\n");
//		System.out.println(DefaultData.MOVIE_2 + "\n");
//		System.out.println(DefaultData.MOVIE_3 + "\n");
//		System.out.println(DefaultData.MOVIE_4 + "\n");
//		System.out.println(DefaultData.MOVIE_5 + "\n");
//		System.out.println(DefaultData.MOVIE_6 + "\n");
//		System.out.println(DefaultData.MOVIE_7 + "\n");
//		System.out.println(DefaultData.MOVIE_8 + "\n");
//		System.out.println(DefaultData.MOVIE_9 + "\n");
//		System.out.println(DefaultData.MOVIE_10);
//		System.out.println("/-----------------------------------/");
//		System.out.println("");
//		
//		
//		System.out.println("===== Theaters =====");
//		System.out.println(DefaultData.THEATER_1 + "\n");
//		System.out.println(DefaultData.THEATER_2 + "\n");
//		System.out.println(DefaultData.THEATER_3);
//		System.out.println("/-----------------------------------/");
//		System.out.println("");
//		
//		
//		System.out.println("===== Persons =====");
//		System.out.println(DefaultData.PERSON_1);
//		System.out.println("/-----------------------------------/");
//		System.out.println("");
//		
//		System.out.println("===== Genres =====");
//		System.out.println(DefaultData.GENRE_1.getName() + "\n");
//		System.out.println(DefaultData.GENRE_2.getName() + "\n");
//		System.out.println(DefaultData.GENRE_3.getName() + "\n");
//		System.out.println(DefaultData.GENRE_4.getName() + "\n");
//		System.out.println(DefaultData.GENRE_5.getName() + "\n");
//		System.out.println(DefaultData.GENRE_6.getName() + "\n");
//		System.out.println(DefaultData.GENRE_7.getName() + "\n");
//		System.out.println(DefaultData.GENRE_8.getName());
//		System.out.println("/-----------------------------------/");
//		System.out.println("");
//		
//		System.out.println("");

	}
}
