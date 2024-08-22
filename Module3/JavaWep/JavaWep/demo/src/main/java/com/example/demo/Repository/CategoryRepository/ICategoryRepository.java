package com.example.demo.Repository.CategoryRepository;

import com.example.demo.Model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> display();
    Category search(int id);
}
