package com.example.demo.Repository.CategoryRepository;

import com.example.demo.Database.BaseRepository;
import com.example.demo.Model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private final String SELECT = "select * from category;";
    private final String SEARCH = "select * from category where id_category = ?;";

    @Override
    public List<Category> display() {
        List<Category> list = new ArrayList<>();
        Connection con = BaseRepository.getConnection();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_category");
                String name = resultSet.getString("name_category");
                list.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category search(int id) {
        Category category = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SEARCH);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCategory = resultSet.getInt("id_category");
                String name = resultSet.getString("name_category");
                category = new Category(idCategory, name);
            }
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
