package edu.century.finalproject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.LinkedList; 
import java.util.List; 
import java.util.Collections; 
import java.util.Comparator; 
import java.util.LinkedHashMap; 

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
		
		Map temp = map.entrySet()
                .stream()
                .filter(x -> predicate.test(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
        return temp;
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
				x -> (x.getMovie().getTitle().toLowerCase().contains(searchString.toLowerCase()))
		);
		
		filteredCollection = filterByValue(
				filteredCollection, 
				x -> (x.getMovie().genres.contains(searchGenre))
		);
		
		return filteredCollection;
	}
	
	public Map<String, MovieMenuItem> search(String searchString, MovieTime searchTime) {
		
		Map<String, MovieMenuItem> filteredCollection;
		String searchDate = "2019-12-11";
			
		filteredCollection = filterByValue(
				menuItems, 
				x -> (x.getMovie().getTitle().toLowerCase().contains(searchString.toLowerCase()))
		);
		
		filteredCollection = filterByValue(
				filteredCollection, 
				x -> (x.getSchedule().get(searchDate).getScheduleForDayTimesOnly().contains(searchTime))
		);
		
		return filteredCollection;
	}
	
	public Map<String, MovieMenuItem> search(String searchString, Genre searchGenre, MovieTime searchTime) {
		
		Map<String, MovieMenuItem> filteredCollection;
		String searchDate = "2019-12-11";
		
		if(searchString.isEmpty()) {
			
			filteredCollection = filterByValue(
					menuItems, 
					x -> (x.getMovie().genres.contains(searchGenre))
			);
			
			filteredCollection = filterByValue(
					filteredCollection, 
					x -> (x.getSchedule().get(searchDate).getScheduleForDayTimesOnly().contains(searchTime))
			);
			
		} else {
			
			filteredCollection = filterByValue(
					menuItems, 
					x -> (x.getMovie().getTitle().toLowerCase().contains(searchString.toLowerCase()))
			);
			
			filteredCollection = filterByValue(
					filteredCollection, 
					x -> (x.getMovie().genres.contains(searchGenre))
			);
			
			filteredCollection = filterByValue(
					filteredCollection, 
					x -> (x.getSchedule().get(searchDate).getScheduleForDayTimesOnly().contains(searchTime))
			);
		}
		
		return filteredCollection;
	}	
}