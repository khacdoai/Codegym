package com.example.thi_ket_thuc_module3.repository;

import com.example.thi_ket_thuc_module3.model.Sach;
import com.example.thi_ket_thuc_module3.model.TheMuonSach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheMuonSachRepository implements ITheMuonSachRepository{
    private static final String SHOW_LIST = "SELECT * FROM quan_ly_sach.the_muon_sach;";

    @Override
    public List<TheMuonSach> showList() {
        List<TheMuonSach> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String maMuon =  resultSet.getString("ma_sach");
                Boolean trangThai = resultSet.getBoolean("ten_sach");
                Date ngayMuon = resultSet.getDate("tac_gia");
                Date ngayTra = resultSet.getDate("so_luong");
                list.add(new TheMuonSach(id,maMuon,trangThai,ngayMuon,ngayTra));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
