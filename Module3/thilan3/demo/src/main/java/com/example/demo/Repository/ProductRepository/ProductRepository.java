package com.example.demo.Repository.ProductRepository;

import com.example.demo.Database.BaseRepository;
import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Repository.CategoryRepository.CategoryRepository;
import com.example.demo.Repository.CategoryRepository.ICategoryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT_FROM_PRODUCT = "SELECT * FROM san_pham;";
    private static final String DELETE_PRODUCT = "delete from san_pham where id = ?;";
    private static final String INSERT_INTO_PRODUCT = "insert into san_pham(ten_san_pham,gia,so_luong,mau_sac,mo_ta,id_loai_san_pham) values (?,?,?,?,?,?);";

    private static final String FIND_BY_NAME ="SELECT sp.*, lsp.danh_muc FROM san_pham sp\n" +
            "                        join loai_san_pham lsp on sp.id_loai_san_pham = lsp.id_loai_san_pham\n" +
            "                        where ten_san_pham like concat('%',?,'%');";
    private static final String SELECTBYID = "SELECT sp.*, lsp.danh_muc FROM san_pham sp\n" +
            "                          join loai_san_pham lsp on sp.id_loailoai_san_pham_san_pham = lsp.id_loai_san_pham\n" +
            "  where   id = ?";
    private static final String UPDATE = "UPDATE san_pham SET ten_san_pham = ?, `gia` = ?, `mau_sac` = ?, `mo_ta` = ?, `id_loai_san_pham` = ? WHERE (`id` = ?);";
    private ICategoryRepository iCategoryRepository = new CategoryRepository();

    @Override
    public List<Product> showListProduct() {
        List<Product> list = new ArrayList<>();
        Category category = null;
        Product product = null;
        Connection connection = BaseRepository.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_PRODUCT);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ten_san_pham");
                double price = resultSet.getDouble("gia");
                int quantity = resultSet.getInt("so_luong");
                String color = resultSet.getString("mau_sac");
                String moTa = resultSet.getString("mo_ta");
                int categoryID = resultSet.getInt("id_loai_san_pham");
                category = iCategoryRepository.search(categoryID);
                product = new Product(id, name, price, quantity, color,moTa ,category);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void create(Product product) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(INSERT_INTO_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategory().getIdCategory());
            preparedStatement.setString(6, product.getMoTa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            try {
                PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(DELETE_PRODUCT);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Product> findByName(String nameSearch) {
        Connection conn = BaseRepository.getConnection();
        List<Product> list = new ArrayList<>();
        Category category = null;
        Product product = null;
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_BY_NAME);
            ps.setString(1,nameSearch);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int categoryId = resultSet.getInt("id_category");
                category = iCategoryRepository.search(categoryId);
                product = new Product(name,price,quantity,color,category);
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Product selecterById(int id) {
        Category category = null;
        Product product = null;
        Connection connection = BaseRepository.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_PRODUCT);
            while (resultSet.next()) {
                int idp = resultSet.getInt("id");
                String name = resultSet.getString("ten_san_pham");
                double price = resultSet.getDouble("gia");
                int quantity = resultSet.getInt("so_luong");
                String color = resultSet.getString("mau_sac");
                String moTa = resultSet.getString("mo_ta");
                int categoryID = resultSet.getInt("id_loai_san_pham");
                category = iCategoryRepository.search(categoryID);
                product = new Product(idp, name, price, quantity, color,moTa ,category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean rowUpdate = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategory().getIdCategory());
            preparedStatement.setInt(6, product.getId());
            preparedStatement.executeUpdate();
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return rowUpdate;
    }

}
