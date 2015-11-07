package io.heckathon.rbcassist.domain;

import java.io.Serializable;

public class AccountType implements Serializable {
	
	private String accountTypeId;
	
	private String accountType;

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public String getAccountType() {
		return accountType;
	}

	public AccountType(String accountTypeId, String accountType) {
		this.accountTypeId = accountTypeId;
		this.accountType = accountType;
	}
}
