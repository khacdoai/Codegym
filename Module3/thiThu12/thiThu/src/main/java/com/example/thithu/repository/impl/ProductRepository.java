package com.example.thithu.repository.impl;

import com.example.thithu.dto.ProductDto;
import com.example.thithu.model.Product;
import com.example.thithu.repository.BaseRepository;
import com.example.thithu.repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SHOW_LIST = "SELECT p.*, lmh.ten_loai_mat_hang, nsx.ten_nha_san_xat FROM product p\n" +
            "join nha_san_xuat nsx on p.id_nha_san_xuat = nsx.id_nha_san_xuat\n" +
            "join loai_mat_hang lmh on p.id_loai_mat_hang = lmh.id_loai_mat_hang\n" +
            "where p.trang_thai = 0;";
    private static final String DELETE_PRODUCT = "UPDATE product SET trang_thai = 1 WHERE id = ?;";
    private static final String CREATE_PRODUCT ="INSERT INTO product (id,ma_mat_hang, ten_mat_hang, gia, so_luong, id_loai_mat_hang, id_nha_san_xuat) VALUES (?,?,?,?,?,?,?);";
    private static final  String SELECTER ="SELECT p.*, lmh.ten_loai_mat_hang, nsx.ten_nha_san_xat FROM product p\n" +
            "             join nha_san_xuat nsx on p.id_nha_san_xuat = nsx.id_nha_san_xuat\n" +
            "\t\t\tjoin loai_mat_hang lmh on p.id_loai_mat_hang = lmh.id_loai_mat_hang\n" +
            "            where   id = ? and trang_thai = 0;";
    private static final String UPDATE ="UPDATE thi_thu.product SET ma_mat_hang = ?, ten_mat_hang = ?, gia = ?, so_luong = ?, id_loai_mat_hang = ?,id_nha_san_xuat= ? WHERE (id = ? );\n";
    @Override
    public List<ProductDto> showList() {
        List<ProductDto> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 int id = resultSet.getInt("id");
                 String maMatHang = resultSet.getString("ma_mat_hang");
                 String tenMaHang = resultSet.getString("ten_mat_hang");
                 float gia = resultSet.getFloat("gia");
                 int soLuong = resultSet.getInt("so_luong");
                 int idLoaiMatHang = resultSet.getInt("id_loai_mat_hang");
                 int idNhaSanXuat = resultSet.getInt("id_nha_san_xuat");
                 String tenLoaiMatHang = resultSet.getString("ten_loai_mat_hang");
                 String tenNhaSanXuat = resultSet.getString("ten_nha_san_xat");
                 list.add(new ProductDto(id,maMatHang,tenMaHang,gia,soLuong,idLoaiMatHang,idNhaSanXuat,tenLoaiMatHang,tenNhaSanXuat));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void createProduct(Product product) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2,product.getMaMatHang());
            preparedStatement.setString(3,product.getTenMaHang());
            preparedStatement.setFloat(4,product.getGia());
            preparedStatement.setInt(5,product.getSoLuong());
            preparedStatement.setInt(6,product.getIdLoaiMatHang());
            preparedStatement.setInt(7,product.getIdNhaSanXuat());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean updateProduct(Product product) {
         boolean rowUpdate = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);
            preparedStatement.setString(1,product.getMaMatHang());
            preparedStatement.setString(2,product.getTenMaHang());
            preparedStatement.setFloat(3,product.getGia());
            preparedStatement.setInt(4,product.getSoLuong());
            preparedStatement.setInt(5,product.getIdLoaiMatHang());
            preparedStatement.setInt(6,product.getIdNhaSanXuat());
            preparedStatement.setInt(7,product.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean rowDelele = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1,id);
            rowDelele = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelele ;
    }

    @Override
    public ProductDto selectProduct(int id) {
        ProductDto productDto = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTER);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String maMatHang = resultSet.getString("ma_mat_hang");
                String tenMaHang = resultSet.getString("ten_mat_hang");
                float gia = resultSet.getFloat("gia");
                int soLuong = resultSet.getInt("so_luong");
                int idLoaiMatHang = resultSet.getInt("id_loai_mat_hang");
                int idNhaSanXuat = resultSet.getInt("id_nha_san_xuat");
                String tenLoaiMatHang = resultSet.getString("ten_loai_mat_hang");
                String tenNhaSanXuat = resultSet.getString("ten_nha_san_xat");
                 productDto = new ProductDto(id1,maMatHang,tenMaHang,gia,soLuong,idLoaiMatHang,idNhaSanXuat,tenLoaiMatHang,tenNhaSanXuat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productDto;
    }

    @Override
    public List<ProductDto> searchProductByName(String name) {
        return null;
    }

    @Override
    public List<ProductDto> searchProductByMaMatHang(String maMatHang) {
        return null;
    }
}
