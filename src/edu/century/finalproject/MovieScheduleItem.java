package edu.century.finalproject;

import java.util.Random;

public class MovieScheduleItem {

	private Theater   theater;
	private MovieTime time;
	private int       remainingSeats;
	
	MovieScheduleItem(Theater theater, MovieTime time){
		
		Random random    = new Random();
		int randomNumber = random.nextInt(10);
				
		this.theater        = theater;
		this.time           = time;
		this.remainingSeats = 0 + randomNumber;
	}
	
	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public MovieTime getMovieTime() {
		return time;
	}

	public void setTime(MovieTime time) {
		this.time = time;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}
	
	public void addRemainingSeats(int number) {
		remainingSeats += number;
	}
	
	public void substractRemainingSeats(int number) {
		remainingSeats -= number;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	@Override
	public String toString() {
		return "MovieSchedule [theater=" + theater + ", time=" + time + ", remainingSeats=" + remainingSeats + "]";
	}
}
