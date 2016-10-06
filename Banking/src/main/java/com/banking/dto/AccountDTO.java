package com.banking.dto;

public class AccountDTO {

	private String accountId;
	private int accountNumber;
	private double balance;
	private String currency;
	private String customerId;

	public AccountDTO() {
	}

	public AccountDTO(double balance, int accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public AccountDTO(String accountId, int accountNumber, double balance, String currency, String customerId) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.currency = currency;
		this.customerId = customerId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double withDrawMoney(double amount) {
		return this.balance = this.balance - amount;
	}

	public double addMonney(double amount) {
		return this.balance = this.balance + amount;
	}

}
