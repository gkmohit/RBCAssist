package io.heckathon.rbcassist.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.Serializable;
import java.util.Set;

public class Person implements Serializable {
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private Set<Appointment> appointments  = new HashSet<Appointment>();

	private Set<Appointment> completedAppointments  = new HashSet<Appointment>();

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

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Set<Appointment> getCompletedAppointments() {
		return completedAppointments;
	}

	public void setCompletedAppointments(Set<Appointment> completedAppointments) {
		this.completedAppointments = completedAppointments;
	}
}
