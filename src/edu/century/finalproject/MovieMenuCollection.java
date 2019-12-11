package edu.century.finalproject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieMenuCollection {
	
	private HashMap<String, MovieMenuItem> menuItems;
	
	public MovieMenuCollection() {
		menuItems = new HashMap();
	}
	
	public HashMap<String, MovieMenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(HashMap<String, MovieMenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	public MovieMenuCollection addItem(MovieMenuItem item) {
		menuItems.put(item.getMovie().getTitle(), item);
		return this;
	}
	
	public MovieMenuCollection removeItem(String key) {
		menuItems.remove(key);
		return this;
	}
	
	public static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
        return map.entrySet()
                .stream()
                .filter(x -> predicate.test(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
	
	
	
	public Map<String, MovieMenuItem> search(String searchString) {
		
		Map<String, MovieMenuItem> filteredCollection;
			
		filteredCollection = filterByValue(
				menuItems, 
				x -> (
						x.getMovie().getTitle().toLowerCase().contains(searchString.toLowerCase()) 
				)
		);
		
		return filteredCollection;
	}
	
	public Map<String, MovieMenuItem> search(String searchString, Genre searchGenre) {
		
		Map<String, MovieMenuItem> filteredCollection;
			
		filteredCollection = filterByValue(
				menuItems, 
				x -> (
						(
								x.getMovie().getTitle().toLowerCase().contains(searchString.toLowerCase()) 
						)
						&& 
						x.getMovie().genres.contains(searchGenre)
				)
		);
		
		return filteredCollection;
	}
	
	public Map<String, MovieMenuItem> search(String searchString, MovieTime searchTime) {
		
		Map<String, MovieMenuItem> filteredCollection;
		String searchDate = "2019-12-11";
		
//		System.out.println("test");
//		System.out.println("Last Christmas");
//		System.out.println(menuItems.get("Last Christmas").getSchedule().get(searchDate).getScheduleForDay().get(0));
//		System.out.println(menuItems.get("Last Christmas").getSchedule().get(searchDate).getScheduleForDay().get(0).getMovieTime().equals(searchTime));
//		System.out.println(menuItems.get("Last Christmas").getSchedule().get(searchDate).getScheduleForDay().get(1));
//		System.out.println(menuItems.get("Last Christmas").getSchedule().get(searchDate).getScheduleForDay().get(1).getMovieTime().equals(searchTime));
			
		filteredCollection = filterByValue(
				menuItems, 
				x -> (
						(
								x.getMovie().getTitle().toLowerCase().contains(searchString.toLowerCase()) 
						)
						&& 
						x.getSchedule().get(searchDate).getScheduleForDayTimesOnly().contains(searchTime)
				)
		);
		
		return filteredCollection;
	}
	
	public Map<String, MovieMenuItem> search(String searchString, Genre searchGenre, MovieTime searchTime) {
		
		Map<String, MovieMenuItem> filteredCollection;
		String searchDate = "2019-12-11";
		
		if(searchString.isEmpty()) {
			
			filteredCollection = filterByValue(
					menuItems, 
					x -> (
							x.getMovie().genres.contains(searchGenre)
					)
			);
			
		} else {
			
			filteredCollection = filterByValue(
					menuItems, 
					x -> (
							(
									x.getMovie().getTitle().toLowerCase().contains(searchString.toLowerCase()) 
									|| x.getMovie().getDescription().toLowerCase().contains(searchString.toLowerCase())
							)
							&& 
								x.getMovie().genres.contains(searchGenre)
							&& 
								x.getSchedule().get(searchDate).getTimes().contains(searchTime)
					)
			);
		}
		
		return filteredCollection;
	}
	
}