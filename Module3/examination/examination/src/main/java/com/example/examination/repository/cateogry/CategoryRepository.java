package com.example.examination.repository.cateogry;

import com.example.examination.model.Category;
import com.example.examination.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private final static String SELECT_CATEGORY = "select * from category";
    private final static String FIND_CATEGORY_BY_ID = "select * from category where id = ?";

    @Override
    public List<Category> showListCategory() {
        List<Category> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_CATEGORY);
            Category category;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                category = new Category(id,name);
                list.add(category);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category findCategoryById(int id) {
        Category category = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(FIND_CATEGORY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idCategory = resultSet.getInt("id");
                String name = resultSet.getString("name");
                category = new Category(idCategory,name);
            }
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
