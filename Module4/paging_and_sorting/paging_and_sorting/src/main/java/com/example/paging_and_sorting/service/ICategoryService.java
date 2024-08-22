package com.example.paging_and_sorting.service;

import com.example.paging_and_sorting.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
