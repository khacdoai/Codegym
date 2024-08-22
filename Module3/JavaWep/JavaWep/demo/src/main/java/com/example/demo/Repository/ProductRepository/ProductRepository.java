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
    private static final String SELECT_FROM_PRODUCT = "select * from product";
    private static final String DELETE_PRODUCT = "delete from product where id = ?;";
    private static final String INSERT_INTO_PRODUCT = "insert into product(name,price,quantity,color,id_category) values (?,?,?,?,?);";
    private static final String FIND_BY_NAME = "call find_by_name(?);";

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
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int categoryID = resultSet.getInt("id_category");
                category = iCategoryRepository.search(categoryID);
                product = new Product(id, name, price, quantity, color, category);
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
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
}
