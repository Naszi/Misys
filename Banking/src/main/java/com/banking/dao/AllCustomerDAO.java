package com.banking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.connection.DatabaseConnection;
import com.banking.dto.AllCustomerDTO;
import com.banking.interfaces.IAllCustomerDAO;

public class AllCustomerDAO implements IAllCustomerDAO<AllCustomerDTO> {

	private static final String SQL_READALL = "SELECT CUSTOMER.NAME, CUSTOMER.ADDRESS, CUSTOMER.BIRTHDAY,"
			+ " ACCOUNT.ACCOUNTNUMBER, ACCOUNT.BALANCE, ACCOUNT.CURRENCY FROM CUSTOMER"
			+ " INNER JOIN ACCOUNT ON CUSTOMER.CUSTOMERID=ACCOUNT.CUSTOMERID";

	private static final DatabaseConnection connection = DatabaseConnection.namelyState();

	@Override
	public List<AllCustomerDTO> readAll() {

		PreparedStatement statement;
		ResultSet set;
		List<AllCustomerDTO> customers = new ArrayList<>();

		try {
			statement = connection.getConnection().prepareStatement(SQL_READALL);
			set = statement.executeQuery();

			while (set.next()) {
				customers.add(new AllCustomerDTO(set.getString(1), set.getString(2), set.getString(3), set.getInt(4),
						set.getDouble(5), set.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return customers;
	}

}
