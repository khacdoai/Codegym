package com.example.case_study.repository;

import com.example.case_study.model.Accout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DangNhapRepository implements IDangNhapRepository{

    private static final String THEM_TAI_KHOAN = "insert into case_study2.tai_khoan (tai_khoan,mat_khau) value (?,?)";
    private static final String LAY_THONG_TIN_TAI_KHOAN = "select * from case_study2.tai_khoan where tai_khoan = ?";

    @Override
    public boolean dangKi(Accout accout) {
        boolean dangKi = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(THEM_TAI_KHOAN);
            preparedStatement.setString(1,accout.getUserName());
            preparedStatement.setString(2,accout.getPassWord());
            dangKi = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dangKi;
    }

    @Override
    public boolean kiemTraDangNhap(String userName, String pass) {
        Connection connection = BaseRepository.getConnection();
        boolean kiemTra = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LAY_THONG_TIN_TAI_KHOAN);
            preparedStatement.setString(1,userName);
            ResultSet  resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String taiKhoanData = resultSet.getString("tai_khoan");
                String matKhauData = resultSet.getString("mat_khau");

                if(taiKhoanData.equals(userName) && matKhauData.equals(pass)){
                    kiemTra = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return kiemTra;
    }
}
