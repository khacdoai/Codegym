package com.example.demo4.controler;

import com.example.demo4.model.Employee;
import com.example.demo4.service.EmployeeService;
import com.example.demo4.service.IEmloyeeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private  static IEmloyeeeService emloyeeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = null;
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "delete":
                break;
            default:
                showEmployee(request,response);
                break;
        }

    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> list = emloyeeeService.showList();
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = null;
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "delete":
                deleteEmployeeById(request,response);
                break;
            default:
                showEmployee(request,response);
                break;
        }

    }

    private void deleteEmployeeById(HttpServletRequest request, HttpServletResponse response) {
        int maKhachhang = Integer.parseInt(request.getParameter("maNhanVien"));
        emloyeeeService.deteleEmployee(maKhachhang);
        try {
            response.sendRedirect("/EmployeeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
