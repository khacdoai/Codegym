package com.example.demo.Service.CategoryService;

import com.example.demo.Model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> display();
    Category search(int id);
}
