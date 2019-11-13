package edu.century.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	private String title;
	private String description;
	private String image;
	int    duration;
	public List<Genre> genres = new ArrayList<>();
	public List<String> times = new ArrayList<>();
	
	public Movie(String title, int duration, String description) {
		super();
		this.title = title;
		this.description = description;
		this.duration = duration;
	}
	
	public Movie() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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
	
	
}
