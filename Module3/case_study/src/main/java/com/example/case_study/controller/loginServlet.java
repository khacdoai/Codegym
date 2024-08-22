package com.example.case_study.controller;

import com.example.case_study.model.Accout;
import com.example.case_study.service.DangNhapService;
import com.example.case_study.service.IDangNhapService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    private static IDangNhapService dangNhapService = new DangNhapService();
    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response){
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "register":
                showFormRegister(request,response);
                break;
            case "login":
                showFormLogin(request,response);
                break;
            case "logout":
                break;
            default:
                break;
        }

    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dangNhap.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormRegister(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dangKi.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest request , HttpServletResponse response){
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "register":
                register(request,response);
                break;
            case "login":
                login(request,response);
                break;
            case "logout":
                break;
            default:
                break;
        }


    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String userNameLogin = request.getParameter("tenDangNhapLogin");
        String pasLogin = request.getParameter("matKhauLogin");
        boolean kiemTra = false;
        kiemTra = dangNhapService.kiemTraDangNhap(userNameLogin,pasLogin);
        if (kiemTra == true){
            try {
                response.sendRedirect("/customerServlet");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            String mess = "Tài khoản hoặc mật khẩu không đúng";
            try {
                response.sendRedirect("/loginServlet?action=login&mess=" +  URLEncoder.encode(mess, "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("tenDangNhap");
        String pass = request.getParameter("matKhau");
        dangNhapService.dangKi(new Accout(userName,pass));
        try {
            response.sendRedirect("/dangNhap.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
