package edu.century.finalproject;

public class Theater {
	
	String name;
	int numberSeats;
	
	public Theater() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberSeats() {
		return numberSeats;
	}

	public void setNumberSeats(int numberSeats) {
		this.numberSeats = numberSeats;
	}

	@Override
	public String toString() {
		return "Theater [name=" + name + ", numberSeats=" + numberSeats + "]";
	}
}
