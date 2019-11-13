package edu.century.finalproject;

import java.util.Arrays;

public class MovieMenuCollection {
	private MovieMenuItem[] movie;
	private int itemCounter;

	public MovieMenuCollection() {
		final int INITIAL_CAPACITY = 12;
		itemCounter = 0;
		movie = new MovieMenuItem[INITIAL_CAPACITY];
	}

	public MovieMenuCollection(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Inital Capacity is negative");
		itemCounter = 0;
		movie = new MovieMenuItem[initialCapacity];
	}

	public MovieMenuItem[] getMovie() {
		return movie;
	}

	public void setMovie(MovieMenuItem[] movie) {
		this.movie = movie;
	}

	public int getItemCounter() {
		return itemCounter;
	}

	public void setItemCounter(int itemCounter) {
		this.itemCounter = itemCounter;
	}

	public void ensureCapacity(int newCapacity) {
		MovieMenuItem[] newArrayMovie;
		if (movie.length < newCapacity) {
			newArrayMovie = new MovieMenuItem[newCapacity];
			System.arraycopy(movie, 0, newArrayMovie, 0, itemCounter);
			movie = newArrayMovie;
		}

	}

	public void addMovie(MovieMenuItem element) {
		if (itemCounter == movie.length)
			ensureCapacity(itemCounter * 2);
		movie[itemCounter] = element;
		itemCounter++;
	}

	public void addMany(MovieMenuItem... element) {
		if (itemCounter + element.length > movie.length)
			ensureCapacity((itemCounter + element.length) * 2);
		System.arraycopy(element, 0, movie, 0, element.length);
		itemCounter += element.length;
	}

	public int getCapacity() {
		return movie.length;
	}

	public void TrimArray() {
		MovieMenuItem[] TrimMovieList;
		if (movie.length != itemCounter) {
			TrimMovieList = new MovieMenuItem[itemCounter];
			System.arraycopy(movie, 0, TrimMovieList, 0, itemCounter);
			movie = TrimMovieList;
		}
	}
	//add remove method
	
	
	//add edit method

	// working on search method by title
	public MovieMenuItem searchMovie(String title) {
		for (int i = 0; i < movie.length; i++) {
			if (movie[i].getMovie().getTitle().equals(title))
				return movie[i];
		}
		return null;
	}
	@Override
	public String toString() {
		return "MovieMenuCollection [movie=" + Arrays.toString(movie) + ", itemCounter=" + itemCounter + "]";
	}

}