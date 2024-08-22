package com.example.case_study.repository.impl;

import com.example.case_study.model.TrinhDo;
import com.example.case_study.repository.BaseRepository;
import com.example.case_study.repository.ITrinhDoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrinhDoRepository implements ITrinhDoRepository {
    private static final String FIND_ALL = "SELECT * FROM case_study2.trinh_do;";
    @Override
    public List<TrinhDo> showList() {
        List<TrinhDo> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maTrinhDo = resultSet.getInt("ma_trinh_do");
                String tenTrinhDo = resultSet.getString("ten_trinh_do");
                list.add(new TrinhDo(maTrinhDo,tenTrinhDo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
