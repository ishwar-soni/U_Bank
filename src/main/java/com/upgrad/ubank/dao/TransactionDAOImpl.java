package com.upgrad.ubank.dao;

import com.upgrad.ubank.db.Database;
import com.upgrad.ubank.dtos.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {

    private static TransactionDAOImpl instance;

    private TransactionDAOImpl () {}

    public static TransactionDAOImpl getInstance() {
        if (instance == null) {
            instance = new TransactionDAOImpl();
        }
        return instance;
    }

    @Override
    public Transaction create(Transaction transaction) throws SQLException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO UBANK_TRANSACTIONS (accountNo, date_, action, amount) VALUES (" +
                transaction.getAccountNo()+ ", '" +
                transaction.getDate()+ "', '" +
                transaction.getAction()+ "', " +
                transaction.getAmount()+ ")";
        statement.executeUpdate(sql);
        return transaction;
    }

    @Override
    public List<Transaction> findByAccountNo(int accountNo) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM UBANK_TRANSACTIONS WHERE accountNo = " + accountNo;
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Transaction temp = new Transaction();
            temp.setAccountNo(resultSet.getInt("accountNo"));
            temp.setDate(resultSet.getString("date_"));
            temp.setAction(resultSet.getString("action"));
            temp.setAmount(resultSet.getInt("amount"));
            transactions.add(temp);
        }

        return transactions;
    }
}
