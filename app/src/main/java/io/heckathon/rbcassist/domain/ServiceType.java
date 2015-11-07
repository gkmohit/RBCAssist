package io.heckathon.rbcassist.domain;

public class ServiceType {
	
	private String serviceTypeId;
	
	private String serviceType;
	
	

	public ServiceType(String serviceTypeId, String serviceType) {
		super();
		this.serviceTypeId = serviceTypeId;
		this.serviceType = serviceType;
	}

	public String getServiceTypeId() {
		return serviceTypeId;
	}

	public String getServiceType() {
		return serviceType;
	}
		
}
