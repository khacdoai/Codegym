package com.example.demo.repository;

import com.example.demo.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private final String FIND_ALL = "SELECT * FROM student";
    private final String ADD_NEW_STUDENT = "insert into student (student_name, student_gender, student_point)\n" +
            "values (?,?,?)";
    private final String FIND_ALL_SP = "call find_all();";
    private final String ADD_NEW_STUDENT_SP = "call add_new_student(?,?,?)";
    private final String DELETE_STUDENT = "delete from student\n" +
            "where id = ?;" ;

    @Override
    public List<Student> showList() {
        List<Student> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(FIND_ALL);
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("student_name");
//                boolean gender = resultSet.getBoolean("student_gender");
//                double point = resultSet.getDouble("student_point");
//                list.add(new Student(id,name,gender,point));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_ALL_SP);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("student_name");
                boolean gender = resultSet.getBoolean("student_gender");
                double point = resultSet.getDouble("student_point");
                list.add(new Student(id, name, gender, point));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addNewStudent(Student student) {
        Connection connection = BaseRepository.getConnection();
        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_STUDENT);
            CallableStatement callableStatement = connection.prepareCall(ADD_NEW_STUDENT_SP);
            callableStatement.setString(1,student.getName());
            callableStatement.setBoolean(2, student.isGender());
            callableStatement.setDouble(3,student.getPoint());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
