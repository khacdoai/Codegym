package com.example.case_study.repository.impl;

import com.example.case_study.model.BoPhan;
import com.example.case_study.repository.BaseRepository;
import com.example.case_study.repository.IBoPhanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoPhanRepository implements IBoPhanRepository {
    private static final String FIND_ALL = "SELECT * FROM case_study2.bo_phan;";
    @Override
    public List<BoPhan> showlist() {
        List<BoPhan> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maBoPhan = resultSet.getInt("ma_bo_phan");
                String tenBoPhan = resultSet.getString("ten_bo_phan");
                list.add(new BoPhan(maBoPhan,tenBoPhan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
