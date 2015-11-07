package io.heckathon.rbcassist.domain;

public class Customer extends Person {
	
	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Customer customer = (Customer) o;

		return !(getCustomerId() != null ? !getCustomerId().equals(customer.getCustomerId()) : customer.getCustomerId() != null);

	}

	@Override
	public int hashCode() {
		return getCustomerId() != null ? getCustomerId().hashCode() : 0;
	}
}
