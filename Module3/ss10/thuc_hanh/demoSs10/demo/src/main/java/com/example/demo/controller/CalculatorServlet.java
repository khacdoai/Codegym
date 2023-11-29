package com.example.demo.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator-servlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        double firstNum = Double.parseDouble(request.getParameter("firstNum"));
//        double secondNum = Double.parseDouble(request.getParameter("secondNum"));
//        double result = firstNum + secondNum;
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
//        request.setAttribute("resul",result);
//        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double firstNum = Double.parseDouble(request.getParameter("firstNum"));
        double secondNum = Double.parseDouble(request.getParameter("secondNum"));
        double result = firstNum + secondNum;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
        request.setAttribute("resul",result);
        requestDispatcher.forward(request,response);
    }
}
