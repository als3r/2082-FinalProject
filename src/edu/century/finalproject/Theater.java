package edu.century.finalproject;

public class Theater {
	
	private String name;
	private int capacity;
	
	public Theater() {
		super();
	}
	
	public Theater(String name, int numberSeats) {
		this.name = name;
		this.capacity = numberSeats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int numberSeats) {
		this.capacity = numberSeats;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == this) { 
            return true; 
        } 
  
        if (!(obj instanceof Theater)) { 
            return false; 
        } 
          
        Theater theater = (Theater) obj; 
          
        // Compare the data members and return accordingly  
        return this.name.equalsIgnoreCase(theater.getName()) && this.capacity == theater.getCapacity();
	}

	@Override
	public String toString() {
		return "Theater [name = " + name + ", capacity = " + capacity + "]";
	}
}
