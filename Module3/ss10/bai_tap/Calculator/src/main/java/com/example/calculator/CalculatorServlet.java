package com.example.calculator;

import com.example.calculator.model.CalculatorModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            float firstOperand = Float.parseFloat(request.getParameter("fist-operand"));
            float secondOperand = Float.parseFloat(request.getParameter("second-operand"));
            char operator = request.getParameter("operator").charAt(0);
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<h1> Result: <h1>");
            try {
                float result = CalculatorModel.calculate(firstOperand,secondOperand,operator);
                writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
            }catch (Exception ex){
                writer.println("Error: " + ex.getMessage());
            }
            writer.println("<html>");
        }
}
