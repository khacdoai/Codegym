package com.example.case_study.controller;

import com.example.case_study.HelloServlet;
import com.example.case_study.dto.CustomerDto;
import com.example.case_study.model.Customer;
import com.example.case_study.model.LoaiKhach;
import com.example.case_study.service.ICustomerService;
import com.example.case_study.service.ILoaiKhachService;
import com.example.case_study.service.impl.LoaiKhachService;
import com.example.case_study.service.impl.customerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "customerServlet", value = "/customerServlet")
public class customerServlet extends HelloServlet {
    ICustomerService customerService = new customerService();
    ILoaiKhachService loaiKhachService = new LoaiKhachService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
            break;
            case "edit":
                showFormUpdate(request,response);
                break;
            case "delete":
                break;
            case "arrange":
                arrangeByName(request,response);
                break;
            default:
                showList(request,response);
                break;
        }

    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int ma_khach_hang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        CustomerDto customer = customerService.selectCustomer(ma_khach_hang);
        List<LoaiKhach> loaiKhachList = loaiKhachService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        request.setAttribute("customer", customer);
        request.setAttribute("loaiKhachList",loaiKhachList);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerDto> list = customerService.showList();
        request.setAttribute("list",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        List<LoaiKhach> loaiKhachList = loaiKhachService.findAll();
        request.setAttribute("loaiKhachList", loaiKhachList);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createNewCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "delete":
                deletteCustomer(request,response);
                break;
            case "search":
                searchByName(request,response);
                break;
            case "arrange":
                arrangeByName(request,response);
                break;
            default:
                showList(request,response);
                break;
        }


    }

    private void arrangeByName(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerDto> list = customerService.arrangeByName();
        request.setAttribute("list",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String ho_ten = request.getParameter("ho_ten");
        List<CustomerDto> list = customerService.searchByName(ho_ten);
        request.setAttribute("list",list);
        request.setAttribute("ho_ten", ho_ten);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int ma_khach_hang = Integer.parseInt(request.getParameter("ma_khach_hang"));
        String ho_ten = request.getParameter("ho_ten");
        Date ngay_sinh = Date.valueOf(request.getParameter("ngay_sinh"));
        int gioi_tinh = Integer.parseInt(request.getParameter("gioi_tinh"));
        String so_cmnd = request.getParameter("so_cmnd");
        String so_dien_thoai = request.getParameter("so_dien_thoai");
        String email = request.getParameter("email");
        String dia_chi = request.getParameter("dia_chi");
        int ma_loai_khach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        Customer customer = new Customer(ma_khach_hang,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach);
        customerService.updateCustomer(customer);
        try {
            response.sendRedirect("/customerServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String ho_ten = request.getParameter("ho_ten");
        Date ngay_sinh = Date.valueOf(request.getParameter("ngay_sinh"));
        int gioi_tinh = Integer.parseInt(request.getParameter("gioi_tinh"));
        String so_cmnd = request.getParameter("so_cmnd");
        String so_dien_thoai = request.getParameter("so_dien_thoai");
        String email = request.getParameter("email");
        String dia_chi = request.getParameter("dia_chi");
        int ma_loai_khach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        customerService.addNewCustomer(new Customer(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach));
        try {
            response.sendRedirect("/customerServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deletteCustomer(HttpServletRequest request, HttpServletResponse response) {
    int ma_khach_hang = Integer.parseInt(request.getParameter("ma_khach_hang"));
    customerService.deleteCustomer(ma_khach_hang);
        try {
            response.sendRedirect("/customerServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
