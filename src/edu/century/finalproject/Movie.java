package edu.century.finalproject;

public class Movie {

	private String title;
	private String description;
	private int    duration;
	
	

	public Movie(String title, String description, int duration) {
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

	@Override
	public String toString() {
		return "Movie [title=" + title + ", description=" + description + ", duration=" + duration + "]";
	}
	
	
}
