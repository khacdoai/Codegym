package com.example.thi_ket_thuc_module3.repository;

import com.example.thi_ket_thuc_module3.model.Sach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepository  implements ISachRepository{
    private static final String SHOW_LIST = "SELECT * FROM quan_ly_sach.sach;";

    @Override
    public List<Sach> showList() {
        List<Sach> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               String maSach =  resultSet.getString("ma_sach");
               String tenSach = resultSet.getString("ten_sach");
               String tacGia = resultSet.getString("tac_gia");
               int soLuong = resultSet.getInt("so_luong");
               String moTa = resultSet.getString("mo_ta");
               list.add(new Sach(maSach,tenSach,tacGia,moTa,soLuong));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
