package com.example.paging_and_sorting.service;

import com.example.paging_and_sorting.model.Category;
import com.example.paging_and_sorting.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepo iCategoryRepo;

    @Override
    public List<Category> findAll() {
        return iCategoryRepo.findAll();
    }
}
