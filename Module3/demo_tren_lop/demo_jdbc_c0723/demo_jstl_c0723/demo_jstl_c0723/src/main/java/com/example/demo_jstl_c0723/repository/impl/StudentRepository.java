package com.example.demo_jstl_c0723.repository.impl;

import com.example.demo_jstl_c0723.dto.StudentDto;
import com.example.demo_jstl_c0723.model.Student;
import com.example.demo_jstl_c0723.repository.BaseRepository;
import com.example.demo_jstl_c0723.repository.IStudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final String SELECT_ALL = "select * from student";
    private final String SELECT_ALL_JOIN = " select s.* ,c.name as class_name\n" +
            "from student s \n" +
            "inner join class c on s.class_id = c.id;";
    private final String INSERT_INTO = "insert into student(`name`, gender,`point`, class_id) \n" +
            " values (?,?,?,?);";

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
//        // kết nối DB
       Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               int id = resultSet.getInt("id");
               String name = resultSet .getString("name");
               boolean gender = resultSet.getBoolean("gender");
               float point = resultSet.getFloat("point");
               int classId = resultSet.getInt("class_id");
               Student student = new Student(id,name,gender,point,classId);
               studentList.add(student);
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
        return studentList;


    }

    @Override
    public boolean add(Student student) {

        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setFloat(3,student.getPoint());
            preparedStatement.setInt(4,student.getClassId());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean delete(int id) {

        return false;
    }
}
