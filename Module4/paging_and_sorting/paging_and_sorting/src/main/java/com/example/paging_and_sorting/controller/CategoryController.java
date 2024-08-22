package com.example.paging_and_sorting.controller;
import com.example.paging_and_sorting.model.Category;
import com.example.paging_and_sorting.service.IBlogService;
import com.example.paging_and_sorting.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class CategoryController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;


    @ModelAttribute("Categorys")
    public Iterable<Category> provinces(){
        return iCategoryService.findAll();
    }
}