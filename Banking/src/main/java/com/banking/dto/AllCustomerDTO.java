package com.banking.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "customers")
public class AllCustomerDTO {

	private String name;
	private String address;
	private String birthday;
	private int accountNumber;
	private double balance;
	private String currency;

	public AllCustomerDTO() {
	}

	public AllCustomerDTO(String name, String address, String birthday, int accountNumber, double balance,
			String currency) {
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllCustomerDTO other = (AllCustomerDTO) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
