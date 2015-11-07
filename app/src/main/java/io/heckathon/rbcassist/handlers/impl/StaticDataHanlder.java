package io.heckathon.rbcassist.handlers.impl;

import io.heckathon.rbcassist.domain.ServiceType;

import java.util.ArrayList;
import java.util.List;

public class StaticDataHanlder {
	
	private final static List<ServiceType> serviceList = new ArrayList<ServiceType>();
	
	static {
		
		ServiceType service1 = new ServiceType("1","In Branch Appointment");
		ServiceType service2 = new ServiceType("2","Call Appointment");
		serviceList.add(service1);
		serviceList.add(service2);
		
	}
		
	
	public static List<ServiceType> getServiceList(){
		return serviceList;
	}
}
