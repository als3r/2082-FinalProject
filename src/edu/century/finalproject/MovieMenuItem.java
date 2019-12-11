package edu.century.finalproject;

import java.util.HashMap;

public class MovieMenuItem {
	
	private Movie   movie;
	private HashMap<String, MovieSchedule> schedule;

	public MovieMenuItem (Movie movie) {
		super();
		this.movie = movie;
		this.schedule = new HashMap<String, MovieSchedule>();
		setUpScheduleForWeek();
	}
	
	public HashMap<String, MovieSchedule> getSchedule() {
		return schedule;
	}


	public void setSchedule(HashMap<String, MovieSchedule> schedule) {
		this.schedule = schedule;
	}	
	
	private void setUpScheduleForWeek() {
		
		for (int i = 9; i <= 15; i++) {
			this.schedule.put("2019-12-" + Integer.valueOf(i), (new MovieSchedule()));
		}
	}
	
	public MovieMenuItem addScheduleForWeek(Theater theater, MovieTime time) {
		
		MovieScheduleItem movieScheduleItem = new MovieScheduleItem(theater, time);
		for (int i = 9; i <= 15; i++) {
			this.schedule.get("2019-12-" + Integer.valueOf(i)).getTimes().add(movieScheduleItem);
		}
		return this;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Name: " + movie + "\n\n" + "Schedule: " + schedule.toString();
	}

}
