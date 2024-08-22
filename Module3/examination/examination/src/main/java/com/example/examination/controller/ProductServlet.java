package com.example.examination.controller;

import com.example.examination.model.Category;
import com.example.examination.model.Product;
import com.example.examination.model.ProductDTO;
import com.example.examination.repository.cateogry.CategoryRepository;
import com.example.examination.repository.cateogry.ICategoryRepository;
import com.example.examination.repository.product.IProductRepository;
import com.example.examination.repository.product.ProductRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "")
public class ProductServlet extends HttpServlet {
    private IProductRepository iProductRepository = new ProductRepository();
    private ICategoryRepository iCategoryRepository = new CategoryRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "show-form-create":
                showFormCreate(request,response);
                break;
            default:
                showListProduct(request, response);
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<ProductDTO> list;
        list = iProductRepository.showListProductDTO();
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> list = iCategoryRepository.showListCategory();
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("/form-create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        iProductRepository.delete(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = iCategoryRepository.findCategoryById(categoryId);
        Product product = new Product(name,category);
        iProductRepository.create(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
