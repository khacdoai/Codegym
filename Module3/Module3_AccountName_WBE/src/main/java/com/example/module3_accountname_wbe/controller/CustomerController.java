package com.example.module3_accountname_wbe.controller;

import com.example.module3_accountname_wbe.model.Customer;
import com.example.module3_accountname_wbe.service.CustomerService;
import com.example.module3_accountname_wbe.service.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "helloServlet", value = "/customerServlet")
public class CustomerController extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action =request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                showlist(request,response);
                break;

        }
    }
    private void showlist(HttpServletRequest request, HttpServletResponse response){
        List<Customer> list =  customerService.findByAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action =request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                break;

        }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);
        try {
            response.sendRedirect("/customerServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
