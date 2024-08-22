package com.example.module3_accountname_wbe.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/case_study";
    private static final String USENAME = "root";
    private static final String PASSWORD = "12345";

    public BaseRepository(){
    }
    public static Connection getConnection(){
    Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(JDBC_URL,USENAME,PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    return connection;
    }
}
