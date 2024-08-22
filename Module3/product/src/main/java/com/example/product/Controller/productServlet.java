package com.example.product.Controller;

import com.example.product.Model.Product;
import com.example.product.Service.IProductService;
import com.example.product.Service.productService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", value = "/product")

public class productServlet extends HttpServlet {
    IProductService productService = new productService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showcreateFrom(request,response);
                break;
            case "edit":
                showUpdateProduct(request,response);
                break;
            case "delete":
               showDeleteProduct(request,response);
                break;
            case "view":
                viewProduct(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }

    }
    private void showcreateFrom(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showUpdateProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher = null;
        if(product == null){
            request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("product",product);
            request.getRequestDispatcher("product/edit.jsp").forward(request,response);
        }
    }
    private void showDeleteProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher = null;
        if(product == null){
            request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("product",product);
            request.getRequestDispatcher("product/delete.jsp").forward(request,response);
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
                createProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "view":
                viewProduct(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }

    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response){
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response){
        int id = (int) Math.random() * 1000;
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String producer = request.getParameter("producer");
        Product product = new Product(id,name,price,describe,producer);
        productService.create(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New product was create");
        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String producer = request.getParameter("producer");
         Product product = productService.findById(id);
        RequestDispatcher dispatcher = null;
        if(product == null){
            request.getRequestDispatcher("error-404.jsp");
        }else {
            product.setName(name);
            product.setPrice(price);
            product.setDescribe(describe);
            product.setProducer(producer);
            productService.update(id,product);
            request.setAttribute("product",product);
            request.setAttribute("message","Customer information was update");
            request.getRequestDispatcher("product/edit.jsp").forward(request,response);

        }
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher = null;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            productService.remote(id);
        }
        try {
            response.sendRedirect("/product");
        }catch (IOException e){
            e.printStackTrace();
        }
        }
        private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = productService.findById(id);
            RequestDispatcher dispatcher = null;
            if(product == null){
                request.getRequestDispatcher("error-404.jsp");
            }else {
                request.setAttribute("product", product);
                request.getRequestDispatcher("product/view.jsp").forward(request,response);
            }
        }
        private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("search");
            Product product = productService.findByName(name);
            RequestDispatcher dispatcher = null;
            if (product == null) {
                request.setAttribute("message", "Product not Found");
            }else {
                request.setAttribute("product", product);
                request.getRequestDispatcher("product/view.jsp").forward(request,response);
            }
        }
}

