package edu.century.finalproject;

public class Genre {
	
	String name;
	
	public Genre(String genre) {
		name = genre;
	}
	
	public String getGenreName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == this) { 
            return true; 
        } 
  
        if (!(obj instanceof Genre)) { 
            return false; 
        } 
          
        Genre genre = (Genre) obj; 
          
        // Compare the data members and return accordingly  
        return this.name.equalsIgnoreCase(genre.getGenreName());
	}

	@Override
	public String toString() {
		return "Genre [name=" + name + "]";
	}
}
