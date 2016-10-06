package com.banking.interfaces;

public interface IBankingStatisticDAO<Colection> {
	
	public Colection numberOfCustomers();

	public int numberOfAccount();

	public int moneyInBank();
}
