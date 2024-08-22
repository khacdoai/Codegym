package com.example.demo2.Repository;

import com.example.demo2.Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static final String FINDBYALL = "select * from student where trang_thai = 1;";
    private static final String DELETESTUDENT = "UPDATE student SET trang_thai = 0 WHERE ma_HS = ?;";
    private static final String ADD_NEW_STUDENT = "INSERT INTO student ( ten_HS, ngay_sinh, email, lop, dia_chi,trang_thai) VALUES (?,?,?,?,?,'1');";
    private static final String UPDATE_STUDENT = "UPDATE student SET ten_HS = ?, ngay_sinh = ?, email = ?, lop = ?, dia_chi = ? WHERE ma_HS = ?;";
    private static final String SELECTE_STUDENT = "select * from student where id = ?;";
    @Override
    public List<Student> findByAll() {
        List<Student> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FINDBYALL);

            while (resultSet.next()) {
                int ma_HS = resultSet.getInt("ma_HS");
                String ten_HS = resultSet.getString("ten_HS");
                String ngay_sinh = resultSet.getString("ngay_sinh");
                String email = resultSet.getString("email");
                String lop = resultSet.getString("lop");
                String dia_chi = resultSet.getString("dia_chi");

                list.add(new Student(ma_HS,ten_HS,ngay_sinh,email,lop,dia_chi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean rowDelete = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETESTUDENT);
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public void addNewStudent(Student student) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_STUDENT);
            preparedStatement.setString(1,student.getTen_hs());
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
    public boolean updateStudent(Student student) {
        boolean rowUpdate = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1,student.getTen_hs());
            preparedStatement.setString(2,student.getNgay_sinh());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setString(4,student.getLop());
            preparedStatement.setString(5,student.getDia_chi());
            preparedStatement.setInt(6,student.getMa_hs());
             rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public Student selectStudent(int ma_HS) {
        Student student = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTE_STUDENT);
            preparedStatement.setInt(1,ma_HS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String ten_HS = resultSet.getString("ten_HS");
                String ngay_sinh = resultSet.getString("ngay_sinh");
                String email = resultSet.getString("email");
                String lop = resultSet.getString("lop");
                String dia_chi = resultSet.getString("dia_chi");
                student = new Student(ten_HS,ngay_sinh,email,lop,dia_chi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

}
