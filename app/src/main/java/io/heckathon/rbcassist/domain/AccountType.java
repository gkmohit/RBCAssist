package io.heckathon.rbcassist.domain;

import java.io.Serializable;

public class AccountType implements Serializable {
	
	private String accountTypeId;
	
	private String accountType;

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
