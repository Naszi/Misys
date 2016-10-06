package com.banking.dto;

public class BankStatisticsDTO {

	private int numberOfCustomer;
	private int numberOfAccount;
	private int moneyInBank;

	public BankStatisticsDTO() {
	}

	public BankStatisticsDTO(int numberOfCustomer) {
		this.numberOfCustomer = numberOfCustomer;
	}

	public int getNumberOfCustomer() {
		return numberOfCustomer;
	}

	public void setNumberOfCustomer(int numberOfCustomer) {
		this.numberOfCustomer = numberOfCustomer;
	}

	public int getNumberOfAccount() {
		return numberOfAccount;
	}

	public void setNumberOfAccount(int numberOfAccount) {
		this.numberOfAccount = numberOfAccount;
	}

	public int getMoneyInBank() {
		return moneyInBank;
	}

	public void setMoneyInBank(int moneyInBank) {
		this.moneyInBank = moneyInBank;
	}

}
