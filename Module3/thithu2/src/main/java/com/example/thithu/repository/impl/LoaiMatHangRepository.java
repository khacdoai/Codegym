package com.example.thithu.repository.impl;

import com.example.thithu.model.LoaiMatHang;
import com.example.thithu.repository.BaseRepository;
import com.example.thithu.repository.ILoaiMatHangRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiMatHangRepository implements ILoaiMatHangRepository {
    private static final String SHOW = "SELECT * FROM thi_thu.loai_mat_hang;";
    @Override
    public List<LoaiMatHang> showlist() {
        List<LoaiMatHang> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
              int id =   resultSet.getInt("id_loai_mat_hang");
              String tenLoaiMatHang =  resultSet.getString("ten_loai_mat_hang");
                list.add(new LoaiMatHang(id,tenLoaiMatHang));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
