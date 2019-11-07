package edu.century.finalproject;

public class Movie {

	String title;
	String description;
	int    duration;
	
	public Movie() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Movie [title=" + title + ", description=" + description + ", duration=" + duration + "]";
	}
	
	
}
