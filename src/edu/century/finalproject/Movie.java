package edu.century.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Movie implements Comparable<Movie> {

	private String title;
	private String description;
	private String image;
	int    duration;
	public List<Genre> genres = new ArrayList<>();
	public List<String> times = new ArrayList<>();
	
	public Movie(String title, int duration, String description) {
		super();
		this.title       = title;
		this.description = description;
		this.duration    = duration;
	}
	
	
	public void sortDuration() {
		
	}
	
	public Movie() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public Movie setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Movie setDescription(String description) {
		this.description = description;
		return this;
	}

	public int getDuration() {
		return duration;
	}

	public Movie setDuration(int duration) {
		this.duration = duration;
		return this;
	}
	
	public String getImage() {
		return image;
	}

	public Movie setImage(String image) {
		this.image = image;
		return this;
	}
	
	public Movie addTime(String time) {
		times.add(time);
		return this;
	}
	
	public Movie removeTime(int index) {
		times.remove(index);
		return this;
	}
	
	public Movie addGenre(Genre genre) {
		genres.add(genre);
		return this;
	}
	
	public Movie removeGenre(int index) {
		genres.remove(index);
		return this;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", description=" + description + ", duration=" + duration + "]";
	}
	
	public void sort() {
		Collections.sort(times);
	}
//	public void sortGenre() {
//		Collections.sort((List<Genre>) genres);
//	}

	@Override
	public int compareTo(Movie o) {
		return this.getTitle().compareTo(o.getTitle());
	}
	
	
}
