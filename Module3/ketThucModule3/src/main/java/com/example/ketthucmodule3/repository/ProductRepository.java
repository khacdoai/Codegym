package com.example.ketthucmodule3.repository;

import com.example.ketthucmodule3.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static final String FIND_ALL = "select id,ten,gia,soLuong,mauSac,moTa,tenDanhMuc from products join category on products.idDanhMuc = category.idDanhMuc where trangThai = 1;";
    private static final String ADD_NEW_PRODUCT ="INSERT INTO products (ten,gia,soLuong,mauSac,moTa) VALUES (?,?,?,?,?)";
    private static final String DELETE_PRODUCT_SQL = "UPDATE products SET trangThai = '0' WHERE `id` = ?;";
    @Override
    public List<Product> showList() {
        Connection connection = BaseRepository.getConnection();
        List<Product> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
               String ten = resultSet.getString("ten");
               double gia = resultSet.getDouble("gia");
               int soLuong = resultSet.getInt("soLuong");
               String mauSac = resultSet.getString("mauSac");
               String moTa = resultSet.getString("moTa");
               String tenDanhMuc = resultSet.getString("tenDanhMuc");
                list.add(new Product(id,ten,gia,soLuong,mauSac,moTa,tenDanhMuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public void addNewUser(Product product) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_PRODUCT);
            preparedStatement.setString(1,product.getTen());
            preparedStatement.setDouble(2,product.getGia());
            preparedStatement.setInt(3,product.getSoLuong());
            preparedStatement.setString(4,product.getMauSac());
            preparedStatement.setString(5,product.getMoTa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean updateUser(Product product) {
        return false;
    }

    @Override
    public Product selectUser(int id) {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDelete = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDelete;
    }

    @Override
    public List<Product> searchUserByName(String ten) {
        return null;
    }

    @Override
    public List<Product> sortByName() {
        return null;
    }
}
