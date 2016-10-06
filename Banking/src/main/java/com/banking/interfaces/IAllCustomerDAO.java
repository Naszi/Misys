package com.banking.interfaces;

import java.util.List;

public interface IAllCustomerDAO<Collection> {
	public List<Collection> readAll();
}
