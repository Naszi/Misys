package com.banking.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.banking.connection.DatabaseConnection;
import com.banking.dto.AccountDTO;
import com.banking.interfaces.IAccountDAO;

public class AccountDAO implements IAccountDAO<AccountDTO> {

	private static final String SQL_INSERT = "INSERT INTO account (accountId, accountNumber, balance, currency, customerId) VALUES (?, ?, ?, ?, ?)";

	private static final DatabaseConnection connection = DatabaseConnection.namelyState();

	@Override
	public boolean create(AccountDTO a) {

		PreparedStatement statement;

		try {
			statement = connection.getConnection().prepareStatement(SQL_INSERT);

			statement.setString(1, a.getAccountId());
			statement.setInt(2, a.getAccountNumber());
			statement.setDouble(3, a.getBalance());
			statement.setString(4, a.getCurrency());
			statement.setString(5, a.getCustomerId());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return false;
	}

}
