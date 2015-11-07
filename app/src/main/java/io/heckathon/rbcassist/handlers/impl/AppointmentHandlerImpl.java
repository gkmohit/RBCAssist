package io.heckathon.rbcassist.handlers.impl;

import io.heckathon.rbcassist.domain.Agent;
import io.heckathon.rbcassist.domain.Appointment;
import io.heckathon.rbcassist.domain.Customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppointmentHandlerImpl {

	private static final List<Customer> customerList = new ArrayList<Customer>();
	private static final List<Agent> agentList = new ArrayList<Agent>();

	private static int appointmentCounter = 1;

	static {

		Customer customer1 = new Customer();
		customer1.setFirstName("Nilesh");
		customer1.setLastName("Kamani");
		customer1.setCustomerId("nkamani");
		customer1.setUsername("nkamani");
		customer1.setPassword("nkamani");

		Customer customer2 = new Customer();
		customer2.setFirstName("Mohit");
		customer2.setLastName("Kishore");
		customer2.setCustomerId("mkishore");
		customer2.setUsername("mkishore");
		customer2.setPassword("mkishore");



		Agent agent1 = new Agent();
		agent1.setFirstName("James");
		agent1.setLastName("Bond");
		agent1.setAgentId("jbond");
		agent1.setUsername("jbond");
		agent1.setPassword("jbond");

		Agent agent2 = new Agent();
		agent2.setFirstName("John");
		agent2.setLastName("McClane");
		agent2.setAgentId("jmcclane");
		agent2.setUsername("jmcclane");
		agent2.setPassword("jmcclane");


		Appointment appointment1 = new Appointment();
		appointment1.setAppointmentId(appointmentCounter++);
		appointment1.setAgentId(agent1.getAgentId());
		appointment1.setServiceTypeId("1");
		appointment1.setCustomerId(customer1.getCustomerId());
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2015, 11, 30, 12, 30, 0);
		appointment1.setDate(cal1.getTime());

		Appointment appointment2 = new Appointment();
		appointment2.setAppointmentId(appointmentCounter++);
		appointment2.setAgentId(agent1.getAgentId());
		appointment2.setServiceTypeId("1");
		appointment2.setCustomerId(customer1.getCustomerId());
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2015, 11, 29, 11, 30, 0);
		appointment2.setDate(cal2.getTime());

		Appointment appointment3 = new Appointment();
		appointment3.setAppointmentId(appointmentCounter++);
		appointment3.setAgentId(agent1.getAgentId());
		appointment3.setServiceTypeId("1");
		appointment3.setCustomerId(customer1.getCustomerId());
		Calendar cal3 = Calendar.getInstance();
		cal3.set(2015, 11, 30, 12, 30, 0);
		appointment3.setDate(cal3.getTime());

		Appointment appointment4 = new Appointment();
		appointment4.setAppointmentId(appointmentCounter++);
		appointment4.setAgentId(agent1.getAgentId());
		appointment4.setServiceTypeId("1");
		appointment4.setCustomerId(customer1.getCustomerId());
		Calendar cal4 = Calendar.getInstance();
		cal4.set(2015, 11, 29, 11, 30, 0);
		appointment4.setDate(cal4.getTime());

		customer1.getCompletedAppointments().add(appointment1);
		customer1.getCompletedAppointments().add(appointment2);
		customer1.getAppointments().add(appointment3);
		customer1.getAppointments().add(appointment4);

		agent1.getCompletedAppointments().add(appointment1);
		agent1.getCompletedAppointments().add(appointment2);
		agent1.getAppointments().add(appointment3);
		agent1.getAppointments().add(appointment4);

		customerList.add(customer1);
		customerList.add(customer2);
		agentList.add(agent1);
		agentList.add(agent2);


	}

	public static Customer authenticate(String username, String password){

		for(Customer cust:customerList){
			if(cust.getUsername().equalsIgnoreCase(username)) {
				return cust;
			}
		}

		return null;
	}

	public static Customer getCustomer(String username){

		for(Customer cust:customerList){
			if(cust.getUsername().equalsIgnoreCase(username)) {
				return cust;
			}
		}

		return null;
	}


}
