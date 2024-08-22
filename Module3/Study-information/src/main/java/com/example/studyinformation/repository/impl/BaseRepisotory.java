package com.example.studyinformation.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepisotory {
    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/demo2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public BaseRepisotory() {
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
