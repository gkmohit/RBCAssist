package io.heckathon.rbcassist.domain;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Person implements Serializable {
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private List<Appointment> appointments  = new ArrayList<Appointment>();

	private List<Appointment> completedAppointments  = new ArrayList<Appointment>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Appointment> getCompletedAppointments() {
		return completedAppointments;
	}

	public void setCompletedAppointments(List<Appointment> completedAppointments) {
		this.completedAppointments = completedAppointments;
	}
}
