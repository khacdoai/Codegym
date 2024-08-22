package org.arthur.ss11_mvc.repository.impl;

import org.arthur.ss11_mvc.DB.DBConnection;
import org.arthur.ss11_mvc.DTO.ProductDTO;
import org.arthur.ss11_mvc.model.Product;
import org.arthur.ss11_mvc.repository.IRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IRepo {

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO Products (id, name, price,description,id_country) VALUE(?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select id,name,price,description,id_country from Products where id =? and isActive =1;";
    private static final String SELECT_ALL_PRODUCT = "call get_all_product();";
    private static final String DELETE_PRODUCT_SQL = "update Products set isActive = 0 where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update Products set name = ?,price= ?, description =?, id_country=? where id = ?;";
    private static final String SELECT_PRODUCT_BY_NAME ="call search_by_name(?);";



    @Override
    public List<ProductDTO> getAll() {
        List<ProductDTO> productList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_PRODUCT);) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String country = resultSet.getString("country");
                String description = resultSet.getString("description");
                productList.add(new ProductDTO(id, name, price,country, description));
            }
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return productList;
    }

    @Override
    public boolean add(Product product) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);) {
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setString(4,product.getDescription());
            preparedStatement.setInt(5,product.getIdCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
    boolean rowDelete = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate()>0;
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
    return rowDelete;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdate = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setInt(4,product.getIdCountry());
            preparedStatement.setInt(5,product.getId());
           rowUpdate= preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }
        return rowUpdate;
    }

    @Override
    public Product getProductByID(int id) throws SQLException {
        Product product = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int idCountry = resultSet.getInt("id_country");
               product=new Product(id, name, price, description,idCountry);
            }
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return product;
    }

    @Override
    public List<ProductDTO> getProductByName(String inputName) throws SQLException {
        List<ProductDTO> productList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);) {
            preparedStatement.setString(1,"%"+inputName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String country = resultSet.getString("country");
                String description = resultSet.getString("description");
                productList.add(new ProductDTO(id,name,price,country,description));
            }
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return productList;
    }

}
