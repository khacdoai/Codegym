package com.example.demo_jstl_c0723.repository.impl;

import com.example.demo_jstl_c0723.model.Clazz;
import com.example.demo_jstl_c0723.model.Student;
import com.example.demo_jstl_c0723.repository.BaseRepository;
import com.example.demo_jstl_c0723.repository.IClassRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository implements IClassRepository {
    @Override
    public List<Clazz> findAll() {
        List<Clazz> clazzList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from class");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet .getString("name");
                Clazz clazz = new Clazz(id,name);
                clazzList.add(clazz);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return clazzList;
    }
}
