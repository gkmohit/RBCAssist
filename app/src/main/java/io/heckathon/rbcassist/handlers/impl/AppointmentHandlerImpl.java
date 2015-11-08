package io.heckathon.rbcassist.handlers.impl;

import io.heckathon.rbcassist.domain.Agent;
import io.heckathon.rbcassist.domain.Appointment;
import io.heckathon.rbcassist.domain.Customer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class AppointmentHandlerImpl {

	private static final List<Customer> customerList = new ArrayList<Customer>();
	private static final List<Agent> agentList = new ArrayList<Agent>();
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

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
		agent1.setFirstName("David");
		agent1.setLastName("Paul");
		agent1.setAgentId("dpaul");
		agent1.setUsername("dpaul");
		agent1.setPassword("dpaul");

		Agent agent2 = new Agent();
		agent2.setFirstName("Melody");
		agent2.setLastName("Adhami");
		agent2.setAgentId("madhami");
		agent2.setUsername("mdhami");
		agent2.setPassword("mdhami");

		Agent agent3 = new Agent();
		agent3.setFirstName("Darren");
		agent3.setLastName("Murata");
		agent3.setAgentId("dmurata");
		agent3.setUsername("dmurata");
		agent3.setPassword("dmurata");

		Agent agent4 = new Agent();
		agent4.setFirstName("Stephen");
		agent4.setLastName("Schroth");
		agent4.setAgentId("sscroth");
		agent4.setUsername("sscroth");
		agent4.setPassword("sscroth");

		Agent agent5 = new Agent();
		agent5.setFirstName("James");
		agent5.setLastName("McGuire");
		agent5.setAgentId("jmcguire");
		agent5.setUsername("jmcguire");
		agent5.setPassword("jmcguire");

		Agent agent6 = new Agent();
		agent6.setFirstName("Dmitry");
		agent6.setLastName("Barinov");
		agent6.setAgentId("dbarinov");
		agent6.setUsername("dbarinov");
		agent6.setPassword("dbarinov");

		Agent agent7 = new Agent();
		agent7.setFirstName("Esteban");
		agent7.setLastName("Contreras");
		agent7.setAgentId("econtreras");
		agent7.setUsername("econtreras");
		agent7.setPassword("econtreras");

		Appointment appointment1 = new Appointment();
		appointment1.setAppointmentId(appointmentCounter++);
		appointment1.setAgentId(agent1.getAgentId());
		appointment1.setAgentName(getAgentName(agent1.getAgentId()));
		appointment1.setServiceTypeId("1");
		appointment1.setCustomerId(customer1.getCustomerId());
		appointment1.setStatus("Processing");
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2015, 9, 30, 12, 30, 0);
		appointment1.setDate(cal1.getTime());
		appointment1.setStrDate(dateFormatter.format(cal1.getTime()));

		Appointment appointment2 = new Appointment();
		appointment2.setAppointmentId(appointmentCounter++);
		appointment2.setAgentId(agent2.getAgentId());
		appointment2.setAgentName(getAgentName(agent2.getAgentId()));
		appointment2.setServiceTypeId("2");
		appointment2.setStatus("Completed");
		appointment2.setCustomerId(customer1.getCustomerId());
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2015, 9, 29, 11, 30, 0);
		appointment2.setDate(cal2.getTime());
		appointment2.setStrDate(dateFormatter.format(cal2.getTime()));

		Appointment appointment3 = new Appointment();
		appointment3.setAppointmentId(appointmentCounter++);
		appointment3.setAgentId(agent1.getAgentId());
		appointment3.setAgentName(getAgentName(agent1.getAgentId()));
		appointment3.setServiceTypeId("2");
		appointment3.setCustomerId(customer1.getCustomerId());
		Calendar cal3 = Calendar.getInstance();
		cal3.set(2015, 11, 30, 12, 30, 0);
		appointment3.setDate(cal3.getTime());
		appointment3.setStrDate(dateFormatter.format(cal3.getTime()));

		Appointment appointment4 = new Appointment();
		appointment4.setAppointmentId(appointmentCounter++);
		appointment3.setAgentName(getAgentName(agent2.getAgentId()));
		appointment4.setServiceTypeId("2");
		appointment4.setCustomerId(customer1.getCustomerId());
		Calendar cal4 = Calendar.getInstance();
		cal4.set(2015, 11, 29, 11, 30, 0);
		appointment4.setDate(cal4.getTime());
		appointment4.setStrDate(dateFormatter.format(cal4.getTime()));

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
		agentList.add(agent3);
		agentList.add(agent4);
		agentList.add(agent5);
		agentList.add(agent6);
		agentList.add(agent7);


	}

	public static Customer authenticate(String username, String password){

		for(Customer cust:customerList){
			if(cust.getUsername().equalsIgnoreCase(username) && cust.getPassword().equals(password) ) {
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

	public static void deleteAppointment(String customerId, String appointmentId){

		Customer customer = getCustomer(customerId);
		Set<Appointment> appointments = customer.getAppointments();
		appointments.remove(appointmentId);
	}

	public static void addAppointment(String customerId, String agentId, String serviceId, String location, Date date, int waittime){

		Customer customer = getCustomer(customerId);
		Appointment appointment3 = new Appointment();
		appointment3.setAppointmentId(appointmentCounter++);
		appointment3.setAgentId(agentId);
		appointment3.setLocation(location);
		appointment3.setServiceTypeId(serviceId);
		appointment3.setCustomerId(customerId);
		appointment3.setAgentName(getAgentName(agentId));
		if(date!=null) {
			appointment3.setDate(date);
		} else {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MINUTE, waittime);
			appointment3.setDate(cal.getTime());
			appointment3.setStrDate(dateFormatter.format(cal.getTime()));

		}
		customer.getAppointments().add(appointment3);
		customerList.add(customer);
	}

	public static String getAgentName (String agentId ){
		for(Agent agent: agentList){
			if(agent.getAgentId().equalsIgnoreCase(agentId)) {
				return agent.getFirstName() + " " + agent.getLastName();
			}
		}

		return null;
	}

	public static List<Agent> getAgentList (){
		return agentList;
	}

	public static int getWaitTime(){
		return (int)(Math.random() * 15);
	}



}
