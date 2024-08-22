package com.example.demo.Service.CategoryService;

import com.example.demo.Model.Category;
import com.example.demo.Repository.CategoryRepository.CategoryRepository;
import com.example.demo.Repository.CategoryRepository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryRepository iCategoryRepository = new CategoryRepository();
    @Override
    public List<Category> display() {
        return iCategoryRepository.display();
    }

    @Override
    public Category search(int id) {
        return iCategoryRepository.search(id);
    }
}
