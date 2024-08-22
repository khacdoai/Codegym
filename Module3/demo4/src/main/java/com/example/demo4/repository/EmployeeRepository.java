package com.example.demo4.repository;

import com.example.demo4.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmloyeeRepository{
    private  static final String FIND_ALL ="SELECT * FROM demo3.employee where trang_thai = 0;";
    private static final String DELETE_EMPLOYEE = "UPDATE demo3.employee SET trang_thai = 1 WHERE ma_nhan_vien = ?;";
    @Override
    public List<Employee> showList() {
        List<Employee> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()){
                int maKhachHang = resultSet.getInt("ma_nhan_vien");
                String hoTen  = resultSet.getString("ho_ten");
                Date ngaySing = resultSet.getDate("ngay_sinh");
                int gioiTinh = resultSet.getInt("gioi_tinh");
                int soCmnd = resultSet.getInt("so_cmnd");
                int soDienThoai = resultSet.getInt("so_dien_thoai");
                String dia_chi = resultSet.getString("dia_chi");
                list.add(new Employee(maKhachHang,hoTen,ngaySing,gioiTinh,soCmnd,soDienThoai,dia_chi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addNewEmployee(Employee employee) {

    }

    @Override
    public boolean deteleEmployee(int maNhanvien) {
        boolean rowDelete = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1,maNhanvien);
           rowDelete =  preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return rowDelete;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public Employee selectEmployee(int maNhanVien) {
        return null;
    }
}
