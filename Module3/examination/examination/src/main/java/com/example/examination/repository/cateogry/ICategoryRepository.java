package com.example.examination.repository.cateogry;

import com.example.examination.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> showListCategory();
    Category findCategoryById(int id);
}
