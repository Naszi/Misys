package com.banking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banking.connection.DatabaseConnection;
import com.banking.dto.BankStatisticsDTO;
import com.banking.interfaces.IBankingStatisticDAO;

public class BankStatisticsDAO implements IBankingStatisticDAO<BankStatisticsDTO> {

	private static final String SQL_NUMBER_OF_CUSTOMERS = "SELECT COUNT(*) FROM CUSTOMER";
	private static final String SQL_NUMBER_OF_ACCOUNT = "SELECT COUNT(*) FROM ACCOUNT";
	private static final String SQL_MONEY_IN_BANK = "SELECT SUM(BALANCE) FROM ACCOUNT";

	private static final DatabaseConnection connection = DatabaseConnection.customerConnection();

	private BankStatisticsDTO bankStatisticDTO = null;

	@Override
	public BankStatisticsDTO numberOfCustomers() {
		PreparedStatement statement;
		ResultSet set;
		BankStatisticsDTO bankStatisticsDTO = null;
		int customers;

		try {
			statement = connection.getConnection().prepareStatement(SQL_NUMBER_OF_CUSTOMERS);
			set = statement.executeQuery();
			if (set.next()) {
				customers = set.getInt(1);
				bankStatisticDTO = new BankStatisticsDTO(set.getInt(customers));
			}
			return bankStatisticDTO;
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}
		return bankStatisticsDTO;
	}

	@Override
	public int numberOfAccount() {
		PreparedStatement statement;
		ResultSet set;
		
		int customer;
		
		try {
			statement = connection.getConnection().prepareStatement(SQL_NUMBER_OF_ACCOUNT);
			set = statement.executeQuery();
			if (set.next()) {
				customer = set.getInt(1);
				bankStatisticDTO.setNumberOfAccount(customer);;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}
		return bankStatisticDTO.getNumberOfAccount();		
	}

	@Override
	public int moneyInBank() {
		// TODO Auto-generated method stub
		return 0;
	}

}
