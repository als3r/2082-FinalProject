package edu.century.finalproject;

public class MovieTime {

	String time;
	
	public MovieTime(String time) {
		this.time = time;
	}

	public String getTimeString() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == this) { 
            return true; 
        } 
  
        if (!(obj instanceof MovieTime)) { 
            return false; 
        } 
          
        MovieTime movieTime = (MovieTime) obj; 
          
        // Compare the data members and return accordingly  
        return this.time.equalsIgnoreCase(movieTime.getTimeString());
	}
	
	@Override
	public String toString() {
		return "MovieTime [time=" + time + "]";
	}
}
