package com.example.case_study.repository.impl;

import com.example.case_study.dto.CustomerDto;
import com.example.case_study.model.Customer;
import com.example.case_study.repository.BaseRepository;
import com.example.case_study.repository.ICustomerRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class customerRepository implements ICustomerRepository {
    private static final String FIND_ALL = "SELECT * FROM case_study2.khach_hang \n" + "join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach where trang_thai = 0;";
    private static final String DELETE_CUSTOMER = "UPDATE case_study2.khach_hang SET trang_thai = 1 WHERE ma_khach_hang = ?;";
    private static final String CREATE_CUSTOMER = "INSERT INTO case_study2.khach_hang (ho_ten, ngay_sinh, gioi_tinh, so_cmnd,so_dien_thoai,email,dia_chi, ma_loai_khach, trang_thai) VALUES (?,?,?,?,?,?,?,?,0);";
    private static final String UPDATE_CUSTOMER = "UPDATE case_study2.khach_hang SET ho_ten = ?, ngay_sinh = ?, gioi_tinh = ?, so_cmnd = ?, so_dien_thoai = ?, email = ?, dia_chi = ?, ma_loai_khach = ? WHERE (ma_khach_hang = ?);\n";
    private static final String SELECT_CUSTOME ="SELECT * FROM case_study2.khach_hang\n" + "join loai_khach lk on khach_hang.ma_loai_khach = lk.ma_loai_khach where trang_thai = 0 and ma_khach_hang = ?";
    private static final String SEARCH_BY_CUSTOMER = "SELECT * FROM case_study2.khach_hang \n" + "join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach where ho_ten like concat('%',?,'%') and trang_thai = 0;";
    private static final String ARRANGE_BY_NAME = "SELECT * FROM case_study2.khach_hang  \n" +
            "join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach where trang_thai = 0\n" +
            "order by ho_ten;";
    @Override
    public List<CustomerDto> showList() {
        List<CustomerDto> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt("ma_khach_hang");
                String ho_ten = resultSet.getString("ho_ten");
                Date ngay_sinh = resultSet.getDate("ngay_sinh");
                int gioi_tinh = resultSet.getInt("gioi_tinh");
                String so_cmnd = resultSet.getString("so_cmnd");
                String so_dien_thoai = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String dia_chi = resultSet.getString("dia_chi");
                int ma_loai_khach_hang = resultSet.getInt("ma_loai_khach");
                String ten_loai_khach = resultSet.getString("ten_loai_khach");
                list.add(new CustomerDto(id,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach_hang,ten_loai_khach));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addNewCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CUSTOMER);
            preparedStatement.setString(1,customer.getHo_ten());
            preparedStatement.setString(2, String.valueOf(customer.getNgay_sinh()));
            preparedStatement.setInt(3,customer.getGioi_tinh());
            preparedStatement.setString(4,customer.getSo_cmnd());
            preparedStatement.setString(5,customer.getSo_dien_thoai());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setString(7,customer.getDia_chi());
            preparedStatement.setInt(8,customer.getMa_loai_khach());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean rowUpdate = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1,customer.getHo_ten());
            preparedStatement.setDate(2,customer.getNgay_sinh());
            preparedStatement.setInt(3,customer.getGioi_tinh());
            preparedStatement.setString(4,customer.getSo_cmnd());
            preparedStatement.setString(5,customer.getSo_dien_thoai());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setString(7,customer.getDia_chi());
            preparedStatement.setInt(8,customer.getMa_loai_khach());
            preparedStatement.setInt(9,customer.getId());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean rowDelele = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1,id);
            rowDelele = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDelele ;
    }

    @Override
    public CustomerDto selectCustomer(int id) {
        CustomerDto customerDto = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOME);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int ma_khach_hang = resultSet.getInt("ma_khach_hang");
                String ho_ten = resultSet.getString("ho_ten");
                Date ngay_sinh = resultSet.getDate("ngay_sinh");
                int gioi_tinh = resultSet.getInt("gioi_tinh");
                String so_cmnd = resultSet.getString("so_cmnd");
                String so_dien_thoai = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String dia_chi = resultSet.getString("dia_chi");
                int ma_loai_khach_hang = resultSet.getInt("ma_loai_khach");
                String ten_loai_khach = resultSet.getString("ten_loai_khach");
                customerDto = new CustomerDto(ma_khach_hang,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach_hang,ten_loai_khach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerDto;
    }

    @Override
    public List<CustomerDto> searchByName(String ho_ten) {
        List<CustomerDto> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_CUSTOMER);
            preparedStatement.setString(1,ho_ten);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                int id = resultSet.getInt("ma_khach_hang");
                String hoTen = resultSet.getString("ho_ten");
                Date ngay_sinh = resultSet.getDate("ngay_sinh");
                int gioi_tinh = resultSet.getInt("gioi_tinh");
                String so_cmnd = resultSet.getString("so_cmnd");
                String so_dien_thoai = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String dia_chi = resultSet.getString("dia_chi");
                int ma_loai_khach_hang = resultSet.getInt("ma_loai_khach");
                String ten_loai_khach = resultSet.getString("ten_loai_khach");
                list.add(new CustomerDto(id,hoTen,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach_hang,ten_loai_khach));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<CustomerDto> arrangeByName() {
        List<CustomerDto> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ARRANGE_BY_NAME);
            while (resultSet.next()){
                int id = resultSet.getInt("ma_khach_hang");
                String ho_ten = resultSet.getString("ho_ten");
                Date ngay_sinh = resultSet.getDate("ngay_sinh");
                int gioi_tinh = resultSet.getInt("gioi_tinh");
                String so_cmnd = resultSet.getString("so_cmnd");
                String so_dien_thoai = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String dia_chi = resultSet.getString("dia_chi");
                int ma_loai_khach_hang = resultSet.getInt("ma_loai_khach");
                String ten_loai_khach = resultSet.getString("ten_loai_khach");
                list.add(new CustomerDto(id,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach_hang,ten_loai_khach));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
