package com.example.thi_ket_thuc_module3.repository;

import com.example.thi_ket_thuc_module3.Dto.TheMuonSachDto;
import com.example.thi_ket_thuc_module3.model.TheMuonSach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheMuonSachDtoRepository implements ITheMuonSachDtoRepository{
    private static final String SHOW_LIST = "SELECT * FROM quan_ly_sach.the_muon_sach tms \n" +
            "join sach s on tms.ma_sach = s.ma_sach \n" +
            "join hoc_sinh hs on hs.id_ma_hoc_sinh = tms.id_ma_hoc_sinh ;";
    private static final String LAY_THONG_TON = "FROM quan_ly_sach.the_muon_sach tms \n" +
            "JOIN sach s ON tms.ma_sach = s.ma_sach \n" +
            "JOIN hoc_sinh hs ON hs.id_ma_hoc_sinh = tms.id_ma_hoc_sinh \n" +
            "WHERE s.ma_sach = ?;";
    private static final String TRA_SACH = "";
    private static final String SEARCH = "SELECT * FROM quan_ly_sach.the_muon_sach tms \n" +
            "            join sach s on tms.ma_sach = s.ma_sach \n" +
            "            join hoc_sinh hs on hs.id_ma_hoc_sinh = tms.id_ma_hoc_sinh\n" +
            "            where hoc_sinh.ho_ten = concat('%',?,'%')";
    @Override
    public List<TheMuonSachDto> showList() {
        List<TheMuonSachDto> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String maMuonSach = resultSet.getString("ma_muon_sach");
                boolean trangThai = resultSet.getBoolean("trang_thai");
                Date ngayMuon = resultSet.getDate("ngay_muon");
                Date ngayTra = resultSet.getDate("ngay_tra");
                String maSach = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                int maHocSinh = resultSet.getInt("id_ma_hoc_sinh");
                String hoTen = resultSet.getString("ho_ten");
                String Lop = resultSet.getString("lop");
                list.add(new TheMuonSachDto(id,maMuonSach,trangThai,ngayMuon,ngayTra,maSach,tenSach,tacGia,moTa,soLuong,maHocSinh,hoTen,Lop));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public TheMuonSachDto layThongTinSach(String id) {
        TheMuonSachDto theMuonSachDto = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LAY_THONG_TON);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String maMuonSach = resultSet.getString("ma_muon_sach");
                boolean trangThai = resultSet.getBoolean("trang_thai");
                Date ngayMuon = resultSet.getDate("ngay_muon");
                Date ngayTra = resultSet.getDate("ngay_tra");
                String maSach = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                int maHocSinh = resultSet.getInt("id_ma_hoc_sinh");
                String hoTen = resultSet.getString("ho_ten");
                String Lop = resultSet.getString("lop");
                theMuonSachDto = new TheMuonSachDto(id1,maMuonSach,trangThai,ngayMuon,ngayTra,maSach,tenSach,tacGia,moTa,soLuong,maHocSinh,hoTen,Lop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return theMuonSachDto;
    }

    @Override
    public List<TheMuonSachDto> search(String name) {
        List<TheMuonSachDto> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String maMuonSach = resultSet.getString("ma_muon_sach");
                boolean trangThai = resultSet.getBoolean("trang_thai");
                Date ngayMuon = resultSet.getDate("ngay_muon");
                Date ngayTra = resultSet.getDate("ngay_tra");
                String maSach = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                int maHocSinh = resultSet.getInt("id_ma_hoc_sinh");
                String hoTen = resultSet.getString("ho_ten");
                String Lop = resultSet.getString("lop");
                list.add(new TheMuonSachDto(id,maMuonSach,trangThai,ngayMuon,ngayTra,maSach,tenSach,tacGia,moTa,soLuong,maHocSinh,hoTen,Lop));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


}
