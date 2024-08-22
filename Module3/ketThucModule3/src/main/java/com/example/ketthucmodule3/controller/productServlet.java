package com.example.ketthucmodule3.controller;

import com.example.ketthucmodule3.model.Product;
import com.example.ketthucmodule3.repository.IProductRepository;
import com.example.ketthucmodule3.service.IProducyService;
import com.example.ketthucmodule3.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", value = "/productServlet")
public class productServlet extends HttpServlet {
    IProducyService producyService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "search":
                break;
            case "sort":
                break;
            default:
                showList(request, response);
                break;


        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = producyService.showList();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewUser(request,response);
                break;
            case "edit":
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "search":
                break;
            case "sort":
                break;
            default:
                showList(request, response);
                break;


        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        producyService.deleteUser(id);

        try {
            response.sendRedirect("/productServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewUser(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten");
        double gia = Double.parseDouble(request.getParameter("gia"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String mauSac = request.getParameter("mauSac");
        String moTa = request.getParameter("moTa");
        int idDanhMuc = 1;

        producyService.addNewUser(new Product(ten, gia, soLuong, mauSac, moTa, idDanhMuc));
        try {
            response.sendRedirect("/productServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
