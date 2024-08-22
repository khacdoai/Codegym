package com.example.demo.Controller;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Service.CategoryService.CategoryService;
import com.example.demo.Service.CategoryService.ICategoryService;
import com.example.demo.Service.ProductService.IProductService;
import com.example.demo.Service.ProductService.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "")
public class ProductServlet extends HttpServlet {
    private ICategoryService iCategoryService = new CategoryService();
    private IProductService iProductService = new ProductService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showFormCreate":
                showFormCreate(request,response);
                break;
            default:
                showListProduct(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> list = iCategoryService.display();
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("/form-create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {

        List<Product> list;
        list = iProductService.showListProduct();
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
            case "searchName":
                searchName(request,response);
                break;
        }
    }

    private void searchName(HttpServletRequest request, HttpServletResponse response) {

        try {
            String searchInput = request.getParameter("searchInput");
            List<Product> productList = iProductService.findByName(searchInput);
            request.setAttribute("list", productList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDel"));
        iProductService.delete(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("id_category"));
        Category category = iCategoryService.search(categoryId);
        Product product = new Product(name,price,quantity,color,category);
        iProductService.create(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
