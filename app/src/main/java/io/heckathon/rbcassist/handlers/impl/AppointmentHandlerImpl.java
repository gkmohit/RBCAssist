package io.heckathon.rbcassist.handlers.impl;

import io.heckathon.rbcassist.domain.Agent;
import io.heckathon.rbcassist.domain.Appointment;
import io.heckathon.rbcassist.domain.Customer;

import java.util.ArrayList;
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
		
		customerList.add(customer1);
		customerList.add(customer2);
		
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
		
		agentList.add(agent1);
		agentList.add(agent2);
		
		Appointment appointment1 = new Appointment();
		appointment1.setAppointmentId(appointmentCounter++);
		appointment1.setAgentId(agent1.getAgentId());
		appointment1.setServiceTypeId("1");
		appointment1.setCustomerId(customer1.getCustomerId());
		
	}
	
	public Customer authenticate(String username, String password){
		
		for(Customer cust:customerList){
			if(cust.getUsername().equalsIgnoreCase(username)) {
				return cust;
			}
		}
		
		return null;
	}
	
    public Customer getCustomer(String username){
		
		for(Customer cust:customerList){
			if(cust.getUsername().equalsIgnoreCase(username)) {
				return cust;
			}
		}
		
		return null;
	}
	

}
