package com.example.demo2.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/demo2";
    private static final String USERNAME = "root";
    private static final String PASS = "12345";

    public BaseRepository() {
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;

    }

}
