package com.example.case_study.repository.impl;

import com.example.case_study.model.LoaiKhach;
import com.example.case_study.repository.BaseRepository;
import com.example.case_study.repository.ILoaiKhachRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiKhachRepository implements ILoaiKhachRepository {
    @Override
    public List<LoaiKhach> findAll() {
        List<LoaiKhach> loaiKhachList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM case_study.loai_khach;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int ma_loai_khach = resultSet.getInt("ma_loai_khach");
                String ten_loai_khach = resultSet.getString("ten_loai_khach");
                loaiKhachList.add(new LoaiKhach(ma_loai_khach,ten_loai_khach));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return loaiKhachList;
    }
}
