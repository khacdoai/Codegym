package com.example.thithu.repository.impl;

import com.example.thithu.model.LoaiMatHang;
import com.example.thithu.model.NhaSanXuat;
import com.example.thithu.repository.BaseRepository;
import com.example.thithu.repository.INhaSanXuatRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaSanXuatRepository implements INhaSanXuatRepository {
    private static final String SHOW = "SELECT * FROM thi_thu.nha_san_xuat;";

    @Override
    public List<NhaSanXuat> showList() {
        List<NhaSanXuat> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_nha_san_xuat");
                String tenNhaSanXuat = resultSet.getString("ten_nha_san_xat");
                list.add(new NhaSanXuat(id, tenNhaSanXuat));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
