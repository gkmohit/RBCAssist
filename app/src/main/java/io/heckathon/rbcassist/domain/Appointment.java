package io.heckathon.rbcassist.domain;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable, Comparable<Appointment> {
	
	private int appointmentId;
	
	private String agentId;

	private String agentName;

	private String location;
	
	private String customerId;
	
	private String serviceTypeId;
	
	private Date date;

	private String status;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getServiceTypeId() {
		return serviceTypeId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(Appointment another) {
		return this.getDate().compareTo(another.getDate());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Appointment that = (Appointment) o;

		return getAppointmentId() == that.getAppointmentId();

	}

	@Override
	public int hashCode() {
		return getAppointmentId();
	}
}
