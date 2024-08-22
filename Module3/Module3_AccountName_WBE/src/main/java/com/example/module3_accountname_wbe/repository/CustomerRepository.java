package com.example.module3_accountname_wbe.repository;

import com.example.module3_accountname_wbe.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String findByAll = "SELECT ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,loai_khach.ten_loai_khach FROM khach_hang join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach\n" +
            "  where khach_hang.trang_thai = 0;";
    private static final String deleteCustomer ="UPDATE case_study.khach_hang SET trang_thai = '1' WHERE ma_khach_hang = ?);";


    @Override
    public List<Customer> findByAll() {
        List<Customer> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findByAll);

            while (resultSet.next()){
                String hoTen = resultSet.getString("ho_ten");
                String ngaySinh = resultSet.getString("ngay_sinh");
                Boolean gioiTinh = resultSet.getBoolean("gioi_tinh");
                String soCMND = resultSet.getString("so_cmnd");
                String SDT = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String diaChi = resultSet.getString("dia_chi");
                String loaiKhach = resultSet.getString("ten_loai_khach");
                list.add(new Customer(hoTen,ngaySinh,gioiTinh,soCMND,SDT,email,diaChi,loaiKhach));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean rowDelete = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteCustomer);
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDelete;
    }
}
