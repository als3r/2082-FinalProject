package edu.century.finalproject;

public class MovieScheduleItem {

	private Theater   theater;
	private MovieTime time;
	private int       remainingSeats;
	
	MovieScheduleItem(Theater theater, MovieTime time){
		this.theater        = theater;
		this.time           = time;
		this.remainingSeats = theater.getCapacity();
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

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	@Override
	public String toString() {
		return "MovieSchedule [theater=" + theater + ", time=" + time + ", remainingSeats=" + remainingSeats + "]";
	}
}
