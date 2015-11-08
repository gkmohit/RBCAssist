package io.heckathon.rbcassist.handlers.impl;

import io.heckathon.rbcassist.domain.AccountType;
import io.heckathon.rbcassist.domain.ServiceType;
import io.heckathon.rbcassist.domain.UrgencyType;

import java.util.ArrayList;
import java.util.List;

public class StaticDataHanlder {
	
	private final static List<ServiceType> serviceList = new ArrayList<ServiceType>();
	private final static List<AccountType> accountList = new ArrayList<AccountType>();
	private final static List<UrgencyType> urgencyTypeList = new ArrayList<UrgencyType>();
	
	static {
		
		ServiceType service1 = new ServiceType("1","In Branch");
		ServiceType service2 = new ServiceType("2","Call");
		serviceList.add(service1);
		serviceList.add(service2);

		UrgencyType urgencyType1 = new UrgencyType("1","Call Now");
		UrgencyType urgencyType2 = new UrgencyType("2","Call Later");
		urgencyTypeList.add(urgencyType1);
		urgencyTypeList.add(urgencyType2);

		AccountType acct1 = new AccountType("1","Savings");
		AccountType acct2 = new AccountType("2","Checking");
		AccountType acct3 = new AccountType("3","Mortgage");
		AccountType acct4 = new AccountType("4","Credit Card");
		accountList.add(acct1);
		accountList.add(acct2);
		accountList.add(acct3);
		accountList.add(acct4);
		
	}
		
	
	public static List<ServiceType> getServiceList(){
		return serviceList;
	}

	public static String getServiceType (String serviceTypeId ){
		for(ServiceType service: serviceList){
			if(service.getServiceTypeId().equalsIgnoreCase(serviceTypeId)) {
				return service.getServiceType();
			}
		}

		return null;
	}

	public static List<AccountType> getAccountList(){
		return accountList;
	}

	public static List<UrgencyType> getUrgencyTypeList(){
		return urgencyTypeList;
	}

	public static String getAccountType (String accountTypeId ){
		for(AccountType acct: accountList){
			if(acct.getAccountTypeId().equalsIgnoreCase(accountTypeId)) {
				return acct.getAccountType();
			}
		}

		return null;
	}

	public static String getUrgencyType(String urgencyTypeId ){
		for(UrgencyType urgencyType: urgencyTypeList){
			if(urgencyType.getUrgencyTypeId().equalsIgnoreCase(urgencyTypeId)) {
				return urgencyType.getUrgencyType();
			}
		}

		return null;
	}
}
