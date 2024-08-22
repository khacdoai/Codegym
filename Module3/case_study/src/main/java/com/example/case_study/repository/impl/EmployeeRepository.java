package com.example.case_study.repository.impl;

import com.example.case_study.dto.EmployeeDto;
import com.example.case_study.model.Employee;
import com.example.case_study.repository.BaseRepository;
import com.example.case_study.repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String FIND_ALL = "SELECT * FROM case_study2.nhan_vien " +
            "join vi_tri on nhan_vien.ma_vi_tri = vi_tri.ma_vi_tri " +
            "join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do " +
            "join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan where trang_thai = 0;";
    private static final String DELETE_EMPLOYEE = "update nhan_vien set trang_thai = 1 where ma_nhan_vien = ?;";
    @Override
    public List<EmployeeDto> showList() {
        List<EmployeeDto> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        Statement statement =null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()){
                int maNhanVien = resultSet.getInt("ma_nhan_vien");
                String hoTen = resultSet.getString("ho_ten");
                Date ngaySinh = resultSet.getDate("ngay_sinh");
                String soCmnd = resultSet.getString("so_cmnd");
                double luong = resultSet.getDouble("luong");
                String soDienThoai = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String diaChi = resultSet.getString("dia_chi");
                String tenViTri = resultSet.getString("ten_vi_tri");
                String tenTrinhDo = resultSet.getString("ten_trinh_do");
                String tenBoPhan = resultSet.getString("ten_bo_phan");
                list.add(new EmployeeDto(maNhanVien,hoTen,ngaySinh,soCmnd,luong,soDienThoai,email,diaChi,tenViTri,tenTrinhDo,tenBoPhan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void createEmployee(Employee employee) {


    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean rowDelete = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateEmploy(Employee employee) {
        return false;
    }

    @Override
    public Employee selectEmployee(int id) {
        return null;
    }

    @Override
    public List<Employee> serchEmployee(String name) {
        return null;
    }
}
