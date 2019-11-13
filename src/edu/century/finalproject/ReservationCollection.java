package edu.century.finalproject;

import java.util.Arrays;

public class ReservationCollection {
	private Reservation[] reservation;
	private int itemCounter;
	
	
	
	public ReservationCollection() {
		super();
		final int INITIAL_CAPACITY = 12;
		itemCounter = 0;
		reservation = new Reservation[INITIAL_CAPACITY];
		
	}
	public ReservationCollection(int initial) {
		if(initial < 0)
			throw new IllegalArgumentException
			("Inital Capacity is negative");
		itemCounter = 0;
		reservation = new Reservation[initial];
	}
	public Reservation[] getReservation() {
		return reservation;
	}
	public void setReservation(Reservation[] reservation) {
		this.reservation = reservation;
	}
	public int getItemCounter() {
		return itemCounter;
	}
	public void setItemCounter(int itemCounter) {
		this.itemCounter = itemCounter;
	}
	
	public void ensureCapacity(int newCapacity) {
		Reservation[] newReservation;
		if(reservation.length < newCapacity) {
			newReservation= new Reservation[newCapacity];
			System.arraycopy(reservation, 0, newReservation, 0, itemCounter);
		}
	}
	
	public void addReservation(Reservation element) {
		if(itemCounter == reservation.length)
			ensureCapacity(itemCounter*2);
		reservation[itemCounter]= element;
		itemCounter++;
	}
	
	public void addMany(Reservation...element) {
		if(itemCounter + element.length > reservation.length)
			ensureCapacity((itemCounter + element.length)*2);
		System.arraycopy(element, 0, reservation, 0, element.length);
		itemCounter += element.length;
	}
	
	public boolean remove(Reservation target) {
		int index=0;
		while((index<itemCounter) && (target!=reservation[index]))
				index++;
		if(index == itemCounter)
			return false;
		else 
		{
			itemCounter--;
			reservation[index]= reservation[itemCounter];
			return true;
		}
	}
	public int getCapacity() {
		return reservation.length;
	}
	
	public void TrimArray() {
		Reservation[] TrimList;
		if(reservation.length != itemCounter) {
			TrimList = new Reservation[itemCounter];
			System.arraycopy(reservation, 0, TrimList, 0, itemCounter);
			reservation = TrimList;
		}
	}
	//add search
	
	@Override
	public String toString() {
		return "ReservationCollection [reservation=" + Arrays.toString(reservation) + ", itemCounter=" + itemCounter
				+ "]";
	}
	
	
	


}
