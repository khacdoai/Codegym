package com.example.studyinformation.repository.impl;

import com.example.studyinformation.model.Student;
import com.example.studyinformation.repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static final String FIND_ALL = "select * from student where trang_thai = 1;";
    private static final String DELETE_STUDENT = "UPDATE student SET trang_thai = 0 WHERE ma_HS = ?;";
    private static final String UPDATE_STUDENT ="UPDATE student SET ten_HS = ?, ngay_sinh = ?, email = ?, lop = ?, dia_chi = ? WHERE ma_HS = ?;";
    private static final String SLECTE_STUDENT ="SELECT * FROM student where ma_HS = ?;";
    private static final String ADD_NEW_USER ="INSERT INTO student ( ten_HS, ngay_sinh, email, lop, dia_chi, trang_thai) VALUES (?,?,?,?,?,'1');";
    @Override
    public List<Student> showlist() {
        List<Student> list = new ArrayList<>();
        Connection connection = BaseRepisotory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()){
                int ma_HS = resultSet.getInt("ma_HS");
                String ten_HS = resultSet.getString("ten_HS");
                String ngay_sinh = resultSet.getString("ngay_sinh");
                String email = resultSet.getString("email");
                String lop = resultSet.getString("lop");
                String dia_chi = resultSet.getString("dia_chi");
                int trang_thai = resultSet.getInt("trang_thai");
                list.add(new Student(ma_HS,ten_HS,ngay_sinh,email,lop,dia_chi,trang_thai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean rowDelete = false;
        Connection connection = BaseRepisotory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean rowUpdated = false;
        Connection connection = BaseRepisotory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1,student.getTen_HS());
            preparedStatement.setString(2,student.getNgay_sinh());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setString(4,student.getLop());
            preparedStatement.setString(5,student.getDia_chi());
            preparedStatement.setInt(6,student.getMa_HS());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public void addnewStudent(Student student) {
        Connection connection = BaseRepisotory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER);
            preparedStatement.setString(1,student.getTen_HS());
            preparedStatement.setString(2,student.getNgay_sinh());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setString(4,student.getLop());
            preparedStatement.setString(5,student.getDia_chi());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        Connection connection = BaseRepisotory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SLECTE_STUDENT);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int ma_HS = resultSet.getInt("ma_HS");
                String ten_HS = resultSet.getString("ten_HS");
                String ngay_sinh = resultSet.getString("ngay_sinh");
                String email = resultSet.getString("email");
                String lop = resultSet.getString("lop");
                String dia_chi = resultSet.getString("dia_chi");
                int trang_thai = resultSet.getInt("trang_thai");
                 student = new Student(ma_HS,ten_HS,ngay_sinh,email,lop,dia_chi,trang_thai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
