package com.example.thi_ket_thuc_module.repository.impl;

import com.example.thi_ket_thuc_module.dto.BenhAnDto;
import com.example.thi_ket_thuc_module.model.BenhAn;
import com.example.thi_ket_thuc_module.repository.BaseRepository;
import com.example.thi_ket_thuc_module.repository.IBenhAnRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository {
    private static final String SHOW_BENH_AN = "SELECT ba.*, bn.ma_benh_nhan , bn.ten_benh_nhan,bn.ngay_nhap_vien,bn.ngay_ra_vien,bn.ly_do_nhap_vien FROM benh_an ba\n" +
            "join benh_nhan bn on ba.id_benh_an = bn.id_benh_nhan\n" +
            "where ba.trang_thai = 0;";
    private static final String DELETE_BENH_AN = "UPDATE thi_ket_thuc_module.benh_an SET trang_thai = 1 WHERE (id_benh_an = ?);\n";
    private static final String SELECTER_BENH_AN = "SELECT ba.*, bn.ma_benh_nhan , bn.ten_benh_nhan,bn.ngay_nhap_vien,bn.ngay_ra_vien,bn.ly_do_nhap_vien FROM benh_an ba\n" +
            "            join benh_nhan bn on ba.id_benh_an = bn.id_benh_nhan\n" +
            "            where ba.id_benh_an = 2  and ba.trang_thai = 0;";

    @Override
    public List<BenhAnDto> showList() {
        List<BenhAnDto> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_BENH_AN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBenhAn = resultSet.getInt("id_benh_an");
                int idBenhNhan = resultSet.getInt("id_benh_nhan");
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                Date ngayNhapvien = resultSet.getDate("ngay_nhap_vien");
                Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
                list.add(new BenhAnDto(idBenhAn, idBenhNhan, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapvien, ngayRaVien, lyDoNhapVien));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean chinhSuaBenhAn(BenhAnDto benhAnDto) {
        return false;
    }

    @Override
    public boolean xoaBenhAn(int id) {

        boolean rowDelele = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BENH_AN);
            preparedStatement.setInt(1, id);
            rowDelele = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelele;
    }

    @Override
    public BenhAnDto layBenhAn(int id) {
        BenhAnDto benhAnDto = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTER_BENH_AN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBenhAn = resultSet.getInt("id_benh_an");
                int idBenhNhan = resultSet.getInt("id_benh_nhan");
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                Date ngayNhapvien = resultSet.getDate("ngay_nhap_vien");
                Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
                benhAnDto = new BenhAnDto(idBenhAn, idBenhNhan, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapvien, ngayRaVien, lyDoNhapVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhAnDto;
    }
}
