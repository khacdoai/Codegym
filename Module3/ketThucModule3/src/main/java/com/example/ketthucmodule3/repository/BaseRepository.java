package com.example.ketthucmodule3.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/ketthucmodule3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    public BaseRepository() {
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
}