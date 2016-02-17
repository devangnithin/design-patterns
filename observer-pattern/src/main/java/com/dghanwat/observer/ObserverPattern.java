package com.dghanwat.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
	void notifyAdmissionAvailable();
}

interface Observable {
	void addObserver(Observer o);
	
	void removeObserver(Observer o);
	
	void notifyObservers();
}

class School implements Observable {
	private boolean admissionAvailable;
	
	private List<Observer> potentialUsers = new ArrayList<Observer>();

	public void addObserver(Observer o) {
		potentialUsers.add(o);
		
	}

	public void removeObserver(Observer o) {
		potentialUsers.remove(o);
		
	}

	public void notifyObservers() {
		if(admissionAvailable) {
			for(Observer potentialUser : potentialUsers) {
				potentialUser.notifyAdmissionAvailable();
			}
		}
	}
	
	public void setAdmissionAvailable() {
		// check status
		this.admissionAvailable = true;
		notifyObservers();
	}
	
}

class User implements Observer {

	public void notifyAdmissionAvailable() {
		// Rush to school for Admission before you loose it again 
		System.out.println("Got message from School");
		
	}
	
}
public class ObserverPattern {
	public static void main(String[] args) {
		School school = new School();
		User user = new User();
		school.addObserver(user);
		school.setAdmissionAvailable();
		
	}
}