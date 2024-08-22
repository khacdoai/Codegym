package com.example.case_study.repository.impl;

import com.example.case_study.model.ViTri;
import com.example.case_study.repository.BaseRepository;
import com.example.case_study.repository.IViTriRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViTriRepository implements IViTriRepository {
    private static final String FIND_ALL = "SELECT * FROM case_study2.vi_tri;";
    @Override
    public List<ViTri> showList() {
        List<ViTri> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maViTri = resultSet.getInt("ma_vi_tri");
                String tenViTri = resultSet.getString("ten_vi_tri");
                list.add(new ViTri(maViTri,tenViTri));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
