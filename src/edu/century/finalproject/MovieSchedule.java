package edu.century.finalproject;

import java.util.ArrayList;
import java.util.List;

public class MovieSchedule {
	
	private List<MovieScheduleItem> times = new ArrayList<>();
	
	MovieSchedule(){
		super();
	}

	public List<MovieScheduleItem> getScheduleForDay() {
		return times;
	}
	
	public List<MovieTime> getScheduleForDayTimesOnly() {
		
		List<MovieTime> timesForDay = new ArrayList<>(); 
		
		for (int i = 0; i < times.size(); i++) {
			timesForDay.add(times.get(i).getMovieTime());
		}
		return timesForDay;
	}
	
	public int getIndexByTime(MovieTime movieTime) {
		int index;
		for (index = 0; index < times.size(); index++) {
			if(times.get(index).getMovieTime().equals(movieTime)) {
				return index;
			}
			index++;
		}
		return index;
	}
	
	public List<MovieScheduleItem> getTimes() {
		return times;
	}

	public void setTimes(List<MovieScheduleItem> times) {
		this.times = times;
	} 
	
	@Override
	public String toString() {
		return "MovieSchedule [times=" + times + "]";
	}
}
