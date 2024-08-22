package com.codegym.demo_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sumServlet", value = {"/sum", "/tinh-tong"})
public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------doGet running --------------");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("sum_form.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------doPost running --------------");
        int n1 = Integer.parseInt(req.getParameter("num1"));
        int n2 = Integer.parseInt(req.getParameter("num2"));
        int sum = n1 + n2;

        req.setAttribute("ketQua",sum);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(req,resp);
    }
}
