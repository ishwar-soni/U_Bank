package com.upgrad.ubank.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection = null;

    public static Connection getConnection () {
        if (connection == null) {
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "ishwar";
            String password = "oracle";

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                System.out.println("Oracle Driver not found. Please download and add the driver.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private Database() {}
}
